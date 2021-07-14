package CapaPresentacio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import CapaPersistencia.AccesFactory;

public class PrincipalMain extends JFrame  implements ActionListener {
	
	JButton LoginFrame = new JButton("LoginFrame");
    JButton SignInFrame = new JButton("SignInFrame");
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new PrincipalMain().setVisible(true);
            }
        });
    }
    
    private PrincipalMain() {
    	this.setTitle("Choose an option:");
        this.setVisible(true);
        this.getContentPane().setLayout(null);
        LoginFrame.setBounds(125, 200, 100, 30);
        getContentPane().add(LoginFrame);
        LoginFrame.setBounds(125, 400, 100, 30);
        getContentPane().add(SignInFrame);
        LoginFrame.addActionListener(this);
        SignInFrame.addActionListener(this);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(10,10,370,600);
        this.setResizable(false);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
    	AccesFactory.getInstancia().getAccess(e.getSource().toString()).actionPerformed(e);
    	this.dispose();
    	
    	/*//M'ha faltat implementar aquesta part i no m'ha donat temps
        //Coding Part of LOGIN button
        
        	
            frame.setTitle(e.getActionCommand());
            frame.setVisible(true);
            frame.setBounds(10,10,370,600);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(false);
            // tancar finestre actual
            this.dispose();*/
    }
}




