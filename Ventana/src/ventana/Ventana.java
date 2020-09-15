package ventana;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class Ventana extends JFrame {  
    private final JTextField txtFile; 
    private final JTextArea text;
    private final JButton encryptJButton;
    private final JButton decryptJButton;
    private final JButton saveJButton;
	Ventana(){
    	super("Testing cipher");
        //CREACION DE INTERFAZ
        BorderLayout layout = new BorderLayout(20, 10);
        setLayout(layout);
        JPanel fileJPanel = new JPanel();
    	fileJPanel.setLayout(new FlowLayout());
        JLabel lblFile = new JLabel( "INGRESE TEXTO:" );
        fileJPanel.add(lblFile);
        txtFile = new JTextField(20);
        fileJPanel.add(txtFile);
        add(fileJPanel, BorderLayout.NORTH);
        text = new JTextArea(10,14);
        
    	add(text, BorderLayout.CENTER);
        JPanel buttonJPanel = new JPanel();
        buttonJPanel.setLayout(new BorderLayout());
        encryptJButton = new JButton("ENCRIPTAR");
    	buttonJPanel.add(encryptJButton, BorderLayout.NORTH);
        
    	decryptJButton = new JButton("DESENCRIPTAR"	);
    	buttonJPanel.add(decryptJButton, BorderLayout.CENTER);
        
    	saveJButton = new JButton("GUARDAR");
        buttonJPanel.add(saveJButton, BorderLayout.SOUTH);
        
        add(buttonJPanel, BorderLayout.EAST);  
        
        txtFile.addActionListener(new txtAccion());
        ButtonEncriptar e = new ButtonEncriptar();
        ButtonDes e2 = new ButtonDes();  
        encryptJButton.addActionListener(e);
        decryptJButton.addActionListener(e2);
    }
          
    class txtAccion implements ActionListener{
    	@Override
          public void actionPerformed(ActionEvent event)
          {
          	text.setText(event.getActionCommand());
          }
    }  
    class ButtonEncriptar implements ActionListener{
    	@Override
        public void actionPerformed(ActionEvent e){
            Encriptado en = new Encriptado();
            	String encript = text.getText();
            	String textoEncriptado = en.encriptar(en.chars(txtFile.getText()));
            	text.setText(textoEncriptado);
        }
    }		
    class ButtonDes implements ActionListener{
    	@Override
        public void actionPerformed(ActionEvent e){
            Encriptado e2 = new Encriptado();
            	String encript = text.getText();
            	String textoEncriptado = e2.desencriptar(e2.chars(txtFile.getText()));
            	text.setText(textoEncriptado);
        }
    }
  
   public static void main(String[] args)
   { 
      Ventana ventana = new Ventana(); 
      ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      ventana.setSize(350, 100); 
      ventana.setVisible(true); 
   } 
}