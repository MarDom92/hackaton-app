package com.example.eventApp.config;

import com.example.eventApp.service.UserDetailsServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private UserDetailsServiceImp userDetailsService;

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public WebSecurityConfig(UserDetailsServiceImp userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication().withUser("pawel.gorski").password(getPasswordEncoder().encode("password")).roles("USER");
        auth.inMemoryAuthentication().withUser("zenon.kowalski").password(getPasswordEncoder().encode("password")).roles("USER");
        auth.inMemoryAuthentication().withUser("kazimierz.wielki").password(getPasswordEncoder().encode("password")).roles("USER");
        auth.inMemoryAuthentication().withUser("jakub.nowak").password(getPasswordEncoder().encode("password")).roles("USER");
        auth.inMemoryAuthentication().withUser("a").password(getPasswordEncoder().encode("a")).roles("USER");

        //        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //allows access to the database
        http.csrf().disable();

        //endpoints and role access settings
        http.httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers("/")
                .hasAnyAuthority()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .defaultSuccessUrl("/users", true)
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login")
                .permitAll();
    }
}
