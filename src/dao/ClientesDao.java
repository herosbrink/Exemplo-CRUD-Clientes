
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
    
}
