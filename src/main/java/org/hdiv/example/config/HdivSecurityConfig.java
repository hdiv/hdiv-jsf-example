package org.hdiv.example.config;

import org.hdiv.config.annotation.EnableHdivWebSecurity;
import org.hdiv.config.annotation.ExclusionRegistry;
import org.hdiv.config.annotation.RuleRegistry;
import org.hdiv.config.annotation.ValidationConfigurer;
import org.hdiv.config.annotation.builders.SecurityConfigBuilder;
import org.hdiv.config.annotation.configuration.HdivWebSecurityConfigurerAdapter;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableHdivWebSecurity
public class HdivSecurityConfig extends HdivWebSecurityConfigurerAdapter {

	@Override
	public void configure(SecurityConfigBuilder builder) {
		builder
			.confidentiality(false)
			.cookiesConfidentiality(true);
	}
	
	@Override
	public void addExclusions(ExclusionRegistry registry) {

		registry.addUrlExclusions("/","/javax.faces.resource/.*","/home.faces").method("GET");
		registry.addUrlExclusions("/images/.*");
		
		registry.addParamExclusions("javax.faces.*");
	}

	@Override
	public void addRules(RuleRegistry registry) {

		registry.addRule("safeText").acceptedPattern("^[a-zA-Z0-9@.\\-_]*$");
	}

	@Override
	public void configureEditableValidation(ValidationConfigurer validationConfigurer) {

		validationConfigurer.addValidation(".*").rules("safeText");
	}
}
