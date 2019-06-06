package activies.rn.senai.br.activities;


import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import activies.rn.senai.br.events.EventClickButtonListaProdutoActivity;

public class ListaProdutosActivity extends AppCompatActivity {

    private FloatingActionButton mBtCadastrarProduto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_produtos);
        setTitle("Home");
        inicializarComponentes();
        definirEventos();
    }

    private void definirEventos() {
        mBtCadastrarProduto.setOnClickListener(new
                EventClickButtonListaProdutoActivity(mBtCadastrarProduto,this));
    }


    private void inicializarComponentes() {
        mBtCadastrarProduto = findViewById(R.id.activity_lista_produtos_bt_novo);
    }
}
