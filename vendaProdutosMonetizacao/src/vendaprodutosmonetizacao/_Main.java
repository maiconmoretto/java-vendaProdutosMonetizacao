
import java.io.IOException;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
//from   ww w .  ja va 2  s  .c o  m

public class _Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 300, 250, Color.WHITE);

        MenuBar menuBar = new MenuBar();
        menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
        root.setTop(menuBar);

        // File menu - new, save, exit
        Menu cliente = new Menu("Clientes");
        MenuItem cadastro = new MenuItem("Cadastro");
        MenuItem editar = new MenuItem("Editar");
        MenuItem excluir = new MenuItem("Excluir");
//        sair.setOnAction(actionEvent -> Platform.exit());

        cliente.getItems().addAll(cadastro, editar,
                excluir);

        Menu produto = new Menu("Produtos");
        MenuItem cadastroP = new MenuItem("Cadastro");
        MenuItem editarP = new MenuItem("Editar");
        MenuItem excluirP = new MenuItem("Excluir");
        produto.getItems().addAll(cadastroP, editarP,
                excluirP);

  

        menuBar.getMenus().addAll(cliente, produto);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    
    public void clientes(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(this.getClass().getResource("/view/TelaPrincipal.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }
    
    
}
