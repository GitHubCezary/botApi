package pl.aplikacja.bot.botApi;

import jakarta.servlet.ServletException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.core.oidc.IdTokenClaimNames;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

import javax.security.auth.login.LoginException;


@Configuration
@EnableWebMvc
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, HandlerMappingIntrospector introspector) throws Exception {
        MvcRequestMatcher.Builder mvcMatcherBuilder = new MvcRequestMatcher.Builder(introspector);
        http.authorizeHttpRequests((requests) -> {

            try {
                requests
                        .requestMatchers(mvcMatcherBuilder.pattern("/test1"))
                        .permitAll()
                        .requestMatchers(VaadinSecurityUtils::isVaadinInternalRequest)
                        .authenticated()
                        .anyRequest()
                        .authenticated()
                        .and()
                        .oauth2Login()
                        .and()
                        .csrf().disable();
                ;

            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        });
        return http.build();
    }


}




