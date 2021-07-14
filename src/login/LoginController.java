package login;

import account.Account;
import javax.swing.*;

public class LoginController {
    Account account;

    public void login(Account account, JTextField username_login_textFeld,
                      JPasswordField password_login_passwordField) {
        this.account=account;

        if (username_login_textFeld.getText().isEmpty()
                && password_login_passwordField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null,
                                          "Fill the blank!");
        } else {
            boolean login = account.login(username_login_textFeld,
                    password_login_passwordField);
            if (login) {
                JOptionPane.showMessageDialog(null,
                                              "login success!");
                username_login_textFeld.setText("");
                password_login_passwordField.setText("");
            } else {
                JOptionPane.showMessageDialog(null,
                                              "login failed!");
                account.setStatus("not logged");
            }
        }
    }

    public String getStatusAccount(){
        return account.getStatus();
    }
}
