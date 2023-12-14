//package pl.aplikacja.bot.botApi;
//
//
//import com.vaadin.flow.spring.security.VaadinWebSecurity;
//import org.slf4j.LoggerFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.oauth2.client.registration.ClientRegistration;
//import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
//import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
//import org.springframework.security.oauth2.core.AuthorizationGrantType;
//import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
//import org.springframework.security.oauth2.core.oidc.IdTokenClaimNames;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.handler.HandlerMappingIntrospector;
//
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import static org.springframework.security.config.Customizer.withDefaults;
//
//@EnableWebSecurity
//@Configuration
//@EnableWebMvc
//public class SecurityConfig {
//
//    @Bean
//    public ClientRegistrationRepository clientRegistrationRepository() {
//        return new InMemoryClientRegistrationRepository(googleClientRegistration1(),googleClientRegistration());
//    }
//
//
//    private ClientRegistration googleClientRegistration1() {
//        return ClientRegistration.withRegistrationId("github")
//                .clientId("76aea9fb3a42c886d491")
//                .clientSecret("847f8b572c054f089fcdaa2d017cf6f62b6ef2c3")
//                .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
//                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
//                .redirectUri("http://localhost:8080/login")
//                .scope("openid")
//                .authorizationUri("https://github.com/login/oauth/authorize")
//                .tokenUri("https://github.com/login/oauth/access_token")
//                .userInfoUri("https://api.github.com/user")
//                .userNameAttributeName(IdTokenClaimNames.SUB)
//                .clientName("GitHub")
//                .build();
//    }
//
//    private ClientRegistration googleClientRegistration() {
//        return ClientRegistration.withRegistrationId("google")
//                .clientId("544172631662-3sj598scne4q72lr9ou99b2ubf7ire7r.apps.googleusercontent.com")
//                .clientSecret("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")
//                .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
//                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
//                .redirectUri("{baseUrl}/login/oauth2/code/{registrationId}")
//                .scope("openid", "profile", "email", "address", "phone")
//                .authorizationUri("https://accounts.google.com/o/oauth2/v2/auth")
//                .tokenUri("https://www.googleapis.com/oauth2/v4/token")
//                .userInfoUri("https://www.googleapis.com/oauth2/v3/userinfo")
//                .userNameAttributeName(IdTokenClaimNames.SUB)
//                .jwkSetUri("https://www.googleapis.com/oauth2/v3/certs")
//                .clientName("Google")
//                .build();
//    }
//
//    private static final Logger logger = LoggerFactory.getLogger(SecurityConfig.class);
//
//
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http, HandlerMappingIntrospector introspector) throws Exception {
//        MvcRequestMatcher.Builder mvcMatcherBuilder = new MvcRequestMatcher.Builder(introspector);
//        http.authorizeHttpRequests((requests) -> {
//            try {
//                requests
//                        .requestMatchers(mvcMatcherBuilder.pattern("/test1"))
//                        .permitAll()
//                        .requestMatchers(mvcMatcherBuilder.pattern("/test2"))
//                        .authenticated()
//                        .anyRequest().authenticated()
//                        .and()
//                        .oauth2Login(withDefaults());
//
//            } catch (Exception e) {
//                logger.error("Error in security configuration", e);
//                throw new RuntimeException(e);
//            }
//        });
//        return http.build();
//    }
//}