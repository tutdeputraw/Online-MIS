package register;

import account.Account;
import login.LoginView;

import javax.swing.*;

public class RegisterController {
    public void register(Account account, JTextField nama_register_textField,
                         JTextField nrp_register_textField,
                         JTextField username_register_textField,
                         JPasswordField password_register_passwordField) {
        if (nama_register_textField.getText().isEmpty()
                || nrp_register_textField.getText().isEmpty()
                || username_register_textField.getText().isEmpty()
                || password_register_passwordField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null,
                                          "Please fill the blank!");
        } else {
            if (account.register(nama_register_textField.getText(),
                    nrp_register_textField.getText(),
                    username_register_textField.getText(),
                    password_register_passwordField.getText())) {
                JOptionPane.showMessageDialog(null,
                                              "Register Success!");
                nama_register_textField.setText("");
                nrp_register_textField.setText("");
                username_register_textField.setText("");
                password_register_passwordField.setText("");
            } else {
                JOptionPane.showMessageDialog(null,
                                              "Register Failed!");
            }
        }
    }
}
