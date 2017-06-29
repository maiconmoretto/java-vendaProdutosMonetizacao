/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendaprodutosmonetizacao;


import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javax.swing.JOptionPane;

/**
 *
 * @author lhries
 */
public class PrintUtil {

    public static void printMessageError(String msg) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText("Look, an Information Dialog");
        alert.setContentText("I have a great message for you!");

        alert.showAndWait();
    }

    public static void printMessageSucesso(String msg) {
        JOptionPane.showMessageDialog(null,
                msg,
                "Sucesso",
                JOptionPane.PLAIN_MESSAGE);
    }
}
