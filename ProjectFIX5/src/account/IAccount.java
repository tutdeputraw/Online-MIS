package account;

import javax.swing.*;

public interface IAccount {
    boolean register(
            String nama,
            String nrp,
            String username,
            String password
    );

    boolean login(
            JTextField username,
            JPasswordField password
    );
}

