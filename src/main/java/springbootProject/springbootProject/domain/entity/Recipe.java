package springbootProject.springbootProject.domain.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Recipe {

    @Id
    private Long recipeKey;

    //private int adminKey;
    private String recipeTitle; //레시피명
    private String recipeType; //레시피명
    //private String creator;
    //private String recipeDetail;
    //private String recipeArrang;
    private String youtb;

    //@Column(columnDefinition = "integer default 0")
    private int youtbLook;

    private String recipeRegDate;

    @Builder
    public Recipe(Long recipeKey, String recipeTitle, String recipeType, String youtb, int youtbLook, String recipeRegDate) {
        this.recipeKey = recipeKey;
        this.recipeTitle = recipeTitle;
        this.recipeType = recipeType;
        this.youtb = youtb;
        this.youtbLook = youtbLook;
        this.recipeRegDate = recipeRegDate;
    }
}
