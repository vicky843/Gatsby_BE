package com.vicky.gatsby.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.vicky.gatsby.*")
public class Dispatcherconfig extends WebMvcConfigurerAdapter {
/*	private static final Logger logger = LoggerFactory.getLogger(Dispatcherconfig.class);
*/
	@Bean
	public ViewResolver viewResolver() {
/*		logger.debug("starting of the viewresolver");*/

		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");

/*		logger.debug("ending of the view resolver");
*/
		return viewResolver;
	}
}
