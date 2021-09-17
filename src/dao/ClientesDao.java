
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javabeans.Clientes;
import jdbc.ConnectionFactory;


public class ClientesDao {
    
    private Connection conecta;
    
    // Construtor
    
    public ClientesDao(){
        this.conecta = new ConnectionFactory().conecta();
    }
    
    // Método Cadastrar Cliente
    public void cadastrarCliente(Clientes obj){
        try {
            
            // criar o comando SQL
            
            String cmdsql = "insert into clientes (nome, email, telefone) values (?,?,?)";
            
            // organizar o comando e executar
            
            PreparedStatement stmt = conecta.prepareStatement(cmdsql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getEmail());
            stmt.setString(3, obj.getTelefone());
            
            // executar o comando
            
            stmt.execute();
            
            // fechar a conexão
            
            stmt.close();
            
        } catch (SQLException e) {
            throw new  RuntimeException(e);
        }
    }
    
     // Método Editar Cliente
    public void editarCliente(Clientes obj){
        try {
            
            // criar o comando SQL
            
            String cmdsql = "update clientes set nome=?, email=?, telefone=? where idcliente=?";
            
            // organizar o comando e executar
            
            PreparedStatement stmt = conecta.prepareStatement(cmdsql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getEmail());
            stmt.setString(3, obj.getTelefone());
            stmt.setInt(4, obj.getIdcliente());
            
            // executar o comando
            
            stmt.execute();
            
            // fechar a conexão
            
            stmt.close();
            
        } catch (SQLException e) {
            throw new  RuntimeException(e);
        }
    }
    
     // Método Excluir Cliente
    public void excluirCliente(Clientes obj){
        try {
            
            // criar o comando SQL
            
            String cmdsql = "delete from clientes where idcliente=?";
            
            // organizar o comando e executar
            
            PreparedStatement stmt = conecta.prepareStatement(cmdsql);
            stmt.setInt(1, obj.getIdcliente());
           
            
            // executar o comando
            
            stmt.execute();
            
            // fechar a conexão
            
            stmt.close();
            
        } catch (SQLException e) {
            throw new  RuntimeException(e);
        }
    }
    
     // Método para listar os clientes na Jtable
    public List<Clientes> listarClientes(){
        try {
            
           // 1º Criar o vetor que vai armazenar os registros do BD
            List<Clientes> lista = new ArrayList<Clientes>();
            
            // 2º Criar o comando SQL
            String cmdSql = "select * from clientes";
            
            //  Organizar o comando para execução
            PreparedStatement stmt = conecta.prepareStatement(cmdSql);
            
            // 3º Guardar o resultado do "select" dentro do objeto "rs" que é do tipo ResultSet
            ResultSet rs = stmt.executeQuery();
            
            // 4º Enquanto houver registros (resultado do select) guarde na lista
            while(rs.next()){
                Clientes cli = new Clientes();
                cli.setIdcliente(rs.getInt("idcliente"));
                cli.setNome(rs.getString("nome"));
                cli.setEmail(rs.getString("email"));
                cli.setTelefone(rs.getString("telefone"));
                
                lista.add(cli);
            }
            return lista;
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
        
    }
    
    // Método para fazer Busca por Nome
    public List<Clientes> BuscarClientes(String nome){
        try {
            
           // 1º Criar o vetor que vai armazenar os registros do BD
            List<Clientes> lista = new ArrayList<Clientes>();
            
            // 2º Criar o comando SQL
            String cmdSql = "select * from clientes where nome like ?";
            
            //  Organizar o comando para execução
            PreparedStatement stmt = conecta.prepareStatement(cmdSql);
            stmt.setString(1, nome);
            
            // 3º Guardar o resultado do "select" dentro do objeto "rs" que é do tipo ResultSet
            ResultSet rs = stmt.executeQuery();
            
            // 4º Enquanto houver registros (resultado do select) guarde na lista
            while(rs.next()){
                Clientes cli = new Clientes();
                cli.setIdcliente(rs.getInt("idcliente"));
                cli.setNome(rs.getString("nome"));
                cli.setEmail(rs.getString("email"));
                cli.setTelefone(rs.getString("telefone"));
                
                lista.add(cli);
            }
            return lista;
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
        
    }
    
}
