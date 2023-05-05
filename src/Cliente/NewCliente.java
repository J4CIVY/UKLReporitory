package Cliente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewCliente extends JFrame implements ActionListener {

    private JLabel lblNombre;
    private JTextField txtNombre;
    private JButton btnGuardar;
    public NewCliente() {

        setTitle("Formulario De Registro De Nuevo Cliente");
        setSize(400, 400);
        JPanel panel = new JPanel(null);

        lblNombre = new JLabel("Digite Nombre:");
        lblNombre.setBounds(100, 100, 200, 30);
        panel.add(lblNombre);


        txtNombre = new JTextField();
        txtNombre.setBounds(100, 125, 200, 30);
        panel.add(txtNombre);


        btnGuardar = new JButton("GUARDAR");
        btnGuardar.setBounds(100, 160, 200, 30);
        btnGuardar.addActionListener(this);
        panel.add(btnGuardar);

        add(panel);

    }

    public void actionPerformed(ActionEvent e){
        System.out.println(e.getSource() == this.btnGuardar);

        if (e.getSource() == this.btnGuardar){
            JOptionPane.showMessageDialog(null, "Dio click en el boton Guardar", "Guardando", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Mensaje: " + this.txtNombre.getText());
        }

    }

}