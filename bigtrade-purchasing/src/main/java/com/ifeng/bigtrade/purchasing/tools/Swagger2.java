//package com.ifeng.bigtrade.purchasing.tools;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//@Configuration
//@EnableSwagger2
//public class Swagger2 extends WebMvcConfigurerAdapter
//{
//	@Override
//	public void addResourceHandlers(ResourceHandlerRegistry registry)
//	{
//		super.addResourceHandlers(registry);
//		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
//		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
//	}
//
//	@Bean
//	public Docket createRestApi()
//	{
//		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
//				.apis(RequestHandlerSelectors.basePackage("com.ifeng.bigtrade.purchasing")).paths(PathSelectors.any()).build();
//	}
//
//	private ApiInfo apiInfo()
//	
//	{
////		return new ApiInfoBuilder().title("申购服务系统接口API").termsOfServiceUrl("github https://github.com/Doubletreelin/myproject")
////				.termsOfServiceUrl("blog http://blog.csdn.net/qq_27808011").contact("doubletree.lin").version("1.0").build();
//		
//		  return new ApiInfoBuilder()
//		            .title("申购服务系统接口API")//大标题
//		            .description("blog http://blog.csdn.net/qq_27808011  github https://github.com/Doubletreelin/myproject")//详细描述
////		            .license("github https://github.com/Doubletreelin/myproject")
//		            .version("1.0")//版本
//		            .termsOfServiceUrl("NO terms of service")
//		            .contact("doubletree ")//作者
//		            .termsOfServiceUrl("")
//		            .build();
//	}
//
//}
