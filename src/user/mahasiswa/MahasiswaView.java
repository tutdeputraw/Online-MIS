package user.mahasiswa;

import matakuliah.MataKuliahSemester3;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class MahasiswaView {
    private MahasiswaManager mahasiswaManager;
    private JTable data_mahasiswa_table;

    public void mahasiswa(JFrame frame, JLabel nama_mahasiswa_label,
                          MahasiswaManager mahasiswaManager,
                          JLabel nrp_mahasiswa_label, JPanel mahasiswa_panel) {
        tableMahasiswa();
        nama_mahasiswa_label.setText(mahasiswaManager.getNama());
        nrp_mahasiswa_label.setText(mahasiswaManager.getNrp());
        frame.setContentPane(mahasiswa_panel);
        frame.setVisible(true);
    }

    public void tableMahasiswa() {
        MataKuliahSemester3 mataKuliahSemester3=new MataKuliahSemester3();

        String[][] data =
                new String[
                        mataKuliahSemester3.getMatakuliahsemester3().length][2];
        for (int i = 0;
             i < mataKuliahSemester3.getMatakuliahsemester3().length; i++) {
            for (int j = 0; j < 2; j++) {
                if (j == 0) {
                    data[i][j] =
                            mataKuliahSemester3.getMatakuliahsemester3()[i];
                } else {
                    data[i][j] =
                            mahasiswaManager.lihatNilai(
                                    mahasiswaManager.getNilaiSemester3(),
                                    mataKuliahSemester3.getMatakuliahsemester3()[i]);
                }
            }
        }
        data_mahasiswa_table.setModel(
                new DefaultTableModel(data, new String[] {
                        "Mata Kuliah",
                        "Nilai"
                }
                )
        );
    }

    public void setMahasiswaManager(MahasiswaManager mahasiswaManager) {
        this.mahasiswaManager = mahasiswaManager;
    }

    public void setData_mahasiswa_table(JTable data_mahasiswa_table) {
        this.data_mahasiswa_table = data_mahasiswa_table;
    }
}
