package com.api.faculdade.senac.piv.gestaoesteticaapi.configs.errosapi;

public class FuncionarioCadastroException extends RuntimeException {

    public FuncionarioCadastroException(String login){
        super("Funcionario já cadastro para o login" + login);
    }
}
