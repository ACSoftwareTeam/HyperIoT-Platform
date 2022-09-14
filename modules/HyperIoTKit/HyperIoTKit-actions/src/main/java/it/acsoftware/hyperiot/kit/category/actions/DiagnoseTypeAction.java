package it.acsoftware.hyperiot.kit.category.actions;

import it.acsoftware.hyperiot.base.action.HyperIoTActionName;

public enum DiagnoseTypeAction implements HyperIoTActionName {

    ACTION_ENUM("action_enum");

    private String name;

    /**
     * DiagnoseType Action with the specified name.
     *
     * @param name parameter that represent the DiagnoseType  action
     */
    private DiagnoseTypeAction(String name) {
        this.name = name;
    }

    /**
     * Gets the name of DiagnoseType action
     */
    public String getName() {
        return name;
    }
}
