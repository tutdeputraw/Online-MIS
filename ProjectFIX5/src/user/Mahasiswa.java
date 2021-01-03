package user;

import matakuliah.nilai.NilaiSemester3;

public class Mahasiswa extends User {
    private String nrp;
    private NilaiSemester3 nilaiSemester3 = new NilaiSemester3();

    public Mahasiswa(
            String nama,
            String status,
            String nrp,
            String username,
            String password
    ) {
        super(
                nama,
                status,
                username,
                password
        );
        this.setNrp(nrp);
        nilaiSemester3.setNrp(nrp);
    }

    public String lihatNilai(String matakuliah) {
        String nilai = "";
        if (matakuliah.equals(super.mataKuliahSemester3.getProjectManagement())) {
            nilai = nilaiSemester3.getWorkshopAplikasiBerbasisWeb();
        } else if (matakuliah.equals(super.mataKuliahSemester3.getSoftwareEngineering())) {
            nilai = nilaiSemester3.getRekayasaPerangkatLunak();
        } else if (matakuliah.equals(super.mataKuliahSemester3.getConcurrentProgramming())) {
            nilai = nilaiSemester3.getPrakPemrogramanBerorientasiObyek();
        } else if (matakuliah.equals(super.mataKuliahSemester3.getDatabaseAdministration())) {
            nilai = nilaiSemester3.getPrakKonsepJaringan();
        } else if (matakuliah.equals(super.mataKuliahSemester3.getLogicProgramming())) {
            nilai = nilaiSemester3.getPrakBasisDataLanjut();
        } else if (matakuliah.equals(super.mataKuliahSemester3.getDataStructuresAndAlgorithms())) {
            nilai = nilaiSemester3.getPancasilaDanKewarganegaraan();
        } else if (matakuliah.equals(super.mataKuliahSemester3.getComputerArchitecture())) {
            nilai = nilaiSemester3.getMatematika3();
        } else if (matakuliah.equals(super.mataKuliahSemester3.getNetworkingConcept())) {
            nilai = nilaiSemester3.getKonsepJaringan();
        } else if (matakuliah.equals(super.mataKuliahSemester3.getOperatingSystems())) {
            nilai = nilaiSemester3.getBasisDataLanjut();
        } else if (matakuliah.equals(super.mataKuliahSemester3.getComputerVision())) {
            nilai = nilaiSemester3.getAljabarLinier();
        } else if (matakuliah.equals(super.mataKuliahSemester3.getDatabases())) {
            nilai = nilaiSemester3.getPemrogramanBerorientasiObyek();
        }
        return nilai;
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
