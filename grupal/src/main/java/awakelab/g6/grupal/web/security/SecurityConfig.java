package awakelab.g6.grupal.web.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
  @Bean
  public InMemoryUserDetailsManager userDetailsManager(PasswordEncoder encoder){
    UserDetails user = User.withUsername("user").password(encoder.encode(
            "hola1234")).roles("USER").build();

    UserDetails admin = User.withUsername("admin").password(encoder.encode(
            "chao4321")).roles("USER","ADMIN").build();
    return new InMemoryUserDetailsManager(user,admin);
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http)throws Exception{
    http.authorizeRequests()
            .requestMatchers("/capacitacion").hasAnyRole("USER","ADMIN")
            .requestMatchers("/api/cliente").hasRole("ADMIN")
            .and().httpBasic(Customizer.withDefaults())
            .formLogin().and().logout().logoutUrl("/logout").logoutSuccessUrl("/").invalidateHttpSession(true)
            .deleteCookies("JSESSIONID");

    return http.build();
  }

  @Bean
  public PasswordEncoder encoder(){
    return PasswordEncoderFactories.createDelegatingPasswordEncoder();
  }
}
