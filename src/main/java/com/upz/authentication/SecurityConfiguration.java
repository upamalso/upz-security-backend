package com.upz.authentication;

import com.upz.service.ApplicationUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Autowired
    private ApplicationUserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

       /*auth.inMemoryAuthentication().withUser("foo")
       .password("foo")
       .roles("USER")
       .and()
       .withUser("upz")
       .password("123")
       .roles("ADMIN");*/

       /*auth.jdbcAuthentication()
               .dataSource(dataSource);*/

       auth.userDetailsService(userDetailsService);
    }



    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder(); //NoOpPasswordEncoder.getInstance();
    }



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin").hasRole("ADMIN")
                //.antMatchers("/user").hasAnyRole("USER", "ADMIN")
                .antMatchers("/user/**").permitAll()
                .antMatchers("/upz").permitAll()
                .antMatchers("/register").permitAll().and().csrf().disable();
    }
}
