package com.githubAnalyzer.Github.Analyzer.controller;

import com.githubAnalyzer.Github.Analyzer.service.GitHubService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/github")
@RequiredArgsConstructor
public class GitHubController {

    private final GitHubService service;

    @GetMapping("/repos/{username}")
    public String getRepos(@PathVariable String username) throws Exception {
        return service.getUserRepos(username);
    }
}
