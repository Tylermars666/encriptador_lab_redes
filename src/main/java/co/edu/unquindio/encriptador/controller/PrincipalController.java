package co.edu.unquindio.encriptador.controller;

import co.edu.unquindio.encriptador.model.Methods;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class PrincipalController implements Initializable {

    private String metodoSeleccionado;

    private String textoIngresado;

    private final String ALFABETO = "abcdefghijklmnopqrstuvwxyz";

    @FXML
    private Button btnCopiar;

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
    void copiarTextoEncriptado(ActionEvent event) {

        this.txtTextoIngresado.setText(this.txtTextoEncriptado.getText());
        this.txtTextoEncriptado.setText("");

    }

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

        try{
            if(this.metodoSeleccionado.equalsIgnoreCase("método cesar")){
                try{                                                                 //Se accede al objeto singleton Methods para usar el método encriptarCesar, se envía el texto ingresado, la clave INVERTIDA y el alfabeto
                    String desencriptadoCesar = Methods.getInstance().encriptarCesar(this.txtTextoIngresado.getText().toLowerCase(),-(Integer.parseInt(this.txtClaveCesar.getText())),this.ALFABETO);
                    this.txtTextoEncriptado.setText(desencriptadoCesar);              //Se introduce el texto desencriptado en el textArea de la interfaz gráfica
                }catch (NumberFormatException nfe){                                   //Alerta de JavaFx para mostrar mensaje en la interfaz gráfica
                    Alert alert = new Alert(Alert.AlertType.ERROR,"Debe digitar una clave válida para el método Cesar",ButtonType.OK); //Alerta de JavaFx para mostrar mensaje en la interfaz gráfica
                    alert.setHeaderText(null);
                    alert.showAndWait();
                }
            }

            if(this.metodoSeleccionado.equalsIgnoreCase("método chino")){

                try{
                    String desencriptadoChino = Methods.getInstance().desencriptarChino(this.txtTextoIngresado.getText().toLowerCase());
                    this.txtTextoEncriptado.setText(desencriptadoChino);
                }catch (Exception e){

                    e.printStackTrace();
                }
            }

        }catch (RuntimeException rte){
                                                                                     //Alerta de JavaFx para mostrar mensaje en la interfaz gráfica
            Alert alert = new Alert(Alert.AlertType.ERROR,"Debe seleccionar un método para desencriptar",ButtonType.OK);                 //Alerta de JavaFx para mostrar mensaje en la interfaz gráfica
            alert.setHeaderText(null);
            alert.showAndWait();
        }
    }

    @FXML
    void encriptarTexto(ActionEvent event) {

        try{
            if(this.metodoSeleccionado.equalsIgnoreCase("método cesar")){
                try{                                                             //Se accede al objeto singleton Methods para usar el método encriptarCesar, se envía el texto ingresado, la clave y el alfabeto
                    String encriptadoCesar = Methods.getInstance().encriptarCesar(this.txtTextoIngresado.getText().toLowerCase(), Integer.parseInt(this.txtClaveCesar.getText()),this.ALFABETO);
                    this.txtTextoEncriptado.setText(encriptadoCesar);            //Se introduce el texto encriptado en el textArea de la interfaz gráfica
                    this.btnCopiar.setVisible(true);                             //Se habilita el botón de copiar

                }catch(NumberFormatException nfe){
                                                                                     //Alerta de JavaFx para mostrar mensaje en la interfaz gráfica
                    Alert alert = new Alert(Alert.AlertType.ERROR,"Debe digitar una clave válida para el método Cesar",ButtonType.OK);
                    alert.setHeaderText(null);
                    alert.showAndWait();
                }
            }
            if(this.metodoSeleccionado.equalsIgnoreCase("método chino")){

                try{                                                       //Se accede al objeto singleton Methods para usar el método encriptarChino, se envía el texto ingresado unicamente
                    String encriptadoChino = Methods.getInstance().encriptarChino(this.txtTextoIngresado.getText().toLowerCase());
                    this.txtTextoEncriptado.setText(encriptadoChino);      //Se introduce el texto encriptado en el textArea de la interfaz gráfica
                    this.btnCopiar.setVisible(true);                       //se habilita el botón de copiar
                }catch(Exception e){

                    e.printStackTrace();
                }
            }
        }catch (RuntimeException e){                                                //Alerta de JavaFx para mostrar mensaje en la interfaz gráfica
            Alert alert = new Alert(Alert.AlertType.ERROR,"Debe seleccionar un método para encriptar",ButtonType.OK);
            alert.setHeaderText(null);
            alert.showAndWait();
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
        this.btnCopiar.setVisible(false);
    }


}
