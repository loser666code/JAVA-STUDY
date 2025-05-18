package controller;

import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.LoginDAO;
import model.User;
import util.Alerta;

public class LoginController{
    Stage stageL = new Stage();
    private ArrayList<String> listaDados;
    private User user;
    private final LoginDAO dao = new LoginDAO();
    
    @FXML
    private ImageView Imagem;

    @FXML
    private Button bntLogar;

    @FXML
    private TextField txtSenha;

    @FXML
    private TextField txtNome;

      
    public void setStage (Stage stage){
        this.stageL = stage;
    }
    
    @FXML
    void onClickLogar(ActionEvent event) throws SQLException {
        processarLogin();
    }
    
    public void verificarBanco(){
        if (dao.bancoOline()){
          File arquivo = new File("src/main/resources/imagens/DBRight.png");
          Image img = new Image(arquivo.toURI().toString());
          Imagem.setImage(img);
        } else {
            File arquivo = new File("src/main/resources/imagens/DBWrong.png");
            Image img = new Image(arquivo.toURI().toString());
            Imagem.setImage(img);
        }
        }
    
    public void processarLogin() throws SQLException{
        if(!dao.bancoOline()){
            Alerta.mostrarErro("Erro!", "Banco de dados desconectado!");
        } else if (txtNome.getText() != null && !txtNome.getText().isEmpty() && txtSenha.getText() != null && !txtSenha.getText().isEmpty()){
            listaDados = autenticar(txtNome.getText(), txtSenha.getText());
            if (listaDados != null){
                Alerta.mostrarInformacao("Informação", "Seja Bem-Vindo! " + listaDados.get(0) + " acesso liberado!" );
                if (stageL != null){
                    stageL.close();
                }
            } else {
                Alerta.mostrarErro("Erro", "Usuario e senha invalidos!");
            } 
        } else {
                Alerta.mostrarErro("Erro", "Verifique Informações!");
            }    
    }
    
    private ArrayList autenticar(String nome, String senha) throws SQLException{
        user = dao.autenticar(nome, senha);
        if (user != null){
            ArrayList<String> listaDados = new ArrayList<>();
            listaDados.add(user.getNome());
            listaDados.add(user.getSenha());
            return listaDados;
        }
        return null;
    }
    
    public void abrirJanela(){
        bntLogar.setDefaultButton(true);
        verificarBanco();
    }
    
}
