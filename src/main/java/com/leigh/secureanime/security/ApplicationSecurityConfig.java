package com.leigh.secureanime.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static com.leigh.secureanime.security.ApplicationUserRole.*;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http    .csrf().disable() //TODO : This will need to be removed, temporary fix to allow POST and PUT apis to work
                .authorizeRequests()
                .antMatchers("/", "index", "/css/*", "/js/*").permitAll()
                .antMatchers("/api/**").hasRole(USER.name())
                .antMatchers("/admin/**").hasRole(ADMIN_TRAINEE.name())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
//                This is what you use if you want to have form login instead
//                .formLogin()
    }

    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        System.out.println ("TEST - " + passwordEncoder.encode("testpass"));

        UserDetails user = User.builder()
                .username("Leigh")
                .password(passwordEncoder.encode("testpass"))
                .roles(USER.name())
                .build();

        UserDetails adminTrainee = User.builder()
                .username("Trinity")
                .password(passwordEncoder.encode("testpass"))
                .roles(ADMIN_TRAINEE.name())
                .build();

        UserDetails user2 = User.builder()
                .username("Neo")
                .password(passwordEncoder.encode("testpass"))
                .roles(ADMIN.name())
                .build();

        return new InMemoryUserDetailsManager(user, user2, adminTrainee);
    }


}
