package springbootProject.springbootProject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springbootProject.springbootProject.dto.RecipeDto;
import springbootProject.springbootProject.dto.ReviewDto;
import springbootProject.springbootProject.service.RecipeService;
import springbootProject.springbootProject.service.ReviewService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class RecipeController {

    private final RecipeService recipeService;


    @GetMapping("/")
    public String indexrecipe(Model model,@RequestParam(value = "page",defaultValue = "1") Integer pageNum){
        List<RecipeDto> recipeDtoList = recipeService.getrecipelist(pageNum);

        model.addAttribute("recipelist", recipeDtoList);

        return "main";
    }

    /*
    @GetMapping("/recipe/{recipekey}")
    public String recipe(Model model,@RequestParam(value = "page",defaultValue = "1") Integer pageNum){
        List<RecipeDto> recipeDtoList = recipeService.getrecipelist(pageNum);

        model.addAttribute("recipelist", recipeDtoList);

        return "recipe";
    }

     */





    // 조회수(creatorBest)
    @GetMapping("/recipe/{recipecreator}")
    public String recipeCreator(@PathVariable("recipecreator") String recipecreator, Model model) {
        List<RecipeDto> recipeDtoList = recipeService.getbestrecipe(recipecreator);
        List<RecipeDto> recipeDtoList1 = recipeService.getnewrecipe(recipecreator);

        model.addAttribute("recipelist", recipeDtoList);
        model.addAttribute("recipelist", recipeDtoList);

        return "recipe";
    }

    // 조회수(best)
    @GetMapping("/best/{recipecreator}")
    public String recipebestCreator(@PathVariable("recipecreator") String recipecreator, Model model) {
        List<RecipeDto> recipeDtoList = recipeService.getbestrecipe(recipecreator);

        model.addAttribute("recipelist", recipeDtoList);

        return "best";
    }

    // 날짜(new)
    @GetMapping("/new/{recipecreator}")
    public String newCreator(@PathVariable("recipecreator") String recipecreator, Model model) {
        List<RecipeDto> recipeDtoList = recipeService.getnewrecipe(recipecreator);

        model.addAttribute("recipelist", recipeDtoList);

        return "new";
    }








    /*
    @GetMapping("/recipe")
    public String recipe(Model model){

        List<RecipeDto> recipeDtoList = recipeService.getAllRecipe();

        model.addAttribute("recipeList", recipeDtoList);

        return "recipe";
    }

     */


    /*

    //레시피 목록 종류별 띄우기
    @GetMapping("/recipe/{recipeType}")
    public String materialMainCate(@PathVariable("recipeType") String recipeType, @PathVariable("id") int id, Model model) {
        List<RecipeDto> recipeDtoList = recipeService.getRecipe(recipeType);
        model.addAttribute("recipeList", recipeDtoList);

        return "recipe";
    }

     */



}
