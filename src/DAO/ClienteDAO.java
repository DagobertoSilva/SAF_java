package DAO;

import DTO.ClienteDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ClienteDAO {

    Connection conn;
    
    public ResultSet autenticacaoUsuario(ClienteDTO objclientedto){
        conn = new ConexaoDAO().conectaBD();
        
        try {
            String sql = "select * from login where login = ? and senha = ?";
            
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, objclientedto.getLogin());
            pstm.setString(2, objclientedto.getSenha());
            
            ResultSet rs = pstm.executeQuery();
            return rs;
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ClienteDAO: " + erro);
            return null;
        }
        
    }
}

