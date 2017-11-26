package iesb.br.escolas;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


class EscolaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    public TextView nomeEscola;
    public TextView enderecoEscola;
    public TextView telefoneEscola;
    public Context context;


    public EscolaViewHolder(View itemView, Context context) {
        super(itemView);
        this.context=context;

        this.nomeEscola = itemView.findViewById(R.id.nomeEscola);
        this.enderecoEscola = itemView.findViewById(R.id.enderecoEscola);
        this.telefoneEscola = itemView.findViewById(R.id.telefoneEscola);
        itemView.setOnClickListener(this);
        RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) itemView.getLayoutParams();
        params.setMargins(35, 0, 0, 0);
        itemView.setLayoutParams(params);
    }
       @Override
        public void onClick(View view ) {
        Toast.makeText(itemView.getContext(), "Item is clicked", Toast.LENGTH_SHORT).show();
         Intent intent = new Intent(context,MapaActivity.class);
        intent.putExtra("latitude","latitude");
        intent.putExtra("longitude","longitude");
        return;


    }
}
