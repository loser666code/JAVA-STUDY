package controller;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


public class PrincipalController{
   
    Stage stagePrincipal = new Stage();
    
    
    @FXML
    private MenuItem UserMI;

    @FXML
    private MenuBar menuBar;

    @FXML
    private Menu menuUsers;

    @FXML
    private MenuItem relatoriosMI;

    @FXML
    private ImageView userImage;

    @FXML
    private Label userName;
    
    
    @FXML
    void userMiClick(ActionEvent event) throws MalformedURLException, IOException {
        URL url = new File ("src/main/java/view/ListagemUsers.fxml").toURI().toURL();
        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();
        Stage stageLU = new Stage();
        ListagemUsersController luc = loader.getController();
        luc.setStage(stageLU);
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("" + "/css/listagemusers.css").toExternalForm());
        stageLU.setScene(scene);
        File file = new File("src/main/resources/imagens/my-melody-icon.png");
        Image icon = new Image(file.toURI().toString());
        stageLU.getIcons().add(icon);
        stageLU.setTitle("Listagem de usuarios");
        stageLU.show();
    }
    
    public void setStage(Stage stage){
        this.stagePrincipal = stage;
    }
    
    void limitarAcoes(ArrayList<String>dados){
        System.out.println("Parametros do login" + dados.get(0) + " - " + dados.get(1));
        userName.setText(dados.get(0));
        if (dados.get(1) == "adm"){
            System.out.println("Acesso Liberado!");
        } else if (dados.get(1) == "client"){
            System.out.println("Acesso Restringido!");
            menuUsers.setDisable(true);
        }
    }
    
}
