package com.appsdeveloper.ws.api.Resourceserver.controllers;

import com.appsdeveloper.ws.api.Resourceserver.response.UserRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UsersController {
    @GetMapping("/status/check")
    public String status() {
        return "Working";
    }

    @PreAuthorize("#id == #jwt.subject")
    @DeleteMapping(path = "/{id}")
    public String deleteUser(@PathVariable String id, @AuthenticationPrincipal Jwt jwt) {
        SecurityContextHolder.getContext();
        return "Deleted user with id " + id + " and JWT subject " + jwt.getSubject();
    }
    /*
    @PreAuthorize("hasAuthority('ROLE_developer') or #id == #jwt.subject")
    //@Secured("ROLE_developer")
    @DeleteMapping(path = "/{id}")
    public String deleteUser(@PathVariable String id, @AuthenticationPrincipal Jwt jwt) {
        return "Deleted user with id " + id + " and JWT subject " + jwt.getSubject();
    }*/

    @PostAuthorize("returnObject.userId == #jwt.subject")
    @GetMapping(path = "/{id}")
    public UserRest getUser(@PathVariable String id, @AuthenticationPrincipal Jwt jwt) {
        return new UserRest("merve", "d","29be9f7f-2854-40ac-aafb-e5b0e2240154");
    }
}