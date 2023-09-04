package co.edu.unquindio.encriptador.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrincipalControllerTest {

    @Test
    void imprimir(){

        String encriptado = encriptarCesar("universidad del quindio", -4);
        System.out.println(encriptado);

    }

    String encriptarCesar(String texto, int clave){

        String alfabeto = "abcdefghijklmnopqrstuvwxyz";
        String textoCesar = "encriptado: ";
        int indiceAux;

        for(int i = 0; i<= texto.length()-1; i++){

            String caracterEncriptado = "";

            for(int j = 0; j<=alfabeto.length()-1; j++){

                if(texto.charAt(i)==' '){
                    caracterEncriptado+=' ';
                    break;

                }else {
                    if(texto.charAt(i)==alfabeto.charAt(j)){

                        if(j + clave>alfabeto.length()-1){

                            indiceAux = 26 - (j + clave);

                        }else{

                            if(j + clave < 0){
                                indiceAux = 26 + (j + clave);

                            }else{

                                indiceAux = j + clave;
                            }
                        }
                        caracterEncriptado+=alfabeto.charAt(indiceAux);
                    }
                }
            }
            textoCesar+=caracterEncriptado;
        }
        return textoCesar;
    }

    void imprimirChino(){
        String message = encriptarChino("universidad bonita", "abcdefghijklmnopqrstuvwxyz");
        System.out.println(message);
    }

    String encriptarChino(String texto, String ALFABETO){

        int rows = texto.length()/3;
        if(texto.length()%3!=0){
            rows = rows + 1;
        }

        return "Mamawebo";

    }

    @Test
    void rows(){
        String texto = "universidad bonitas";
        if(texto.length()%3!=0){
            System.out.println((texto.length()/3)+1);
        }
        System.out.println(texto.length()/3);
    }
  
}