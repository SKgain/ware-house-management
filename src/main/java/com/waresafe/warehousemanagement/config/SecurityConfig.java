package com.waresafe.warehousemanagement.config;

import org.apache.catalina.filters.HttpHeaderSecurityFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails customer = User.withDefaultPasswordEncoder()
                .username("customer")
                .password("password1")
                .roles("CUSTOMER")
                .build();
        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("password2")
                .roles("ADMIN")
                .build();
        UserDetails supplier = User.withDefaultPasswordEncoder()
                .username("supplier")
                .password("password3")
                .roles("SUPPLIER")
                .build();
        UserDetails employee = User.withDefaultPasswordEncoder()
                .username("employee")
                .password("password4")
                .roles("EMPLOYEE")
                .build();
        UserDetails warehouse = User.withDefaultPasswordEncoder()
                .username("warehouse")
                .password("password5")
                .roles("WAREHOUSE")
                .build();

        return new InMemoryUserDetailsManager(customer, admin, supplier, employee, warehouse);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/public/**", "/swagger-ui/**", "/v3/api-docs/**").permitAll()
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .requestMatchers("/customer/**").hasAnyRole("CUSTOMER", "ADMIN")
                        .requestMatchers("/supplier/**").hasAnyRole("SUPPLIER", "ADMIN")
                        .requestMatchers("/employee/**").hasAnyRole("EMPLOYEE","ADMIN")
                        .requestMatchers("/warehouse/**").hasAnyRole("WAREHOUSE","ADMIN")
                        .anyRequest().authenticated()
                )
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }
}
