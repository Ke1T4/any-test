package com.keita.katayama.githubfunction.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RequestMapping("/github")
@RestController
public class GitHubController {

    private static final String key = "Ke1T@o904S";

    @PostMapping
    public void postFunction(
            @RequestBody String json,
            @RequestParam String url,
            @RequestParam String token) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(json);

        if (node.get("key").textValue().equals(key)) {
            System.out.println(node);
        }

        System.out.println("エラー");
    }

}
