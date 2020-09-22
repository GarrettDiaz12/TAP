package interfaceview;
import java.awt.event.*;
import javax.swing.*;
class Controlador implements ActionListener {
    private Modelo modelo;
    private Vista vista;
    private Encriptado encriptado = new Encriptado();
    public Controlador(Modelo m, Vista v) {
        modelo = m;
        vista = v;
        vista.setController(this);
    }
    @Override
    public void actionPerformed(ActionEvent event) {
        System.out.println(event.getActionCommand());
        switch (event.getActionCommand()) {
            case VistaInterface.ABRIR:
                System.out.println("abrir");
                modelo.setFile(vista.getFileName());
                vista.setText(modelo.read());
                break;
            case VistaInterface.ENCRYPT:
                modelo.encript();
                break;
            case VistaInterface.DECRYPT:
                modelo.decript();
                break;
            case VistaInterface.GUARDAR:
                System.out.println("guardar");
                modelo.setFileName(vista.getFileName());
                modelo.setContenido(vista.getText());
                modelo.write();
                break;
            default:
                System.err.println("INGRESE OPCION VALIDA");
                break;
        }
    }

    public void run() {
        vista.setLocationRelativeTo(null);
        vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vista.setSize(500, 230);
        vista.setVisible(true);
    }
}