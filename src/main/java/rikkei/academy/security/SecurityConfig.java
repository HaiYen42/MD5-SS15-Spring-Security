package rikkei.academy.security;

import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("YenElli").password("{noop}123").roles("USER")
                .and().withUser("admin").password("{noop}456").roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //authorizeRequests-->Đã đăng nhập rồi
        //antMatchers('/')--> được phép làm việc với ánh xạ nào (ánh xạ bên trong),
        http
                .authorizeRequests().antMatchers("/auth/user").hasRole("USER")
                .and().authorizeRequests().antMatchers("/auth/admin").hasRole("ADMIN")
                .and().formLogin()   //loginPage("/")--> Đến trang của m
                .and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
    }
}
