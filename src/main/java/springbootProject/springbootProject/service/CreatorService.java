package springbootProject.springbootProject.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springbootProject.springbootProject.domain.entity.Creator;
import springbootProject.springbootProject.domain.entity.Recipe;
import springbootProject.springbootProject.domain.repository.CreatorRepository;
import springbootProject.springbootProject.dto.CreatorDto;
import springbootProject.springbootProject.dto.RecipeDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CreatorService {

    @Autowired
    private CreatorRepository creatorRepository;

    private static final int BLOCK_PAGE_NUM_COUNT = 5; // 블럭에 존재하는 페이지 번호 수
    private static final int PAGE_POST_COUNT = 5; // 한 페이지에 존재하는 게시글 수


    @Transactional
    public int updateView(Long recipekey) {
        return creatorRepository.updateView(recipekey);

    }

    public List<CreatorDto> getAllRecipe(){
        List<Creator> creators = creatorRepository.findAll();
        List<CreatorDto> creatorDtoList= new ArrayList<>();

        for (Creator creator : creators){
            CreatorDto creatorDto = CreatorDto.builder()
                    .recipekey(creator.getRecipekey())
                    .recipetitle(creator.getRecipetitle())
                    .recipecreator(creator.getRecipecreator())
                    .recipedetail(creator.getRecipedetail())
                    .recipehit(creator.getRecipehit())
                    .recipelink(creator.getRecipelink())
                    .recipetype(creator.getRecipetype())
                    .recipeupdated(creator.getRecipeupdated())
                    .build();
            creatorDtoList.add(creatorDto);
        }
        return creatorDtoList;
    }

    @Transactional
    public CreatorDto getRecipe(Long recipekey){
        Optional<Creator> creatorWrapper = creatorRepository.findById(recipekey);
        Creator creator = creatorWrapper.get();

        CreatorDto creatorDto = CreatorDto.builder()
                .recipekey(creator.getRecipekey())
                .recipetitle(creator.getRecipetitle())
                .recipecreator(creator.getRecipecreator())
                .recipedetail(creator.getRecipedetail())
                .recipehit(creator.getRecipehit())
                .recipelink(creator.getRecipelink())
                .recipetype(creator.getRecipetype())
                .recipeupdated(creator.getRecipeupdated())
                .build();

        return creatorDto;
    }

    private RecipeDto convertEntityToDto(Recipe recipe){
        return RecipeDto.builder()
                .recipekey(recipe.getRecipekey())
                .recipetitle(recipe.getRecipetitle())
                .recipecreator(recipe.getRecipecreator())
                .recipedetail(recipe.getRecipedetail())
                .recipehit(recipe.getRecipehit())
                .recipelink(recipe.getRecipelink())
                .recipetype(recipe.getRecipetype())
                .recipeupdated(recipe.getRecipeupdated()).build();


    }

    /*

    public List<CreatorDto> getrecipelist(Integer pageNum){
        Page<Creator> page = creatorRepository.findAll(PageRequest.of(pageNum-1,PAGE_POST_COUNT, Sort.by(Sort.Direction.DESC,"recipekey")));

        List<Creator> creators = page.getContent();
        List<CreatorDto> creatorDtoList = new ArrayList<>();

        for(Creator creator : creators){
            creatorDtoList.add(this.convertEntityToDto(creator));
        }
        return creatorDtoList;
    }

     */


    public List<CreatorDto> getbestrecipe(){
        List<Creator> creators = creatorRepository.findAll();
        List<CreatorDto> creatorDtoList= new ArrayList<>();

        for (Creator creator : creators){
            CreatorDto creatorDto = CreatorDto.builder()
                    .recipekey(creator.getRecipekey())
                    .recipehit(creator.getRecipehit())
                    .recipelink(creator.getRecipelink())
                    .recipedetail(creator.getRecipedetail())
                    .recipecreator(creator.getRecipecreator())
                    .recipetitle(creator.getRecipetitle())
                    .recipetype(creator.getRecipetype())
                    .recipeupdated(creator.getRecipeupdated())
                    .build();
            creatorDtoList.add(creatorDto);
        }
        return creatorDtoList;
    }
}
