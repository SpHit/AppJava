package sample;

import conexion.conexionClase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Controller {

    private Integer idpost;

    @FXML
    private Button cerrar;

    @FXML
    private Label post;

    @FXML
    void conectar(ActionEvent event) {
        conexionClase con = new conexionClase();
        Connection conexion = con.getConnection();

        try{
            Statement st = conexion.createStatement();
            ResultSet rs;
            rs = st.executeQuery("SELECT p.PostId, p.Texto FROM Post AS p WHERE p.Moderado = 0 ORDER BY RAND() LIMIT 1");

            rs.next();
            String texto = rs.getString("Texto");
            idpost = rs.getInt("PostId");
            System.out.println(idpost);

            post.setText(texto);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void moderar(ActionEvent event) {
        conexionClase con = new conexionClase();
        Connection conexion = con.getConnection();
        try{
            Statement st = conexion.createStatement();
            st.executeUpdate("UPDATE Post SET Moderado=1 WHERE PostId = " + idpost);
            Stage stage = (Stage) cerrar.getScene().getWindow();
            stage.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
