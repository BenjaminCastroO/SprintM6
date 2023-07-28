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
    UserDetails cliente = User.withUsername("cliente").password(encoder.encode(
            "hola1234")).roles("CLIENTE").build();

    UserDetails administrativo = User.withUsername("administrativo").password(encoder.encode(
            "hola1234")).roles("ADMINISTRATIVO").build();

    UserDetails profesional = User.withUsername("profesional").password(encoder.encode(
            "hola1234")).roles("PROFESIONAL").build();
    return new InMemoryUserDetailsManager(cliente,administrativo,profesional);
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http)throws Exception{
    http.authorizeRequests()
            .requestMatchers("/capacitacion/**").hasRole("CLIENTE")
            .requestMatchers("/contacto/**").hasRole("CLIENTE")
            .requestMatchers("/usuario/**").hasRole("ADMINISTRATIVO")
            .requestMatchers("/cliente/**").hasRole("ADMINISTRATIVO")
            .requestMatchers("/profesional/**").hasRole("ADMINISTRATIVO")
            .requestMatchers("/administrativo/**").hasRole("ADMINISTRATIVO")
            .requestMatchers("/pago/**").hasRole("ADMINISTRATIVO")
            .requestMatchers("/visita").hasRole("PROFESIONAL")
            .requestMatchers("/chequeo").hasRole("PROFESIONAL")
            .requestMatchers("/api/cliente").hasRole("ADMINISTRATIVO")
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
