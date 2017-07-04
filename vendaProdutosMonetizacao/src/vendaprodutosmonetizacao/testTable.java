package vendaprodutosmonetizacao;


import java.sql.SQLException;
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
        deleteButton.setOnAction(e -> deleteButtonClicked());

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

        int valor = Integer.parseInt(priceInput.getText());
        int quantidade = Integer.parseInt(quantityInput.getText());
        String nome = nameInput.getText();
        produtos.cadastrarProduto(nome, valor, quantidade);
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
    public void deleteButtonClicked() {
        ObservableList<Product> productSelected, allProducts;
        allProducts = table.getItems();
        productSelected = table.getSelectionModel().getSelectedItems();

        productSelected.forEach(allProducts::remove);
    }

    //Get all of the products
    public ObservableList<Product> getProduct() {
        ObservableList<Product> products = FXCollections.observableArrayList();
        products.add(new Product("Laptop", 859.00, 20));
        products.add(new Product("Bouncy Ball", 2.49, 198));
        products.add(new Product("Toilet", 99.00, 74));
        products.add(new Product("The Notebook DVD", 19.99, 12));
        products.add(new Product("Corn", 1.49, 856));
        return products;
    }

}
