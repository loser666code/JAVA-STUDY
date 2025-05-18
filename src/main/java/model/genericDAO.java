package model;
import dal.Conn;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public abstract class genericDAO {
    private Connection conexao;

    protected genericDAO(){
     this.conexao = Conn.conectar();
    }
    
    protected Connection conectarCon(){
        this.conexao = Conn.conectar();
        return conexao;
    }
    
    protected void save (String insertsql,Object... parametros) throws SQLException{
        PreparedStatement stmt = conectarCon().prepareStatement(insertsql);
        for ( int i = 0; i < parametros.length; i++){
            stmt.setObject(i + 1, parametros[i]);
        }
        stmt.execute();
        stmt.close();
        conexao.close();
    }
    
    protected void editar (String editarsql,Object id, Object... parametros) throws SQLException{
        PreparedStatement stmt = conectarCon().prepareStatement(editarsql);
        for ( int i = 0; i < parametros.length; i++){
            stmt.setObject(i + 1, parametros[i]);
        }
        stmt.setObject(parametros.length + 1, id);
        stmt.execute();
        stmt.close();
        conexao.close();
    }
    
    protected void deletar (String deletarsql,Object id, Object... parametros) throws SQLException{
        PreparedStatement stmt = conectarCon().prepareStatement(deletarsql);
        for ( int i = 0; i < parametros.length; i++){
            stmt.setObject(i + 1, parametros[i]);
        }
        stmt.execute();
        stmt.close();
        conexao.close();
    }
}
