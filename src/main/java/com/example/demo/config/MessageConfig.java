package com.example.demo.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
public class MessageConfig {
	
	@Bean
	public MessageSource messageSource() {
		var source=new ReloadableResourceBundleMessageSource();
		 source.setBasenames("classpath:i18n/messages","classpath:i18n/ValidationMessages");
		  source.setDefaultEncoding("UTF-8");
		   source.setFallbackToSystemLocale(false);
		   return source;
	}
	@Bean
	public LocalValidatorFactoryBean getValidator() {
		var bean = new LocalValidatorFactoryBean();
		 bean.setValidationMessageSource(messageSource());
		 return bean;
	}

}
