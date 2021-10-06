package springbootProject.springbootProject.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import springbootProject.springbootProject.domain.entity.Recipe;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    //public List<Recipe> findByRecipeType(String RecipeType);

    @Query(value = "select * from recipe where recipeHit=(select max(recipehit)from recipe)",nativeQuery = true)
    List<Recipe> bestrecipe();

    // 조회수 증가
    @Modifying
    @Query("update Recipe p set p.recipehit = p.recipehit + 1 where p.recipekey = :recipekey")
    int updateView(Long recipekey);
}
