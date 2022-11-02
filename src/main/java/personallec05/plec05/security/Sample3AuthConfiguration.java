package personallec05.plec05.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class Sample3AuthConfiguration {

  @Bean
  public InMemoryUserDetailsManager userDetailsService() {

    UserBuilder users = User.builder();

    UserDetails customer1 = users
        .username("customer1")
        .password("$2y$10$xJcYazQhtEl9Ua2.94KlQOpPrLs6blMpS0va5kUDyCeUKcdRZIq3W")
        .roles("CUSTOMER")
        .build();
    UserDetails customer2 = users
        .username("customer2")
        .password("$2y$10$sJYjExH2K73GmdnaXx5M..YbB/tikSqoYKqmZTq/gEIlLsTyA83Hi")
        .roles("CUSTOMER")
        .build();
    UserDetails seller = users
        .username("seller")
        .password("$2y$10$5PsuVH8PxLjcbBtcJsNeCO1P5R9WBYNIqmfL08LHvZRYkoerezfJy")
        .roles("SELLER")
        .build();

    return new InMemoryUserDetailsManager(customer1, customer2, seller);
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

    http.formLogin();

    http.authorizeHttpRequests()
        .mvcMatchers("/").authenticated();

    http.logout().logoutSuccessUrl("/");

    http.csrf().disable();
    http.headers().frameOptions().disable();
    return http.build();
  }

  @Bean
  PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
