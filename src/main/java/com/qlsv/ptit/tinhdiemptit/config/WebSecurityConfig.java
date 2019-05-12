package com.qlsv.ptit.tinhdiemptit.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/", "/js/**", "/css/**").permitAll()
			.antMatchers("/monhoc/INT1408/**").hasAnyRole("TEACHERINT1408", "ADMIN")
			.antMatchers("/monhoc/INT1416/**").hasAnyRole("TEACHERINT1416", "ADMIN")
			.antMatchers("/monhoc/INT1427/**").hasAnyRole("TEACHERINT1427", "ADMIN")
			.antMatchers("/cauhinh/**").hasRole("ADMIN")
			.anyRequest().authenticated()
				.and()
			.formLogin()
				.loginPage("/login")
				.loginProcessingUrl("/authenticateUser").permitAll()
				.defaultSuccessUrl("/", true)
				.and()
			.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).permitAll()
			.deleteCookies("JSESSIONID")
				.and()
			.rememberMe().key("uniqueAndSecret").tokenValiditySeconds(86400)
				.and()
			.exceptionHandling().accessDeniedPage("/access-denied");
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		InMemoryUserDetailsManagerConfigurer<AuthenticationManagerBuilder> mngConfig = auth.inMemoryAuthentication();
//		UserDetails user = User.withUsername("admin").password("{noop}admin").roles("ADMIN").build();
//		mngConfig.withUser(user);
		auth.jdbcAuthentication().dataSource(dataSource);
	}

}
