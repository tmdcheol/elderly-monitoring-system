package inha.ELDERLYMONITORING.web;

import inha.ELDERLYMONITORING.common.argumentresolver.Login;
import inha.ELDERLYMONITORING.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class HomeController {
    @GetMapping
    public String home(@Login Member member, Model model) {
        if(member != null){
            model.addAttribute("member", member);
        }
        log.info("home controller!");
        return "home";
    }
}
