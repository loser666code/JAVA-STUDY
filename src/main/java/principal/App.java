package principal;

import controller.LoginController;
import java.io.File;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import javafx.scene.image.Image;
import javafx.stage.Window;

public class App extends Application {

        private static Window janela;
    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("estranha loja");
        URL url = new File("src/main/java/view/Login.fxml").toURI().toURL();
        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();
        Stage telaLogin = new Stage();
        LoginController lc = loader.getController();
        lc.setStage(telaLogin);
        telaLogin.setOnShown( event -> {
        lc.abrirJanela();
        });
        File file = new File("src/main/resources/imagens/my-melody-icon.png");
        Image icon = new Image(file.toURI().toString());
        telaLogin.getIcons().add(icon);
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("" + "/css/login.css").toExternalForm());
        telaLogin.setScene(scene);
        telaLogin.show();
    }

    public static void main(String[] args) {
        launch();
    }

}