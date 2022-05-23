public class SettingsURLsXPathsNamesOrIDs {
    /**
     * В этом классе лежат все локаторы(по xpath, id или name) элементов, которые используются в тестах.
     * Локаторы лежат в переменных, которые являются константами и для которых сгенерированы getтеры.
     * Отдельно идут переменные driverName, driverPath и url. В этих переменных не лежат локаторы, но
     * они используются для указания имени драйвера, пути в системе к файлу драйвера. В переменную url
     * записывается url той страницы, которая исппользуется в тесте. Для переменных driverName, driverPath и url
     * сгенерированы getтеры и setтеры без изменений.
     */
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
    private final String usernameFieldID = "username";
    private final String passFieldID = "password";
    private final String loginButtonText = "//button[text()=\"Login\"]";
    private final String chooseFileButtonID = "file-upload";
    private final String UploadButton = "//input[@value=\"Upload\"]";
    private final String alertButtonXpath = "//button[text()='Click for JS Alert']";
    private final String confirmButtonXpath = "//button[text()='Click for JS Confirm']";
    private final String promptButtonXpath = "//button[text()='Click for JS Prompt']";
    private final String code200Xpath = "//a[@href=\"status_codes/200\"]";
    private final String code301Xpath = "//a[@href=\"status_codes/301\"]";
    private final String code404Xpath = "//a[@href=\"status_codes/404\"]";
    private final String code500Xpath = "//a[@href=\"status_codes/500\"]";

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
    public String getUsernameFieldID() {
        return usernameFieldID;
    }
    public String getPassFieldID() {
        return passFieldID;
    }
    public String getLoginButtonText() {
        return loginButtonText;
    }
    public String getChooseFileButtonID() {
        return chooseFileButtonID;
    }
    public String getUploadButton() {
        return UploadButton;
    }
    public String getAlertButtonXpath() {
        return alertButtonXpath;
    }
    public String getConfirmButtonXpath() {
        return confirmButtonXpath;
    }
    public String getPromptButtonXpath() {
        return promptButtonXpath;
    }

    public String getCode200Xpath() {
        return code200Xpath;
    }

    public String getCode301Xpath() {
        return code301Xpath;
    }

    public String getCode404Xpath() {
        return code404Xpath;
    }

    public String getCode500Xpath() {
        return code500Xpath;
    }
}
