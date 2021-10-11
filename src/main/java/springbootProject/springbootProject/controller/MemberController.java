package springbootProject.springbootProject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springbootProject.springbootProject.dto.AdminDto;
import springbootProject.springbootProject.dto.MemberDto;
import springbootProject.springbootProject.service.AdminService;
import springbootProject.springbootProject.service.MemberService;

import javax.servlet.http.HttpSession;


@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final AdminService adminService;
    private final HttpSession session;


    /*
    @GetMapping("/")
    public String main() {
        return "/main";
    }

     */


    // 회원가입
    @GetMapping("/user/join")
    public String join() {
        return "/memberJoin";
    }

    // 회원가입 처리
    @PostMapping("/userJoin")
    public String Sign(MemberDto memberDto) {
        memberService.joinUser(memberDto);

        return "redirect:/login";
    }

    // 사용자 로그인
    @GetMapping("/login")
    public String login() {
        return "/memberLogin";
    }


    // 사용자 로그인 처리
    @PostMapping("/userLogin")
    public String userLogin(MemberDto memberDto) {
        MemberDto result = memberService.userLogin(memberDto);

        if(result != null){

            session.setAttribute("user", result);
            return "redirect:/" ;

        }
        else{
            return "redirect:/login";
        }


    }

    // 사용자 로그아웃
    @GetMapping("/userlogout")
    public String logout(){
        session.setAttribute("user", null);
        return "main";
    }

    // 관리자 로그인
    @GetMapping("/adLogin")
    public String adLog() {
        return "/adminLogin";
    }

    // 관리자 로그인 처리
    @PostMapping("/adminLog")
    public String adminLogin(AdminDto adminDto) {
        AdminDto adResult = adminService.adminLogin(adminDto);

        if(adResult != null){

            session.setAttribute("admin", adResult);
            return "redirect:/" ;

        }
        else{
            return "redirect:/adLogin";
        }

    }

    // 관리자 로그아웃
    @GetMapping("/adminlogout")
    public String adlogout(){
        session.setAttribute("admin", null);
        return "main";
    }

}
