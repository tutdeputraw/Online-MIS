package account;
import user.dosen.*;
import user.mahasiswa.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Account implements IAccount {
    private final String adminUsername = "root";
    private final String adminPassword = "root";
    private List<MahasiswaManager> mahasiswaManagers = new ArrayList<>();
    private List<DosenManager> dosenManagers = new ArrayList<>();
    private DataMahasiswaD4ITB2019 d4InformatikaB19;
    private DataDosenSemester3 dosenSemester3;
    private String status;
    private int index;

    public Account() {
        d4InformatikaB19 = new DataMahasiswaD4ITB2019();
        dosenSemester3 = new DataDosenSemester3();
        for (int i = 0; i < d4InformatikaB19.getStudent().length; i++) {
            mahasiswaManagers.add(
                    new MahasiswaManager(d4InformatikaB19.getStudent()[i][1],
                                         "Mahasiswa",
                                         d4InformatikaB19.getStudent()[i][0],
                                         "", "")
            );
        }
        for (int i = 0; i < dosenSemester3.getDosen().length; i++) {
            dosenManagers.add(new DosenManager(dosenSemester3.getDosen()[i][0],
                                 "Dosen",
                                 dosenSemester3.getDosen()[i][1],
                                 dosenSemester3.getDosen()[i][2],
                                 dosenSemester3.getDosen()[i][3],
                                 dosenSemester3.getDosen()[i][4])
            );
        }
        mahasiswaManagers.get(18).setUsername("bagus");
        mahasiswaManagers.get(18).setPassword("bagus");
    }

    @Override
    public boolean register(String nama, String nrp,
                            String username, String password) {
        for (MahasiswaManager mahasiswaManager : mahasiswaManagers) {
            if (nama.equals(mahasiswaManager.getNama())
                && nrp.equals(mahasiswaManager.getNrp())) {
                    mahasiswaManager.setUsername(username);
                    mahasiswaManager.setPassword(password);
                    return true;
            }
        }
        return false;
    }

    @Override
    public boolean login(JTextField username, JPasswordField password) {
        if (username.getText().equals(adminUsername)
            && password.getText().equals(adminPassword)) {
                status = this.adminUsername;
                return true;
        }
        for (int i = 0; i < mahasiswaManagers.size(); i++) {
            try {
                if (username.getText().equals(
                        mahasiswaManagers.get(i).getUsername())
                    && password.getText().equals(
                        mahasiswaManagers.get(i).getPassword())) {
                    status = mahasiswaManagers.get(i).getStatus();
                    index = i;
                    return true;
                } else if (username.getText().equals(
                               dosenManagers.get(i).getUsername())
                           && password.getText().equals(
                               dosenManagers.get(i).getPassword())) {
                    status = dosenManagers.get(i).getStatus();
                    index = i;
                    return true;
                }
            } catch (Exception exception) {
                continue;
            }
        }
        return false;
    }

    public List<MahasiswaManager> getMahasiswas() {
        return mahasiswaManagers;
    }

    public List<DosenManager> getDosens() {
        return dosenManagers;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getIndex() {
        return index;
    }
}