package matakuliah;

public final class MataKuliahSemester3 {
    private final String computerArchitecture = "Computer Architecture";
    private final String dataStructuresAndAlgorithms = "Data Structures & Algorithms";
    private final String databases = "Databases";
    private final String networkingConcept = "Networking Concept";
    private final String operatingSystems = "Operating Systems";
    private final String softwareEngineering = "Software Engineering";
    private final String projectManagement = "Project Management";
    private final String computerVision = "Computer Vision";
    private final String concurrentProgramming = "Concurrent Programming";
    private final String databaseAdministration = "Database Administration";
    private final String logicProgramming = "Logic Programming";
    private final String[] subjectsThirdSemester = {
            getComputerArchitecture(),
            getDataStructuresAndAlgorithms(),
            getDatabases(),
            getNetworkingConcept(),
            getOperatingSystems(),
            getSoftwareEngineering(),
            getProjectManagement(),
            getComputerVision(),
            getConcurrentProgramming(),
            getDatabaseAdministration(),
            getLogicProgramming()
    };

    public String getComputerArchitecture() {
        return computerArchitecture;
    }

    public String getDataStructuresAndAlgorithms() {
        return dataStructuresAndAlgorithms;
    }

    public String getDatabases() {
        return databases;
    }

    public String getNetworkingConcept() {
        return networkingConcept;
    }

    public String getOperatingSystems() {
        return operatingSystems;
    }

    public String getSoftwareEngineering() {
        return softwareEngineering;
    }

    public String getProjectManagement() {
        return projectManagement;
    }

    public String getComputerVision() {
        return computerVision;
    }

    public String getConcurrentProgramming() {
        return concurrentProgramming;
    }

    public String getDatabaseAdministration() {
        return databaseAdministration;
    }

    public String getLogicProgramming() {
        return logicProgramming;
    }

    public String[] getSubjectsThirdSemester() {
        return subjectsThirdSemester;
    }
}
