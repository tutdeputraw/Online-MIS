package user;

import matakuliah.*;

public class UserManager {
    protected String nama;
    protected String status;
    protected String username;
    protected String password;

    public UserManager(String nama, String status, String username,
                       String password) {
        this.setNama(nama);
        this.setUsername(username);
        this.setPassword(password);
        this.setStatus(status);
    }

    public String lihatNilai(NilaiSemester3 nilaiSemester3, String matakuliah) {
        String nilai = "";
        MataKuliahSemester3 mataKuliahSemester3 = new MataKuliahSemester3();

        for (int i = 0; i < mataKuliahSemester3.getMatakuliahsemester3().length;
             i++) {
            if (matakuliah.equals(
                    mataKuliahSemester3.getMatakuliahsemester3()[i])) {
                nilai = nilaiSemester3.getNilaiSemester3()[i][1];
            }
        }
        return  nilai;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
