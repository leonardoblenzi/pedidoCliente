package Model.Entidades;

import Model.Enums.STATUS;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Pedido {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    private Date momento;
    private STATUS status;
    //Pedido contem item do pedido
    private List<ItemDoPedido> itens_pedidos = new ArrayList<>();
    //Pedido contem cliente
    private Cliente cliente;


    public Pedido() {
    }

    public Pedido(Date momento, STATUS status, Cliente cliente) {
        this.momento = momento;
        this.status = status;
        this.cliente = cliente;
    }

    public Date getMomento() {
        return momento;
    }

    public void setMomento(Date momento) {
        this.momento = momento;
    }

    public STATUS getStatus() {
        return status;
    }

    public void setStatus(STATUS status) {
        this.status = status;
    }

    public List<ItemDoPedido> getItems_pedidos() {
        return itens_pedidos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void adicionarItem(ItemDoPedido item){
        this.itens_pedidos.add(item);
    }

    public void removerItem(ItemDoPedido item){
        this.itens_pedidos.remove(item);
    }

    public double total(){
        double soma = 0.0;
        for(ItemDoPedido item : itens_pedidos){
            soma += item.subTotal();
        }
        return soma;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Momento do pedido: ");
        sb.append(sdf.format(momento) + "\n");
        sb.append("Status do pedido: ");
        sb.append(status + "\n");
        sb.append("Cliente: ");
        sb.append(cliente + "\n");
        sb.append("Itens do pedido: \n");
        for(ItemDoPedido item: itens_pedidos){
            sb.append(item + "\n");
        }
        sb.append("Preço total: ");
        sb.append(String.format("%.2f", total()));
        return sb.toString();
    }
}
