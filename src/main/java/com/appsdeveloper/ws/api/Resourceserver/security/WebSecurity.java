package com.appsdeveloper.ws.api.Resourceserver.security;


import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;


//@Configuration
@EnableWebSecurity
public class WebSecurity{
	@Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception {

		JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();

		jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(new KeycloakRoleConverter());



		http.authorizeRequests()

				.antMatchers(HttpMethod.GET, "/users/status/check")

				//.hasAuthority("SCOPE_profile")

				.hasRole("developer")

				.anyRequest().authenticated()

				.and()

				.oauth2ResourceServer()

				.jwt()

				.jwtAuthenticationConverter(jwtAuthenticationConverter);



		return http.build();

	}}
	/*@Bean
     public SecurityFilterChain configure(HttpSecurity http) throws Exception {
		JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
		jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(new KeycloakRoleConverter());
		http
		.authorizeRequests()
		.antMatchers(HttpMethod.GET, "/users/status/check")
		//.hasAuthority("SCOPE_profile")
				.hasRole("fdeveloperrdfdf")
		.anyRequest().authenticated()
		.and()
		.oauth2ResourceServer()
		.jwt()
				.jwtAuthenticationConverter(jwtAuthenticationConverter);
		return http.build();
		}*/
/*
@EnableGlobalMethodSecurity(securedEnabled=true, prePostEnabled=true)
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
		jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(new KeycloakRoleConverter());

		http//.cors().and()
			.authorizeRequests()
					.antMatchers(HttpMethod.GET, "/users/status/check")
					//.hasAuthority("SCOPE_profile")
					.hasRole("developer")
					//.hasAnyAuthority("ROLE_developer")
					//.hasAnyRole("devleoper","user")
				.anyRequest().authenticated()
				.and()
			.oauth2ResourceServer()
			.jwt()
			.jwtAuthenticationConverter(jwtAuthenticationConverter);
	}*/

//	@Bean
//	CorsConfigurationSource corsConfigurationSource() {
//		CorsConfiguration corsConfiguration = new CorsConfiguration();
//		corsConfiguration.setAllowedOrigins(Arrays.asList("*"));
//		corsConfiguration.setAllowedMethods(Arrays.asList("GET","POST"));
//		corsConfiguration.setAllowedHeaders(Arrays.asList("*"));
//
//		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//		source.registerCorsConfiguration("/**", corsConfiguration);
//
//		return source;
//	}
//

