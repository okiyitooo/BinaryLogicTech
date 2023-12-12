package com.BinaryLogic.Paintings.SecurityConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfiguracion {
	@Bean
	public InMemoryUserDetailsManager userDetailsManager() {
		UserDetails sam = User.builder()
				.username("sam")
				.password("{noop}Sam'sPassword")
				.roles("Guy")
				.build();
		UserDetails john = User.builder()
				.username("Cena")
				.password("{noop}")
				.roles("Guy","Wrestler")
				.build();
		UserDetails Jotaro = User.builder()
				.username("Jotaro")
				.password("{noop}DioWasHere!!!")
				.roles("Guy","Wrestler","ORA!","norioku")
				.build();
		UserDetails DIO = User.builder()
				.username("JOESTARCRUSHER")
				.password("{noop}JotaroIsGay(┬┬﹏┬┬)")
				.roles("Guy","Wrestler","MUDA!!!","norioku","GOD")
				.build();
		return new InMemoryUserDetailsManager(sam,john,Jotaro,DIO);
	};
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) {
//		try {
//			        http.authorizeHttpRequests()
//			                .requestMatchers("/login").permitAll() // Allow access to login page without authentication
//			                .requestMatchers("/admin/**").hasAnyRole("ADMIN", "GOD") // Only users with ADMIN or GOD role can access /admin/** resources
//			                .requestMatchers("/wrestling/**").hasAnyRole("Guy", "Wrestler") // Users with Guy or Wrestler role can access /wrestling/** resources
//			                .requestMatchers("/secret/**").hasRole("ORA!") // Only users with ORA! role can access /secret/** resources
//			                .anyRequest().authenticated() // All other requests require authentication
//			                .and()
//			            .formLogin()
//			                .loginPage("/login") // Customize login page URL
//			                .defaultSuccessUrl("/home") // Redirect to home page after successful login
//			                .permitAll()
//			                .and()
//			            .logout()
//			                .logoutUrl("/logout") // Customize logout URL
//			                .permitAll();
//
//			        return http.build();
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
		try {
			http.authorizeHttpRequests(configurer -> configurer
					.requestMatchers(HttpMethod.GET,"/paintings").hasAnyRole("Guy","Wrestler","norioku")
					.requestMatchers(HttpMethod.GET,"/paintings/**").hasAnyRole("Guy","Wrestler","norioku")
					.requestMatchers(HttpMethod.POST,"/paintings").hasAnyRole("Wrestler","norioku")
					.requestMatchers(HttpMethod.PUT,"/paintings/**").hasAnyRole("norioku")
					.requestMatchers(HttpMethod.DELETE,"/paintings/**").hasAnyRole("norioku")
					);
			http.httpBasic(Customizer.withDefaults());
			http.csrf(csrf->csrf.disable());
			return http.build();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
