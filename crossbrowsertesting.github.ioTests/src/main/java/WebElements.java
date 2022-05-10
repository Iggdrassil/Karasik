

public class WebElements {
    private String driverName;
    private String driverPath;
    private String url;
    private final String showMessageButtonXPath = "//button[@id=\"btn\"]";
    private final String entryFieldXPath = "//input[@type=\"text\"]";
    private final String checkBoxXPath = "//input[@type=\"checkbox\"]";
    private final String dropdownListXPath = "//select[@id=\"dropdown\"]";
    private final String radioButtonID = "radiobtn1";
    private final String textAreaName = "textarea";
    private final String submitButtonID = "submitbtn";
    private final String draggableID = "draggable";
    private final String droppableID = "droppable";

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverPath() {
        return driverPath;
    }

    public void setDriverPath(String dirverPath) {
        this.driverPath = dirverPath;
    }
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    public String getShowMessageButtonXPath() {
        return showMessageButtonXPath;
    }

    public String getEntryFieldXPath() {
        return entryFieldXPath;
    }

    public String getCheckBoxXPath() {
        return checkBoxXPath;
    }

    public String getDropdownListXPath() {
        return dropdownListXPath;
    }

    public String getRadioButtonID() {
        return radioButtonID;
    }

    public String getTextAreaName() {
        return textAreaName;
    }

    public String getSubmitButtonID() {
        return submitButtonID;
    }
    public String getDraggableID() {
        return draggableID;
    }

    public String getDroppableID() {
        return droppableID;
    }

}
