package co.edu.unquindio.encriptador.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class PrincipalController implements Initializable {

    private String metodoSeleccionado;

    @FXML
    private Button btnDesencriptar;

    @FXML
    private Button btnEncriptar;

    @FXML
    private ComboBox<String> comboMetodo;

    @FXML
    private TextArea txtTextoEncriptado;

    @FXML
    private TextArea txtTextoIngresado;

    @FXML
    private TextField txtClaveCesar;

    ObservableList<String> opcionMetodo;

    @FXML
    void seleccionarMetodo(ActionEvent event) {

        this.metodoSeleccionado = comboMetodo.getSelectionModel().getSelectedItem();              //Se toma el método seleccionado en el combobox

        if(this.metodoSeleccionado.equalsIgnoreCase("Método Cesar")){                            //Si el método seleccionado es método cesar
            this.txtClaveCesar.setVisible(true);                                                 //se habilita el text field para que se escriba la clave
        }else{
            this.txtClaveCesar.setVisible(false);                                                //Si es el método chino, se oculta nuevamente el text field de clave
        }

    }

    @FXML
    void desencriptarTexto(ActionEvent event) {

    }

    @FXML
    void encriptarTexto(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        opcionMetodo = FXCollections.observableArrayList("Método Cesar","Método Chino");       //Se llena el combobox
        this.comboMetodo.setItems(opcionMetodo);                                               //con las opciones de método
        this.txtClaveCesar.setVisible(false);                                                  //de encriptación y se oculta el text field de la clave de cesar
                                                                                               //si no se ha seleccionado esa opción


    }
}
