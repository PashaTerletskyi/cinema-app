package cinema.config;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    public SecurityConfig(UserDetailsService userDetailsService,
                          PasswordEncoder passwordEncoder) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers(HttpMethod.POST,"/register").permitAll()
                .antMatchers(HttpMethod.GET,"/cinema-halls",
                        "/movies",
                        "/movie-sessions/available",
                        "/movie-sessions/{id}").hasAnyRole("ADMIN","USER")
                .antMatchers(HttpMethod.POST,"/cinema-halls",
                        "/movies",
                        "/movie-sessions"
                        ).hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/users/by-email").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT,"/movie-sessions/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE,"/movie-sessions/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/orders",
                        "/shopping-carts/by-user").hasRole("USER")
                .antMatchers(HttpMethod.POST,"/complete",
                        "/shopping-carts/movie-sessions").hasRole("USER")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .permitAll()
                .and()
                .httpBasic()
                .and()
                .csrf().disable();
    }
}