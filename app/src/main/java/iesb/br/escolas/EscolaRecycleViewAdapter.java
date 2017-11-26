package iesb.br.escolas;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;



class EscolaRecycleViewAdapter extends RecyclerView.Adapter<EscolaViewHolder>{
    private Context context;
    private List<ModeloEscola> listaEscola;

    public EscolaRecycleViewAdapter(Context context, List<ModeloEscola> listaEscola) {
        this.context = context;
        this.listaEscola = listaEscola;
    }

    @Override
    public EscolaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_lista_escola, parent, false);
        return new EscolaViewHolder(view,context);
    }

    @Override
    public void onBindViewHolder(final EscolaViewHolder holder, int position) {
        ModeloEscola escola = listaEscola.get(position);

        holder.nomeEscola.setText(String.valueOf(escola.getCodEscola()));
        holder.enderecoEscola.setText(escola.getNome());
        holder.telefoneEscola.setText(escola.getEmail());

    }

    @Override
    public int getItemCount() {
        return listaEscola.size();
    }
}
