package net.guides.springboot2.springboot2jpacrudexample;

import java.util.Collections;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan({"net.guides.springboot2.springboot2jpacrudexample.controller", "net.guides.springboot2jpacrudexample.service"})
@EnableSwagger2
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	
	//http://localhost:8080/swagger-ui.html
	
    @Bean
    public Docket swaggerConfiguration() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()             
                .paths(PathSelectors.ant("/api/v1/*"))
                .apis(RequestHandlerSelectors.basePackage("net.guides.springboot2.springboot2jpacrudexample.controller"))
                .build()
                .apiInfo(apiDetails());
    }
    
    
    private ApiInfo apiDetails(){
    	return new ApiInfo("Address Book API",
    			"Sample API for poronga", "1.0",
    			"Free to use", null, "Api Licence",
    			"www.pepe.com",
    			Collections.emptyList());    	
    }
    
    
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }   

}
	

