package alex.pol.config;

import alex.pol.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.boot.context.web.ErrorPageFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


//@Configuration
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

//    @Autowired
//    @Qualifier("userDetailsService")
//    UserDetailsService userDetailsService;

    @Override
    public void configure(WebSecurity web) throws Exception {

        web.ignoring().antMatchers("/resources/**");

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        System.out.println("ПРОВЕРКА КОНФИГОВ СЕКЬЮРИТИ");

        http
                .authorizeRequests()
                .antMatchers("/", "/home", "/userLogin", "/dashboards", "/saveUser").permitAll()
                .antMatchers("/adminDash").hasAuthority("ADMIN")
                .antMatchers("/userDash").hasAuthority("USER")
                .anyRequest().fullyAuthenticated()
                .and()
                .formLogin()
                .loginPage("/")
                .usernameParameter("email")
                .passwordParameter("password")
                .failureUrl("/loginProblems")
                .permitAll()
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/accountLogout"))
                .and()
                .csrf().disable();
    }

//    @Override
//    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .userDetailsService(userDetailsService)
//                .passwordEncoder(new BCryptPasswordEncoder());
//    }

}

//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .inMemoryAuthentication()
//                .withUser("user")
//                .password("password")
//                .roles("USER")
//                .and()
//                .withUser("admin")
//                .password("password")
//                .roles("ADMIN");
//
//    }





//----------------------------------------

//@Configuration
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
//class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    private UserDetailsService userDetailsService;
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/", "/public/**").permitAll()
//                .antMatchers("/users/**").hasAuthority("ADMIN")
//                .anyRequest().fullyAuthenticated()
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .failureUrl("/login?error")
//                .usernameParameter("email")
//                .permitAll()
//                .and()
//                .logout()
//                .logoutUrl("/logout")
//                .deleteCookies("remember-me")
//                .logoutSuccessUrl("/")
//                .permitAll()
//                .and()
//                .rememberMe();
//    }
//
//    @Override
//    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .userDetailsService(userDetailsService)
//                .passwordEncoder(new BCryptPasswordEncoder());
//    }
//
//}
//----------------------------------------












//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .inMemoryAuthentication()
//                .withUser("user").password("password").roles("USER").and()
//                .withUser("admin@admin.com").password("12345678").roles("ADMIN");
//    }



//    /**
//     * Append extra information to the {@link AuthenticationManagerBuilder} to tell spring where to
//     * get the {@link org.springframework.security.core.userdetails.UserDetails} from and how the
//     * password is to be encrypted.
//     *
//     * @param authenticationManagerBuilder This is passed in by spring and will allow us to append
//     *                                     operations
//     * @throws Exception This is not great but the exception will be thrown on any error. There are
//     *                   many possible exception types. Throwing {@link Exception} is generally
//     *                   considered bad practise.
//     * @see AuthenticationManagerBuilder
//     */
//    @Autowired
//    public void configAuthBuilder(final AuthenticationManagerBuilder authenticationManagerBuilder)
//            throws Exception {
//
//        /**
//         * Inform spring that the {@link org.springframework.security.core.userdetails.UserDetails}
//         * can be gathered from our custom implementation of the
//         * {@link org.springframework.security.core.userdetails.UserDetailsService} which in this
//         * case is {@link AuthenticationUserService}. When spring has gathered the
//         * {@link org.springframework.security.core.userdetails.UserDetails}
//         * then it will check the password provided from the web form to that in the
//         * {@link org.springframework.security.core.userdetails.UserDetails}
//         * this is where the {@code passwordEncoderWrapper} is used as the encoder.
//         */
//        authenticationManagerBuilder.userDetailsService(authenticationUserService)
//                .passwordEncoder(passwordEncoderWrapper);
//    }
//
//    /**
//     * Provide an implementation for {@link WebSecurityConfigurerAdapter#configure(HttpSecurity)} to
//     * allow us to inform spring on how to handle authentications. This example is a very basic
//     * usage and is only intended to get you up an running.
//     *
//     * @param http Instance of the {@link HttpSecurity} provided by spring
//     * @throws Exception Thrown on misconfiguration
//     */

//        /**
//         * csrf().disable() disables cross site scripting checks, this is not recommended for production
//         *
//         * formLogin() informs spring that the authentication request will be coming from a web form
//         *
//         * failureUrl("") states where to redirect the browser if the authentication attempt failed
//         *
//         * loginPage("") informs spring where the login form is located, this means that an request
//         * that is not authenticated will be redirected to here. Note that once the user has been
//         * authenticated then they will be taken to the page that they were trying to access.
//         *
//         * authorizeRequests().antMatchers("").permitAll() states that these matched urls do not
//         * require the user to be authenticated. For example we have antMatchers("/auth/**") which
//         * means that any resources under /auth/ will not require the user to be authenticated.
//         *
//         * .anyMatchers("/**").authenticated() which is chained to the permitAll() catches all other
//         * url mappings and states that the user must be authenticated.
//         *
//         *
//         * logout.logoutUrl("") states the link to listen to provide the functionality to terminate
//         * the sessions an log the user out
//         *
//         * logoutSuccessUrl("") provides the url to redirect the browser to when the logout process
//         * has been completed.
//         */

//        http
//                .csrf().disable()
//                .formLogin().failureUrl("/securityProblems")
//                .loginProcessingUrl("/dasboards/adminDash")
//                .loginPage("/home")
//                .and()
//                .authorizeRequests()
//                .antMatchers("/userLogin/**").permitAll().antMatchers("/**")
//                .authenticated().and().logout()
//                .logoutUrl("/accountLogout").logoutSuccessUrl("/success");
//    }

//}

//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .inMemoryAuthentication()
//                .withUser("user").password("password").roles("USER").and()
//                .withUser("admin@admin.com").password("12345678").roles("ADMIN");
//    }
//
//    @Configuration
//    @Order(1)
//    public static class ApiWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {
//        protected void configure(HttpSecurity http) throws Exception {
//            http
//                    .antMatcher("/dashboards/adminDash/**")
//                    .authorizeRequests()
//                    .anyRequest().hasRole("ADMIN")
//                    .and()
//                    .httpBasic();
//        }
//    }
//
//
//    @Configuration
//    public static class FormLoginWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {
//
//        @Override
//        protected void configure(HttpSecurity http) throws Exception {
//            http
//                    .authorizeRequests()
//                    .anyRequest().authenticated()
//                    .and()
//                    .formLogin()
//                    .loginPage("/home");
//        }
//    }
//}


//    @Bean
//    public ErrorPageFilter errorPageFilter() {
//        return new ErrorPageFilter();
//    }
//
//    @Bean
//    public FilterRegistrationBean disableSpringBootErrorFilter(ErrorPageFilter filter) {
//        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
//        filterRegistrationBean.setFilter(filter);
//        filterRegistrationBean.setEnabled(false);
//        return filterRegistrationBean;
//    }


//}

/*
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/").permitAll();
                /*.anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll()*/
// }

    /*@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("user").password("password").roles("USER");
    }
}*/
