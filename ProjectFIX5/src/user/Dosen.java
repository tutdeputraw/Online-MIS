package user;

import matakuliah.nilai.NilaiSemester3;

public class Dosen extends User {
    private String nip;
    private String matakuliah;

    public Dosen(
            String nama,
            String status,
            String nip,
            String matakuliah,
            String username,
            String password
    ) {
        super(
                nama,
                status,
                username,
                password
        );
        this.setNip(nip);
        this.setMatakuliah(matakuliah);
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getMatakuliah() {
        return matakuliah;
    }

    public void setMatakuliah(String matakuliah) {
        this.matakuliah = matakuliah;
    }

    public void insertData(NilaiSemester3 nilaiSemester3, String nilai) {
        if (getMatakuliah().equals(super.mataKuliahSemester3.getConcurrentProgramming())) {
            nilaiSemester3.setPrakPemrogramanBerorientasiObyek(nilai);
        } else if (getMatakuliah().equals(super.mataKuliahSemester3.getDatabases())) {
            nilaiSemester3.setPemrogramanBerorientasiObyek(nilai);
        } else if (getMatakuliah().equals(super.mataKuliahSemester3.getProjectManagement())) {
            nilaiSemester3.setWorkshopAplikasiBerbasisWeb(nilai);
        } else if (getMatakuliah().equals(super.mataKuliahSemester3.getSoftwareEngineering())) {
            nilaiSemester3.setRekayasaPerangkatLunak(nilai);
        } else if (getMatakuliah().equals(super.mataKuliahSemester3.getLogicProgramming())) {
            nilaiSemester3.setPrakBasisDataLanjut(nilai);
        } else if (getMatakuliah().equals(super.mataKuliahSemester3.getDatabaseAdministration())) {
            nilaiSemester3.setPrakKonsepJaringan(nilai);
        } else if (getMatakuliah().equals(super.mataKuliahSemester3.getDataStructuresAndAlgorithms())) {
            nilaiSemester3.setPancasilaDanKewarganegaraan(nilai);
        } else if (getMatakuliah().equals(super.mataKuliahSemester3.getComputerArchitecture())) {
            nilaiSemester3.setMatematika3(nilai);
        } else if (getMatakuliah().equals(super.mataKuliahSemester3.getNetworkingConcept())) {
            nilaiSemester3.setKonsepJaringan(nilai);
        } else if (getMatakuliah().equals(super.mataKuliahSemester3.getOperatingSystems())) {
            nilaiSemester3.setBasisDataLanjut(nilai);
        } else if (getMatakuliah().equals(super.mataKuliahSemester3.getComputerVision())) {
            nilaiSemester3.setAljabarLinier(nilai);
        }
    }

    public String lihatNilai(NilaiSemester3 nilaiSemester3) {
        String nilai = "";
        if (getMatakuliah().equals(mataKuliahSemester3.getConcurrentProgramming())) {
            nilai = nilaiSemester3.getPrakPemrogramanBerorientasiObyek();
        } else if (getMatakuliah().equals(mataKuliahSemester3.getDatabases())) {
            nilai = nilaiSemester3.getPemrogramanBerorientasiObyek();
        } else if (getMatakuliah().equals(mataKuliahSemester3.getProjectManagement())) {
            nilai = nilaiSemester3.getWorkshopAplikasiBerbasisWeb();
        } else if (getMatakuliah().equals(mataKuliahSemester3.getSoftwareEngineering())) {
            nilai = nilaiSemester3.getRekayasaPerangkatLunak();
        } else if (getMatakuliah().equals(mataKuliahSemester3.getLogicProgramming())) {
            nilai = nilaiSemester3.getPrakBasisDataLanjut();
        } else if (getMatakuliah().equals(mataKuliahSemester3.getDatabaseAdministration())) {
            nilai = nilaiSemester3.getPrakKonsepJaringan();
        } else if (getMatakuliah().equals(mataKuliahSemester3.getDataStructuresAndAlgorithms())) {
            nilai = nilaiSemester3.getPancasilaDanKewarganegaraan();
        } else if (getMatakuliah().equals(mataKuliahSemester3.getComputerArchitecture())) {
            nilai = nilaiSemester3.getMatematika3();
        } else if (getMatakuliah().equals(mataKuliahSemester3.getNetworkingConcept())) {
            nilai = nilaiSemester3.getKonsepJaringan();
        } else if (getMatakuliah().equals(mataKuliahSemester3.getOperatingSystems())) {
            nilai = nilaiSemester3.getBasisDataLanjut();
        } else if (getMatakuliah().equals(mataKuliahSemester3.getComputerVision())) {
            nilai = nilaiSemester3.getAljabarLinier();
        }
        return nilai;
    }
}
