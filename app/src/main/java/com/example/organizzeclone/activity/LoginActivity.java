package com.example.organizzeclone.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.organizzeclone.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;

import Config.ConfiguracaoFirebase;
import Model.Usuario;

public class LoginActivity extends AppCompatActivity {

    //Atributos
    private EditText campoEmail, campoSenha;
    private FirebaseAuth autentificacao;
    private Usuario usuario;



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
                        usuario = new Usuario();
                        usuario.setEmail(textoEmail);
                        usuario.setSenha(textoSenha);
                        validarLogin();

                        logarUsuario();
                    } else {
                        Toast.makeText(LoginActivity.this, "Preencha sua senha", Toast.LENGTH_LONG).show();}
                }else {Toast.makeText(LoginActivity.this,"Preencha seu email", Toast.LENGTH_LONG).show();}
            }
        });
    }

    //Metodo para validar Login de Usuario
    public void validarLogin(){
        autentificacao = ConfiguracaoFirebase.getFirebaseAutentificacao();
        autentificacao.signInWithEmailAndPassword(
                usuario.getEmail(),
                usuario.getSenha()
        ).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(LoginActivity.this,
                            "Sucesso ao fazer login", Toast.LENGTH_SHORT).show();
                } else {
                    //Tratamento de erros
                    String excecao = "";
                    try {
                        throw task.getException();
                    }

                    //Usuario invalido
                    catch (FirebaseAuthInvalidUserException e ){
                        excecao = "Usuario não está cadastrado";
                    }

                    //Email ou senha não conferem
                    catch (FirebaseAuthInvalidCredentialsException e){
                        excecao = "Email ou senha não conferem ";
                    }


                    //Erro generico
                    catch (Exception e){
                        excecao = "Erro ao cadastrar usuario: " + e.getMessage();
                        e.printStackTrace(); //printar erro no log
                    }
                    Toast.makeText(LoginActivity.this,
                            excecao, Toast.LENGTH_SHORT).show();
                }
            }}
            );
        }
    }

