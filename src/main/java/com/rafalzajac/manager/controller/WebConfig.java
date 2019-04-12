package com.rafalzajac.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Class responsible for simple views performing only get request and not doing anything than returning a view like
 * home page, contact page, and login page.
 */
@Controller
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
            registry.addViewController("/").setViewName("home");
            registry.addViewController("/info/contact").setViewName("views/contact");
            registry.addViewController("/login").setViewName("auth/login");
    }
}
