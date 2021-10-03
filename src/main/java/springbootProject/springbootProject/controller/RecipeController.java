package springbootProject.springbootProject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import springbootProject.springbootProject.dto.RecipeDto;
import springbootProject.springbootProject.service.RecipeService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class RecipeController {

    private final RecipeService recipeService;


    @GetMapping("/creator")
    public String login() {
        return "/recipe";
    }

    @GetMapping("/recipe")
    public String recipe(Model model){

        List<RecipeDto> recipeDtoList = recipeService.getAllRecipe();

        model.addAttribute("recipeList", recipeDtoList);

        return "recipe";
    }

    //레시피 목록 종류별 띄우기
    @GetMapping("/recipe/{recipeType}")
    public String materialMainCate(@PathVariable("recipeType") String recipeType, @PathVariable("id") int id, Model model) {
        List<RecipeDto> recipeDtoList = recipeService.getRecipe(recipeType);
        model.addAttribute("recipeList", recipeDtoList);

        return "recipe";
    }

    @GetMapping("/")
    public String index(Long id, Model model, @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {

        model.addAttribute("view", recipeService.updateCount(id));

        return "main";
    }
}
