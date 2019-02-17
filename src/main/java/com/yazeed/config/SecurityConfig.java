package com.yazeed.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@CrossOrigin
class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSourse;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        /*
         * Specify the list of authenticated users
         */
//        auth.inMemoryAuthentication()
//                .withUser("Yazeed").password(encoder().encode("1234")).roles("USER").and()
//                .passwordEncoder(encoder());
//
////
//
//
//
//        //this if you have user&password table And role tables in the DB
//        auth.jdbcAuthentication().passwordEncoder(encoder()).dataSource(dataSourse);




        auth.jdbcAuthentication().dataSource(dataSourse)
                .usersByUsernameQuery("select userid,password,enabled"
                        + " from USERS where userid=?")
                .authoritiesByUsernameQuery("select userid, rolename "
                        + "from USERS where userid=?")
                .passwordEncoder(new BCryptPasswordEncoder());



    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /*
         * Which endpoints can accessed by which users
         */
//
//        // Secures all bar the get endpoints
//        http.httpBasic().and().csrf().disable() // All user can get request
//                .authorizeRequests()
//                .antMatchers(HttpMethod.POST).authenticated() // only authenticated user will post new teams
//                .antMatchers(HttpMethod.PUT).authenticated() // only authenticated user will update teams
//                .antMatchers(HttpMethod.DELETE).authenticated(); // only authenticated user will delete teams


        http.csrf().disable().authorizeRequests()
                .antMatchers("/api/user/add").permitAll()
                .antMatchers("/userData").permitAll()

                .anyRequest().authenticated().and().httpBasic().and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//                .antMatchers("/login").permitAll()
//                .antMatchers("/api/admin/users/all").permitAll()
//                .antMatchers("/api/admin/users/{userid}").permitAll()
//                .antMatchers("/api/update/user/{userid}").permitAll()
//                .authorizeRequests().antMatchers("/api/admin/**").hasRole("ADMIN")
//                .antMatchers("/api/organizer/**").hasRole("ORGANIZER")
//                .antMatchers("/api/**").hasAnyRole("ADMIN","ORGANIZER","USER")
//                .and().httpBasic(); // Authenticate users with HTTP basic authentication

    }
}

