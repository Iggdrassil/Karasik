import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.interactions.Actions;


public class Tests_on_Selenium_Test_Example_Page {
    public static WebDriver chromeDriver;
    public static WebElements webElements;
    public static WebElement showMessageButton;
    public static WebElement entryField;
    public static WebElement checkBox;
    public static WebElement dropdownList;
    public static WebElement radioButton;
    public static WebElement textArea;
    public static WebElement submitButton;
    public static WebElement draggable;
    public static WebElement droppable;

    @BeforeAll
    public static void BeforeClass (){
        webElements = new WebElements();
        webElements.setDriverName("webdriver.chrome.driver");
        webElements.setDriverPath("C:/Users/Navar/Desktop/Karasik/chromedriver.exe");
        System.setProperty(webElements.getDriverName(), webElements.getDriverPath());
        chromeDriver = new ChromeDriver();
    }
    @Test
    public void ClickButtonsAndEnteredFieldsTest() throws InterruptedException{
        webElements.setUrl("https://crossbrowsertesting.github.io/selenium_example_page.html");
        chromeDriver.get(webElements.getUrl());
        Thread.sleep(2000);
        showMessageButton = chromeDriver.findElement(By.xpath(webElements.getShowMessageButtonXPath()));
        entryField = chromeDriver.findElement(By.xpath(webElements.getEntryFieldXPath()));
        checkBox = chromeDriver.findElement(By.xpath(webElements.getCheckBoxXPath()));
        dropdownList = chromeDriver.findElement(By.xpath(webElements.getDropdownListXPath()));
        radioButton = chromeDriver.findElement(By.id(webElements.getRadioButtonID()));
        textArea = chromeDriver.findElement(By.name(webElements.getTextAreaName()));
        submitButton = chromeDriver.findElement(By.id(webElements.getSubmitButtonID()));
        Thread.sleep(2000);
        showMessageButton.click();
        Thread.sleep(2000);
        entryField.sendKeys("SomeTestText");
        checkBox.click();
        dropdownList.click();
        dropdownList.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
        radioButton.click();
        textArea.sendKeys("Entered Some text for test");
        entryField.clear();
        entryField.sendKeys("New Text");
        Thread.sleep(2000);
        submitButton.click();
    }
    @Test
    public void DragAndDropTest() throws InterruptedException{
        webElements.setUrl("https://crossbrowsertesting.github.io/drag-and-drop.html");
        chromeDriver.get(webElements.getUrl());
        Thread.sleep(2000);
        draggable = chromeDriver.findElement(By.id(webElements.getDraggableID()));
        droppable = chromeDriver.findElement(By.id(webElements.getDroppableID()));
        Actions dragAndDropAction = new Actions(chromeDriver);
        dragAndDropAction.pause(5000).dragAndDrop(draggable,droppable).pause(5000).build().perform();

        }
     @AfterAll
    public static void AfterClass() throws InterruptedException{
        Thread.sleep(10000);
        chromeDriver.quit();
     }
    }
