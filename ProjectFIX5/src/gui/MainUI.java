package gui;

import account.Account;
import matakuliah.MataKuliahSemester3;
import user.Dosen;
import user.Mahasiswa;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
    private JPanel dosen_admin_panel;
    private JPanel mahasiswa_admin_panel;
    private JTable data_dosenAdmin_table;
    private JButton back_dosenAdmin_Button;
    private JButton back_mahasiswaAdmin_Button;
    private JTable data_mahasiswaAdmin_table;
    private JPanel detailDosen_admin_panel;
    private JTextField nama_detailDosen_textField;
    private JTextField nip_detailDosen_textField;
    private JComboBox matakuliah_detailDosen_comboBox;
    private JTextField username_detailDosen_textField;
    private JTextField password_detailDosen_textField;
    private JButton saveChanges_detailDosen_Button;
    private JPanel detailMahasiswa_admin_panel;
    private JTextField nama_detailMahasiswa_textField;
    private JTextField nrp_detailMahasiswa_textField;
    private JTextField username_detailMahasiswa_textField;
    private JTextField password_detailMahasiswa_textField;
    private JButton saveChanges_detailMahasiswa_Button;
    private JPanel admin_panel;
    //******************************************
    private JFrame frame = new JFrame();
    Account account = new Account();
    Dosen dosen;
    Mahasiswa mahasiswa;
    MataKuliahSemester3 mataKuliahSemester3 = new MataKuliahSemester3();
    DosenController dosenController = new DosenController();
    MahasiswaController mahasiswaController = new MahasiswaController();
    AdminController adminController = new AdminController();
    String nipNrpBuffer;

    public MainUI() {
        frame();
        submit_login_Button.addActionListener(e -> login());
        submit_register_button.addActionListener(e -> register());
        register_login_button.addActionListener(e -> viewRegister());
        back_register_button.addActionListener(e -> {
            nama_register_textField.setText("");
            nrp_register_textField.setText("");
            username_register_textField.setText("");
            password_register_passwordField.setText("");
            viewLogin();
        });
        logout_mahasiswa_button.addActionListener(e -> viewLogin());
        logout_dosen_button.addActionListener(e -> {
            viewLogin();
        });
        insertData_dosen_button.addActionListener(e -> dosenController.insertData());
        data_dosen_table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                dosenController.tableSelected();
            }
        });
        dosen_admin_Button.addActionListener(e -> {
            adminController.tableAdminDosen();
            frame.setContentPane(dosen_admin_panel);
            frame.setVisible(true);
        });
        mahasiswa_admin_Button.addActionListener(e -> {
            adminController.tableAdminMahasiswa();
            frame.setContentPane(mahasiswa_admin_panel);
            frame.setVisible(true);
        });
        logout_admin_Button.addActionListener(e -> viewLogin());
        back_dosenAdmin_Button.addActionListener(e -> {
            frame.setContentPane(menu_admin_panel);
            frame.setVisible(true);
        });
        back_mahasiswaAdmin_Button.addActionListener(e -> {
            frame.setContentPane(menu_admin_panel);
            frame.setVisible(true);
        });
        saveChanges_detailDosen_Button.addActionListener(e -> {
            int index = 0;
            int a = JOptionPane.showConfirmDialog(null, "Are you sure to save this changes?");
            if (a == JOptionPane.YES_OPTION) {
                for (int i = 0; i < account.getDosens().size(); i++) {
                    if (
                            nipNrpBuffer.equals(account.getDosens().get(i).getNip())
                    ) {
                        index = i;
                        System.out.println(nama_detailDosen_textField.getText());
                        account.
                                getDosens().
                                get(i).
                                setNama(nama_detailDosen_textField.getText());
                        account.
                                getDosens().
                                get(i).
                                setNip(nip_detailDosen_textField.getText());
                        account.
                                getDosens().
                                get(i).
                                setMatakuliah(
                                        String.valueOf(matakuliah_detailDosen_comboBox.getSelectedItem())
                                );
                        account.
                                getDosens().
                                get(i).
                                setUsername(username_detailDosen_textField.getText());
                        account.
                                getDosens().
                                get(i).
                                setPassword(password_detailDosen_textField.getText());
                        adminController.tableAdminDosen();
                        frame.setContentPane(dosen_admin_panel);
                        frame.setVisible(true);
                    }
                }
            } else if (
                    a == JOptionPane.NO_OPTION
            ) {
                adminController.tableAdminDosen();
                frame.setContentPane(dosen_admin_panel);
                frame.setVisible(true);
            }
        });
        saveChanges_detailMahasiswa_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = 0;
                int a = JOptionPane.showConfirmDialog(null, "Are you sure to save this changes?");
                for (int i = 0; i < account.getMahasiswas().size(); i++) {
                    if (
                            nrp_detailMahasiswa_textField.
                                    getText().
                                    equals(account.getMahasiswas().get(i).getNrp()) &&
                                    nama_detailMahasiswa_textField.
                                            getText().
                                            equals(account.getMahasiswas().get(i).getNama())
                    ) {
                        continue;
                    } else if (
                            nrp_detailMahasiswa_textField.
                                    getText().
                                    equals(account.getMahasiswas().get(i).getNrp())
                    ) {
                        JOptionPane.showMessageDialog(
                                null,
                                "Failed!"
                        );
                        return;
                    }
                }
                if (a == JOptionPane.YES_OPTION) {
                    for (int i = 0; i < account.getMahasiswas().size(); i++) {
                        if (nipNrpBuffer.equals(account.getMahasiswas().get(i).getNrp())) {
                            account.
                                    getMahasiswas().
                                    get(i).
                                    setNama(nama_detailMahasiswa_textField.getText());
                            account.
                                    getMahasiswas().
                                    get(i).
                                    setNrp(nrp_detailMahasiswa_textField.getText());
                            account.
                                    getMahasiswas().
                                    get(i).
                                    setUsername(username_detailMahasiswa_textField.getText());
                            account.
                                    getMahasiswas().
                                    get(i).
                                    setPassword(password_detailMahasiswa_textField.getText());
                            adminController.tableAdminMahasiswa();
                            frame.setContentPane(mahasiswa_admin_panel);
                            frame.setVisible(true);
                        }
                    }
                } else if (
                        a == JOptionPane.NO_OPTION
                ) {
                    frame.setContentPane(mahasiswa_admin_panel);
                    frame.setVisible(true);
                }
            }
        });
        data_dosenAdmin_table.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                adminController.dosenTableDoubleClick(e);
            }
        });
        data_mahasiswaAdmin_table.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                adminController.nilaiTableDoubleClick(e);
            }
        });
    }

    private void register() {
        System.out.println(account.getMahasiswas().get(0).getNama()+account.getMahasiswas().get(0).getNrp());
        System.out.println(nama_register_textField.getText()+nrp_register_textField.getText());
        if (
                nama_register_textField.getText().isEmpty() ||
                        nrp_register_textField.getText().isEmpty() ||
                        username_register_textField.getText().isEmpty() ||
                        password_register_passwordField.getText().isEmpty()

        ) {
            JOptionPane.showMessageDialog(
                    null,
                    "Please fill the blank!"
            );
        } else {
            if (
                    account.register(
                            nama_register_textField.getText(),
                            nrp_register_textField.getText(),
                            username_register_textField.getText(),
                            password_register_passwordField.getText()
                    )
            ) {
                JOptionPane.showMessageDialog(
                        null,
                        "Register Success!"
                );
                nama_register_textField.setText("");
                nrp_register_textField.setText("");
                username_register_textField.setText("");
                password_register_passwordField.setText("");
                viewLogin();
            } else {
                JOptionPane.showMessageDialog(
                        null,
                        "Register Failed!"
                );
            }
        }
    }

    private void login() {
        if (
                username_login_textFeld.getText().isEmpty() &&
                        password_login_passwordField.getText().isEmpty()
        ) {
            JOptionPane.showMessageDialog(
                    null,
                    "Fill the blank!"
            );
        } else {
            boolean login = account.login(
                    username_login_textFeld,
                    password_login_passwordField
            );
            if (login) {
                JOptionPane.showMessageDialog(
                        null,
                        "login success!"
                );
                username_login_textFeld.setText("");
                password_login_passwordField.setText("");
                user(account.getStatus());
            } else {
                JOptionPane.showMessageDialog(
                        null,
                        "Login Failed!"
                );
            }
        }
    }

    private void user(String user) {
        switch (user) {
            case "root":
                adminController.admin();
                break;
            case "Dosen":
                dosen = account.getDosens().get(account.getIndex());
                dosenController.dosen();
                break;
            case "Mahasiswa":
                mahasiswa = account.getMahasiswas().get(account.getIndex());
                mahasiswaController.mahasiswa();
                break;
        }
    }

    class DosenController {
        private void dosen() {
            tableDosen();
            namaDosen_dosen_label.setText(dosen.getNama());
            nipDosen_dosen_label.setText(dosen.getNip());
            matakuliahDosen_dosen_label.setText(dosen.getMatakuliah());
            frame.setContentPane(dosen_panel);
            frame.setVisible(true);
        }

        private void tableDosen() {
            String[][] data = new String[account.getMahasiswas().size()][3];
            for (int i = 0; i < account.getMahasiswas().size(); i++) {
                data[i][0] = account.
                        getMahasiswas().
                        get(i).
                        getNrp();
                data[i][1] = account.getMahasiswas().get(i).getNama();
                data[i][2] = dosen.lihatNilai(account.getMahasiswas().get(i).getNilaiSemester3());
            }
            data_dosen_table.setModel(
                    new DefaultTableModel(
                            data,
                            new String[]{
                                    "NRP",
                                    "Nama",
                                    "Nilai"
                            }
                    )
            );
        }

        private void tableSelected() {
            DefaultTableModel tableModel = (DefaultTableModel) data_dosen_table.getModel();
            int i = data_dosen_table.getSelectedRow();
            nrpMahasiswa_dosen_label.setText(tableModel.getValueAt(i, 0).toString());
            namaMahasiswa_dosen_label.setText(tableModel.getValueAt(i, 1).toString());
            nilaiMahasiswa_dosen_textField.setText(tableModel.getValueAt(i, 2).toString());
        }

        private void insertData() {
            DefaultTableModel tableModel = (DefaultTableModel) data_dosen_table.getModel();
            if (data_dosen_table.getSelectedRowCount() == 1) {
                String nrp = nrpMahasiswa_dosen_label.getText();
                String nama = namaMahasiswa_dosen_label.getText();
                String nilai = nilaiMahasiswa_dosen_textField.getText();
                //storing data to selected row
                tableModel.setValueAt(nrp, data_dosen_table.getSelectedRow(), 0);
                tableModel.setValueAt(nama, data_dosen_table.getSelectedRow(), 1);
                tableModel.setValueAt(nilai, data_dosen_table.getSelectedRow(), 2);
                for (int i = 0; i < account.getMahasiswas().size(); i++) {
                    if (
                            nama.equals(account.getMahasiswas().get(i).getNama())
                                    && nrp.equals(account.getMahasiswas().get(i).getNrp())
                    ) {
                        dosen.insertData(
                                account.getMahasiswas().get(i).getNilaiSemester3(),
                                nilai
                        );
                    }
                }
            } else {
                if (data_dosen_table.getSelectedRowCount() == 0)
                    JOptionPane.showMessageDialog(null, "Table is Empty!");
                else
                    JOptionPane.showMessageDialog(null, "Select single Row!");
            }
        }
    }

    class MahasiswaController {
        private void mahasiswa() {
            tableMahasiswa();
            nama_mahasiswa_label.setText(mahasiswa.getNama());
            nrp_mahasiswa_label.setText(mahasiswa.getNrp());
            frame.setContentPane(mahasiswa_panel);
            frame.setVisible(true);
        }

        private void tableMahasiswa() {
            String[][] data = new String[mataKuliahSemester3.getSubjectsThirdSemester().length][2];
            for (int i = 0; i < mataKuliahSemester3.getSubjectsThirdSemester().length; i++) {
                for (int j = 0; j < 2; j++) {
                    if (j == 0) {
                        data[i][j] = mataKuliahSemester3.getSubjectsThirdSemester()[i];
                    } else {
                        data[i][j] = mahasiswa.lihatNilai(mataKuliahSemester3.getSubjectsThirdSemester()[i]);
                    }
                }
            }
            data_mahasiswa_table.setModel(
                    new DefaultTableModel(
                            data,
                            new String[]{
                                    "Mata Kuliah",
                                    "Nilai"
                            }
                    )
            );
        }
    }

    class AdminController {
        private void admin() {
            frame.setContentPane(menu_admin_panel);
            frame.setVisible(true);
        }

        private void tableAdminDosen() {
            String[][] data = new String[account.getDosens().size()][5];
            for (int i = 0; i < account.getDosens().size(); i++) {
                data[i][0] = account.getDosens().get(i).getNama();
                data[i][1] = account.getDosens().get(i).getNip();
                data[i][2] = account.getDosens().get(i).getMatakuliah();
                data[i][3] = account.getDosens().get(i).getUsername();
                data[i][4] = account.getDosens().get(i).getPassword();
            }
            data_dosenAdmin_table.setModel(
                    new DefaultTableModel(
                            data,
                            new String[]{
                                    "Nama",
                                    "NIP",
                                    "Mengajar",
                                    "Username",
                                    "Password"
                            }
                    )
            );
        }

        private void tableAdminMahasiswa() {
            String[][] data = new String[account.getMahasiswas().size()][4];
            for (int i = 0; i < account.getMahasiswas().size(); i++) {
                data[i][0] = account.getMahasiswas().get(i).getNama();
                data[i][1] = account.getMahasiswas().get(i).getNrp();
                data[i][2] = account.getMahasiswas().get(i).getUsername();
                data[i][3] = account.getMahasiswas().get(i).getPassword();
            }
            data_mahasiswaAdmin_table.setModel(
                    new DefaultTableModel(
                            data,
                            new String[]{
                                    "Nama",
                                    "NIP",
                                    "Username",
                                    "Password"
                            }
                    )
            );
        }

        private void dosenTableDoubleClick(MouseEvent e) {
            int idx = 0;
            JTable table = (JTable) e.getSource();
            Point point = e.getPoint();
            int row = table.rowAtPoint(point);
            if (e.getClickCount() == 2 && table.getSelectedRow() != -1) {
                String[] dataComboBox = new String[mataKuliahSemester3.getSubjectsThirdSemester().length];
                for (int i = 0; i < mataKuliahSemester3.getSubjectsThirdSemester().length; i++) {
                    dataComboBox[i] = mataKuliahSemester3.getSubjectsThirdSemester()[i];
                }
                matakuliah_detailDosen_comboBox.setModel(
                        new DefaultComboBoxModel(
                                dataComboBox
                        )
                );
                for (int i = 0; i < account.getDosens().size(); i++) {
                    if (
                            table.getValueAt(row, 1).equals(account.getDosens().get(i).getNip())
                    ) {
                        idx = i;
                        break;
                    }
                }
                
                matakuliah_detailDosen_comboBox.
                        setSelectedItem(account.getDosens().get(idx).getMatakuliah());
                nipNrpBuffer = account.getDosens().get(idx).getNip();
                nama_detailDosen_textField.setText(account.getDosens().get(idx).getNama());
                nip_detailDosen_textField.setText(account.getDosens().get(idx).getNip());
                username_detailDosen_textField.setText(account.getDosens().get(idx).getUsername());
                password_detailDosen_textField.setText(account.getDosens().get(idx).getPassword());
                frame.setContentPane(detailDosen_admin_panel);
                frame.setVisible(true);
            }
        }

        public void nilaiTableDoubleClick(MouseEvent e) {
//            int idx = 0;
            JTable table = (JTable) e.getSource();
            Point point = e.getPoint();
            int row = table.rowAtPoint(point);
            if (e.getClickCount() == 2 && table.getSelectedRow() != -1) {
//                for (int i = 0; i < account.getMahasiswas().size(); i++) {
//                    if (table.getValueAt(row, 1).equals(account.getMahasiswas().get(i).getNrp())) {
//                        idx = i;
//                        break;
//                    }
//                }
                nipNrpBuffer = table.getValueAt(row, 1).toString();
                nama_detailMahasiswa_textField.setText(table.getValueAt(row, 0).toString());
                nrp_detailMahasiswa_textField.setText(table.getValueAt(row, 1).toString());
                username_detailMahasiswa_textField.setText(table.getValueAt(row, 2).toString());
                password_detailMahasiswa_textField.setText(table.getValueAt(row, 3).toString());
                frame.setContentPane(detailMahasiswa_admin_panel);
                frame.setVisible(true);
            }
        }
    }

    private void frame() {
        frame = new JFrame("REKAP NILAI BAGUS PUNYA");
        frame.setContentPane(login_panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(600, 400);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void viewRegister() {
        username_login_textFeld.setText("");
        password_login_passwordField.setText("");
        frame.setContentPane(register_panel);
        frame.setVisible(true);
    }

    private void viewLogin() {
        namaMahasiswa_dosen_label.setText("");
        nrpMahasiswa_dosen_label.setText("");
        nilaiMahasiswa_dosen_textField.setText("");
        frame.setContentPane(login_panel);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new MainUI();
    }
}