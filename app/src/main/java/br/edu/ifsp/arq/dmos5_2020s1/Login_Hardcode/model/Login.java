package br.edu.ifsp.arq.dmos5_2020s1.Login_Hardcode.model;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.io.Serializable;

public class Login {
    private String usuario;
    private String senha;

    public Login(String usuario, String senha) {
        setUsuario(usuario);
        setSenha(senha);
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getSenha() {
        return senha;
    }

    public int verificaLogin() {
        StringBuffer buffer = new StringBuffer(usuario);
        String usuarioInvertido = buffer.reverse().toString();

        // Verifica se a senha corresponde ao prontuário invertido do usuário
        if ( usuarioInvertido.compareTo(senha) == 0 ) {
            return 1;
        } else return 0;
    }


}
