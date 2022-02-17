package ru.anyforany.mypredictor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.anyforany.mypredictor.entity.User;
import ru.anyforany.mypredictor.service.UserService;

import java.io.UnsupportedEncodingException;

//@RestController
@Controller
public class NewsController {

    @Autowired
    private UserService userService;

//    @Autowired
//    private RestTemplate restTemplate;

    @GetMapping("/news")
    public String userBalance(Model model, @AuthenticationPrincipal User user) throws UnsupportedEncodingException {
        user.setBalance(user.getUsername());
        model.addAttribute("userBalance", userService.getUserBalance(user.getId()));

//        HttpHeaders headers = new HttpHeaders();
//        headers.set("x-client-key", "Application khP44F88GLRn3brs2tT5cIj8x03jGxWe9WNXj8z89h3oKMWgp5t7FfY666SBzEcy");
//
//        HttpEntity entity = new HttpEntity(headers);
//
//        System.out.println(restTemplate.exchange("https://api.aqsi.ru/pub/v2/Receipts?filtered.EndDate=2022-01-12T09:00:00&filtered.BeginDate=2022-01-11T09:00:00", HttpMethod.GET, entity, String.class).getBody());
        return "news";
    }

}
