package br.edu.ifsp.arq.dmos5_2020s1.Login_Hardcode.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.edu.ifsp.arq.dmos5_2020s1.Login_Hardcode.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public static final String KEY_USUARIO = "usuario";
    public static final String KEY_SENHA = "senha";

    private EditText usuarioEditText;
    private EditText senhaEditText;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Referência dos elementos de layout
        usuarioEditText = findViewById(R.id.edittext_usuario_entrada);
        senhaEditText = findViewById(R.id.edittext_senha_entrada);
        loginButton = findViewById(R.id.button_login);

        //OnClickListern do botão
        loginButton.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        usuarioEditText.setText("");
        senhaEditText.setText("");
    }

    @Override
    public void onClick(View v) {
        if(v == loginButton){
            login();
        }
    }

    public void login() {
        int usuario, senha;
        try {
            usuario = Integer.valueOf(usuarioEditText.getText().toString());
            senha = Integer.valueOf(senhaEditText.getText().toString());
        }catch (NumberFormatException nfe){
            usuario = 0;
            senha = 0;
        }

        if ( usuario != 0 && senha !=0 ) {

            // Embrulho
            Bundle args = new Bundle();

            // Insere dados no Bundle
            args.putString(KEY_USUARIO, String.valueOf(usuario));
            args.putString(KEY_SENHA, String.valueOf(senha));

            // Intenção de abrir nova tela
            Intent intent = new Intent(this, LoginActivity.class);

            // Inclui argumentos
            intent.putExtras(args);

            // Inicia
            startActivity(intent);
        } else {
            Toast.makeText(this, "Entrada de dados inválida.", Toast.LENGTH_SHORT).show();
        }
    }
}
