package user.dosen;

import account.Account;
import user.mahasiswa.DataMahasiswaD4ITB2019;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class DosenView {
    DosenManager dosenManager;
    Account account;


    public void dosen(Account account, JTable data_dosen_table, JFrame frame,
                      DosenManager dosenManager, JPanel dosen_panel,
                      JLabel namaDosen_dosen_label, JLabel nipDosen_dosen_label,
                      JLabel matakuliahDosen_dosen_label) {
        this.account=account;
        this.dosenManager=dosenManager;
        tableDosen(data_dosen_table);
        namaDosen_dosen_label.setText(dosenManager.getNama());
        nipDosen_dosen_label.setText(dosenManager.getNip());
        matakuliahDosen_dosen_label.setText(dosenManager.getMataKuliah());
        frame.setContentPane(dosen_panel);
        frame.setVisible(true);
    }

    public void tableDosen(JTable data_dosen_table) {
        DataMahasiswaD4ITB2019 d4InformatikaB19 = new DataMahasiswaD4ITB2019();
        String[][] data =
            new String[d4InformatikaB19.getStudent().length][3];

        for (int i = 0; i < d4InformatikaB19.getStudent().length; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 2) {
                    data[i][j] = dosenManager.lihatNilai(
                    account.getMahasiswas().get(i).getNilaiSemester3(),
                    dosenManager.getMataKuliah());
                } else {
                    data[i][j] = d4InformatikaB19.getStudent()[i][j];
                }
            }
        }
        data_dosen_table.setModel(
            new DefaultTableModel(data, new String[]{"NRP", "Nama",
                                                     "Nilai"})
        );
    }

    public void tableSelected(JTable data_dosen_table,
                              JLabel nrpMahasiswa_dosen_label,
                              JLabel namaMahasiswa_dosen_label,
                              JTextField nilaiMahasiswa_dosen_textField) {
        DefaultTableModel tableModel =
            (DefaultTableModel) data_dosen_table.getModel();
        int i = data_dosen_table.getSelectedRow();

        nrpMahasiswa_dosen_label.setText(
            tableModel.getValueAt(i, 0).toString());
        namaMahasiswa_dosen_label.setText(
            tableModel.getValueAt(i, 1).toString());
        nilaiMahasiswa_dosen_textField.setText(
            tableModel.getValueAt(i, 2).toString());
    }

    public void insertData(JTable data_dosen_table,
                           JLabel nrpMahasiswa_dosen_label,
                           JLabel namaMahasiswa_dosen_label,
                           JTextField nilaiMahasiswa_dosen_textField) {
        DataMahasiswaD4ITB2019 d4InformatikaB19 = new DataMahasiswaD4ITB2019();
        DefaultTableModel tableModel =
                (DefaultTableModel) data_dosen_table.getModel();
        String nrp;
        String nama;
        String nilai;

        if (data_dosen_table.getSelectedRowCount() == 1) {
            nrp = nrpMahasiswa_dosen_label.getText();
            nama = namaMahasiswa_dosen_label.getText();
            nilai = nilaiMahasiswa_dosen_textField.getText();

            tableModel.setValueAt(
                    nrp, data_dosen_table.getSelectedRow(), 0);
            tableModel.setValueAt(
                    nama, data_dosen_table.getSelectedRow(), 1);
            tableModel.setValueAt(
                    nilai, data_dosen_table.getSelectedRow(), 2);
            for (int i = 0; i < d4InformatikaB19.getStudent().length; i++) {
                if (nama.equals(account.getMahasiswas().get(i).getNama())
                    && nrp.equals(
                            account.getMahasiswas().get(i).getNrp())) {
                    dosenManager.insertData(
                            account.getMahasiswas().get(i).getNilaiSemester3(),
                            nilai
                    );
                }
            }
        } else {
            if (data_dosen_table.getSelectedRowCount() == 0){
                JOptionPane.showMessageDialog(null,
                                              "Table is Empty!");
            }
            else{
                JOptionPane.showMessageDialog(null,
                                              "Select single Row!");
            }
        }
    }
}

    