package com.api.faculdade.senac.piv.gestaoesteticaapi.entity.funcionario.services;

import com.api.faculdade.senac.piv.gestaoesteticaapi.configs.errosapi.FuncionarioCadastroException;
import com.api.faculdade.senac.piv.gestaoesteticaapi.entity.funcionario.Funcionario;
import com.api.faculdade.senac.piv.gestaoesteticaapi.entity.funcionario.FuncionarioController;
import com.api.faculdade.senac.piv.gestaoesteticaapi.entity.funcionario.FuncionarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class FuncionarioAuthService implements UserDetailsService {

    private final FuncionarioRepository funcionarioRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Funcionario funcionario = funcionarioRepository.findByLogin(login)
                .orElseThrow( () -> new UsernameNotFoundException("Login não encontrado"));
        return User.builder().username(funcionario.getLogin())
                             .password(funcionario.getSenha())
                             .roles(funcionario.getPermissao()).build();
    }

    public Funcionario salvarFuncionaro(Funcionario funcionario){
        boolean existe = funcionarioRepository.existsByLogin(funcionario.getLogin());
        if(existe){
            throw new FuncionarioCadastroException(funcionario.getLogin());
        }
        return funcionarioRepository.save(funcionario);
    }
}
