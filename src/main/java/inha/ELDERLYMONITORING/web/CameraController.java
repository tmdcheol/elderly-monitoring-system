package inha.ELDERLYMONITORING.web;

import inha.ELDERLYMONITORING.common.argumentresolver.ClientIp;
import inha.ELDERLYMONITORING.common.argumentresolver.Login;
import inha.ELDERLYMONITORING.domain.Member;
import inha.ELDERLYMONITORING.service.CameraService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/cameras")
@Slf4j
public class CameraController {

    private final CameraService cameraService;

    @PostMapping("/new")
    public String addCamera(@Login Member member, @ClientIp String clientIp) {
        log.info("clientIp={}", clientIp);
        cameraService.addCamera(member, clientIp);

        /**
         * todo
         * python server 로 ip event 보내기
         */

        return "redirect:/cameras";
    }

    @GetMapping
    public String list(@Login Member member, Model model) {
        model.addAttribute("cameras", cameraService.lists(member));
        return "/cameras/cameraList";
    }
}
