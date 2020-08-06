package br.com.sast.exception;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
public class MensagesPropertiesConfig {

/* Bean de configuração para carregar as mensagens inseridas no arquivo 'messages.properties'*/
	
	@Bean
	public MessageSource messageSource() {
		
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("classpath:messages"); /* Busca o arquivo 'messages.properties' */ 
		messageSource.setDefaultEncoding("ISO-8859-1"); /* Configuração para aceitar caracteres especiais*/
		messageSource.setDefaultLocale(Locale.getDefault()); /* Define a data e hora do sistema operacional */
		
		return messageSource;
	}
	
	/* Bean de configuração para linkar as validações do Bean Validation, com as mensagens do 'messages.properties' */
	
	@Bean
	public LocalValidatorFactoryBean validatorFactoryBean() {
		
		LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
		bean.setValidationMessageSource(messageSource());
		
		return bean;
	}
	
	
}
