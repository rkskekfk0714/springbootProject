package springbootProject.springbootProject.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import springbootProject.springbootProject.domain.entity.Member;
import springbootProject.springbootProject.domain.entity.Recipe;
import springbootProject.springbootProject.domain.entity.Review;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class ReviewDto {
    private Long reviewkey;
    private String reviewcontent;
    private Date reviewupdated;
    private Recipe recipe;
    private Member member;

    @Builder
    public ReviewDto(Long reviewkey, String reviewcontent, Date reviewupdated, Recipe recipe, Member member)
    {
        this.reviewkey=reviewkey;
        this.reviewcontent=reviewcontent;
        this.reviewupdated=reviewupdated;
        this.recipe=recipe;
        this.member=member;
    }

    public Review toEntity(){
        return Review.builder()
                .reviewkey(reviewkey)
                .reviewcontent(reviewcontent)
                .reviewupdated(reviewupdated)
                .recipe(recipe)
                .member(member)
                .build();

    }
}
