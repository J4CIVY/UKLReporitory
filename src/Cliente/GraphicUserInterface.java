package Cliente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GraphicUserInterface extends JFrame {

    public JPanel PanelRegistro;
    public JTextField idUser;
    public JTextField nameUser;
    public JTextField surnameUser;
    public JTextField emailUser;
    public JTextField phoneUser;
    public JTextField adressUser;
    public JTextField ageUser;
    private JButton btnRegister;
    public JList confirmationSystem;

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

//    public void getidUser (){
//        this.idUser = ;
//    }

    public static void main(String[] args) {
        GraphicUserInterface FormRegister = new GraphicUserInterface();
        FormRegister.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FormRegister.setContentPane(new GraphicUserInterface().PanelRegistro);
        FormRegister.pack();
        FormRegister.setVisible(true);

    }
}
