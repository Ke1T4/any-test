package com.keita.katayama.githubfunction.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Objects;

@Component
public class MessageBuilder {

    public String createMessage(String json) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(json);
        StringBuilder stringBuilder = new StringBuilder();

        if (Objects.nonNull(node.get("commits"))) {
            stringBuilder.append(node.get("commits").get(0).get("committer").get("username") + "さんがコミットしました！\n");
            stringBuilder.append("コメント：" + node.get("commits").get(0).get("message") + "\n");
            stringBuilder.append("URL：" + node.get("commits").get(0).get("url").toString());
        }

        if (Objects.nonNull(node.get("pull_request")) && "\"opened\"".equals(node.get("action").toString())) {
            stringBuilder.append(node.get("sender").get("login") + "さんがプルリクエストを作成しました！\n");
            stringBuilder.append("タイトル：" + node.get("pull_request").get("title") + "\n");
            stringBuilder.append("コメント：" + node.get("pull_request").get("body") + "\n");
            stringBuilder.append("URL：" + node.get("pull_request").get("html_url"));
        }
        return URLEncoder.encode(stringBuilder.toString(), "UTF-8");
    }
}
