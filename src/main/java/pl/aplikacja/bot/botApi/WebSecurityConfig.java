package pl.aplikacja.bot.botApi;


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


@Configuration
@EnableWebMvc
public class WebSecurityConfig {


    @Bean
    public ClientRegistrationRepository clientRegistrationRepository() {
        return new InMemoryClientRegistrationRepository(googleClientRegistration());
    }


    private ClientRegistration googleClientRegistration1() {
        return ClientRegistration.withRegistrationId("github")
                .clientId("fb3f753a7365e37f0479")
                .clientSecret("45244998436e8c3140f9e27dd4f60402ca40cb79")
                .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
                .redirectUri("{baseUrl}/login/oauth2/code/{registrationId}")
                .scope("openid")
                .authorizationUri("https://github.com/login/oauth/authorize")
                .tokenUri("https://github.com/login/oauth/access_token")
                .userInfoUri("https://api.github.com/user")
                .userNameAttributeName(IdTokenClaimNames.SUB)
                .clientName("GitHub")
                .build();
    }

    private ClientRegistration googleClientRegistration() {
        return ClientRegistration.withRegistrationId("google")
                .clientId("544172631662-3sj598scne4q72lr9ou99b2ubf7ire7r.apps.googleusercontent.com")
                .clientSecret("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")
                .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
                .redirectUri("{baseUrl}/login/oauth2/code/{registrationId}")
                .scope("openid", "profile", "email", "address", "phone")
                .authorizationUri("https://accounts.google.com/o/oauth2/v2/auth")
                .tokenUri("https://www.googleapis.com/oauth2/v4/token")
                .userInfoUri("https://www.googleapis.com/oauth2/v3/userinfo")
                .userNameAttributeName(IdTokenClaimNames.SUB)
                .jwkSetUri("https://www.googleapis.com/oauth2/v3/certs")
                .clientName("Google")
                .build();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, HandlerMappingIntrospector introspector) throws Exception {
        MvcRequestMatcher.Builder mvcMatcherBuilder = new MvcRequestMatcher.Builder(introspector);
        http.authorizeHttpRequests((requests) -> {

            try {
                requests
                        .requestMatchers(mvcMatcherBuilder.pattern("hello"))
                        .permitAll()
                        .requestMatchers(mvcMatcherBuilder.pattern("/test2"))
                        .authenticated()
                        .anyRequest()
                        .authenticated()
                        .and()
                        .oauth2Login().loginPage("/login")
                        .defaultSuccessUrl("/hello")
                        .and()
                        .logout()
                        .logoutSuccessUrl("/")
                        .permitAll();

            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        });
        return http.build();
    }


}




