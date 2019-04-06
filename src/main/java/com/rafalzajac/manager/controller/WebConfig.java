package com.rafalzajac.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
            registry.addViewController("/").setViewName("home");
            registry.addViewController("/contact").setViewName("views/contact");
            registry.addViewController("/login").setViewName("auth/login");
    }
}
