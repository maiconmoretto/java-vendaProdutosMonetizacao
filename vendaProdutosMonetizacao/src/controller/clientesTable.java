package controller;

import trash.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import vendaprodutosmonetizacao.model.Clientes;

public class clientesTable extends Application {

    Clientes clientes = new Clientes();
    Stage window;
    TableView<Client> table;
    TextField emailInput, nomeInput, cpfInput;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("thenewboston - JavaFX");

        //Name column
        TableColumn<Client, String> nameColumn = new TableColumn<>("Nome");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        //Price column
        TableColumn<Client, Double> cpfColumn = new TableColumn<>("CPF");
        cpfColumn.setMinWidth(100);
        cpfColumn.setCellValueFactory(new PropertyValueFactory<>("cpf"));

        //Quantity column
        TableColumn<Client, String> emailColumn = new TableColumn<>("Email");
        emailColumn.setMinWidth(100);
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));

        //Name input
        emailInput = new TextField();
        emailInput.setPromptText("Email");
        emailInput.setMinWidth(100);

        //Price input
        nomeInput = new TextField();
        nomeInput.setPromptText("Nome");

        //Quantity input
        cpfInput = new TextField();
        cpfInput.setPromptText("Cpf");

        //Button
        Button addButton = new Button("Add");
        addButton.setOnAction(e -> {
            try {
                addButtonClicked();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(clientesTable.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(clientesTable.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(e -> {
            try {
                deleteButtonClicked();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(clientesTable.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(clientesTable.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10, 10, 10, 10));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(nomeInput, cpfInput, emailInput,addButton, deleteButton);

        table = new TableView<>();

        table.setItems(getClient());
        table.getColumns().addAll(nameColumn, cpfColumn, emailColumn);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(table, hBox);

        Scene scene = new Scene(vBox);
        window.setScene(scene);
        window.show();
    }

    //Add button clicked
    public void addButtonClicked() throws ClassNotFoundException, SQLException {
        Client client = new Client();
      
        String nome = nomeInput.getText();
        String cpf = cpfInput.getText();
        String email = emailInput.getText();
        clientes.cadastrarCliente(nome, email, cpf);
        client.setName(nome);
        client.setEmail(email);
        client.setCpf(cpf);
        table.getItems().add(client);
        emailInput.clear();
        nomeInput.clear();
        cpfInput.clear();
    }

    //Delete button clicked
    public void deleteButtonClicked() throws ClassNotFoundException, SQLException {
        ObservableList<Client> clientSelected, allClients;
        Client client = new Client();
        String nome = nomeInput.getText();
        String cpf = cpfInput.getText();
        String email = emailInput.getText();
        clientes.deletarClientePorNome(nome);
//        client.setName(nome);
//        client.setName(nome);
//        client.setEmail(email);
//        client.setCpf(cpf);
//        table.getItems().remove(client);
//        emailInput.clear();
//        nomeInput.clear();
//        cpfInput.clear();
        table.refresh();

    }

    //Get all of the clients
    public ObservableList<Client> getClient() throws ClassNotFoundException, SQLException {
        ObservableList<Client> clients = FXCollections.observableArrayList();

        Connection connection = Conexao.Conexao();
        String sql = "SELECT * FROM  clientes  ORDER BY idcliente";
        Statement comando = connection.createStatement();
        ResultSet resultado = comando.executeQuery(sql);

        while (resultado.next()) {
            clients.add(new Client(resultado.getString("nome"), resultado.getString("cpf"), resultado.getString("email")));

        }
        return clients;
    }

}
