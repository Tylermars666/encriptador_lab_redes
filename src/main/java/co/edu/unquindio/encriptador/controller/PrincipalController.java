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

        try{
            if(this.metodoSeleccionado.equalsIgnoreCase("método cesar")){
                try{
                    String encriptadoCesar = encriptarCesar(this.txtTextoIngresado.getText(),Integer.parseInt(this.txtClaveCesar.getText()));
                    this.txtTextoEncriptado.setText(encriptadoCesar);
                }catch(NumberFormatException nfe){

                    this.txtTextoEncriptado.setText("SELECCIONE UN VALOR PARA LA CLAVE");

                }

            }
        }catch (RuntimeException e){
            this.txtTextoEncriptado.setText("SELECCIONE UN MÉTODO DE ENCRIPTACIÓN");
        }

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
        int indiceAux;

        for(int i = 0; i<= texto.length()-1; i++){

            String caracterEncriptado = "";

            for(int j = 0; j<=ALFABETO.length()-1; j++){

                if(texto.charAt(i)==' '){
                    caracterEncriptado+=' ';
                    break;

                }else {
                    if(texto.charAt(i)==ALFABETO.charAt(j)){

                        if(j + clave>ALFABETO.length()-1){

                            indiceAux = 26 - (j + clave);

                        }else{

                            if(j + clave < 0){
                                indiceAux = 26 + (j + clave);

                            }else{

                                indiceAux = j + clave;
                            }
                        }
                        caracterEncriptado+=ALFABETO.charAt(indiceAux);
                    }
                }
            }
            textoCesar+=caracterEncriptado;
        }
        return textoCesar;
    }
}
