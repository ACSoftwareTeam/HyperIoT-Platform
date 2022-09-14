package it.acsoftware.hyperiot.algorithm.model;


import java.util.List;
import java.util.Objects;

public class AlgorithmConfig {

    private List<AlgorithmIOField> input;
    private List<AlgorithmIOField> output;

    public List<AlgorithmIOField> getInput() {
        return input;
    }

    public void setInput(List<AlgorithmIOField> input) {
        this.input = input;
    }

    public List<AlgorithmIOField> getOutput() {
        return output;
    }

    public void setOutput(List<AlgorithmIOField> output) {
        this.output = output;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AlgorithmConfig that = (AlgorithmConfig) o;
        return Objects.equals(input, that.input) &&
                Objects.equals(output, that.output);
    }

    @Override
    public int hashCode() {
        return Objects.hash(input, output);
    }

}
