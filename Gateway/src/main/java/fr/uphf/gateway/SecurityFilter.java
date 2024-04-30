package fr.uphf.gateway;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.web.cors.CorsConfiguration;

@Configuration
@EnableReactiveMethodSecurity
@EnableWebFluxSecurity
public class SecurityFilter {

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
        http.authorizeExchange(authorize -> authorize
                        .pathMatchers(HttpMethod.GET, "/commandes/**", "/clients/**", "/restaurants/**")
                        .hasAuthority("SCOPE_all")
                        .pathMatchers(HttpMethod.POST, "/commandes/**", "/clients/**", "/restaurants/**")
                        .hasAuthority("SCOPE_all")
                        .anyExchange().authenticated())
                .oauth2ResourceServer(ServerHttpSecurity.OAuth2ResourceServerSpec::jwt)
                .cors(cors -> cors.configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues()));
        return http.build();
    }
}