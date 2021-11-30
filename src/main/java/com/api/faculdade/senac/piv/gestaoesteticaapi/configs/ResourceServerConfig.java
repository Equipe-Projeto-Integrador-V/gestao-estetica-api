package com.api.faculdade.senac.piv.gestaoesteticaapi.configs;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {

            http
                    .authorizeRequests()
                    .antMatchers("/api/clientes/**").hasAnyRole("USER", "ADMIN")
                    .antMatchers("/api/funcionarios/**").hasRole("ADMIN")
                    .antMatchers("/api/servicos/**").hasAnyRole("USER", "ADMIN")
                    .antMatchers("/api/fornecedores/**").hasAnyRole("USER", "ADMIN")
                    .antMatchers("/api/agendamentos/**").hasAnyRole("USER", "ADMIN")
                    .antMatchers("/api/ordemservicos/**").hasAnyRole("USER", "ADMIN")
                    .antMatchers("/api/contaspagar/**").hasAnyRole("USER", "ADMIN")
                    .antMatchers("/api/contasreceber/**").hasAnyRole("USER", "ADMIN")
                    .anyRequest().denyAll();


    }
}
