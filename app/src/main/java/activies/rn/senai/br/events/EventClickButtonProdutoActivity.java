package activies.rn.senai.br.events;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import activies.rn.senai.br.activities.ProdutoActivity;
import activies.rn.senai.br.activities.R;
import activies.rn.senai.br.dao.ProdutoDAO;
import activies.rn.senai.br.model.Produto;

public class EventClickButtonProdutoActivity implements View.OnClickListener {
    private Button button;
    private EditText nome;
    private EditText fabricante;
    private EditText preco;
    private Activity activity;
    private ProdutoDAO dao = new ProdutoDAO();

    public EventClickButtonProdutoActivity(Button button, EditText nome,
                                           EditText fabricante, EditText preco,
                                           ProdutoActivity produtoActivity) {
        this.button = button;
        this.nome = nome;
        this.fabricante = fabricante;
        this.preco = preco;
        this.activity = produtoActivity;
    }

    private Button getButton() {
        return button;
    }

    private String getNome() {
        return nome.getText().toString();
    }

    private String getFabricante() {
        return fabricante.getText().toString();
    }

    private String getPreco() {
        return preco.getText().toString();
    }

    private void setNome() {
        this.nome.setText("");
    }

    private void setFabricante() {
        this.fabricante.setText("");
    }

    private void setPreco() {
        this.preco.setText("");
    }

    @Override
    public void onClick(View v) {

        final int id = getButton().getId();
        final int viewByIdSalvar = activity.findViewById(R.id.activity_produto_bt_salvar).getId();
        final int viewByIdCorrigir = activity.findViewById(R.id.activity_produto_bt_corrigir).getId();
        final Context context = v.getContext();

        if (id == viewByIdSalvar && !getNome().trim().isEmpty() &&
                !getFabricante().trim().isEmpty() && !getPreco().trim().isEmpty()) {
            String nome = getNome();
            final String fabricante = getFabricante();
            final float preco = Float.valueOf(getPreco());
            final Produto produto = new Produto(nome, preco, fabricante);
            dao.salvar(produto);
            Toast.makeText(context, "Salvo com sucesso ".concat(nome), Toast.LENGTH_SHORT).show();
            limparCampoEd();
            dao.atualizaLista(ProdutoDAO.buscarTodos());
            this.activity.finish();
        } else if (viewByIdCorrigir == id) {
            limparCampoEd();
        }
    }

    private void limparCampoEd() {
        setNome();
        setFabricante();
        setPreco();
    }

}
