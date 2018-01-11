package org.upmc.obolink.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {
    private static String ressourcesPathA = "/Users/Steven/";
    private static String ressourcesPathB = "resources/";

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**")
                .addResourceLocations("/resources/", "file:"+ressourcesPathA+ressourcesPathB);
    }

    public static String getRessourcesPathA() {
        return ressourcesPathA;
    }

    public static String getRessourcesPathB() {
        return ressourcesPathB;
    }
}
