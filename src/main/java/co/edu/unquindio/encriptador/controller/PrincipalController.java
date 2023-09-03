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
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class PrincipalController implements Initializable {

    private String metodoSeleccionado;

    private String textoIngresado;

    private final String ALFABETO = "abcdefghijklmnopqrstuvwxyz";

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
    void detectarTexto(KeyEvent event) {

        if(!this.txtTextoIngresado.getText().equalsIgnoreCase("")){                           //Se habilitan los botones para encriptar o desencriptar
            this.btnEncriptar.setVisible(true);                                               //Si se detecta texto en la caja de texto
            this.btnDesencriptar.setVisible(true);                                            //En caso de no haber texto, se deshabilitan los botones
        }else{
            this.btnEncriptar.setVisible(false);
            this.btnDesencriptar.setVisible(false);
        }

    }

    @FXML
    void desencriptarTexto(ActionEvent event) {

    }

    @FXML
    void encriptarTexto(ActionEvent event) {

        //volver a minúscula todo el texto ingresado
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        opcionMetodo = FXCollections.observableArrayList("Método Cesar","Método Chino");       //Se llena el combobox
        this.comboMetodo.setItems(opcionMetodo);                                               //con las opciones de método
        this.txtClaveCesar.setVisible(false);                                                  //de encriptación y se oculta el text field de la clave de cesar
                                                                                               //si no se ha seleccionado esa opción

        this.btnEncriptar.setVisible(false);
        this.btnDesencriptar.setVisible(false);
    }

    public String encriptarCesar(String texto, int clave){

        String textoCesar = "";
        char caracterCesar;
        int indiceAux;

        for(int i = 0; i<= this.ALFABETO.length()-1; i++){

            for(int j = 0; j<=texto.length()-1; j++){

                indiceAux = 0;

                if(this.ALFABETO.charAt(i)==texto.charAt(j)){

                    if(i + clave>ALFABETO.length()-1){

                        indiceAux = i + clave;
                        textoCesar+=ALFABETO.charAt(indiceAux);

                    }

                }

            }

        }

        return "";
    }
}
