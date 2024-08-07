package com.amachlou.spring_azure_entraid_oauth2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.prepost.PreAuthorize;

@RestController
@RequestMapping("/")
public class HelloController {

    @GetMapping
    public String welcome() {
        return "No Auth needed!";
    }

    @GetMapping("admin")
    @ResponseBody
    @PreAuthorize("hasAuthority('APPROLE_Admin')")
    public String admin() {
        return "Admin message";
    }
}