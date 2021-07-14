package matakuliah;

public class NilaiSemester3 {
    private String nrp = "";
    MataKuliahSemester3 mataKuliahSemester3 = new MataKuliahSemester3();

    public String[][] nilaiSemester3 = new String[11][2];

    public NilaiSemester3() {
        for (int i = 0; i < 11; i++) {
            nilaiSemester3[i][0] =
                    mataKuliahSemester3.getMatakuliahsemester3()[i];
            nilaiSemester3[i][1] = "";
        }
    }

    public void setNilaiSemester3(int i, String nilai) {
        this.nilaiSemester3[i][1] = nilai;
    }

    public String[][] getNilaiSemester3() {
        return nilaiSemester3;
    }

    public void setNrp(String nrp) {
        this.nrp = nrp;
    }
}
