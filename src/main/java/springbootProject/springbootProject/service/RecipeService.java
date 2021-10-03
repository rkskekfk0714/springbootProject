package springbootProject.springbootProject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import springbootProject.springbootProject.domain.entity.Recipe;
import springbootProject.springbootProject.domain.repository.RecipeRepository;
import springbootProject.springbootProject.dto.RecipeDto;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RecipeService {

    private final RecipeRepository recipeRepository;
    private static final int VIEW_POST_COUNT = 10000; // 한 영상당 최대 조회수

    //종류별 레시피 목록 보기
    public List<RecipeDto> getAllRecipe() {
        List<Recipe> recipeEntities = recipeRepository.findAll();
        List<RecipeDto> recipeDtoList = new ArrayList<>();

        for (Recipe recipeEntity : recipeEntities) {
            RecipeDto recipeDto = RecipeDto.builder()
                    .recipeKey(recipeEntity.getRecipeKey())
                    .recipeTitle(recipeEntity.getRecipeTitle())
                    .recipeType(recipeEntity.getRecipeType())
                    .youtb(recipeEntity.getYoutb())
                    .youtbLook(recipeEntity.getYoutbLook()).build();
            recipeDtoList.add(recipeDto);

        }
        return recipeDtoList;

    }


    //종류별 재료 목록 보기
    public List<RecipeDto> getRecipe(String recipeType) {
        List<Recipe> recipeList = recipeRepository.findByRecipeType(recipeType);
        List<RecipeDto> recipeDtoList = new ArrayList<>();

        for (Recipe recipeEntity : recipeList) {
            RecipeDto recipeDto = RecipeDto.builder()
                    .recipeKey(recipeEntity.getRecipeKey())
                    .recipeTitle(recipeEntity.getRecipeTitle())
                    .recipeType(recipeEntity.getRecipeType())
                    .youtb(recipeEntity.getYoutb())
                    .youtbLook(recipeEntity.getYoutbLook()).build();
            recipeDtoList.add(recipeDto);

        }
        return recipeDtoList;

    }


    public int updateCount(Long id) {
        return recipeRepository.updateCount(id);
    }




}
