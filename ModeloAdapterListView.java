package com.example.delivers;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.delivers.arquivosUtil.FreteUtil;
import com.example.delivers.arquivosUtil.ResourceUtil;

import java.util.List;

public class AdapterListaParceiros extends BaseAdapter {

    private final List<Parceiro> parceiros;
    private Context contexto;

    public AdapterListaParceiros(List<Parceiro> parceiros, Context contexto) {
        this.parceiros = parceiros;
        this.contexto = contexto;
    }

    @Override
    public int getCount() {
        return parceiros.size();
       // Devolve a quantidade de itens da lista;
    }

    @Override
    public Object getItem(int position) {
        return parceiros.get(position);
        // Devolve um item da lista pela posição;
    }

    @Override
    public long getItemId(int position) {
        return parceiros.get(position).getId();
        // Devolve o Id de um elemento pela sua posição;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View viewCriada  = LayoutInflater.from(contexto)
                .inflate(R.layout.list_view_layout, parent, false);
                // Esse trecho pode ser extraído pra outro método;

        Parceiro parceiro = parceiros.get(position);

            // Os próximos códigos puxam as informações do parceiro para mostrar na tela
        TextView nomeProduto = viewCriada.findViewById(R.id.item_card_produto);
        nomeProduto.setText(parceiro.getProduto());

        TextView horarioDeEntrega = viewCriada.findViewById(R.id.item_card_horario_de_entrega);
        horarioDeEntrega.setText(parceiro.getHorarioDeEntrega());

        TextView valorDeEntrega = viewCriada.findViewById(R.id.item_card_valor_entrega);
        String cobrancaEntrega = MoedaUtil.valorEntrega(parceiro.getValorDeEntrega());
        valorDeEntrega.setText(cobrancaEntrega);
            // Usa o arquivo MoedaUtil pra converter a moeda em reais;

        ImageView imagem = viewCriada.findViewById(R.id.item_card_imagem);
        Drawable drawableImagemProduto = ResourceUtil.criaDrawable(contexto, parceiro.getImagem());
        imagem.setImageDrawable(drawableImagemProduto);
            // Usa o arquivo ResourceUtil pra pegar o drawable correto;

        return viewCriada;
    }

    // Métodos originais do adapter padrão do ArrayList;

    public void remove(Empresa empresa) {
        empresas.remove(empresa);
        notifyDataSetChanged(); //Avisa ao sistema para atualizar a tela;
    }

    public void atualiza(List<Empresa> empresa) {
        this.empresas.clear();
        this.empresas.addAll(empresa);
        notifyDataSetChanged(); // Atualiza a tela;
    }
}
