package com.clasedoce.ejerciciodos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain webSecurity(HttpSecurity http)throws Exception{

         http.authorizeHttpRequests(auth->{
            auth.requestMatchers("/publico").permitAll();
                    auth.anyRequest().authenticated();
        }
         ).formLogin(Customizer.withDefaults())
                 .httpBasic(Customizer.withDefaults());
         return http.build();
    }

    @Bean
    public UserDetailsService usuarioCreado(){
        UserDetails user = User
                .withDefaultPasswordEncoder()
                .username("pepe")
                .password("pepe1234")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user);
    }

//    @Bean
//    public UserDetailsService userDetailsService(){
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        manager.createUser(User.withUsername("Lucas").password(passwordEncoder().encode("1234")).roles().build());
//        return manager;
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }

}
