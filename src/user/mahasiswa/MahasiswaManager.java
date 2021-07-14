package user.mahasiswa;

import matakuliah.NilaiSemester3;
import user.UserManager;

public class MahasiswaManager extends UserManager {
    private String nrp;
    private NilaiSemester3 nilaiSemester3 = new NilaiSemester3();

    public MahasiswaManager(String nama, String status, String nrp,
                            String username,
                            String password) {
        super(nama, status, username, password);
        this.setNrp(nrp);
        nilaiSemester3.setNrp(nrp);
    }

    public String getNrp() {
        return nrp;
    }

    public void setNrp(String nrp) {
        this.nrp = nrp;
    }

    public NilaiSemester3 getNilaiSemester3() {
        return nilaiSemester3;
    }
}
