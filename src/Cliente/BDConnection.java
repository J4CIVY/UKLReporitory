package Cliente;

import javax.swing.*;
import java.sql.*;

public class BDConnection {

    private Connection connection;
    private PreparedStatement prest;
    DefaultListModel mod = new DefaultListModel();

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
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS users (idUser TEXT PRIMARY KEY, nameUser TEXT, surnameUser TEXT, emailUser TEXT, phoneUser TEXT, adressUser TEXT, ageUser INTEGER)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void create() {
        GraphicUserInterface Userinsert = new GraphicUserInterface();
        try {
            prest = connection.prepareStatement("INSERT INTO users(idUser, nameUser, surnameUser, emailUser, phoneUser, adressUser, ageUser) VALUES (?, ?, ?, ?, ?, ?, ?)");
            prest.setString(1, Userinsert.idUser.getText());
            prest.setString(2, Userinsert.nameUser.getText());
            prest.setString(3, Userinsert.surnameUser.getText());
            prest.setString(4, Userinsert.emailUser.getText());
            prest.setString(5, Userinsert.phoneUser.getText());
            prest.setString(6, Userinsert.adressUser.getText());
            prest.setInt(7, Integer.parseInt(Userinsert.ageUser.getText()));
            if (prest.executeUpdate() > 0) {
                Userinsert.confirmationSystem.setModel(mod);
                mod.removeAllElements();
                mod.addElement("Su Registro Fue Exitoso");

                Userinsert.idUser.setText("");
                Userinsert.nameUser.setText("");
                Userinsert.surnameUser.setText("");
                Userinsert.emailUser.setText("");
                Userinsert.phoneUser.setText("");
                Userinsert.adressUser.setText("");
                Userinsert.ageUser.setText("");


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void readAll() {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");

            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id") + " " + resultSet.getString("name") + " " + resultSet.getInt("age"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void update(int id, String name, int age) {
        try {
            prest = connection.prepareStatement("UPDATE users SET name=?, age=? WHERE id=?");
            prest.setString(1, name);
            prest.setInt(2, age);
            prest.setInt(3, id);
            prest.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM users WHERE id=?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
