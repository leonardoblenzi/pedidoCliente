package Application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import Model.Enums.STATUS;
import Model.Entidades.*;

public class Program {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Insira os dados do cliente: ");
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("\nEmail: ");
        String email = sc.nextLine();
        System.out.print("\nData de nascimento(dd/mm/yyy): ");
        String data_string = sc.nextLine();
        //conv String para Date
        Date data_nascimento = sdf.parse(data_string);

        //objeto cliente criado
        Cliente cliente = new Cliente(nome, email, data_nascimento);

        System.out.println("Insira as informações do pedido: ");
        System.out.print("STATUS: ");
        //pegando valor de enum STATUS
        STATUS status = STATUS.valueOf(sc.next());

        //pegando momento do pedido
        Date agora = new Date();

        //objeto pedido criado
        Pedido pedido = new Pedido(agora, status, cliente);

        //pegando itens do pedido
        System.out.print("Quantos items vão ser adicionados ao pedido ?: ");
        int num = sc.nextInt();

        Produto produto = new Produto();
        ItemDoPedido itemDoPedido = new ItemDoPedido();

        for(int i = 0; i<num; i++){
            System.out.print("\n Insira dados do item #" + (i+1)) ;
            sc.nextLine();
            System.out.print("\nNome do produto: ");
            String nome_prod = sc.nextLine();
            System.out.print("\n Preço do produto: ");
            double preco_prod = sc.nextDouble();
            System.out.print("\nQuantidade: ");
            int quantidade_prod = sc.nextInt();

            //instanciando objeto produto
            produto = new Produto(nome_prod, preco_prod);

            //instanciando objeto item do pedido
            itemDoPedido = new ItemDoPedido(quantidade_prod, preco_prod, produto);

            //adicionando produto ao pedido
            pedido.adicionarItem(itemDoPedido);
        }

        System.out.println("################################");
        System.out.println("Resumo do pedido: ");
        System.out.print(pedido);

        //System.out.println(formato.format(data_nascimento));


        sc.close();
    }
}