package user.admin;

import account.Account;
import matakuliah.MataKuliahSemester3;
import user.dosen.DataDosenSemester3;
import user.mahasiswa.DataMahasiswaD4ITB2019;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseEvent;

public class AdminView {
    public String nipNrpBuffer;

    public void admin(JFrame frame, JPanel menu_admin_panel) {
        frame.setContentPane(menu_admin_panel);
        frame.setVisible(true);
    }

    public void tableAdminDosen(Account account, JTable data_dosenAdmin_table) {
        DataDosenSemester3 dosenSemester3 = new DataDosenSemester3();
        String[][] data = new String[dosenSemester3.getDosen().length][5];
        for (int i = 0; i < account.getDosens().size(); i++) {
            data[i][0] = account.getDosens().get(i).getNama();
            data[i][1] = account.getDosens().get(i).getNip();
            data[i][2] = account.getDosens().get(i).getMataKuliah();
            data[i][3] = account.getDosens().get(i).getUsername();
            data[i][4] = account.getDosens().get(i).getPassword();
        }
        data_dosenAdmin_table.setModel(new DefaultTableModel(
                data,
                new String[]{
                        "Nama",
                        "NIP",
                        "Mengajar",
                        "Username",
                        "Password"
                })
        );
    }

    public void tableAdminMahasiswa(Account account,
                                    JTable data_mahasiswaAdmin_table) {
        DataMahasiswaD4ITB2019 d4InformatikaB19 = new DataMahasiswaD4ITB2019();

        String[][] data = new String[d4InformatikaB19.getStudent().length][4];

        for (int i = 0; i < d4InformatikaB19.getStudent().length; i++) {
            data[i][0] = account.getMahasiswas().get(i).getNama();
            data[i][1] = account.getMahasiswas().get(i).getNrp();
            data[i][2] = account.getMahasiswas().get(i).getUsername();
            data[i][3] = account.getMahasiswas().get(i).getPassword();
        }
        data_mahasiswaAdmin_table.setModel(new DefaultTableModel(
                data,
                new String[]{
                        "Nama",
                        "NIP",
                        "Username",
                        "Password"
                })
        );
    }

    public void dosenTableDoubleClick(MouseEvent e,
                                      JComboBox matakuliah_detailDosen_comboBox,
                                      Account account,
                                      JTextField nama_detailDosen_textField,
                                      JTextField nip_detailDosen_textField,
                                      JTextField username_detailDosen_textField,
                                      JTextField password_detailDosen_textField,
                                      JPanel detailDosen_admin_panel,
                                      JFrame frame) {
        int idx = 0;
        JTable table = (JTable) e.getSource();
        Point point = e.getPoint();
        int row = table.rowAtPoint(point);
        String[] dataComboBox;
        MataKuliahSemester3 mataKuliahSemester3 = new MataKuliahSemester3();
        DataDosenSemester3 dosenSemester3 = new DataDosenSemester3();

        if (e.getClickCount() == 2 && table.getSelectedRow() != -1) {
            dataComboBox =
                    new String[
                            mataKuliahSemester3.getMatakuliahsemester3().length];
            System.arraycopy(
                    mataKuliahSemester3.getMatakuliahsemester3(),
                    0, dataComboBox, 0,
                    mataKuliahSemester3.getMatakuliahsemester3().length);
            matakuliah_detailDosen_comboBox.setModel(
                    new DefaultComboBoxModel<>(dataComboBox));
            for (int i = 0; i < dosenSemester3.getDosen().length; i++) {
                if (table.getValueAt(
                        row, 1).equals(
                        account.getDosens().get(i).getNip())) {
                    idx = i;
                    break;
                }
            }

            matakuliah_detailDosen_comboBox.setSelectedItem(
                    account.getDosens().get(idx).getMataKuliah());
            nipNrpBuffer = account.getDosens().get(idx).getNip();
            this.nipNrpBuffer=nipNrpBuffer;
            nama_detailDosen_textField.setText(
                    account.getDosens().get(idx).getNama());
            nip_detailDosen_textField.setText(
                    account.getDosens().get(idx).getNip());
            username_detailDosen_textField.setText(
                    account.getDosens().get(idx).getUsername());
            password_detailDosen_textField.setText(
                    account.getDosens().get(idx).getPassword());
            frame.setContentPane(detailDosen_admin_panel);
            frame.setVisible(true);
        }
    }

