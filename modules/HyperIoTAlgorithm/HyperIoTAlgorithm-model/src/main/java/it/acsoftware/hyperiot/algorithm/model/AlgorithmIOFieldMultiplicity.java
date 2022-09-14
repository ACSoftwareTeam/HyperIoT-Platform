package it.acsoftware.hyperiot.algorithm.model;

public enum AlgorithmIOFieldMultiplicity {

    SINGLE("single"), ARRAY("array"), MATRIX("matrix");

    private String name;

    AlgorithmIOFieldMultiplicity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
