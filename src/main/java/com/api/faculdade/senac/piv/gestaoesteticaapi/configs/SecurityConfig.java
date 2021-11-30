package com.api.faculdade.senac.piv.gestaoesteticaapi.configs;


import com.api.faculdade.senac.piv.gestaoesteticaapi.entity.funcionario.services.FuncionarioAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final FuncionarioAuthService funcionarioAuthService;

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {

            auth.userDetailsService(funcionarioAuthService)
                    .passwordEncoder(passwordEncoder());
            auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");
    }

    //gerenciamento de usuarios
    @Bean
    public AuthenticationManager authenticationManager() throws Exception{
        return super.authenticationManager();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .cors()
         .and()
             .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);  //não guardará sessão (será controlado por expire token)
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance(); //não possui criptografia
    }

/*    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }*/


}
