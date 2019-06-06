package activies.rn.senai.br.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import activies.rn.senai.br.dao.ProdutoDAO;
import activies.rn.senai.br.events.EventClickButtonProdutoActivity;
import activies.rn.senai.br.events.EventTextChanged;

public class ProdutoActivity extends AppCompatActivity {

    private TextView mTvProdutoNome;
    private TextView mTvProdutoPreco;
    private TextView mTvProdutoFabricante;
    private EditText mEdProdutoNome;
    private EditText mEdProdutoPreco;
    private EditText mEdProdutoFabricante;
    private Button mBtSalvar;
    private Button mBtCorrigir;
    ProdutoDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produto);
        setTitle("Cadastro de Produtos");

        inicializarComponentes();
        definirEventos();

    }

    @Override
    protected void onResume() {
        super.onResume();
        dao.buscarTodos();
    }

    private void definirEventos() {
        textChangedListenerActivityProduto(mEdProdutoNome, mTvProdutoNome);
        textChangedListenerActivityProduto(mEdProdutoPreco, mTvProdutoPreco);
        textChangedListenerActivityProduto(mEdProdutoFabricante, mTvProdutoFabricante);

        eventBtSave(mBtSalvar);
        eventBtCorrigir(mBtCorrigir);
    }

    private void eventBtCorrigir(Button mBtCorrigir) {
        mBtCorrigir.setOnClickListener(new EventClickButtonProdutoActivity(mBtCorrigir,
                mEdProdutoNome,
                mEdProdutoPreco,
                mEdProdutoFabricante, this));
    }

    private void eventBtSave(Button mBtSalvar) {
        mBtSalvar.setOnClickListener(new EventClickButtonProdutoActivity(mBtSalvar,
                mEdProdutoNome,
                mEdProdutoFabricante,
                mEdProdutoPreco,
                this));
    }

    private void textChangedListenerActivityProduto(EditText mEd, TextView mTv) {
        mEd.addTextChangedListener(new EventTextChanged(mTv, mEd));
    }

    private void inicializarComponentes() {
        mTvProdutoNome = findViewById(R.id.activity_produto_tv_nome);
        mTvProdutoPreco = findViewById(R.id.activity_produto_tv_preco);
        mTvProdutoFabricante = findViewById(R.id.activity_produto_tv_fabricante);

        mEdProdutoNome = findViewById(R.id.activity_produto_ed_nome);
        mEdProdutoPreco = findViewById(R.id.activity_produto_ed_preco);
        mEdProdutoFabricante = findViewById(R.id.activity_produto_ed_fabricante);

        mBtSalvar = findViewById(R.id.activity_produto_bt_salvar);
        mBtCorrigir = findViewById(R.id.activity_produto_bt_corrigir);

    }

}
