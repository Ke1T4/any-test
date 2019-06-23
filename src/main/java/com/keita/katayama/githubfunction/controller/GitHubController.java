package com.keita.katayama.githubfunction.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.keita.katayama.githubfunction.infrastructure.WorkplaceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RequestMapping
@Controller
public class GitHubController {
    @Autowired
    WorkplaceClient workplaceClient;

    @PostMapping("/github")
    public void postFunction(
            @RequestBody String json,
            @RequestParam("token") String token) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String url = "https://graph.facebook.com/v3.0/group/feed?messege=" + "TEST" + "&access_token=" + token;
        workplaceClient.sendFunction(url);
    }

    @GetMapping
    public String testFunction() {
        String text = "Hello World!!";
        return text;
    }

}
