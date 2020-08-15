package br.edu.ifsp.arq.dmos5_2020s1.Login_Hardcode.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import br.edu.ifsp.arq.dmos5_2020s1.Login_Hardcode.R;
import br.edu.ifsp.arq.dmos5_2020s1.Login_Hardcode.model.Login;

public class LoginActivity extends AppCompatActivity {

    private TextView loginTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginTextView = findViewById(R.id.textview_login_final);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        extrairArgumentos();
    }

    private void extrairArgumentos(){
        Intent intent = getIntent();
        Bundle embrulho = intent.getExtras();

        // Recebe os argumentos do embrulho
        if(embrulho != null){
            String usuario = embrulho.getString(MainActivity.KEY_USUARIO);
            String senha = embrulho.getString(MainActivity.KEY_SENHA);

            login(usuario,senha);
        }
    }

    private void login(String usuario, String senha) {
        Login login = new Login(usuario,senha);

        // Verifica se a senha corresponde ao prontuário invertido do usuário
        if ( login.verificaLogin() == 1 ) {
            loginTextView.setText("Bem Vindo "+login.getUsuario());
        } else {
            loginTextView.setText("Erro no login");
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
