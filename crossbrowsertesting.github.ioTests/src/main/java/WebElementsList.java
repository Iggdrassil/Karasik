import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebElementsList {
    private  WebElement showMessageButton;
    private  WebElement entryField;
    private  WebElement checkBox;
    private  WebElement dropdownList;
    private  WebElement radioButton;
    private  WebElement textArea;
    private  WebElement submitButton;
    private  WebElement draggable;
    private  WebElement droppable;
    public WebElement getShowMessageButton() {
        return showMessageButton;
    }

    public void setShowMessageButton(WebDriver driver, String webElementXPathNameOrID) {
        this.showMessageButton = driver.findElement(By.xpath(webElementXPathNameOrID));
    }
    public WebElement getDraggable() {
        return draggable;
    }

    public void setDraggable(WebDriver driver, String webElementXPathNameOrID) {
        this.draggable = driver.findElement(By.id(webElementXPathNameOrID));
    }

    public WebElement getDroppable() {
        return droppable;
    }

    public void setDroppable(WebDriver driver, String webElementXPathNameOrID) {
        this.droppable = driver.findElement(By.id(webElementXPathNameOrID));
    }

    public WebElement getEntryField() {
        return entryField;
    }

    public void setEntryField(WebDriver driver, String webElementXPathNameOrID) {
        this.entryField = driver.findElement(By.xpath(webElementXPathNameOrID));
    }

    public WebElement getCheckBox() {
        return checkBox;
    }

    public void setCheckBox(WebDriver driver, String webElementXPathNameOrID) {
        this.checkBox = driver.findElement(By.xpath(webElementXPathNameOrID));
    }

    public WebElement getDropdownList() {
        return dropdownList;
    }

    public void setDropdownList(WebDriver driver, String webElementXPathNameOrID) {
        this.dropdownList = driver.findElement(By.xpath(webElementXPathNameOrID));
    }

    public WebElement getRadioButton() {
        return radioButton;
    }

    public void setRadioButton(WebDriver driver, String webElementXPathNameOrID) {
        this.radioButton = driver.findElement(By.id(webElementXPathNameOrID));
    }

    public WebElement getTextArea() {
        return textArea;
    }

    public void setTextArea(WebDriver driver, String webElementXPathNameOrID) {
        this.textArea = driver.findElement(By.name(webElementXPathNameOrID));
    }

    public WebElement getSubmitButton() {
        return submitButton;
    }

    public void setSubmitButton(WebDriver driver, String webElementXPathNameOrID) {
        this.submitButton = driver.findElement(By.id(webElementXPathNameOrID));
    }
}
