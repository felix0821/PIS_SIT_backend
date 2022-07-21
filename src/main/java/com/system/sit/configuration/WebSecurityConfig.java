package com.system.sit.configuration;

import static com.system.sit.attached.constant.RouteConstant.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.system.sit.security.JwtEntryPoint;
import com.system.sit.security.JwtTokenFilter;
import com.system.sit.service.method.UserDetailsServiceImplements;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	private String[] openResources = new String[]{
			"/css/**","/icons/**","/img/**","/js/**","/layer/**","/","/index","/person/recovery-password",
			"/auth/**",URL_SIGNUP_POST,URL_SIGNUP_V2_POST,"/","/generate-data", "/favicon.ico","/alert-websocket/**",
			"/gs-guide-websocket/**","/person/**"
    }; //, "/app","/topic","/hello","/topic/**"
	
	private String[] securedResources = new String[] {"/secured/**/**", "/secured/success", "/secured/socket", "/secured/success"};
	
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
    UserDetailsServiceImplements userDetailsService;

    @Autowired
    JwtEntryPoint jwtEntryPoint;
    
	@Override
    protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable();
		http.authorizeRequests().antMatchers(openResources).permitAll();
		http.authorizeRequests().antMatchers(securedResources).authenticated()
				.anyRequest().authenticated()
                .and()
                .exceptionHandling().authenticationEntryPoint(jwtEntryPoint)
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(jwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    public JwtTokenFilter jwtTokenFilter(){
        return new JwtTokenFilter();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
		bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

}