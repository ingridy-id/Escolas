package iesb.br.escolas;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TCUEscolas {
    @GET("rest/escolas")
    Call<List<ModeloEscola>> listarEscolas();
}
