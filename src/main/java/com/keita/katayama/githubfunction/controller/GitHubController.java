package com.keita.katayama.githubfunction.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RequestMapping("/github")
@RestController
public class GitHubController {

    private static final String key = "Ke1T@o904S";

    @PostMapping
    public JsonNode postFunction(@RequestBody String json) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(json);

        if (node.get("key").textValue().equals(key)) {
            return node;
        }

        System.out.println("エラー");
        return null;

    }

}
