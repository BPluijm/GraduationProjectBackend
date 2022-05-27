package com.graduation.backend.config;

import com.graduation.backend.model.JwtRequestFilter;
import com.graduation.backend.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    JwtService jwtService;

    @Bean
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return super.userDetailsService();
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth

                .jdbcAuthentication()
                .passwordEncoder(passwordEncoder)
                .dataSource(dataSource)
                .usersByUsernameQuery("select username, password, enabled from users where username=?")
                .authoritiesByUsernameQuery("select username, role from users where username=?");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic()
                .and()
                // door onderstaande worden geen cookies gegenereerd
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/auth").permitAll()
                .antMatchers(HttpMethod.GET,"/**").authenticated()
                .antMatchers(HttpMethod.GET,"/travels/**").hasAnyAuthority("ADMIN", "USER")
                .antMatchers(HttpMethod.POST,"/travels/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.PUT,"/travels/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.DELETE,"/travels/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.GET,"/favorites/**").hasAnyAuthority("ADMIN", "USER")
                .antMatchers(HttpMethod.POST,"/favorites/**").hasAnyAuthority("ADMIN", "USER")
                .antMatchers(HttpMethod.DELETE,"/favorites/**").hasAnyAuthority("ADMIN", "USER")
                .antMatchers(HttpMethod.GET,"/flyer/**").hasAnyAuthority("ADMIN", "USER")
                .antMatchers(HttpMethod.POST,"/flyer/**").hasAnyAuthority("ADMIN", "USER")
                .antMatchers(HttpMethod.PUT,"/flyer/**").hasAnyAuthority("ADMIN", "USER")
                .antMatchers(HttpMethod.DELETE,"/flyer/**").hasAnyAuthority("ADMIN")
                .antMatchers(HttpMethod.GET,"/future-travels/**").hasAnyAuthority("ADMIN", "USER")
                .antMatchers(HttpMethod.POST,"/future-travels/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.PUT,"/future-travels/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.DELETE,"/future-travels/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.GET,"/hotspots/**").hasAnyAuthority("ADMIN", "USER")
                .antMatchers(HttpMethod.POST,"/hotspots/**").hasAnyAuthority("ADMIN", "USER")
                .antMatchers(HttpMethod.PUT,"/hotspots/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.DELETE,"/hotspots/**").hasAnyAuthority("ADMIN", "USER")
                .antMatchers(HttpMethod.GET,"/travel-tips/**").hasAnyAuthority("ADMIN", "USER")
                .antMatchers(HttpMethod.POST,"/travel-tips/**").hasAnyAuthority("ADMIN", "USER")
                .antMatchers(HttpMethod.PUT,"/travel-tips/**").hasAnyAuthority("ADMIN", "USER")
                .antMatchers(HttpMethod.DELETE,"/travel-tips/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.GET,"/users/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.POST,"/users/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.PUT,"/users/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.DELETE,"/users/**").hasAuthority("ADMIN")
                .and()
                .authorizeRequests().anyRequest().authenticated()
                .and()
                .addFilterBefore(new JwtRequestFilter(jwtService, userDetailsService()), UsernamePasswordAuthenticationFilter.class)
                .csrf().disable();
    }
}
