package project2;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane; // Importăm clasa JOptionPane pentru a afișa caseta de dialog
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPage implements ActionListener {

    JFrame frame = new JFrame();
    JButton loginButton = new JButton("Login");
    JButton registerButton = new JButton("Register");
    JButton resetButton = new JButton("Reset");
    JTextField userIdField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JLabel userIdLabel = new JLabel("UserId:");
    JLabel userPasswordLabel = new JLabel("Password:");
    JLabel messageLabel = new JLabel("");
    JLabel tries = new JLabel("");
    JComboBox<String> gameModeDropdown = new JComboBox<>(new String[]{"Single Player", "Multiplayer"});
    
    HashMap<String, String> loginInfo = new HashMap<>();

    public LoginPage(HashMap<String, String> LoginParams) {
        this.loginInfo = LoginParams;
       
        messageLabel.setBounds(125, 350, 250, 35);
        messageLabel.setFont(new Font(null, Font.ITALIC, 10));
        tries.setBounds(125, 350, 250, 35);
        tries.setFont(new Font(null, Font.ITALIC, 10));
        
        userIdField.setBounds(125, 100, 200, 25);
        passwordField.setBounds(125, 150, 200, 25);
        userIdLabel.setBounds(50, 100, 75, 25);
        userPasswordLabel.setBounds(50, 150, 75, 25);

        loginButton.setBounds(125, 200, 100, 25);
        loginButton.addActionListener(this);
        loginButton.setFocusable(false);
        resetButton.setFocusable(false);
        resetButton.setBounds(225, 200, 100, 25);
        resetButton.addActionListener(this);
        resetButton.setFocusable(false);

        registerButton.setBounds(125, 250, 100, 25);
        registerButton.addActionListener(this);
        registerButton.setVisible(true);

        gameModeDropdown.setBounds(125, 300, 200, 25);

        frame.add(userIdLabel);
        frame.add(userPasswordLabel);
        frame.add(messageLabel);
        frame.add(userIdField);
        frame.add(passwordField);
        frame.add(loginButton);
        frame.add(resetButton);
        frame.add(registerButton);
        frame.add(gameModeDropdown);
        frame.add(tries);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ErrorConstants instance = ErrorConstants.getInstance();
        String selectedGameMode = (String) gameModeDropdown.getSelectedItem();

        if (e.getSource() == resetButton) {
            userIdField.setText("");
            passwordField.setText("");
        } else if (e.getSource() == loginButton) {
            String user = this.userIdField.getText();
            String password = String.valueOf(passwordField.getPassword());

            if (loginInfo.containsKey(user)) {
                if (loginInfo.get(user).equals(password)) {
                    messageLabel.setForeground(Color.green);
                    messageLabel.setText(instance.LOGIN_SUCCESS);
                    frame.dispose();
                    if (selectedGameMode.equals("Single Player")) {
                        FirstPage firstPage = new FirstPage(user, selectedGameMode);
                    } else if (selectedGameMode.equals("Multiplayer")) {
                        String user2 = JOptionPane.showInputDialog("Introduceți al doilea utilizator:");
                        if (user2 != null && !user2.isEmpty()) {
                            FirstPage firstPage = new FirstPage(user, user2, selectedGameMode);
                        } else {
                            messageLabel.setForeground(Color.red);
                            messageLabel.setText("Al doilea utilizator este necesar pentru modul Multiplayer.");
                        }
                    }
                } else {
                    messageLabel.setForeground(Color.red);
                    messageLabel.setText(instance.ERROR_WRONG_PASSWORD);
                }
            } else {
                messageLabel.setForeground(Color.red);
                messageLabel.setText(instance.ERROR_INVALID_EMAIL);
            }
        } else if (e.getSource() == registerButton) {
            String user = this.userIdField.getText();
            String password = String.valueOf(passwordField.getPassword());

            if (loginInfo.containsKey(user)) {
                messageLabel.setText(instance.ERROR_INVALID_EMAIL);
            } else {
                if (password.length() > 5 && user.contains("@")) {
                    messageLabel.setText(instance.REGISTER_SUCCESS);
                    loginInfo.put(user, password);
                } else if (password.length() <= 5) {
                    messageLabel.setText(instance.ERROR_SHORT_PASSWORD);
                } else if (!user.contains("@")) {
                    messageLabel.setText(instance.ERROR_INVALID_EMAIL);
                }
            }
        }
    }
}
