package pl.aplikacja.bot.botApi;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableOAuth2Sso
public class WebSecurityConfig {


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .requestMatchers(AntPathRequestMatcher
                        .antMatcher("/test1"))
                .permitAll()
                .and()
                .authorizeHttpRequests()
                .requestMatchers(AntPathRequestMatcher
                        .antMatcher("/test2"))
                .authenticated()
                .and()
                .formLogin();

        return http.build();

    }
}

