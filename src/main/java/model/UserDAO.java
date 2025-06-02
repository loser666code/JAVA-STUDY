package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class UserDAO extends genericDAO{
    public void salvar(User user) throws SQLException{
        String insert = "INSERT INTO user(nome,sobrenome,email,cargo,senha,username,telefone,aniversario) VALUES (?,?,?,?,?,?,?,?)";
        save(insert,user.getNome(),user.getSobrenome(),user.getEmail(),user.getCargo(),user.getSenha(),user.getUsername(),user.getTelefone(),user.getAniversario());
    }
    
    public void alterar(User user) throws SQLException{
        String update = "UPDATE user" + "SET nome= ?, sobrenome = ?, email = ?, crago=?, senha=?,username=?,telefone=?,aniversario=?" + "WHERE idUser = ?";
        editar(update,user.getNome(),user.getSobrenome(),user.getEmail(),user.getCargo(),user.getSenha(),user.getUsername(),user.getTelefone(),user.getAniversario());
    }
    
    public void deletar(long id) throws SQLException{
        String delete = "DELETE FROM user WHERE idUser=?";
        deletar(delete, id);
    }
    
    public ObservableList<User> selecionarUsers()throws SQLException {
        ObservableList<User> lista = FXCollections.observableArrayList();
        String sql = "SELECT * FROM user";
        PreparedStatement stmt = conectarCon().prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            User user = new User();
            user.setId(rs.getInt("idUser"));
            user.setNome(rs.getString("nome"));
            user.setSobrenome(rs.getString("sobrenome"));
            user.setEmail(rs.getString("email"));
            user.setCargo(rs.getString("cargo"));
            user.setSenha(rs.getString("senha"));
            user.setUsername(rs.getString("username"));
            user.setTelefone(rs.getString("telefone"));
            user.setAniversario(rs.getString("aniversario"));
            
            lista.add(user);
        }
        rs.close();
        stmt.close();
        conectarCon().close();
        return lista;
    }
    
    public ObservableList<User> selecionarUser(long idUser)throws SQLException {
        ObservableList<User> usuario = FXCollections.observableArrayList();
        String sql = "SELECT * FROM user WHERE idUser=?";
        PreparedStatement stmt = conectarCon().prepareStatement(sql);
        stmt.setLong(1, idUser);
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            User user = new User();
            user.setId(rs.getInt("idUser"));
            user.setNome(rs.getString("nome"));
            user.setSobrenome(rs.getString("sobrenome"));
            user.setEmail(rs.getString("email"));
            user.setCargo(rs.getString("cargo"));
            user.setSenha(rs.getString("senha"));
            user.setUsername(rs.getString("username"));
            user.setTelefone(rs.getString("telefone"));
            user.setAniversario(rs.getString("aniversario"));
            
            usuario.add(user);
        }
        rs.close();
        stmt.close();
        conectarCon().close();
        return usuario;
    }
}
