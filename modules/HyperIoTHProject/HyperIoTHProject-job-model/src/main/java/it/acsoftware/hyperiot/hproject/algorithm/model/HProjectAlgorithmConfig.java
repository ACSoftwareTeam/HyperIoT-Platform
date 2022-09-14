package it.acsoftware.hyperiot.hproject.algorithm.model;

import it.acsoftware.hyperiot.algorithm.model.AlgorithmIOField;

import java.util.List;
import java.util.Objects;

public class HProjectAlgorithmConfig {

    private List<HProjectAlgorithmInputField> input;
    private List<AlgorithmIOField> output;

    public List<HProjectAlgorithmInputField> getInput() {
        return input;
    }

    public void setInput(List<HProjectAlgorithmInputField> input) {
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
        HProjectAlgorithmConfig that = (HProjectAlgorithmConfig) o;
        return Objects.equals(input, that.input) &&
                Objects.equals(output, that.output);
    }

    @Override
    public int hashCode() {
        return Objects.hash(input, output);
    }

}
