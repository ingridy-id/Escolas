package iesb.br.escolas;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Cadastro extends AppCompatActivity {

    private FirebaseAuth mAuth;
    final int RC_PHOTO_PICKER = 2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        final EditText email = (EditText) findViewById(R.id.txemailcadastro);
        final EditText senha = (EditText) findViewById(R.id.txsenhacadastro);
        final EditText confirmasenha = (EditText) findViewById(R.id.txconfirmasenhacadastro);
        Button cadastrar = (Button) findViewById(R.id.btncadastrocadastro);
        mAuth = FirebaseAuth.getInstance();

        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.createUserWithEmailAndPassword(email.getText().toString(), senha.getText().toString())
                        .addOnCompleteListener(Cadastro.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    finish();
                                } else {

                                    Toast.makeText(Cadastro.this, "Falha na Autenticação",
                                            Toast.LENGTH_SHORT).show();

                                }


                            }
                        });

            }
        });
        
         final Button foto = (Button) findViewById(R.id.foto);

        foto.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent it = new Intent(Intent.ACTION_GET_CONTENT);
                it.setType("image/jpeg");
                it.putExtra(Intent.EXTRA_LOCAL_ONLY, true);

                startActivityForResult(Intent.createChooser(it, "Complete action using"), RC_PHOTO_PICKER);
            }

        });

    }

    public void onStart(){
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        //updateUI(currentUser);
    }
}
