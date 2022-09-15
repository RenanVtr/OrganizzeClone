package com.example.organizzeclone.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.organizzeclone.R;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    //Atributos
    private EditText campoEmail, campoSenha;
    private FirebaseAuth autentificacao;



    //Metodo Logar Usuario
    public void logarUsuario() {

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        campoEmail = findViewById(R.id.editTextEmailLogin);
        campoSenha = findViewById(R.id.editTextSenhaLogin);
        Button botaoLogin = findViewById(R.id.buttonEntrar);

        //OnClick Botão Entrar
        botaoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textoEmail = campoEmail.getText().toString();
                String textoSenha = campoSenha.getText().toString();


                //Validando se os campos foram preenchidos
                if (!textoEmail.isEmpty()){
                    if (!textoSenha.isEmpty()){
                        logarUsuario();
                    }else {
                        Toast.makeText(LoginActivity.this, "Preencha sua senha", Toast.LENGTH_LONG).show();}
                }else {Toast.makeText(LoginActivity.this,"Preencha seu email", Toast.LENGTH_LONG).show();}
            }
        });
    }


}