package Model.Entidades;

public class ItemDoPedido {
    private Integer quantidade;
    private Double preco;
    //composto por produtos
    private Produto produto;

    public ItemDoPedido() {
    }

    public ItemDoPedido(Integer quantidade, Double preco, Produto produto) {
        this.quantidade = quantidade;
        this.preco = preco;
        this.produto = produto;
    }

    public Integer getQuantidade() {

        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Produto getProdutos() {
        return this.produto;
    }


    //retorna subtotal do pedido multipilacando qnt * preco do produto
    public Double subTotal(){
        return this.quantidade * this.preco;
    }

    public String toString(){
        return produto + ", " + "Quantidade: " + this.quantidade + ", " + "Subtotal: " + subTotal();
    }
}
