package login;

import javax.swing.*;

public class LoginView {
    public void viewLogin(JFrame frame, JLabel namaMahasiswa_dosen_label,
                          JLabel nrpMahasiswa_dosen_label,
                          JTextField nilaiMahasiswa_dosen_textField,
                          JPanel login_panel) {
        namaMahasiswa_dosen_label.setText("");
        nrpMahasiswa_dosen_label.setText("");
        nilaiMahasiswa_dosen_textField.setText("");
        frame.setContentPane(login_panel);
        frame.setVisible(true);
    }
}
