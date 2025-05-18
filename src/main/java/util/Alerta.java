package util;

import java.io.File;
import java.util.Optional;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class Alerta {
    
    private static Scene cenaAlerta;
    
    public static void setCena(Scene cena){
        cenaAlerta = cena;
    }

    public static void aplicarEstilo(Alert alerta){
        DialogPane dp = alerta.getDialogPane();
        dp.getStylesheets().add(Alerta.class.getResource("/css/alertas.css").toExternalForm());
    }
    
    public static void mostrarAlerta(Alert.AlertType alertat, String titulo, String mgs, Image img) {
        Alert alerta = new Alert(alertat);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        aplicarEstilo(alerta);
        alerta.setContentText(mgs);
        ImageView imgV = new ImageView(img);
        alerta.setGraphic(imgV);
        alerta.showAndWait();
    }
    
    public static void mostrarErro(String titulo, String mensagem){
        File arquivo = new File("src/main/resources/imagens/trashIcon.png");
        Image img = new Image(arquivo.toURI().toString(),80, 80, true, true);
        mostrarAlerta(Alert.AlertType.ERROR, titulo, mensagem,img);
    }
    
    public static void mostrarInformacao(String titulo, String mensagem){
        File arquivo = new File("src/main/resources/imagens/listIcon.png");
        Image img = new Image(arquivo.toURI().toString(),80, 80, true, true);
        mostrarAlerta(Alert.AlertType.INFORMATION, titulo, mensagem, img);
    }
    
    public static void mostrarAviso(String titulo, String mensagem){
        File arquivo = new File("src/main/resources/imagens/chatIcon.png");
        Image img = new Image(arquivo.toURI().toString(),80, 80, true, true);
        mostrarAlerta(Alert.AlertType.WARNING, titulo, mensagem, img);
    }
    
    public static Optional<ButtonType> mostrarConfirmacao(String titulo,
            String mensagem){
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        File arquivo = new File("src/main/resources/imagens/confirmationIcon.png");
        Image img = new Image(arquivo.toURI().toString(),80, 80, true, true);
        ImageView imgV = new ImageView(img);
        alerta.setGraphic(imgV);
        aplicarEstilo(alerta);
        alerta.setContentText(mensagem);
        return alerta.showAndWait();
    }
        
}
