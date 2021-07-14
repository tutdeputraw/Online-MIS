package gui;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import account.*;
import login.*;
import register.*;
import user.admin.*;
import user.dosen.*;
import user.mahasiswa.*;

public class MainUI {
    private JPanel login_panel;
    private JPanel register_panel;
    private JPanel mahasiswa_panel;
    private JPanel dosen_panel;
    private JTextField username_login_textFeld;
    private JPasswordField password_login_passwordField;
    private JButton submit_login_Button;
    private JButton register_login_button;
    private JTextField nama_register_textField;
    private JTextField nrp_register_textField;
    private JTextField username_register_textField;
    private JPasswordField password_register_passwordField;
    private JButton submit_register_button;
    private JButton back_register_button;
    private JTable data_mahasiswa_table;
    private JButton logout_mahasiswa_button;
    private JTextField nilaiMahasiswa_dosen_textField;
    private JTable data_dosen_table;
    private JButton logout_dosen_button;
    private JLabel nama_mahasiswa_label;
    private JLabel nrp_mahasiswa_label;
    private JLabel namaDosen_dosen_label;
    private JLabel nipDosen_dosen_label;
    private JLabel matakuliahDosen_dosen_label;
    private JLabel namaMahasiswa_dosen_label;
    private JLabel nrpMahasiswa_dosen_label;
    private JButton insertData_dosen_button;
    private JPanel menu_admin_panel;
    private JButton dosen_admin_Button;
    private JButton mahasiswa_admin_Button;
    private JButton logout_admin_Button;
    private JPanel admin_panel;
    private JPanel dosen_admin_panel;
    private JPanel mahasiswa_admin_panel;
    private JTable data_dosenAdmin_table;
    private JButton back_dosenAdmin_Button;
    private JButton back_mahasiswaAdmin_Button;
    private JTable data_mahasiswaAdmin_table;
    private JPanel detailDosen_admin_panel;
    private JTextField nama_detailDosen_textField;
    private JTextField nip_detailDosen_textField;
    private JComboBox<String> matakuliah_detailDosen_comboBox;
    private JTextField username_detailDosen_textField;
    private JTextField password_detailDosen_textField;
    private JButton saveChanges_detailDosen_Button;
    private JPanel detailMahasiswa_admin_panel;
    private JTextField nama_detailMahasiswa_textField;
    private JTextField nrp_detailMahasiswa_textField;
    private JTextField username_detailMahasiswa_textField;
    private JTextField password_detailMahasiswa_textField;
    private JButton saveChanges_detailMahasiswa_Button;
    private JFrame frame;
    Account account;
    DosenManager dosenManager;
    MahasiswaManager mahasiswaManager;
    LoginController loginController;
    RegisterController registerController;
    RegisterView registerView;
    LoginView loginView;
    DosenView dosenView;
    DataDosenSemester3 dosenSemester3;
    MahasiswaView mahasiswaView;
    AdminView adminView;
    String nipNrpBuffer;

