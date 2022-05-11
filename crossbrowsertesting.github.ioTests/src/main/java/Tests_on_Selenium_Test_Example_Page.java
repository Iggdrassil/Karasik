import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class Tests_on_Selenium_Test_Example_Page {
    /*
    Здесь создаются перменные, которые понадобятся в тестах
     */
    public static WebDriver chromeDriver; //Переменная драйвера
    public static SettingsURLsXPathsNamesOrIDs SettingsURLsXPathsNamesOrIDs; //Переменная для доступа к xpath, id и тд вебэлементов
    public static WebElementsList webElements; //Переменная для доступа к  вэбэлементам, используемых в тестах

    @BeforeAll
    /*
      В BeforeClass выполняются настройки, общие для всех тестов.
      Аннтоция BeforeAll говорит о том, что этот класс нужно выполнить перед всеми внутренними классами, помеченными аннтоцаиями @Test,
      @RepeatedTest, @ParameterizedTest, and @TestFactory в текущем классе
     */
    public static void BeforeClass (){
        SettingsURLsXPathsNamesOrIDs = new SettingsURLsXPathsNamesOrIDs();
        webElements = new WebElementsList();
        SettingsURLsXPathsNamesOrIDs.setDriverName("webdriver.chrome.driver"); //Название файла драйвера
        SettingsURLsXPathsNamesOrIDs.setDriverPath("C:/Users/Navar/Desktop/Karasik/chromedriver.exe"); //Путь к файлу драйвера
        System.setProperty(SettingsURLsXPathsNamesOrIDs.getDriverName(), SettingsURLsXPathsNamesOrIDs.getDriverPath()); //Задание системных настроек
        chromeDriver = new ChromeDriver(); //Объявление инстанса драйвера
    }
    @Test
    public void ClickButtonsAndEnteredFieldsTest() throws InterruptedException{
        SettingsURLsXPathsNamesOrIDs.setUrl("https://crossbrowsertesting.github.io/selenium_example_page.html"); //Задание URL
        chromeDriver.get(SettingsURLsXPathsNamesOrIDs.getUrl()); //Получение URL
        webElements.setShowMessageButton(chromeDriver, SettingsURLsXPathsNamesOrIDs.getShowMessageButtonXPath()); //Задание вебэлемента. В метод set___ передается драйвер и локатор элеманта
        webElements.setEntryField(chromeDriver, SettingsURLsXPathsNamesOrIDs.getEntryFieldXPath());
        webElements.setCheckBox(chromeDriver, SettingsURLsXPathsNamesOrIDs.getCheckBoxXPath());
        webElements.setDropdownList(chromeDriver, SettingsURLsXPathsNamesOrIDs.getDropdownListXPath());
        webElements.setRadioButton(chromeDriver, SettingsURLsXPathsNamesOrIDs.getRadioButtonID());
        webElements.setTextArea(chromeDriver, SettingsURLsXPathsNamesOrIDs.getTextAreaName());
        webElements.setSubmitButton(chromeDriver, SettingsURLsXPathsNamesOrIDs.getSubmitButtonID());
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
         webElements.setNameField(chromeDriver,SettingsURLsXPathsNamesOrIDs.getUsernameFieldID());
         webElements.setPassField(chromeDriver,SettingsURLsXPathsNamesOrIDs.getPassFieldID());
         webElements.setLoginButton(chromeDriver, SettingsURLsXPathsNamesOrIDs.getLoginButtonText());
         webElements.getNameField().sendKeys("tester@crossbrowsertesting.com");
         webElements.getPassField().sendKeys("test123");
         webElements.getLoginButton().click();
         WebDriverWait wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(50));
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()=\"You are now logged in!\"]"))); //Ожидание появления текста You are now  logged in!
         Thread.sleep(2000);


     }
     @AfterAll
    public static void AfterClass() throws InterruptedException{
        Thread.sleep(10000);
        chromeDriver.quit();
     }
    }
