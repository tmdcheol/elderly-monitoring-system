package inha.ELDERLYMONITORING.web;

import inha.ELDERLYMONITORING.domain.Member;
import inha.ELDERLYMONITORING.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/login")
    public String loginForm(Model model) {
        model.addAttribute("memberRequest", new MemberRequest());
        return "/members/loginForm";
    }

    @PostMapping("/login")
    public String login(@Valid MemberRequest request, BindingResult result) {
        if(result.hasErrors()){
            return "members/loginForm";
        }
        memberService.login(request);
        return "redirect:/";
    }
    @PostMapping("/new")
    public String create(@Valid MemberRequest request, BindingResult result) {
        if (result.hasErrors()) {
            return "members/createMemberForm";
        }
        memberService.join(request);
        return "redirect:/members/login";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("memberRequest", new MemberRequest());
        return "/members/createMemberForm";
    }
}
