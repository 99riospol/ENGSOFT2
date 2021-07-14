package CapaPresentacio;
import javax.swing.*;

import CapaPersistencia.FitxerUsuaris;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Creating LoginFrame class
public class SignInFrame extends JFrame implements ActionListener, IType  {
	
	
	
    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JPasswordField repeatPasswordField = new JPasswordField();
    JButton signInButton = new JButton("SIGN IN");
    JButton resetButton = new JButton("RESET");
    JCheckBox showPassword = new JCheckBox("Show Password");
    JCheckBox acceptCondition = new JCheckBox("Agree to donate a kidney!");
 
 
    public SignInFrame() {
        initComponents();
 
    }
 
    private void initComponents() {
    	Container container = getContentPane();
        JLabel userLabel = new JLabel("USERNAME");
        JLabel passwordLabel = new JLabel("NEW PASSWORD");
        JLabel repeatPasswordLabel = new JLabel("REPEAT PASSWORD");
        
    	container.setLayout(null);

        userLabel.setBounds(20, 150, 100, 30);
        passwordLabel.setBounds(20, 220, 100, 30);
        repeatPasswordLabel.setBounds(20, 290, 150, 30);
        userTextField.setBounds(150, 150, 150, 30);
        passwordField.setBounds(150, 220, 150, 30);
        repeatPasswordField.setBounds(150, 290, 150, 30);
        showPassword.setBounds(50, 320, 250, 30);
        acceptCondition.setBounds(50, 350, 250, 30);
        signInButton.setBounds(50, 400, 100, 30);
        resetButton.setBounds(200, 400, 100, 30);

    	container.add(userLabel);
    	container.add(userTextField);
    	container.add(passwordLabel);
    	container.add(passwordField);
    	container.add(repeatPasswordLabel);
    	container.add(repeatPasswordField);
        
    	container.add(showPassword);
    	container.add(acceptCondition);
        
    	container.add(signInButton);
    	container.add(resetButton);
        
    	signInButton.addActionListener(this);
        resetButton.addActionListener(this);
        showPassword.addActionListener(this);
    }
 
 
    @Override
    public void actionPerformed(ActionEvent e) {
        //Coding Part of LOGIN button
        if (e.getSource() == signInButton) {
            String userText  = userTextField.getText();
            String pwdText = new String(passwordField.getPassword());;
            String repeatPwdText = new String(repeatPasswordField.getPassword());
            FitxerUsuaris file = new FitxerUsuaris();
            
            if ( !acceptCondition.isSelected())
            {
				JOptionPane.showMessageDialog(this, "You must agree to the terms");
			} 
            else if ( userText.isEmpty() || pwdText.isEmpty() || repeatPwdText.isEmpty())
            {
				JOptionPane.showMessageDialog(this, "You must fill in all fields");
			} 
            else if( file.checkSignIn(userText) 
					&& pwdText.equals(repeatPwdText)
					&& acceptCondition.isSelected()
					&& file.addUser(userText, pwdText))
            {
			    JOptionPane.showMessageDialog(this, "Sign in Successful");
			}
            else
            {
			    JOptionPane.showMessageDialog(this, "Invalid Username or Password");
			}
        }
        //Coding Part of RESET button
        if (e.getSource() == resetButton) {
            userTextField.setText("");
            passwordField.setText("");
        }
       //Coding Part of showPassword JCheckBox
        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0);
                repeatPasswordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
                repeatPasswordField.setEchoChar('*');
            }
 
 
        }
    }
 
}