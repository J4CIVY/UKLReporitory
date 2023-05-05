package Cliente;

import javax.swing.*;
import java.sql.*;

public class BDConnection {

    private Connection connection;
    private PreparedStatement prest;
    private DefaultListModel mod = new DefaultListModel();
    private GraphicUserInterface Userinsert = new GraphicUserInterface();

    public BDConnection() {
        try {
            Class.forName("org.sqlite.JDBC");
            this.connection = DriverManager.getConnection("jdbc:sqlite:claseprogramacion1.db");
            System.out.println("Conectado");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void createTable() {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS users (idUser INTEGER PRIMARY KEY, nameUser TEXT, surnameUser TEXT, emailUser TEXT, phoneUser INTEGER, adressUser TEXT, ageUser INTEGER)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void create() {

        try {
            prest = connection.prepareStatement("INSERT INTO users (idUser, nameUser, surnameUser, emailUser, phoneUser, adressUser, ageUser) VALUES (?, ?, ?, ?, ?, ?, ?)");
            prest.setInt(1, Integer.parseInt(Userinsert.getIdUser().getText()));
            prest.setString(2, Userinsert.getNameUser().getText());
            prest.setString(3, Userinsert.getSurnameUser().getText());
            prest.setString(4, Userinsert.getEmailUser().getText());
            prest.setInt(5, Integer.parseInt(Userinsert.getPhoneUser().getText()));
            prest.setString(6, Userinsert.getAdressUser().getText());
            prest.setInt(7, Integer.parseInt(Userinsert.getAgeUser().getText()));
            if (prest.executeUpdate() > 0) {
                Userinsert.getConfirmationSystem().setModel(mod);
                mod.removeAllElements();
                mod.addElement("Su Registro Fue Exitoso");

                Userinsert.getIdUser().setText("");
                Userinsert.getNameUser().setText("");
                Userinsert.getSurnameUser().setText("");
                Userinsert.getEmailUser().setText("");
                Userinsert.getPhoneUser().setText("");
                Userinsert.getAdressUser().setText("");
                Userinsert.getAgeUser().setText("");


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


//    public void readAll() {
//        try {
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
//
//            while (resultSet.next()) {
//                System.out.println(resultSet.getInt("id") + " " + resultSet.getString("name") + " " + resultSet.getInt("age"));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//
//    public void update(int id, String name, int age) {
//        try {
//            prest = connection.prepareStatement("UPDATE users SET name=?, age=? WHERE id=?");
//            prest.setString(1, name);
//            prest.setInt(2, age);
//            prest.setInt(3, id);
//            prest.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void delete(int id) {
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM users WHERE id=?");
//            preparedStatement.setInt(1, id);
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

}
