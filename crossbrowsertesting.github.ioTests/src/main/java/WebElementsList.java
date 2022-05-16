import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebElementsList {
    /**
     * В этом классе лежат все вебэлементы, которые используются в тестах.
     * Так как вебэлементов достаточно много, было решено выделить для этого отжельный класс.
     * В классе сначала объявлется переменная класса WebElement %названиеЭлемента%
     * Потом для этой переменной генерируются getтеры и setтеры.
     * Getтер остается без изменений, а в конструктор setтера дописываются две переменные: driver класса Webdriver и переменная класса String,
     * которая может содержать xpath элемента, или его id, или его name.
     * Потом в setтере происходит поиск элемента с помощью драйвера и указанного локатора.
     */
    private  WebElement showMessageButton;
    private  WebElement entryField;
    private  WebElement checkBox;
    private  WebElement dropdownList;
    private  WebElement radioButton;
    private  WebElement textArea;
    private  WebElement submitButton;
    private  WebElement draggable;
    private  WebElement droppable;
    private  WebElement nameField;
    private  WebElement passField;
    private  WebElement loginButton;
    private  WebElement chooseFileButton;
    private  WebElement uploadButton;
    private WebElement alertButton;
    private WebElement confirmButton;
    private WebElement promptButton;

    public WebElement getShowMessageButton() {
        return showMessageButton;
    }
    public void setShowMessageButton(WebDriver driver, String webElementXPathNameOrID) {
        this.showMessageButton = driver.findElement(By.xpath(webElementXPathNameOrID)); //Поиск вебэлемента по Xpath
    }
    public WebElement getDraggable() {
        return draggable;
    }
    public void setDraggable(WebDriver driver, String webElementXPathNameOrID) {
        this.draggable = driver.findElement(By.id(webElementXPathNameOrID)); //Поиск вебэлемента по id
    }
    public WebElement getDroppable() {
        return droppable;
    }
    public void setDroppable(WebDriver driver, String webElementXPathNameOrID) {
        this.droppable = driver.findElement(By.id(webElementXPathNameOrID)); //Поиск вебэлемента по id
    }
    public WebElement getEntryField() {
        return entryField;
    }
    public void setEntryField(WebDriver driver, String webElementXPathNameOrID) {
        this.entryField = driver.findElement(By.xpath(webElementXPathNameOrID));  //Поиск вебэлемента по Xpath
    }
    public WebElement getCheckBox() {
        return checkBox;
    }
    public void setCheckBox(WebDriver driver, String webElementXPathNameOrID) {
        this.checkBox = driver.findElement(By.xpath(webElementXPathNameOrID));  //Поиск вебэлемента по Xpath
    }
    public WebElement getDropdownList() {
        return dropdownList;
    }
    public void setDropdownList(WebDriver driver, String webElementXPathNameOrID) {
        this.dropdownList = driver.findElement(By.xpath(webElementXPathNameOrID));  //Поиск вебэлемента по Xpath
    }
    public WebElement getRadioButton() {
        return radioButton;
    }
    public void setRadioButton(WebDriver driver, String webElementXPathNameOrID) {
        this.radioButton = driver.findElement(By.id(webElementXPathNameOrID));  //Поиск вебэлемента по id
    }
    public WebElement getTextArea() {
        return textArea;
    }
    public void setTextArea(WebDriver driver, String webElementXPathNameOrID) {
        this.textArea = driver.findElement(By.name(webElementXPathNameOrID));  //Поиск вебэлемента по name
    }
    public WebElement getSubmitButton() {
        return submitButton;
    }
    public void setSubmitButton(WebDriver driver, String webElementXPathNameOrID) {
        this.submitButton = driver.findElement(By.id(webElementXPathNameOrID));  //Поиск вебэлемента по id
    }
    public WebElement getNameField() {
        return nameField;
    }
    public void setNameField(WebDriver driver, String webElementXPathNameOrID) {
        this.nameField = driver.findElement(By.id(webElementXPathNameOrID));  //Поиск вебэлемента по id
    }
    public WebElement getPassField() {
        return passField;
    }
    public void setPassField(WebDriver driver, String webElementXPathNameOrID) {
        this.passField = driver.findElement(By.id(webElementXPathNameOrID));  //Поиск вебэлемента по id
    }
    public WebElement getLoginButton() {
        return loginButton;
    }
    public void setLoginButton(WebDriver driver, String webElementXPathNameOrID) {
        this.loginButton = driver.findElement(By.xpath(webElementXPathNameOrID));  //Поиск вебэлемента по Xpath
    }
    public WebElement getChooseFileButton() {
        return chooseFileButton;
    }
    public void setChooseFileButton(WebDriver driver, String webElementXPathNameOrID) {
        this.chooseFileButton = driver.findElement(By.id(webElementXPathNameOrID));
    }
    public WebElement getUploadButton() {
        return uploadButton;
    }
    public void setUploadButton(WebDriver driver, String webElementXPathNameOrID) {
        this.uploadButton = driver.findElement(By.xpath(webElementXPathNameOrID));
    }

    public WebElement getAlertButton() {
        return alertButton;
    }

    public void setAlertButton(WebDriver driver, String webElementXPathNameOrID) {
        this.alertButton = driver.findElement(By.xpath(webElementXPathNameOrID));
    }

    public WebElement getConfirmButton() {
        return confirmButton;
    }

    public void setConfirmButton(WebDriver driver, String webElementXPathNameOrID) {
        this.confirmButton = driver.findElement(By.xpath(webElementXPathNameOrID));
    }

    public WebElement getPromptButton() {
        return promptButton;
    }

    public void setPromptButton(WebDriver driver, String webElementXPathNameOrID) {
        this.promptButton = driver.findElement(By.xpath(webElementXPathNameOrID));
    }

}
