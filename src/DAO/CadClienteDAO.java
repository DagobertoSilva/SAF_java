package DAO;

import DTO.CadClienteDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class CadClienteDAO {

    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<CadClienteDTO> lista = new ArrayList<>();
    
    
    public void cadastrarCliente(CadClienteDTO objcadclientedto) {

        String sql = "insert into cliente (nome, cpf, telefone, email, endereco, planos) values (?,?,?,?,?,?)";

        conn = new ConexaoDAO().conectaBD();

        try {

            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objcadclientedto.getNome());
            pstm.setString(2, objcadclientedto.getCpf());
            pstm.setString(3, objcadclientedto.getTelefone());
            pstm.setString(4, objcadclientedto.getEmail());
            pstm.setString(5, objcadclientedto.getEndereco());
            pstm.setString(6, objcadclientedto.getPlanos());
            
            pstm.execute();
            pstm.close();

        } catch (Exception erro) {

            JOptionPane.showMessageDialog(null, "CadClienteDAO cadastrar" + erro);
        }

    }
    
    public ArrayList<CadClienteDTO> ListarClientes(){
        String sql = "select * from cliente";
        conn = new ConexaoDAO().conectaBD();
        try {
           pstm = conn.prepareStatement(sql);
           rs = pstm.executeQuery();
           
           while(rs.next()){
               CadClienteDTO objCadClienteDTO = new CadClienteDTO();
               objCadClienteDTO.setId_cliente(rs.getInt("id_cliente"));
               objCadClienteDTO.setNome(rs.getString("nome"));
               objCadClienteDTO.setCpf(rs.getString("cpf"));
               objCadClienteDTO.setTelefone(rs.getString("telefone"));
               objCadClienteDTO.setEmail(rs.getString("email"));
               objCadClienteDTO.setEndereco(rs.getString("endereco"));
               objCadClienteDTO.setPlanos(rs.getString("planos"));
               
               lista.add(objCadClienteDTO);
           }
           
        } catch (SQLException erro){
            
            JOptionPane.showMessageDialog(null, "CadClienteDAO listar:" + erro);
        }
    
  return lista;
}
    public void AlterarClientes(CadClienteDTO objcadclientedto){
        String sql = "update cliente set nome = ?, cpf = ?, telefone = ?, email = ?, endereco = ?, planos = ? where id_cliente = ?";
        
        conn = new ConexaoDAO().conectaBD();

        try {

            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objcadclientedto.getNome());
            pstm.setString(2, objcadclientedto.getCpf());
            pstm.setString(3, objcadclientedto.getTelefone());
            pstm.setString(4, objcadclientedto.getEmail());
            pstm.setString(5, objcadclientedto.getEndereco());
            pstm.setString(6, objcadclientedto.getPlanos());
            pstm.setInt(7, objcadclientedto.getId_cliente());

            pstm.execute();
            pstm.close();

        } catch (Exception erro) {

            JOptionPane.showMessageDialog(null, "CadClienteDAO Editar" + erro);
        }
    }
    
    public void DeletarClientes(CadClienteDTO objcadclientedto){
        String sql = "delete from cliente where id_cliente = ?";
        
         conn = new ConexaoDAO().conectaBD();

        try {

            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, objcadclientedto.getId_cliente());

            pstm.execute();
            pstm.close();

        } catch (Exception erro) {

            JOptionPane.showMessageDialog(null, "CadClienteDAO Deletar" + erro);
        }
    }
    public ResultSet ListarProduto(){
        conn = new ConexaoDAO().conectaBD();
        String sql = "select * from planos ORDER By nomeplano;";
        
         try {

            pstm = conn.prepareStatement(sql);
            return pstm.executeQuery();


        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "CadClienteDAO ListarProduto" + erro);
            return null;
        }
        
    }
}
    
