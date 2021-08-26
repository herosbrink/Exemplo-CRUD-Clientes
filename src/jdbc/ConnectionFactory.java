/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public Connection conecta() {

        try {

            return DriverManager.getConnection("jdbc:mysql://localhost:3306/bdclientes", "root", "rRedp5PDb3fDiY4");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
