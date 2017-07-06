/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trash;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author lhries
 */
public class TelaProximaController implements Initializable {
    @FXML
    private AnchorPane painelTelaProxima;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    
    @FXML
    private void tratarBotaoVoltar(ActionEvent event) throws IOException {
        Stage stage = (Stage) painelTelaProxima.getScene().getWindow();
        stage.setTitle("Tela Principal");
        Parent painelTelaPrincipal = FXMLLoader.load(this.getClass().getResource("TelaPrincipal.fxml"));
        stage.setScene(new Scene(painelTelaPrincipal));

    }
}
