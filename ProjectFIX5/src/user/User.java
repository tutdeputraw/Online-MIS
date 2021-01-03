package user;

import matakuliah.MataKuliahSemester3;
import matakuliah.nilai.NilaiSemester3;

public abstract class User {
    protected String nama;
    protected String status;
    protected String username;
    protected String password;
    protected MataKuliahSemester3 mataKuliahSemester3 = new MataKuliahSemester3();

    public User(
            String nama,
            String status,
            String username,
            String password
    ) {
        this.setNama(nama);
        this.setUsername(username);
        this.setPassword(password);
        this.setStatus(status);
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
