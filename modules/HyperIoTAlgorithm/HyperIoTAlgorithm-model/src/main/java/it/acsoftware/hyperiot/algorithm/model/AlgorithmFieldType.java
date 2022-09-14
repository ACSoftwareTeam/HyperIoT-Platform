package it.acsoftware.hyperiot.algorithm.model;

public enum AlgorithmFieldType {

    INPUT("input"), OUTPUT("output");

    private String name;

    AlgorithmFieldType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
