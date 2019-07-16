package com.hon.lib;

import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurationSupport
{
  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
      .select()
      .apis(RequestHandlerSelectors.any())
      .paths(PathSelectors.any())
      .build()
      .apiInfo(new ApiInfoBuilder()
        .title("Library Management APIS")
        .description("APIs for Library Management")
        .version("3.0.0")
        .contact(new Contact("RAM", "", "rambabu.maina@honeywell.com"))
        .extensions(vendors())
        .build());
  }
  private List<VendorExtension> vendors() {
    List<VendorExtension> vendors = new ArrayList<>();
    return vendors;
  }

  @Bean
  public UiConfiguration uiConfig()
  {
    return UiConfigurationBuilder.builder() //
      .displayRequestDuration( true ) //
      .validatorUrl(null) // Disable the validator to avoid "Error" at the bottom of the Swagger UI page
      .build();
  }

  @Override
  protected void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("swagger-ui.html")
      .addResourceLocations("classpath:/META-INF/resources/");
    registry.addResourceHandler("/webjars/**")
      .addResourceLocations("classpath:/META-INF/resources/webjars/");
  }

}