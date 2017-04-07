package com.zyt;

import javax.servlet.ServletContext;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

@Configuration
@EnableWebMvc
@ComponentScan("com.zyt.controller")
public class WebAppConfig extends WebMvcConfigurerAdapter {
    @Bean
    public ViewResolver viewResolver(TemplateEngine templateEngine) {
	ThymeleafViewResolver resolver = new ThymeleafViewResolver();
	resolver.setTemplateEngine(templateEngine);
	resolver.setCharacterEncoding(Const.Coding.UTF8);
	return resolver;
    }

    @Bean
    public TemplateEngine TemplateEngine(ITemplateResolver templateResolver) {
	SpringTemplateEngine engine = new SpringTemplateEngine();
	engine.setTemplateResolver(templateResolver);
	return engine;
    }

    @Bean
    public ITemplateResolver templateResolver(ServletContext context) {
	ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver(context);
	templateResolver.setPrefix("/WEB-INF/views/");
	templateResolver.setSuffix(".html");
	templateResolver.setTemplateMode("HTML5");
	templateResolver.setCharacterEncoding(Const.Coding.UTF8);
	return templateResolver;
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
	configurer.enable();
    }
}