    public MainUI() {
        createInstance();
        frame();
        submit_login_Button.addActionListener(e -> {
            loginController.login(account, username_login_textFeld,
                                  password_login_passwordField);
            switchUser(loginController.getStatusAccount());
        }
        );
        submit_register_button.addActionListener(e -> {
            registerController.register(account, nama_register_textField,
                                        nrp_register_textField,
                                        username_register_textField,
                                        password_register_passwordField);
            loginView.viewLogin(frame, namaMahasiswa_dosen_label,
                                nrpMahasiswa_dosen_label,
                                nilaiMahasiswa_dosen_textField,
                                login_panel);
        });
        register_login_button.addActionListener(e ->
                registerView.viewRegister(frame, register_panel,
                                          username_login_textFeld,
                                          password_login_passwordField));
        back_register_button.addActionListener(e -> {
            nama_register_textField.setText("");
            nrp_register_textField.setText("");
            username_register_textField.setText("");
            password_register_passwordField.setText("");
            loginView.viewLogin(frame, namaMahasiswa_dosen_label,
                                nrpMahasiswa_dosen_label,
                                nilaiMahasiswa_dosen_textField,
                                login_panel);
        });
        logout_mahasiswa_button.addActionListener(e ->
                loginView.viewLogin(frame, namaMahasiswa_dosen_label,
                                    nrpMahasiswa_dosen_label,
                                    nilaiMahasiswa_dosen_textField,
                                    login_panel));
        logout_dosen_button.addActionListener(e ->
                loginView.viewLogin(frame, namaMahasiswa_dosen_label,
                                    nrpMahasiswa_dosen_label,
                                    nilaiMahasiswa_dosen_textField,
                                    login_panel));
        insertData_dosen_button.addActionListener(
                e -> dosenView.insertData(data_dosen_table,
                                          nrpMahasiswa_dosen_label,
                                          namaMahasiswa_dosen_label,
                                          nilaiMahasiswa_dosen_textField));
        data_dosen_table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                dosenView.tableSelected(data_dosen_table,
                                        nrpMahasiswa_dosen_label,
                                        namaMahasiswa_dosen_label,
                                        nilaiMahasiswa_dosen_textField);
            }
        });
        dosen_admin_Button.addActionListener(e -> {
            adminView.tableAdminDosen(account, data_dosenAdmin_table);
            displayContentPane(dosen_admin_panel);
        });
        mahasiswa_admin_Button.addActionListener(e -> {
            adminView.tableAdminMahasiswa(account, data_mahasiswaAdmin_table);
            displayContentPane(mahasiswa_admin_panel);
        });
        logout_admin_Button.addActionListener(e -> {
            loginView.viewLogin(frame, namaMahasiswa_dosen_label,
                    nrpMahasiswa_dosen_label,
                    nilaiMahasiswa_dosen_textField,
                    login_panel);
        });
        back_dosenAdmin_Button.addActionListener(e -> {
            displayContentPane(menu_admin_panel);
        });
        back_mahasiswaAdmin_Button.addActionListener(e -> {
            displayContentPane(menu_admin_panel);
        });
        saveChanges_detailDosen_Button.addActionListener(e -> {
            adminView.confirmUpdateDosen(account, nama_detailDosen_textField,
                                         nip_detailDosen_textField,
                                         matakuliah_detailDosen_comboBox,
                                         username_detailDosen_textField,
                                         password_detailDosen_textField,
                                         data_dosenAdmin_table,
                                         dosen_admin_panel, frame);
        });
        saveChanges_detailMahasiswa_Button.addActionListener(e -> {
            adminView.confirmUpdateMahasiswa(account,
                                             nama_detailMahasiswa_textField,
                                             nrp_detailMahasiswa_textField,
                                             username_detailMahasiswa_textField,
                                             password_detailMahasiswa_textField,
                                             data_mahasiswaAdmin_table, frame,
                                             mahasiswa_admin_panel);
        });
        data_dosenAdmin_table.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                adminView.dosenTableDoubleClick(e,
                                                matakuliah_detailDosen_comboBox,
                                                account,
                                                nama_detailDosen_textField,
                                                nip_detailDosen_textField,
                                                username_detailDosen_textField,
                                                password_detailDosen_textField,
                                                detailDosen_admin_panel, frame);
                nipNrpBuffer = adminView.nipNrpBuffer;
            }
        });
        data_mahasiswaAdmin_table.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                adminView.nilaiTableDoubleClick(e,
                                                nama_detailMahasiswa_textField,
                                                nrp_detailMahasiswa_textField,
                                                username_detailMahasiswa_textField,
                                                password_detailMahasiswa_textField,
                                                frame, detailMahasiswa_admin_panel);
                nipNrpBuffer = adminView.nipNrpBuffer;
            }
        });
    }

    private void createInstance(){
        frame=new JFrame();
        account=new Account();
        loginController=new LoginController();
        registerController=new RegisterController();
        registerView=new RegisterView();
        loginView=new LoginView();
        dosenView=new DosenView();
        dosenSemester3=new DataDosenSemester3();
        mahasiswaView=new MahasiswaView();
        adminView=new AdminView();
    }

    private void switchUser(String user) {
        try {
            switch (user) {
                case "root":
                    adminView.admin(frame, menu_admin_panel);
                    break;
                case "Dosen":
                    dosenManager = account.getDosens().get(account.getIndex());
                    dosenView.dosen(account,data_dosen_table, frame, dosenManager,
                            dosen_panel, namaDosen_dosen_label,
                            nipDosen_dosen_label,
                            matakuliahDosen_dosen_label);
                    break;
                case "Mahasiswa":
                    mahasiswaManager = account.getMahasiswas().get(
                            account.getIndex());
                    mahasiswaView.setMahasiswaManager(mahasiswaManager);
                    mahasiswaView.setData_mahasiswa_table(data_mahasiswa_table);
                    mahasiswaView.mahasiswa(frame, nama_mahasiswa_label,
                            mahasiswaManager, nrp_mahasiswa_label,
                            mahasiswa_panel);
                    break;
                case "not logged":
            }
        }catch (Exception e){

        }
    }

    private void frame() {
        frame = new JFrame("Mis PENS");
        frame.setContentPane(login_panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(600, 400);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void displayContentPane(JPanel panel){
        frame.setContentPane(panel);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new MainUI();
    }
}