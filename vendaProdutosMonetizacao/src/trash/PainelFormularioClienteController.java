package trash;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.scene.input.InputEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import vendaprodutosmonetizacao.model.Clientes;

public class PainelFormularioClienteController implements Initializable {

    @FXML
    private AnchorPane painelFormularioCliente;

    
    @FXML
    private AnchorPane telaPrincipal;

    @FXML
    private TextField textFieldNome;
    @FXML
    private TextField textFieldEmail;
    @FXML
    private TextField textFieldCpf;

    private Clientes clientes;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        clientes = new Clientes();

    }
    @FXML
    private void cadastraCliene(ActionEvent event) throws IOException {
      
        Stage stage = (Stage) telaPrincipal.getScene().getWindow();
        stage.setTitle("Proxima Tela");
        Parent telaPrincipal = FXMLLoader.load(this.getClass().getResource("PainelFormularioCliente.fxml"));
        stage.setScene(new Scene(telaPrincipal));
    }
    
    @FXML
    private void tratarBotaoVoltar(ActionEvent event) throws IOException {
        Stage stage = (Stage) painelFormularioCliente.getScene().getWindow();
        stage.setTitle("Tela Principal");
        Parent painelFormularioCliente = FXMLLoader.load(this.getClass().getResource("TelaPrincipal.fxml"));
        stage.setScene(new Scene(painelFormularioCliente));

    }
    
    
    @FXML
    private void tratarBotaoSalvar(ActionEvent event) throws ClassNotFoundException {
        Stage stage = (Stage) painelFormularioCliente.getScene().getWindow();
        try {
            clientes.cadastrarCliente(textFieldNome.getText(), textFieldEmail.getText(), textFieldCpf.getText());

        } catch (SQLException e) {
            Alert alerta = new Alert(AlertType.INFORMATION);
            alerta.setTitle(textFieldNome.getText());
            alerta.setHeaderText(null);//"Cadastro realizado!");
            alerta.setContentText("erro ao realizar o  cadastro");
            alerta.showAndWait();
        }
        Alert alerta = new Alert(AlertType.INFORMATION);
        alerta.setTitle(textFieldNome.getText());
        alerta.setHeaderText(null);//"Cadastro realizado!");
        alerta.setContentText("Cliente salvo com sucesso!");
        alerta.showAndWait();
    }

}
