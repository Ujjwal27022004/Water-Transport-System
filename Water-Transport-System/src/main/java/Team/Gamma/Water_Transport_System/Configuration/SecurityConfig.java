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
                .csrf(csrf -> csrf.disable()) // Disable CSRF for simplicity (adjust based on your app's needs)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/v1/user/signup", "/api/v1/user/**", "/api/v1/user/logout" , "/api/v1/user/details" , "/api/v1/user/ask" ).permitAll() // Allow public access
                        .anyRequest().authenticated() // Secure all other endpoints
                )
                .httpBasic(basic -> {}); // Enable Basic Authentication

        return http.build();
    }
}
