package com.grouptransportes.config;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;


@SpringBootApplication
@EnableJpaRepositories("com.grouptransportes.model.repository")
@EntityScan("com.grouptransportes.model.entities")
@MapperScan("com.grouptransportes.service.query")
@ComponentScan(basePackages = "com.grouptransportes")
public class GroupTransportesApplication {

	public static void main(String[] args) {
		SpringApplication.run(GroupTransportesApplication.class, args);
	}
	
	@Bean // Tiles Configuração
	public TilesConfigurer tilesConfig() {
	    TilesConfigurer tilesConfigurer = new TilesConfigurer();
	    tilesConfigurer.setCheckRefresh(true);
	    tilesConfigurer.setDefinitionsFactoryClass(TilesDefinitionsConfig.class);
	    tilesConfigurer.setPreparerFactoryClass(org.springframework.web.servlet.view.tiles3.SpringBeanPreparerFactory.class);
	    TilesDefinitionsConfig.addDefinitions();
	    return tilesConfigurer;
	}
	 
	@Bean // Resolver do Tiles
    public TilesViewResolver getTilesViewResolver() {
        TilesViewResolver viewResolver = new TilesViewResolver();
        viewResolver.setViewClass(TilesView.class);
        return viewResolver;
    }
	
	@Bean // View Resolver para uso de requests types
	public ViewResolver contentNegotiatingViewResolver(ContentNegotiationManager manager) {
		List<ViewResolver> resolvers = new ArrayList<ViewResolver>();
		resolvers.add(getTilesViewResolver());
		ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
		resolver.setViewResolvers(resolvers);
		resolver.setContentNegotiationManager(manager);
		return resolver;
	}

}
