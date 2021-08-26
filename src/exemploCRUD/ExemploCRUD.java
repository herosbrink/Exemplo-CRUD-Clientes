/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemploCRUD;

import java.awt.HeadlessException;
import java.sql.Connection;
import javax.swing.JOptionPane;
import jdbc.ConnectionFactory;

/**
 *
 * @author vmari
 */
public class ExemploCRUD {
    
    public static void main(String[] args) {
        
        JOptionPane.showMessageDialog(null, "Testando Conexão");
        
        try {
            Connection con = new ConnectionFactory().conecta();
            
            JOptionPane.showMessageDialog(null, "Esta Conectado");
        } catch (HeadlessException e) {
        }
        
        
        
        
    }
    
}
