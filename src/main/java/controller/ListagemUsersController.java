package controller;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.User;
import model.UserDAO;
import util.Alerta;

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
    private TableView<User> twUsers;
    
    @FXML
    void bntCadastrarOnClick(ActionEvent event) throws MalformedURLException, IOException {
        URL url = new File("src/main/java/view/CadastrarUsers.fxml").toURI().toURL();
        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();
        Stage stageCadastroUser = new Stage();
        CadastrarUsersController cuc = loader.getController();
        cuc.setStage(stageViewUser);
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("" + "/css/cadastrarusers.css").toExternalForm());
    }
    
    public void ajustarTabela() throws SQLException{
        carregarUsersTabela();
    }
    
    private void carregarUsersTabela() throws SQLException{
        lista = FXCollections.observableArrayList(listarUsers());
        if (!lista.isEmpty()){
            twUsers.getColumns().clear();
            
            TableColumn<User, Number> colunaID = new TableColumn<>("ID");
            colunaID.setCellValueFactory(u -> u.getValue().idProperty());
            colunaID.setPrefWidth(40);
            
            TableColumn<User, String> colunaNome = new TableColumn<>("Nome");
            colunaNome.setCellValueFactory(u -> u.getValue().nomeProperty());
            colunaNome.setStyle("-fx-aligment: CENTER;");
            
            TableColumn<User, String> colunaSobrenome = new TableColumn<>("Sobrenome");
            colunaSobrenome.setCellValueFactory(u -> u.getValue().sobrenomeProperty());
            
            TableColumn<User, String> colunaEmail = new TableColumn<>("Email");
            colunaEmail.setCellValueFactory(u -> u.getValue().emailProperty());
            
            TableColumn<User, String> colunaCargo = new TableColumn<>("Cargo");
            colunaCargo.setCellValueFactory(u -> u.getValue().cargoProperty());
            
            TableColumn<User, String> colunaUsername = new TableColumn<>("Username");
            colunaUsername.setCellValueFactory(u -> u.getValue().usernameProperty());
            
            twUsers.getColumns().addAll(colunaID,colunaNome,colunaSobrenome, colunaEmail, colunaCargo, colunaUsername);
            
            FilteredList<User> listaFiltrada = new FilteredList<>(lista, p -> true);
            tfPesquisa.textProperty().addListener((obs,oldVal,newVal) -> {
             listaFiltrada.setPredicate(user -> {
                 if (newVal == null || newVal.isEmpty()){
                     return true;
                 }
                 String filtro = newVal.toLowerCase();
                 return user.getNome().toLowerCase().contains(filtro)
                        || user.getSobrenome().toLowerCase().contains(filtro)
                        || user.getCargo().toLowerCase().contains(filtro)
                        || user.getEmail().toLowerCase().contains(filtro)
                        || user.getUsername().toLowerCase().contains(filtro);
             });
            });
            
            SortedList<User> listaOrdenada = new SortedList<>(listaFiltrada);
            listaOrdenada.comparatorProperty().bind(twUsers.comparatorProperty());
            twUsers.setItems(listaOrdenada);
        } else {
            Alerta.mostrarErro("Error", "Error a carregar lista de users");
        } }
    
    private ObservableList<User> listarUsers() throws SQLException{
        UserDAO dao = new UserDAO();
        return dao.selecionarUsers();
    }
    
    @FXML
    void tableViewOnClick(MouseEvent event) {
        if(event.getClickCount() == 1){
            this.usuario = twUsers.getSelectionModel().getSelectedItem();
            if(this.usuario != null){
                
            }
        }
    }
    
    void setStage(Stage stage){
        this.stageViewUser=stage;
    }
}
