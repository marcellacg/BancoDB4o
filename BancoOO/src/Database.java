import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

import java.util.ArrayList;
import java.util.List;

/**
 * Esta classe contém a conexão do banco de dados
 */
public class Database {

    private ObjectContainer database = null;

    private void abrirDB() {
        database = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "banco");
    }
    private void fecharDB(){
        database.close();
    }

    public void cadastrarCliente (Cliente cliente){
        abrirDB();
        database.store(cliente);
        System.out.println("Cliente cadastrado.");
        fecharDB();
    }
    public void cadastrarEntrega (Entrega entrega){
        abrirDB();
        database.store(entrega);
        System.out.println("Entrega cadastrada.");
        fecharDB();
    }
    public void cadastrarItemVenda (ItemVenda itemVenda){
        abrirDB();
        database.store(itemVenda);
        System.out.println("Item de venda cadastrado.");
        fecharDB();
    }
    public void cadastrarMotorista (Motorista motorista){
        abrirDB();
        database.store(motorista);
        System.out.println("Motorista cadastrado.");
        fecharDB();
    }
    public void cadastrarProduto (Produto produto){
        abrirDB();
        database.store(produto);
        System.out.println("Produto cadastrado");
        fecharDB();
    }
    public void cadastrarVeiculo (Veiculo veiculo){
        abrirDB();
        database.store(veiculo);
        System.out.println("Veiculo cadastrado.");
        fecharDB();
    }
    public void cadastrarVenda (Venda venda){
        abrirDB();
        database.store(venda);
        System.out.println("Venda cadastrada.");
        fecharDB();
    }
    public void cadastrarVendedor (Vendedor vendedor){
        abrirDB();
        database.store(vendedor);
        System.out.println("Vendedor cadastrado.");
        fecharDB();
    }
    public List<Cliente> exibirTodosClientes (){
        abrirDB();
        ObjectSet listCliente = database.queryByExample(Cliente.class);
        List<Cliente> cliente = new ArrayList<>();
        for (Object c: listCliente) {
            cliente.add((Cliente) c);
        }
        fecharDB();
        return cliente;
    }
    
    public List<Produto> exibirTodosProdutos (){
        abrirDB();
        ObjectSet listProduto = database.queryByExample(Produto.class);
        List<Produto> produto = new ArrayList<>();
        for (Object p: listProduto) {
            produto.add((Produto) p);
        }
        fecharDB();
        return produto;
    }
    
    public void inserirCliente(Cliente cliente){
        abrirDB();
        database.store(cliente);
        fecharDB();
    }
    
    public void inserirProduto(Produto produto){
        abrirDB();
        database.store(produto);
        fecharDB();
    }
    
    public Cliente selecionarUmCliente(Cliente cliente){
        abrirDB();
        ObjectSet result = database.queryByExample(cliente);
        Cliente cli = (Cliente) result.next();
        fecharDB();
        return cli;
    }
    
    public void updateCliente(int codCli, String nnome, String ttelefone, String eendereco, String ccep, String eemail){
        abrirDB();
        Cliente cliente = new Cliente();
        cliente.setCodCli(codCli);
        ObjectSet result = database.queryByExample(cliente);
        Cliente clienteresult = (Cliente) result.next();
        clienteresult.setNome(nnome);
        clienteresult.setTelefone(ttelefone);
        clienteresult.setEndereco(eendereco);
        clienteresult.setCep(ccep);
        clienteresult.setEmail(eemail);
        database.store(clienteresult);
        fecharDB();
    }
    
    public void deletarProduto(int codPro){
        abrirDB();
        Produto produto = new Produto();
        produto.setCodPro(codPro);
        ObjectSet result = database.queryByExample(produto);
        Produto produtoresult = (Produto) result.next();
        database.delete(produtoresult);
        fecharDB();
    }
        
    
    
    public void criarDatabase () {
        abrirDB();

        Cliente cliente = new Cliente(1, "Jose", "9999-9999", "Avenida Florida", "59.000-000", "jose@email.com");
        Vendedor vendedor = new Vendedor(1, "4902322", 2, "Floriano", "Rua da semente");
        Produto produto = new Produto(1, 10.00, "Pipoca estrela", 15.00, "Pipoca");
        Venda venda = new Venda(1, 12, vendedor, cliente);
        ItemVenda itemVenda = new ItemVenda(produto, venda, 10, 1);
        Veiculo veiculo = new Veiculo("OGB-1111", 4);
        Motorista motorista = new Motorista(1, "90323290", "2329042", "Mariano", "Rua dos louros");
        Entrega entrega = new Entrega("19:27h", "01/01/2022", 1, venda, veiculo, motorista);

        database.store(cliente);
        database.store(vendedor);
        database.store(produto);
        database.store(venda);
        database.store(itemVenda);
        database.store(veiculo);
        database.store(motorista);
        database.store(entrega);
        System.out.println("Base de dados criada");
        fecharDB();
    }

}
