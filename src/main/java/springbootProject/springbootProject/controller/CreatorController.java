package springbootProject.springbootProject.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import springbootProject.springbootProject.domain.repository.CreatorRepository;
import springbootProject.springbootProject.dto.CreatorDto;
import springbootProject.springbootProject.dto.RecipeDto;
import springbootProject.springbootProject.dto.ReviewDto;
import springbootProject.springbootProject.service.CreatorService;
import springbootProject.springbootProject.service.RecipeService;
import springbootProject.springbootProject.service.ReviewService;

@Controller
@AllArgsConstructor
public class CreatorController {

    @Autowired
    private CreatorService creatorService;
    private final ReviewService reviewService;

    /*
    @GetMapping("/creatorB")
    public String cre() {
        return "/creator";
    }



    @GetMapping("/creator/{recipekey}")
    public String creator(@PathVariable("recipekey")Long recipekey, Model model){
        CreatorDto creatorDto = creatorService.getRecipe(recipekey);


        model.addAttribute("recipehit", creatorService.updateView(recipekey));
        model.addAttribute("creatorDto",creatorDto);
        return "recipedetail.html";
    }
    @PostMapping("/creator/{recipekey}")
    public String reviewwrite(@ModelAttribute ReviewDto reviewDto){
        reviewService.savereview(reviewDto);
        return ("redirect:/creator" +
                "/{recipekey}");
    }
 */
}
