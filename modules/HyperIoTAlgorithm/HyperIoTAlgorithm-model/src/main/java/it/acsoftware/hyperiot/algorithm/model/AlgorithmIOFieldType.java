package it.acsoftware.hyperiot.algorithm.model;

public enum AlgorithmIOFieldType {

    NUMBER(Number.class), INTEGER(Integer.class), LONG(Long.class), DOUBLE(Double.class), FLOAT(Float.class),
    TEXT(String.class), BYTE(Byte.class);

    private Class<?> classType;

    AlgorithmIOFieldType(Class<?> classType) {
        this.classType = classType;
    }

    public Class<?> getClassType() {
        return classType;
    }

}
