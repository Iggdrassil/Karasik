import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class Tests_on_Selenium_Test_Example_Page {
    public static WebDriver chromeDriver;
    public static SettingsURLsXPathsNamesOrIDs SettingsURLsXPathsNamesOrIDs;
    public static WebElementsList webElements;

    @BeforeAll
    public static void BeforeClass (){
        SettingsURLsXPathsNamesOrIDs = new SettingsURLsXPathsNamesOrIDs();
        webElements = new WebElementsList();
        SettingsURLsXPathsNamesOrIDs.setDriverName("webdriver.chrome.driver");
        SettingsURLsXPathsNamesOrIDs.setDriverPath("C:/Users/Navar/Desktop/Karasik/chromedriver.exe");
        System.setProperty(SettingsURLsXPathsNamesOrIDs.getDriverName(), SettingsURLsXPathsNamesOrIDs.getDriverPath());
        chromeDriver = new ChromeDriver();
    }
    @Test
    public void ClickButtonsAndEnteredFieldsTest() throws InterruptedException{
        SettingsURLsXPathsNamesOrIDs.setUrl("https://crossbrowsertesting.github.io/selenium_example_page.html");
        chromeDriver.get(SettingsURLsXPathsNamesOrIDs.getUrl());
        webElements.setShowMessageButton(chromeDriver, SettingsURLsXPathsNamesOrIDs.getShowMessageButtonXPath());
        webElements.setEntryField(chromeDriver, SettingsURLsXPathsNamesOrIDs.getEntryFieldXPath());
        webElements.setCheckBox(chromeDriver, SettingsURLsXPathsNamesOrIDs.getCheckBoxXPath());
        webElements.setDropdownList(chromeDriver, SettingsURLsXPathsNamesOrIDs.getDropdownListXPath());
        webElements.setRadioButton(chromeDriver, SettingsURLsXPathsNamesOrIDs.getRadioButtonID());
        webElements.setTextArea(chromeDriver, SettingsURLsXPathsNamesOrIDs.getTextAreaName());
        webElements.setSubmitButton(chromeDriver, SettingsURLsXPathsNamesOrIDs.getSubmitButtonID());
        Thread.sleep(2000);
        Thread.sleep(2000);
        webElements.getShowMessageButton().click();
        Thread.sleep(2000);
        webElements.getEntryField().sendKeys("SomeTestText");
        webElements.getCheckBox().click();
        webElements.getDropdownList().click();
        webElements.getDropdownList().sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
        webElements.getRadioButton().click();
        webElements.getTextArea().sendKeys("Entered Some text for test");
        webElements.getEntryField().clear();
        webElements.getEntryField().sendKeys("New Text");
        Thread.sleep(2000);
        webElements.getSubmitButton().click();
    }
    @Test
    public void DragAndDropTest() throws InterruptedException{
        SettingsURLsXPathsNamesOrIDs.setUrl("https://crossbrowsertesting.github.io/drag-and-drop.html");
        chromeDriver.get(SettingsURLsXPathsNamesOrIDs.getUrl());
        Thread.sleep(2000);
        webElements.setDraggable(chromeDriver, SettingsURLsXPathsNamesOrIDs.getDraggableID());
        webElements.setDroppable(chromeDriver, SettingsURLsXPathsNamesOrIDs.getDroppableID());
        Actions dragAndDropAction = new Actions(chromeDriver);
        dragAndDropAction.pause(5000).dragAndDrop(webElements.getDraggable(),webElements.getDroppable()).pause(5000).build().perform();

        }
     @Test
     public void LoginFormTest() throws InterruptedException{
         SettingsURLsXPathsNamesOrIDs.setUrl("https://crossbrowsertesting.github.io/login-form.html");
         chromeDriver.get(SettingsURLsXPathsNamesOrIDs.getUrl());
         Thread.sleep(2000);


     }
     @AfterAll
    public static void AfterClass() throws InterruptedException{
        Thread.sleep(10000);
        chromeDriver.quit();
     }
    }
