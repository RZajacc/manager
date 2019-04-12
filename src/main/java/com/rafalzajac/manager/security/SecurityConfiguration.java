package com.rafalzajac.manager.security;

import com.rafalzajac.manager.service.MyUserDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Class handling web security. Creates a bean for authentication provider, password encoder and overrides two methods
 * for configuration, Authentication Builder and HTTP Security.
 */
@Configuration
@Slf4j
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserDetailsService userDetailsService;

    /**
     * Method returning authentication provider which accepts custom user details service as argument
     * @return
     */
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider
                = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(encoder());
        return authProvider;
    }

    /**
     * BCrypt password encoder bean definition
     * @return
     */
    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder(11);
    }

    /**
     * Configuration for authentication provider accepting as argument the one defined in bean previously
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    /**
     * Http request security specification. Basicly it restricts for non logged user only a profile page. It's not
     * necessary becuase its hidden for non logged users anyway, but this way you cant access it through url adress.
     * After logging out it clears session and cookies.
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()
                    .antMatchers("/profile").access("hasRole('ROLE_USER')")
                    .antMatchers("/", "/**").access("permitAll()")

                .and()
                .formLogin()
                .loginPage("/login")

                .and()
                .logout()
                    .logoutSuccessUrl("/login")
                    .deleteCookies("JSESSIONID")
                    .clearAuthentication(true)
                    .invalidateHttpSession(true);

    }
}
