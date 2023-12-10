package pl.aplikacja.bot.botApi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class VaadinConfig {

    @Bean
    public SecurityFilterChain securityFilterChain2(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(authorizeRequests -> authorizeRequests.requestMatchers(VaadinSecurityUtils::isVaadinInternalRequest).permitAll()
                        .anyRequest().authenticated())
                .oauth2Login()
                .permitAll()
                .and()
                .csrf().disable();

        return http.build();
    }

}

