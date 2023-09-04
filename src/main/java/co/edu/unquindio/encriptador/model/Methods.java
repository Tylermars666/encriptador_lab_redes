package co.edu.unquindio.encriptador.model;

public class Methods {

    private static Methods methods;

    private Methods(){
    }

    public static Methods getInstance (){                          //Método para retornar el objeto singletón
        if(methods==null){
            methods = new Methods();
        }

        return methods;
    }

    public String encriptarCesar(String texto, int clave, String ALFABETO){

        String textoCesar = "";
        int indiceAux;

        for(int i = 0; i<= texto.length()-1; i++){                       //Se toma cada letra del texto ingresado y se compara
                                                                         //cada una con todas las letras del alfabeto
            String caracterEncriptado = "";

            for(int j = 0; j<=ALFABETO.length()-1; j++){

                if(texto.charAt(i)==' '){                               //Se valida si hay un espacio en blanco dentro del texto
                    caracterEncriptado+=' ';                            //ingresado por el usuario
                    break;

                }else {
                    if(texto.charAt(i)==ALFABETO.charAt(j)){          //Se valida entonces si la letra del texto es igual a la letra del alfabeto
                                                                      //Se tiene en cuenta el índice de la letra del alfabeto
                        if(j + clave>ALFABETO.length()-1){            //Si este indice sumado a la clave es mayor que el tamaño del alfabeto

                            indiceAux = 26 - (j + clave);             //Entonces se procede a calcular el indice correspondiente para esa letra
                                                                      //Es decir que le da la vuelta al alfabeto y vuelve a empezar por las primeras letras
                        }else{

                            if(j + clave < 0){                        //En este caso se valida si el indice de la letra del alfabeto
                                indiceAux = 26 + (j + clave);         //sumado a la clave, es menor que cero, es decir, la clave es negativa
                                                                      //Se calcula el nuevo indice que en este caso dará la vuelta al alfabeto y llegará a las ultimas letras
                            }else{

                                indiceAux = j + clave;                //En caso de que ninguno de los casos anteriores se cumpla, entonces simplemente
                            }                                         //el indice nuevo es el indice de la letra del alfabeto sumado a la clave
                        }
                        caracterEncriptado+=ALFABETO.charAt(indiceAux); //En este String se van concatenando todos los caracteres que se han encriptado mediante la clave
                    }
                }
            }
            textoCesar+=caracterEncriptado;                            //Terminado el ciclo interno, se asigna a la variable textoCesar el String
        }                                                              //almacenado en la variable caracterEncriptado y por último se retorna
        return textoCesar;                                             //ese String que corresponde a la palabra totalmente encriptada
    }

    public String desencriptarCesar(String texto, int clave, String ALFABETO){

        String textoCesar = "";
        int indiceAux;

        return "";

    }
}
