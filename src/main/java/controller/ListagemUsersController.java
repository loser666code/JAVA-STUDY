package controller;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.User;

public class ListagemUsersController  {
    
   Stage stageViewUser;
   User usuario;
    ObservableList<User>lista;

   @FXML
    private Button bntCadastrar;

    @FXML
    private ImageView imgVPesquisar;

    @FXML
    private TextField tfPesquisa;

    @FXML
    private TableView<?> twUsers;
    
    void setStage(Stage stage){
        this.stageViewUser=stage;
    }
}
