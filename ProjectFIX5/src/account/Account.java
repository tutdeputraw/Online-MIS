package account;

import lecturer.DataDosenSemester3;
import student.DataMahasiswaD4ITB2019;
import user.Dosen;
import user.Mahasiswa;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Account implements IAccount {
    private final String adminUsername = "root";
    private final String adminPassword = "root";
    private List<Mahasiswa> mahasiswas = new ArrayList<>();
    private List<Dosen> dosens = new ArrayList<>();
    private DataMahasiswaD4ITB2019 dataMahasiswaD4ITB2019 = new DataMahasiswaD4ITB2019();
    private DataDosenSemester3 dataDosenSemester3 = new DataDosenSemester3();
    private String status;
    private int index;

    public Account() {
        for (int i = 0; i < dataMahasiswaD4ITB2019.getStudent().length; i++) {
            mahasiswas.add(
                    new Mahasiswa(
                            dataMahasiswaD4ITB2019.getStudent()[i][1],
                            "Mahasiswa",
                            dataMahasiswaD4ITB2019.getStudent()[i][0],
                            "",
                            ""
                    )
            );
        }
        for (int i = 0; i < dataDosenSemester3.getDosen().length; i++) {
            dosens.add(
                    new Dosen(
                            dataDosenSemester3.getDosen()[i][0],
                            "Dosen",
                            dataDosenSemester3.getDosen()[i][1],
                            dataDosenSemester3.getDosen()[i][2],
                            dataDosenSemester3.getDosen()[i][3],
                            dataDosenSemester3.getDosen()[i][4]
                    )
            );
        }
        mahasiswas.get(18).setUsername("ceci");
        mahasiswas.get(18).setPassword("ceci");
    }

    @Override
    public boolean register(
            String nama,
            String nrp,
            String username,
            String password
    ) {
        for (int i = 0; i < mahasiswas.size(); i++) {
            if (
                    nama.equals(mahasiswas.get(i).getNama()) &&
                            nrp.equals(mahasiswas.get(i).getNrp()) &&
                            mahasiswas.get(i).getUsername().isEmpty() &&
                            mahasiswas.get(i).getPassword().isEmpty()
            ) {
                mahasiswas.get(i).setUsername(username);
                mahasiswas.get(i).setPassword(password);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean login(JTextField username, JPasswordField password) {
        if (
                username.getText().equals(adminUsername) &&
                        password.getText().equals(adminPassword)
        ) {
            status = this.adminUsername;
            return true;
        }
        for (int i = 0; i < mahasiswas.size(); i++) {
            try {
                if (
                        username.getText().equals(mahasiswas.get(i).getUsername()) &&
                                password.getText().equals(mahasiswas.get(i).getPassword())
                ) {
                    status = mahasiswas.get(i).getStatus();
                    index = i;
                    return true;
                } else if (
                        username.getText().equals(dosens.get(i).getUsername()) &&
                                password.getText().equals(dosens.get(i).getPassword())
                ) {
                    status = dosens.get(i).getStatus();
                    index = i;
                    return true;
                }
            } catch (Exception exception) {
                continue;
            }
        }
        return false;
    }

    public List<Mahasiswa> getMahasiswas() {
        return mahasiswas;
    }

    public List<Dosen> getDosens() {
        return dosens;
    }

    public String getStatus() {
        return status;
    }

    public int getIndex() {
        return index;
    }
}
