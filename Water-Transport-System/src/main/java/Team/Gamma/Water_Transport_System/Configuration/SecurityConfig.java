package Team.Gamma.Water_Transport_System.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/v1/user/signup",
                                "/api/v1/user/login",
                                "/api/v1/user/logout" ,
                                "/api/v1/user/details",
                                "/api/v1/user/profile",
                                "/api/v1/user/ask",
                                "/api/v1/shipdetails",
                                "/api/v1/admindetails",
                                "/api/v1/bookings",
                                "/api/v1/payments",
                                "/api/v1/receipts").permitAll()
                        .anyRequest().authenticated()
                )
                .httpBasic(basic -> {});
        return http.build();
    }
}


