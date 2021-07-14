package register;

import javax.swing.*;

public class RegisterView {
    public void viewRegister(JFrame frame, JPanel register_panel,
                             JTextField username_login_textFeld,
                             JPasswordField password_login_passwordField) {
        username_login_textFeld.setText("");
        password_login_passwordField.setText("");
        frame.setContentPane(register_panel);
        frame.setVisible(true);
    }
}
