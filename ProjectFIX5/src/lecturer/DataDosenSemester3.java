package lecturer;

import matakuliah.MataKuliahSemester3;

public final class DataDosenSemester3 {
    private MataKuliahSemester3 mataKuliahSemester3 = new MataKuliahSemester3();
    private final String[][] dosen = {
            {"Lane Davis\n", "###01", mataKuliahSemester3.getComputerArchitecture(), "1", "1"},
            {"Wallace Joseph", "###02", mataKuliahSemester3.getDataStructuresAndAlgorithms(), "2", "2"},
            {"Carmen Geis", "###03", mataKuliahSemester3.getDatabases(), "3", "3"},
            {"Elaine Reeves", "###04", mataKuliahSemester3.getNetworkingConcept(), "4", "4"},
            {"Joan Erickson", "###05", mataKuliahSemester3.getOperatingSystems(), "5", "5"},
            {"Bailey Holt", "###06", mataKuliahSemester3.getSoftwareEngineering(), "6", "6"},
            {"Violet Reese", "###07", mataKuliahSemester3.getProjectManagement(), "7", "7"},
            {"Ruth Pierpoint", "###08", mataKuliahSemester3.getComputerVision(), "8", "8"},
            {"Terry Hardy", "###09", mataKuliahSemester3.getDatabaseAdministration(), "9", "9"},
            {"Heath Pauley", "###10", mataKuliahSemester3.getLogicProgramming(), "10", "10"},
            {"Yvonne Mendez", "###11", mataKuliahSemester3.getConcurrentProgramming(), "11", "11"},
    };

    public String[][] getDosen() {
        return dosen;
    }
}
