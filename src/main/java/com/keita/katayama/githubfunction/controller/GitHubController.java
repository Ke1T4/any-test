package com.keita.katayama.githubfunction.controller;

import com.keita.katayama.githubfunction.infrastructure.WorkplaceClient;
import com.keita.katayama.githubfunction.service.MessageBuider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class GitHubController {
    @Autowired
    WorkplaceClient workplaceClient;

    @Autowired
    MessageBuider messageBuider;

    @PostMapping("/github")
    public void postFunction(
            @RequestBody String json,
            @RequestParam("token") String token) throws IOException {
        String url = "https://graph.facebook.com/v3.0/group/feed?message=" + messageBuider.createMessage(json) + "&access_token=" + token;
        workplaceClient.sendFunction(url);
    }

    @GetMapping
    public String testFunction() {
        String text = "Hello World!!";
        return text;
    }

}
