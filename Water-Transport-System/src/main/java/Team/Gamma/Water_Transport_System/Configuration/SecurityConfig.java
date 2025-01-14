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
                        .requestMatchers("/api/v1/user/signup",
                                "api/v1/user/**",
                                "/api/v1/user/login",
                                "/api/v1/user/Adminlogin",
                                "/api/v1/user/logout",
                                "/api/v1/user/details",
                                "/api/v1/user/profile",
                                "/api/v1/user/ask",
                                "api/v1/user/getQueries",
                                "/shipdetails/**",
                                "/admindetails",
                                "/api/v1/shipdetails",
                                "api/admindetails/adminedit",
                                "/api/admindetails",
                                "/usermanagement",
                                "/shipdetails/search",
                                "/admindetails/Shipadd",
                                "/bookings/**",
                                "/bookings/getBookings",
                                "/api/admindetails/Shipadd",
                                "/api/v1/bookings",
                                "/payments/**",
                                "/passengerDetails","/revenue/**","/receipts/generate/**").permitAll() // Allow public access
                        .anyRequest().authenticated() // Secure all other endpoints
                )
                .httpBasic(basic -> {}); // Enable Basic Authentication

        return http.build();
    }
}