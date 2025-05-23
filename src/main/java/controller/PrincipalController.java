package controller;

import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


public class PrincipalController{
   
    Stage stagePrincipal = new Stage();
    
     @FXML
    private ImageView userImage;

    @FXML
    private Label userName;
    
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
        }
    }
    
}
