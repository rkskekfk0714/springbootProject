package springbootProject.springbootProject.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import springbootProject.springbootProject.domain.entity.Recipe;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    public List<Recipe> findByRecipeType(String RecipeType);

    // 조회수 증가
    @Modifying
    @Query("UPDATE Post p SET p.youtbLook = p.youtbLook + 1 WHERE p.id = :id")
    int updateCount(Long id);
}
