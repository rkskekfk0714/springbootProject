package springbootProject.springbootProject.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Session;
import springbootProject.springbootProject.domain.entity.Recipe;

@Getter
@Setter
@NoArgsConstructor
public class RecipeDto {
    private Long recipeKey;
    private String recipeTitle; //레시피명
    private String recipeType;
    private String creator;
    private String youtb;
    private int youtbLook;
    private String recipeRegDate;

    @Builder
    public RecipeDto(Long recipeKey, String recipeTitle, String recipeType, String youtb, int youtbLook) {
        this.recipeKey = recipeKey;
        this.recipeTitle = recipeTitle;
        this.recipeType = recipeType;
        this.youtb = youtb;
        this.youtbLook = youtbLook;
    }

    public Recipe toEntity() {
        return Recipe.builder()
                .recipeKey(recipeKey)
                .recipeTitle(recipeTitle)
                .recipeType(recipeType)
                .youtb(youtb)
                .youtbLook(youtbLook).build();
    }

    /*
    public void updateView(RecipeDto recipeDto) throws Exception {
        // 조회수 업데이트
        Session.("Recipe.updateView", recipeDto);
    }

     */
}
