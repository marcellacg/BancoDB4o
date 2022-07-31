import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("Adicionando novo cliente:------------------------------");
        Cliente cliente2 = new Cliente(2, "Mariano", "9999-9999", "Avenida Florida", "59.000-000", "jose@email.com");
//
        Database database = new Database();
        database.criarDatabase();
        database.cadastrarCliente(cliente2);
//
        List<Cliente> clienteList = database.exibirTodosClientes();
        for (Cliente c : clienteList){
           System.out.printf(String.valueOf(c));
        }
        
        
        
        System.out.println("Adicionando outro cliente:------------------------------");
        
        Cliente cliente3 = new Cliente();
        
        cliente3.setCodCli(3);
        cliente3.setNome("Juliana");
        cliente3.setTelefone("5587-1215");
        cliente3.setEndereco("Rua das Carlotas");
        cliente3.setCep("87.169-920");
        cliente3.setEmail("julia@com");
        
        database.inserirCliente(cliente3);
        System.out.println(cliente3);
//        
//        
        //Selecionando um cliente:
//        
        Cliente cliente4 = new Cliente();
//        
        cliente4.setCodCli(4);
        cliente4.setNome("Inacio");
        cliente4.setTelefone("5872-9528");
        cliente4.setEndereco("Rua Amalia Coelho");
        cliente4.setCep("58.200-000");
        cliente4.setEmail("inacio12@com");
        database.inserirCliente(cliente4);
//        
//        cliente4.setCodCli(5);
//        Cliente c1 = database.selecionarUmCliente(cliente4);
//        System.out.println(c1);
//        
        System.out.println("Update do cliente:------------------------------");
        System.out.println();
        System.out.println("Depois das alteracoes:------------------------------");
//        
        int codCli = 4;
        String nnome = "Inacyo";
        String ttelefone = "5870-7080";
        String eendereco = "Rua das Abelhas";
        String ccep = "52.780-155";
        String eemail = "newinacio@outlook";
        database.updateCliente(codCli, nnome, ttelefone, eendereco, ccep, eemail);
        clienteList = database.exibirTodosClientes();
        for (Cliente ccc : clienteList){
            System.out.println(ccc);
        }
//        
 
//        
        System.out.println("Cadastrar novo produto:------------------------------");

        Produto produto1 = new Produto();
        
        produto1.setCodPro(6);
        produto1.setCusto(18.00);
        produto1.setDescricao("Mingau de aveia");
        produto1.setPreco(20.00);
        produto1.setNome("Mingau");
        database.inserirProduto(produto1);
        List<Produto> produtoList = database.exibirTodosProdutos();
        for (Produto p : produtoList){
           System.out.printf(String.valueOf(p));
           System.out.println();
        }
        
         System.out.println();
         System.out.println("Depois de deletar:------------------------------");
         int codPro = 6;
         database.deletarProduto(codPro);
         produtoList = database.exibirTodosProdutos();
         for (Produto prod : produtoList){
             System.out.println(prod);
         }
  
    }
}
