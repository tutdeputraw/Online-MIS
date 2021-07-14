package user.dosen;

import matakuliah.MataKuliahSemester3;
import matakuliah.NilaiSemester3;
import user.UserManager;

public class DosenManager extends UserManager {
    private String nip;
    private String mataKuliah;
    private MataKuliahSemester3 mataKuliahSemester3 = new MataKuliahSemester3();

    public DosenManager(String nama, String status, String nip,
                        String matakuliah, String username, String password) {
        super(nama, status, username, password);
        this.setNip(nip);
        this.setMataKuliah(matakuliah);
    }

    public void insertData(NilaiSemester3 nilaiSemester3, String nilai) {
        for (int i = 0; i < 11; i++) {
            if (mataKuliah.equals(
                    mataKuliahSemester3.getMatakuliahsemester3()[i])) {
                nilaiSemester3.setNilaiSemester3(i, nilai);
            }
        }
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getMataKuliah() {
        return mataKuliah;
    }

    public void setMataKuliah(String mataKuliah) {
        this.mataKuliah = mataKuliah;
    }
}
