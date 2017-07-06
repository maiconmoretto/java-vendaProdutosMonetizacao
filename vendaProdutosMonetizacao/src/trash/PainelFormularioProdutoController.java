package trash;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.scene.input.InputEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import jdk.nashorn.internal.runtime.JSType;
import vendaprodutosmonetizacao.model.Produtos;


public class PainelFormularioProdutoController implements Initializable {

    @FXML
    private TextField textFieldNome;
    @FXML
    private TextField intFieldValor;


    @FXML
    private AnchorPane painelFormularioProduto;
    private Produtos produtos;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        produtos = new Produtos();

    }

    @FXML
    private void tratarBotaoSalvar(ActionEvent event) throws ClassNotFoundException {
        Stage stage = (Stage) painelFormularioProduto.getScene().getWindow();
        try {
            produtos.cadastrarProduto(textFieldNome.getText(), Integer.parseInt(intFieldValor.getText())  );

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
        alerta.setContentText("Produto salvo com sucesso!");
        alerta.showAndWait();
    }

}

