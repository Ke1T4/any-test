package com.keita.katayama.githubfunction.controller;

import com.keita.katayama.githubfunction.infrastructure.WorkplaceClient;
import com.keita.katayama.githubfunction.service.MessageBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class GitHubController {
    @Autowired
    WorkplaceClient workplaceClient;

    @Autowired
    MessageBuilder messageBuider;

    @PostMapping("/github")
    public void postFunction(
            @RequestBody String json,
            @RequestParam("token") String token) throws IOException {



        String message = messageBuider.createMessage(json);
        if (!StringUtils.isEmpty(message)) {
            String url = "https://graph.facebook.com/v3.0/group/feed?message=" + messageBuider.createMessage(json) + "&access_token=" + token;
            workplaceClient.sendFunction(url);
        }
    }

    @GetMapping
    public String testFunction() {
        String text = "Hello World!!";
        return text;
    }

}
