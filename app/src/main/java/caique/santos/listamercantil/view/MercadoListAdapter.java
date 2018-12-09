package caique.santos.listamercantil.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import caique.santos.listamercantil.R;
import caique.santos.listamercantil.entity.Mercado;

public class MercadoListAdapter extends RecyclerView.Adapter<MercadoListAdapter.MercadoViewHolder> {

    class MercadoViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.mercado_tv_nome)
        TextView tv_nome;
        @BindView(R.id.mercado_tv_telefone)
        TextView tv_telefone;

        private MercadoViewHolder(View itemView){
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    private final LayoutInflater mInflater;
    private List<Mercado> mMercados;

    public MercadoListAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public MercadoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.mercado_recycler_view_item,
                parent, false);

        return new MercadoViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MercadoViewHolder holder, int position) {
        if(mMercados != null){
            Mercado atual = mMercados.get(position);
            holder.tv_nome.setText(atual.getNome());
            holder.tv_telefone.setText(atual.getTelefone());
        }else{
            holder.tv_nome.setText("Não há mercados cadastrados");
        }
    }

    void setMercados(List<Mercado> mercados){
        mMercados = mercados;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if(mMercados != null){
            return mMercados.size();
        }else
            return 0;
    }
}
