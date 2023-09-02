module co.edu.unquindio.encriptador {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.unquindio.encriptador to javafx.fxml;
    exports co.edu.unquindio.encriptador;
    exports co.edu.unquindio.encriptador.controller;
    opens co.edu.unquindio.encriptador.controller to javafx.fxml;
}