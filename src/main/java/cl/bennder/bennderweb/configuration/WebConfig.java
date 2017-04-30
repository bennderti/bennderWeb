package cl.bennder.bennderweb.configuration;

import cl.bennder.bennderweb.multitenancy.MultiTenancyInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = { "cl.bennder.bennderweb" })
public class WebConfig extends WebMvcConfigurerAdapter{
	@Autowired
	MultiTenancyInterceptor multiTenancyInterceptor;

	@Bean
    public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver
                          = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/jsp/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	@Bean
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
		return resolver;
	}


	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//registry.addInterceptor(multiTenancyInterceptor).addPathPatterns("/**");
	}
}