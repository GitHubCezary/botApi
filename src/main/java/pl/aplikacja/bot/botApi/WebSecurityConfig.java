package pl.aplikacja.bot.botApi;

import com.vaadin.flow.spring.security.VaadinWebSecurity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

@EnableWebSecurity
@Configuration
//@EnableWebMvc
public class WebSecurityConfig extends VaadinWebSecurity {
    private static final String LOGIN_URL = "/login";
    private static final String TARGET_URL = "/testApi";

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        http.oauth2Login().loginPage(LOGIN_URL).permitAll();
    }

    @Bean
    public AuthenticationSuccessHandler authenticationSuccessHandler() {
        SimpleUrlAuthenticationSuccessHandler handler = new SimpleUrlAuthenticationSuccessHandler();
        handler.setDefaultTargetUrl(TARGET_URL);
        return handler;
    }

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http, HandlerMappingIntrospector introspector) throws Exception {
//        MvcRequestMatcher.Builder mvcMatcherBuilder = new MvcRequestMatcher.Builder(introspector);
//        http.authorizeHttpRequests((requests) -> {
//
//            try {
//                requests
//                        .requestMatchers(mvcMatcherBuilder.pattern(LOGIN_URL))
//                        .anonymous()
//                        .requestMatchers(VaadinSecurityUtils::isVaadinInternalRequest)
//                        .authenticated()
//                        .requestMatchers(mvcMatcherBuilder.pattern("/test1"))
//                        .authenticated()
//                        .anyRequest()
//                        .permitAll()
//                        .and()
//                        .oauth2Login()
//                        .loginPage(LOGIN_URL)
//                        .permitAll()
//                        .and()
//                        .csrf().disable();
//                ;
//
//            } catch (Exception e) {
//                throw new RuntimeException(e);
//            }
//
//        });
//        return http.build();
//    }
//

}




