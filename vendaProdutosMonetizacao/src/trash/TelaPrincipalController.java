package trash;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author lhries
 */
public class TelaPrincipalController implements Initializable {
    
    @FXML
    private AnchorPane painelTelaPrincipal;


    
    @FXML
    private void tratarProximaTela(ActionEvent event) throws IOException {
  
        Stage stage = (Stage) painelTelaPrincipal.getScene().getWindow();
        stage.setTitle("Proxima Tela");
        Parent painelTelaProxima = FXMLLoader.load(this.getClass().getResource("TelaProxima.fxml"));
        stage.setScene(new Scene(painelTelaProxima));
    }
    
    
        

    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
