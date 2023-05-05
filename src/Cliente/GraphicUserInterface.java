package Cliente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GraphicUserInterface extends JFrame {

    private JPanel PanelRegistro;
    private JTextField idUser;
    public JTextField nameUser;
    public JTextField surnameUser;
    public JTextField emailUser;
    public JTextField phoneUser;
    public JTextField adressUser;
    public JTextField ageUser;
    private JButton btnRegister;
    private JList confirmationSystem;

    public GraphicUserInterface() {
        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BDConnection conexion = new BDConnection();
                conexion.createTable();
                conexion.create();
            }
        });
    }

    public void setIdUser(JTextField idUser) {
        this.idUser = idUser;
    }

    public void setNameUser(JTextField nameUser) {
        this.nameUser = nameUser;
    }

    public void setSurnameUser(JTextField surnameUser) {
        this.surnameUser = surnameUser;
    }

    public void setEmailUser(JTextField emailUser) {
        this.emailUser = emailUser;
    }

    public void setPhoneUser(JTextField phoneUser) {
        this.phoneUser = phoneUser;
    }

    public void setAdressUser(JTextField adressUser) {
        this.adressUser = adressUser;
    }

    public void setAgeUser(JTextField ageUser) {
        this.ageUser = ageUser;
    }

    public JTextField getIdUser() {
        return idUser;
    }

    public JTextField getNameUser() {
        return nameUser;
    }

    public JTextField getSurnameUser() {
        return surnameUser;
    }

    public JTextField getEmailUser() {
        return emailUser;
    }

    public JTextField getPhoneUser() {
        return phoneUser;
    }

    public JTextField getAdressUser() {
        return adressUser;
    }

    public JTextField getAgeUser() {
        return ageUser;
    }

    public JButton getBtnRegister() {
        return btnRegister;
    }

    public JList getConfirmationSystem() {
        return confirmationSystem;
    }

    public void registerNewUser() {
        GraphicUserInterface FormRegister = new GraphicUserInterface();
        FormRegister.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FormRegister.setContentPane(new GraphicUserInterface().PanelRegistro);
        FormRegister.pack();
        FormRegister.setVisible(true);

    }
}
