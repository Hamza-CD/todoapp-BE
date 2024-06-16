//package org.codedistrict.sample.ToDoApplication.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.firewall.HttpFirewall;
//import org.springframework.security.web.firewall.StrictHttpFirewall;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests(authorize -> authorize
//                        .requestMatchers("/login", "/register").permitAll()
//                        .anyRequest().authenticated()
//                )
//                .formLogin(form -> form
//                        .loginPage("/login")
//                        .loginProcessingUrl("/login")
//                        .defaultSuccessUrl("/home", true)
//                        .permitAll()
//                )
//                .logout(logout -> logout
//                        .permitAll()
//                )
//                .cors().and().csrf().disable();
//
//        http.setSharedObject(HttpFirewall.class, allowSemicolonHttpFirewall());
//        return http.build();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public HttpFirewall allowSemicolonHttpFirewall() {
//        StrictHttpFirewall firewall = new StrictHttpFirewall();
//        firewall.setAllowSemicolon(true);
//        return firewall;
//    }
//}
