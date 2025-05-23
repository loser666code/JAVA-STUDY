package controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
    void onClickLogar(ActionEvent event) throws SQLException, IOException {
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
    
    public void processarLogin() throws SQLException, IOException{
        if(!dao.bancoOline()){
            Alerta.mostrarErro("Erro!", "Banco de dados desconectado!");
        } else if (txtNome.getText() != null && !txtNome.getText().isEmpty() && txtSenha.getText() != null && !txtSenha.getText().isEmpty()){
            listaDados = autenticar(txtNome.getText(), txtSenha.getText());
            if (listaDados != null){
                Alerta.mostrarInformacao("Informação", "Seja Bem-Vindo! " + listaDados.get(0) + " acesso liberado!" );
                if (stageL != null){
                    stageL.close();
                }
                abrirTelaPrincipal(listaDados);
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
    
    public void abrirTelaPrincipal(ArrayList<String> dados) throws IOException{
        URL url = new File("src/main/java/view/Principal.fxml").toURI().toURL();
        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();
        Stage telaPrincipal = new Stage();
        PrincipalController pc = loader.getController();
        telaPrincipal.setOnShown(evento -> {
            pc.limitarAcoes(dados);
        });
        pc.setStage(telaPrincipal);
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("" + "/css/principal.css").toExternalForm());
        telaPrincipal.setScene(scene);
        File file = new File("src/main/resources/imagens/my-melody-icon.png");
        Image icon = new Image(file.toURI().toString());
        telaPrincipal.getIcons().add(icon);
        telaPrincipal.setTitle("tela principal");
        telaPrincipal.show();
    }
    
}
