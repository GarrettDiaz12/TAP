package interfaceview;
import java.awt.event.*;
import javax.swing.*;
class Controlador implements ActionListener{
    private Modelo modelo;
    private Vista vista;
    
    public Controlador(Modelo m,Vista v){
        modelo = m;
        vista = v;
        vista.setController(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent event){
        switch(event.getActionCommand()){
            case VistaInterface.ABRIR:
                modelo.setFile(vista.getFileName());
                vista.setText(modelo.read());
                break;
            case VistaInterface.ENCRYPT:
                modelo.setContenido(vista.getText());
                vista.setText(modelo.encript());
                break;
            case VistaInterface.DECRYPT:
                modelo.setContenido(vista.getText());
                vista.setText(modelo.decript());
                break;
            case VistaInterface.GUARDAR:
                modelo.setFileName(vista.getFileName());
                modelo.setContenido(vista.getText());
                modelo.write();
                break;
            default:
                System.err.println("INGRESE OPCION VALIDA");
                break;
        }
    }
    public void run(){
        vista.setLocationRelativeTo(null);
        vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vista.setSize(500,230);
        vista.setVisible(true);
    }
}