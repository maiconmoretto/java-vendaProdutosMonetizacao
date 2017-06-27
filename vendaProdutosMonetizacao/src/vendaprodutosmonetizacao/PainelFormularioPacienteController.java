package vendaprodutosmonetizacao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author lhries
 */
public class PainelFormularioPacienteController implements Initializable {
    @FXML
    private TextField textFieldNome;
    @FXML
    private AnchorPane painelFormularioPaciente;
      
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        pacienteNegocio = new PacienteNegocio();

    }
    
    @FXML
    private void tratarBotaoSalvar(ActionEvent event) {
         Stage stage = (Stage) painelFormularioPaciente.getScene().getWindow();
        /*
        
                Stage stage = (Stage) painelFormularioPaciente.getScene().getWindow();

        try {
            pacienteNegocio.salvar(new Paciente(
                    textFieldRg.getText(),
                    textFieldNome.getText(),
                    datePickerDataNascimento.getValue()
            ));
            PrintUtil.printMessageSucesso("Cadastro realizado com sucesso!");
            limparCampos();
        } catch (NegocioException ex) {
            PrintUtil.printMessageError(ex.getMessage());
        }
        
        */
        
        
        System.out.println("aqui "+ textFieldNome.getText());
        Alert alerta = new Alert(AlertType.INFORMATION);
        alerta.setTitle( textFieldNome.getText());
        alerta.setHeaderText(null);//"Cadastro realizado!");
        alerta.setContentText(textFieldNome.getText()+" salvo com sucesso!");
        alerta.showAndWait();
    }
    
  
    
}
