package springbootProject.springbootProject.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import springbootProject.springbootProject.domain.entity.Creator;
import springbootProject.springbootProject.domain.entity.Recipe;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class CreatorDto {

    private Long recipekey;
    private String recipetitle;
    private String recipetype;
    private String recipecreator;
    private String recipedetail;
    private String recipelink;
    private Integer recipehit;
    private Date recipeupdated;
    //private Material material;

    @Builder
    public CreatorDto(Long recipekey, String recipetitle, String recipetype, String recipecreator, String recipedetail, String recipelink, int recipehit, Date recipeupdated) {
        this.recipekey = recipekey;
        this.recipetitle = recipetitle;
        this.recipetype = recipetype;
        this.recipecreator = recipecreator;
        this.recipedetail = recipedetail;
        this.recipelink = recipelink;
        this.recipehit = recipehit;
        this.recipeupdated = recipeupdated;

    }

    public Creator toEntity(){
        return Creator.builder()
                .recipekey(recipekey)
                .recipetitle(recipetitle)
                .recipetype(recipetype)
                .recipecreator(recipecreator)
                .recipedetail(recipedetail)
                .recipelink(recipelink)
                .recipehit(recipehit)
                .recipeupdated(recipeupdated)
                .build();
    }
}
