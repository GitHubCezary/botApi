package pl.aplikacja.bot.botApi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@Configuration
@EnableWebMvc
public class WebSecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsConfig() {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("password")
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(user);
    }

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
                .authenticated();
        return http.build();

    }


//    public SecurityFilterChain filterChain2(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests((authz2) -> authz2.requestMatchers("/test1").anonymous()
//                )
//                .httpBasic(Customizer.withDefaults());
//        return http.build();
//    }


}

