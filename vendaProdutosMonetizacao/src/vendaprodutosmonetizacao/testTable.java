package vendaprodutosmonetizacao;

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
import vendaprodutosmonetizacao.Product;
import vendaprodutosmonetizacao.model.Produtos;

public class testTable extends Application {

    Produtos produtos = new Produtos();
    Stage window;
    TableView<Product> table;
    TextField nameInput, priceInput, quantityInput;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("thenewboston - JavaFX");

        //Name column
        TableColumn<Product, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        //Price column
        TableColumn<Product, Double> priceColumn = new TableColumn<>("Price");
        priceColumn.setMinWidth(100);
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        //Quantity column
        TableColumn<Product, String> quantityColumn = new TableColumn<>("Quantity");
        quantityColumn.setMinWidth(100);
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        //Name input
        nameInput = new TextField();
        nameInput.setPromptText("Name");
        nameInput.setMinWidth(100);

        //Price input
        priceInput = new TextField();
        priceInput.setPromptText("Price");

        //Quantity input
        quantityInput = new TextField();
        quantityInput.setPromptText("Quantity");

        //Button
        Button addButton = new Button("Add");
        addButton.setOnAction(e -> {
            try {
                addButtonClicked();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(testTable.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(testTable.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(e -> {
            try {
                deleteButtonClicked();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(testTable.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(testTable.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10, 10, 10, 10));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(nameInput, priceInput, quantityInput, addButton, deleteButton);

        table = new TableView<>();

        table.setItems(getProduct());
        table.getColumns().addAll(nameColumn, priceColumn, quantityColumn);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(table, hBox);

        Scene scene = new Scene(vBox);
        window.setScene(scene);
        window.show();
    }

    //Add button clicked
    public void addButtonClicked() throws ClassNotFoundException, SQLException {
        Product product = new Product();

        int valor = Integer.parseInt(priceInput.getText());
        int quantidade = Integer.parseInt(quantityInput.getText());
        String nome = nameInput.getText();
        produtos.cadastrarProduto(nome, valor, quantidade);
        product.setName(nome);
        product.setPrice(valor);
        product.setQuantity(quantidade);
        table.getItems().add(product);
        nameInput.clear();
        priceInput.clear();
        quantityInput.clear();

//        Product product = new Product();
//        product.setName(nameInput.getText());
//        product.setPrice(Double.parseDouble(priceInput.getText()));
//        product.setQuantity(Integer.parseInt(quantityInput.getText()));
//        table.getItems().add(product);
//        nameInput.clear();
//        priceInput.clear();
//        quantityInput.clear();
    }

    //Delete button clicked
    public void deleteButtonClicked() throws ClassNotFoundException, SQLException {
        ObservableList<Product> productSelected, allProducts;
        Product product = new Product();
        String nome = nameInput.getText();
        produtos.deletarProdutoPorNome(nome);
        product.setName(nome);
        table.getItems().remove(product);
        nameInput.clear();
        priceInput.clear();
        quantityInput.clear();
        
        
        
        
//        allProducts = table.getItems();
//        productSelected = table.getSelectionModel().getSelectedItems();
//        productSelected.forEach(allProducts::remove);
    }

    //Get all of the products
    public ObservableList<Product> getProduct() throws ClassNotFoundException, SQLException {
        ObservableList<Product> products = FXCollections.observableArrayList();

//        for (List<produtos.list()> : list) {
//            System.out.println(integer);
//            qnt += integer;
//        }
        Connection connection = Conexao.Conexao();

        String sql = "SELECT * FROM  produtos  ORDER BY idproduto";
        Statement comando = connection.createStatement();
        ResultSet resultado = comando.executeQuery(sql);

        while (resultado.next()) {
            products.add(new Product(resultado.getString("nome"), resultado.getInt("valor"), 10));
//                System.out.println("\nId: " + resultado.getInt("idproduto"));
//                System.out.println("Nome: " + resultado.getString("nome"));
//                System.out.println("valor: " + resultado.getInt("valor"));
//                System.out.println("data cadastro: " + resultado.getDate("data_cadastro"));
        }
        //  produtos.listarProdutos();
//        products.add(new Product("Laptop", 859.00, 20));
//        products.add(new Product("Bouncy Ball", 2.49, 198));
//        products.add(new Product("Toilet", 99.00, 74));
//        products.add(new Product("The Notebook DVD", 19.99, 12));
//        products.add(new Product("Corn", 1.49, 856));
        return products;
    }

}
