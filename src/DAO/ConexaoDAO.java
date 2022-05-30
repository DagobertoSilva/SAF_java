package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
//dentro da classe teremos o método
public class ConexaoDAO {
   public Connection conectaBD(){
      Connection conn = null; 
       try {
           String url = "jdbc:mysql://localhost:3306/bd_saf?user=root&password=";
           conn = DriverManager.getConnection(url);
       } catch (SQLException error) {
           JOptionPane.showMessageDialog(null,"ConexãoDAO" + error.getMessage());
       }
       return conn;
   }
}
