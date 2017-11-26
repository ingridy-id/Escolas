package iesb.br.escolas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import com.facebook.AccessToken;

public class MainActivity extends AppCompatActivity {

    private List<ModeloEscola> listaescola = new ArrayList<>();
    private EscolaRecycleViewAdapter recycleViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        recycleViewAdapter = new EscolaRecycleViewAdapter(this, listaescola);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler);
        recyclerView.setAdapter(recycleViewAdapter);
        buscarDados();
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));}


    private void buscarDados() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://mobile-aceite.tcu.gov.br:80/nossaEscolaRS/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        TCUEscolas service = retrofit.create(TCUEscolas.class);

        Call<List<ModeloEscola>> escolas = service.listarEscolas();

        escolas.enqueue(new Callback<List<ModeloEscola>>() {
            @Override
            public void onResponse(Call<List<ModeloEscola>> call,
                                   Response<List<ModeloEscola>> response) {
                List<ModeloEscola> lista = response.body();

                for (ModeloEscola r : lista) {
                    Log.d("RETROFIT", r.getCodEscola() + " " + r.getNome());
                    listaescola.add(r);
                }
                recycleViewAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<ModeloEscola>> call,
                                  Throwable t) {
            }
        });


    }
    
     private void goLoginScreen() {

        Intent intent = new Intent(this, Login.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}



