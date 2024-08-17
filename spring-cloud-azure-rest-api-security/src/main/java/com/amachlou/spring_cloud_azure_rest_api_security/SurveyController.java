package com.amachlou.spring_cloud_azure_rest_api_security;

import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class SurveyController {

    private static final String QUESTION = "Which sports do you like most?";
    private final Map<LocalDateTime, String> surveys = new LinkedHashMap<>();

    @GetMapping(value ="/question", produces = MediaType.APPLICATION_JSON_VALUE)
    public String question () {
        return QUESTION;
    }

    @PreAuthorize("hasAuthority('SCOPE_Survey.User')")
    public String addAnswer (@RequestParam("answer") String answer) {
        if(StringUtils.hasText(answer)) {
            surveys.put(LocalDateTime.now(), answer);
            return "succeeded";
        }
        return "Failed";
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAuthority('SCOPE_Survey.Admin')")
    public Map<LocalDateTime, String> list() {
        return surveys;
    }

}
