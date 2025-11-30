package com.githubAnalyzer.Github.Analyzer.service;

import com.githubAnalyzer.Github.Analyzer.client.GitHubGraphQLClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class GitHubService {

  private final GitHubGraphQLClient client;
  private final ObjectMapper objectMapper = new ObjectMapper();

  public String getUserRepos(String username) throws Exception {

    // Load GraphQL file
    String query = Files.readString(Path.of("src/main/resources/graphql/userRepos.graphql")).trim();

    Map<String, Object> requestBody = new HashMap<>();
    requestBody.put("query", query);

    Map<String, Object> variables = new HashMap<>();
    variables.put("username", username.trim());

    requestBody.put("variables", variables);

    String json = objectMapper.writeValueAsString(requestBody);

    System.out.println(json);
    return client.executeQuery(json);
  }
}
