package iesb.br.escolas;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //recupenrando a instancia do Firebase
        mAuth = FirebaseAuth.getInstance();

        // BOTÃO CADASTRAR
        Button cadastrar = (Button) findViewById(R.id.btnCadastrar);
        cadastrar.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent it = new Intent();
                it.setClass(Login.this, Cadastro.class);
                startActivity(it);
            }
        });

        // BOTÃO ENTRAR
        final EditText email = (EditText) findViewById(R.id.txemaillogin);
        final EditText senha = (EditText) findViewById(R.id.txsenhalongin);
        Button entrar = (Button) findViewById(R.id.btnEntrar);
        entrar.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                mAuth.signInWithEmailAndPassword(email.getText().toString(), senha.getText().toString())
                        .addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Intent it = new Intent(Login.this, MainActivity.class);
                                    startActivity(it);
                                } else {}
                            }
                        });
            }
        });

        }
    }