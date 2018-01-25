package org.upmc.obolink.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 *This class manage the location of the resources.
 *
 * @author boteam
 * @version 1.0
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {
    private static String ressourcesPathA = "";

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**")
                .addResourceLocations("/resources/", "file:" + ressourcesPathA + "/resources/");
    }

    public static String getRessourcesPathA() {
        return ressourcesPathA;
    }

    public static void setRessourcesPathA(String ressourcesPathA) {
        WebMvcConfig.ressourcesPathA = ressourcesPathA;
    }
}
