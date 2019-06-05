package activies.rn.senai.br.model;

public class produto {

    private int id;
    private String nome;
    private float preco;
    private String fabricante;

    public produto() {
    }

    public produto(String nome, float preco, String fabricante) {
        this.nome = nome;
        this.preco = preco;
        this.fabricante = fabricante;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }
}