    public void nilaiTableDoubleClick(MouseEvent e,
                                      JTextField nama_detailMahasiswa_textField,
                                      JTextField nrp_detailMahasiswa_textField,
                                      JTextField username_detailMahasiswa_textField,
                                      JTextField password_detailMahasiswa_textField,
                                      JFrame frame, JPanel detailMahasiswa_admin_panel) {
        JTable table = (JTable) e.getSource();
        Point point = e.getPoint();
        int row = table.rowAtPoint(point);

        if (e.getClickCount() == 2 && table.getSelectedRow() != -1) {
            nipNrpBuffer = table.getValueAt(row, 1).toString();
            this.nipNrpBuffer=nipNrpBuffer;
            nama_detailMahasiswa_textField.setText(
                    table.getValueAt(row, 0).toString());
            nrp_detailMahasiswa_textField.setText(
                    table.getValueAt(row, 1).toString());
            username_detailMahasiswa_textField.setText(
                    table.getValueAt(row, 2).toString());
            password_detailMahasiswa_textField.setText(
                    table.getValueAt(row, 3).toString());
            frame.setContentPane(detailMahasiswa_admin_panel);
            frame.setVisible(true);
        }
    }

    public void confirmUpdateDosen(Account account,
                                   JTextField nama_detailDosen_textField,
                                   JTextField nip_detailDosen_textField,
                                   JComboBox matakuliah_detailDosen_comboBox,
                                   JTextField username_detailDosen_textField,
                                   JTextField password_detailDosen_textField,
                                   JTable data_dosenAdmin_table,
                                   JPanel dosen_admin_panel, JFrame frame){
        DataDosenSemester3 dosenSemester3 = new DataDosenSemester3();
        int a = JOptionPane.showConfirmDialog(
                null,
                "Are you sure to save this changes?");

        if (a == JOptionPane.YES_OPTION) {
            for (int i = 0; i < dosenSemester3.getDosen().length; i++) {
                if (nipNrpBuffer.equals(
                        account.getDosens().get(i).getNip())) {
                    System.out.println(
                            nama_detailDosen_textField.getText());
                    account.getDosens().get(i).setNama(
                            nama_detailDosen_textField.getText());
                    account.getDosens().get(i).setNip(
                            nip_detailDosen_textField.getText());
                    account.getDosens().get(i).setMataKuliah(
                            String.valueOf(
                                    matakuliah_detailDosen_comboBox.getSelectedItem()));
                    account.getDosens().get(i).setUsername(
                            username_detailDosen_textField.getText());
                    account.getDosens().get(i).setPassword(
                            password_detailDosen_textField.getText());
                    tableAdminDosen(account, data_dosenAdmin_table);
                    frame.setContentPane(dosen_admin_panel);
                    frame.setVisible(true);
                }
            }
        } else if (a == JOptionPane.NO_OPTION) {
            tableAdminDosen(account, data_dosenAdmin_table);
            frame.setContentPane(dosen_admin_panel);
            frame.setVisible(true);
        }
    }

    public void confirmUpdateMahasiswa(Account account,
                                       JTextField nama_detailMahasiswa_textField,
                                       JTextField nrp_detailMahasiswa_textField,
                                       JTextField username_detailMahasiswa_textField,
                                       JTextField password_detailMahasiswa_textField,
                                       JTable data_mahasiswaAdmin_table,
                                       JFrame frame,
                                       JPanel mahasiswa_admin_panel){

        int a = JOptionPane.showConfirmDialog(null,
                "Are you sure to save this changes?");
        if (a == JOptionPane.YES_OPTION) {
            for (int i = 0; i < account.getMahasiswas().size(); i++) {
                if (nipNrpBuffer.equals(
                        account.getMahasiswas().get(i).getNrp())) {
                    account.getMahasiswas().get(i).setNama(
                            nama_detailMahasiswa_textField.getText());
                    account.getMahasiswas().get(i).setNrp(
                            nrp_detailMahasiswa_textField.getText());
                    account.getMahasiswas().get(i).setUsername(
                            username_detailMahasiswa_textField.getText());
                    account.getMahasiswas().get(i).setPassword(
                            password_detailMahasiswa_textField.getText());
                    tableAdminMahasiswa(account, data_mahasiswaAdmin_table);
                    frame.setContentPane(mahasiswa_admin_panel);
                    frame.setVisible(true);
                }
            }
        } else if (a == JOptionPane.NO_OPTION) {
            frame.setContentPane(mahasiswa_admin_panel);
            frame.setVisible(true);
        }
    }
}
