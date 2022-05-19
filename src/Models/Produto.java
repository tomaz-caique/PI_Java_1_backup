
package Models;

public class Produto {
    
    private int id;
    private String nome;
    private String descricao;
    private String categoria;
    private double preco;
    private int quantidade;
    private String material;
    private String provider;

    public Produto(int id, String nome, String descricao, String categoria, double preco, int quantidade, String material, String provider) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.categoria = categoria;
        this.preco = preco;
        this.quantidade = quantidade;
        this.material = material;
        this.provider = provider;
    }

    public Produto(String nome, String descricao, String categoria, double preco, int quantidade, String material, String provider) {
        this.nome = nome;
        this.descricao = descricao;
        this.categoria = categoria;
        this.preco = preco;
        this.quantidade = quantidade;
        this.material = material;
        this.provider = provider;
    }

    public Produto(String nome, String categoria, double preco, int quantidade, String material, String provider) {
        this.nome = nome;
        this.categoria = categoria;
        this.preco = preco;
        this.quantidade = quantidade;
        this.material = material;
        this.provider = provider;
    }

    public Produto(int id, String nome, String descricao, double preco, int quantidade) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public Produto(int id) {
        this.id = id;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

   
    
}
