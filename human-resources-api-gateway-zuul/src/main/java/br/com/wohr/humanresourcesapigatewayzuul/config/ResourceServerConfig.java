package br.com.wohr.humanresourcesapigatewayzuul.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
	
	@Autowired
	private JwtTokenStore tokenStore;
	
	@Autowired
	private JwtAccessTokenConverter tokenConverter;
	
	private static final String[] PUBLIC = { "/human-resources-oauth/oauth/token" };

	private static final String[] OPERATOR = { "/human-resources-worker/**" };

	private static final String[] ADMIN = { "/human-resources-payroll/**", "/human-resources-user/**" };

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		
		resources.tokenStore(tokenStore);
		
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
			.antMatchers(PUBLIC).permitAll()
			.antMatchers(HttpMethod.GET, OPERATOR).hasAnyRole("OPERATOR", "ADMIN")
			.antMatchers(ADMIN).hasAnyRole("ADMIN")
			.anyRequest()
			.authenticated();
		
	}

}
