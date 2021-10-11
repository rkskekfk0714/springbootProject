package springbootProject.springbootProject.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import springbootProject.springbootProject.domain.entity.Recipe;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    /*
    @Query(value = "select * from recipe where recipeHit=(select max(recipehit)from recipe)",nativeQuery = true)
    List<Recipe> bestrecipe();

     */



    /*
    // 조회수 증가
    @Modifying
    @Query("update Recipe p set p.recipehit = p.recipehit + 1 where p.recipekey = :recipekey")
    int updateView(Long recipekey);

     */


    // 조회수 불러오기(Best)
    @Modifying
    @Query(value = "select p.recipekey, p.recipetitle, p.recipelink, p.recipehit from Recipe p where p.recipecreator = :recipecreator order by p.recipehit desc")
    public List<Recipe> creatorbestRecipe(@Param("recipecreator") String recipecreator);




    // 날짜 불러오기(New)
    @Query(value = "select r.recipekey, r.recipetitle, r.recipelink, r.recipeupdated from Recipe r where r.recipecreator = :recipecreator order by r.recipeupdated desc")
    public List<Recipe> newRecipe(@Param("recipecreator") String recipecreator);





    public List<Recipe> findByRecipecreator(String recipecreator);
}
