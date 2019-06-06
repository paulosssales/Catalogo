package activies.rn.senai.br.dao;

import android.content.Context;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import activies.rn.senai.br.model.Produto;

public class ProdutoDAO {
    private final static List<Produto> listProdutos = new ArrayList<>();
    private static int contador = 1;

    public void salvar(Produto produto) {
        if (produto != null)
            produto.setId(contador);
            listProdutos.add(produto);
            setContador();

    }

    public static void setContador() {
        ProdutoDAO.contador++;
    }

    public static List<Produto> buscarTodos() {
        return new ArrayList<>(listProdutos);
    }

    public void atualizaLista(List<Produto> list) {
        this.listProdutos.clear();
        this.listProdutos.addAll(list);
    }
}
