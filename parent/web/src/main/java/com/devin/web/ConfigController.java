package com.devin.web;



import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
//<!--annotation driver-->
@EnableWebMvc
//<!--component scan-->
@ComponentScan(basePackages = "com.devin.web", includeFilters ={@ComponentScan.Filter(type = FilterType.ANNOTATION, classes={Controller.class})})

public class ConfigController implements WebMvcConfigurer{

//    <!--Internal resource resolver-->
    @Bean("viewResolver")
    public InternalResourceViewResolver getInternalResourceViewResolver(){
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        internalResourceViewResolver.setPrefix("/jsp/");
        internalResourceViewResolver.setSuffix(".jsp");
        return internalResourceViewResolver;

    }

//     <!--static resource share-->
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
