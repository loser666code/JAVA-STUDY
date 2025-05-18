
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class LoginDAO extends genericDAO {
    
    public Boolean bancoOline(){
        Connection conn = conectarCon();
        if (conn != null){
        try {
            conectarCon().close();
        } catch (SQLException e){ 
        }
            return true;
        } else {
            return false;
        }
    }
    
    public User autenticar(String username, String senha) throws SQLException{
        String sql = "SELECT * FROM user WHERE username = ? AND senha = ?";
        User user = null;
        Connection conn = conectarCon();
        if (conn != null){
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,username);
            stmt.setString(2,senha);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
            user = new User();
            user.setId(rs.getInt("idUser"));
            user.setNome(rs.getString("nome"));
            user.setSobrenome(rs.getString("sobrenome"));
            user.setEmail(rs.getString("email"));
            user.setCargo(rs.getString("cargo"));
            user.setSenha(rs.getString("senha"));
            user.setUsername(rs.getString("username"));
            
        }
            rs.close();
            stmt.close();
            conectarCon().close();
            return user;
        } else {
            return null;
        }
    }
    
}
