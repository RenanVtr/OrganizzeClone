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

import Config.ConfiguracaoFirebase;
import Model.Usuario;

public class CadastroActivity extends AppCompatActivity {

    //Atributos
    private EditText campoNome, campoEmail, campoSenha;
    private FirebaseAuth autentificacao;
    private Usuario usuario;


    //Metodo Cadastrar Usuario
    public void cadastrarUsuario(){
        autentificacao = ConfiguracaoFirebase.getFirebaseAutentificacao();
        autentificacao.createUserWithEmailAndPassword(usuario.getEmail(), usuario.getSenha()
        ).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(CadastroActivity.this,"Sucesso ao cadastrar usuário", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(CadastroActivity.this,"Erro ao cadastrar usuário", Toast.LENGTH_LONG).show();
                }
        }});
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        campoNome = findViewById(R.id.editTextNomeCadastro);
        campoEmail = findViewById(R.id.editTextEmailCadastro);
        campoSenha = findViewById(R.id.editTextSenhaCadastro);
        Button botaoCadastrar = findViewById(R.id.buttonCadastrar);

        //OnClick Botão Cadastrar
        botaoCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textoNome = campoNome.getText().toString();
                String textoEmail = campoEmail.getText().toString();
                String textoSenha = campoSenha.getText().toString();

                //Validar se os campos foram preenchidos
                if (!textoNome.isEmpty()){
                    if (!textoEmail.isEmpty()){
                        if (!textoSenha.isEmpty()){
                            usuario = new Usuario();
                            usuario.setNome(textoNome);
                            usuario.setEmail(textoEmail);
                            usuario.setSenha(textoSenha);
                            cadastrarUsuario();
                        }else {Toast.makeText(CadastroActivity.this, "Preencha sua senha", Toast.LENGTH_LONG).show();}
                    }else {Toast.makeText(CadastroActivity.this,"Preencha seu email", Toast.LENGTH_LONG).show();}
                }else {Toast.makeText(CadastroActivity.this,"Preencha seu nome", Toast.LENGTH_LONG).show();}
            }
        });
    }


}