package ch.ny.demo.security;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import ch.ny.demo.person.PersonService;

/**
 * This class is the main security context
 *
 * @author Yves Kaufmann
 */
@EnableWebSecurity
@PropertySource("classpath:application.properties")
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	// field injection because this class doesn't need to be tested
	@Autowired @Qualifier("personService") private PersonService userService;

	@Autowired private BCryptPasswordEncoder pwEncoder;
	
	@Autowired private Properties properties;

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// registers the UserDetailsService (used to loadByUsername) and the password
		// encoder to be used
		auth.userDetailsService(userService).passwordEncoder(pwEncoder);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// create filters for later use
		var authenticationReqMatcher = new AntPathRequestMatcher("/login", "POST");
		var authenticationFilter = 
				new JWTAuthenticationFilter(authenticationManager(), properties, authenticationReqMatcher);
		
		var authorizationFilter = 
				new JWTAuthorizationFilter(userService, properties);
		
		// configure security
		http.csrf().disable()
			.authorizeRequests()
				.antMatchers("/welcome", "/login", "/v2/api-docs", "/swagger-resources/**", "/swagger-ui.html",
						"/webjars/**", "/fachrichtung", "/berfusbdilner", "/ort", "/roles", "/authorities")
				.permitAll()
			.anyRequest().authenticated().and()
			.addFilterAfter(
					authenticationFilter,
					UsernamePasswordAuthenticationFilter.class)
			.addFilterAfter(
					authorizationFilter,
					UsernamePasswordAuthenticationFilter.class)
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}

}
