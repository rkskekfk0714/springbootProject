package springbootProject.springbootProject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springbootProject.springbootProject.domain.entity.Recipe;
import springbootProject.springbootProject.domain.entity.Review;
import springbootProject.springbootProject.domain.repository.RecipeRepository;
import springbootProject.springbootProject.dto.RecipeDto;
import springbootProject.springbootProject.dto.ReviewDto;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RecipeService {

    private final RecipeRepository recipeRepository;
    private static final int PAGE_POST_COUNT = 5; // 한 페이지에 존재하는 게시글 수

    /*

    @Transactional
    public int updateView(Long recipekey) {
        return recipeRepository.updateView(recipekey);

    }

     */

/*
    //종류별 레시피 목록 보기
    public List<RecipeDto> getAllRecipe(){
        List<Recipe> recipies = recipeRepository.findAll();
        List<RecipeDto> recipeDtoList= new ArrayList<>();

        for (Recipe recipe : recipies){
            RecipeDto recipeDto = RecipeDto.builder()
                    .recipekey(recipe.getRecipekey())
                    .recipetitle(recipe.getRecipetitle())
                    .recipecreator(recipe.getRecipecreator())
                    .recipedetail(recipe.getRecipedetail())
                    .recipehit(recipe.getRecipehit())
                    .recipelink(recipe.getRecipelink())
                    .recipetype(recipe.getRecipetype())
                    .recipeupdated(recipe.getRecipeupdated())
                    .build();
            recipeDtoList.add(recipeDto);
        }
        return recipeDtoList;
    }

 */

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

    public List<RecipeDto> getrecipelist(Integer pageNum){
        Page<Recipe> page = recipeRepository.findAll(PageRequest.of(pageNum-1,PAGE_POST_COUNT, Sort.by(Sort.Direction.DESC,"recipekey")));

        List<Recipe> recipes = page.getContent();
        List<RecipeDto> recipeDtoList = new ArrayList<>();

        for(Recipe recipe : recipes){
            recipeDtoList.add(this.convertEntityToDto(recipe));
        }
        return recipeDtoList;
    }

    //모든 레시피 목록 보기
    public List<RecipeDto> getAllRecipe(String recipecreator){
        List<Recipe> recipeList = recipeRepository.findByRecipecreator(recipecreator);
        List<RecipeDto> recipeDtoList = new ArrayList<>();

        for (Recipe recipeEntity : recipeList) {
            recipeDtoList.add(this.convertEntityToDto(recipeEntity));
        }
        return recipeDtoList;
    }

    /*
    public List<RecipeDto> getrecipe(String recipecreator) {
        List<Recipe> recipeList = recipeRepository.findByRecipecreator(recipecreator);
        List<RecipeDto> recipeDtoList = new ArrayList<>();

        for (Recipe recipeEntity : recipeList) {
            RecipeDto recipeDto = RecipeDto.builder()
                    .recipekey(recipeEntity.getRecipekey())
                    .recipelink(recipeEntity.getRecipelink())
                    .recipetitle(recipeEntity.getRecipetitle())
                    .recipehit(recipeEntity.getRecipehit()).build();
            recipeDtoList.add(recipeDto);
        }
        return recipeDtoList;
    }

     */



    //조회수(best)
    public List<RecipeDto> getbestrecipe(String recipecreator) {
        List<Recipe> recipeList = recipeRepository.creatorbestRecipe(recipecreator);
        List<RecipeDto> recipeDtoList = new ArrayList<>();

        for (Recipe recipeEntity : recipeList) {
            RecipeDto recipeDto = RecipeDto.builder()
                    .recipekey(recipeEntity.getRecipekey())
                    .recipelink(recipeEntity.getRecipelink())
                    .recipetitle(recipeEntity.getRecipetitle())
                    .recipehit(recipeEntity.getRecipehit()).build();
            recipeDtoList.add(recipeDto);
        }
        return recipeDtoList;
    }


    // 날짜(new)
    public List<RecipeDto> getnewrecipe(String recipecreator) {
        List<Recipe> recipeList = recipeRepository.newRecipe(recipecreator);
        List<RecipeDto> recipeDtoList = new ArrayList<>();

        for (Recipe recipeEntity : recipeList) {
            RecipeDto recipeDto = RecipeDto.builder()
                    .recipekey(recipeEntity.getRecipekey())
                    .recipelink(recipeEntity.getRecipelink())
                    .recipetitle(recipeEntity.getRecipetitle())
                    .recipeupdated(recipeEntity.getRecipeupdated()).build();
            recipeDtoList.add(recipeDto);
        }
        return recipeDtoList;
    }



}
