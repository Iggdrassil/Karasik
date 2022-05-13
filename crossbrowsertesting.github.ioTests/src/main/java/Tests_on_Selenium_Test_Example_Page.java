import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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
    public void ClickButtonsAndEnteredFields() throws InterruptedException{
        ClickButtonsAndEnteredFieldsTest clickButtonsAndEnteredFieldsTest = new ClickButtonsAndEnteredFieldsTest();
        clickButtonsAndEnteredFieldsTest.start("https://crossbrowsertesting.github.io/selenium_example_page.html",
                chromeDriver, SettingsURLsXPathsNamesOrIDs, webElements);
    }
    @Test
    public void DragAndDrop() throws InterruptedException{
        DragAndDropTest dragAndDropTest = new DragAndDropTest();
        dragAndDropTest.start("https://crossbrowsertesting.github.io/drag-and-drop.html",
                chromeDriver, SettingsURLsXPathsNamesOrIDs, webElements);
        }
     @Test
     public void LoginForm() throws InterruptedException{
        LoginFormTest loginFormTest = new LoginFormTest();
        loginFormTest.start("https://crossbrowsertesting.github.io/login-form.html",
                chromeDriver, SettingsURLsXPathsNamesOrIDs, webElements);
     }
     @Test
     public void FileUpload() throws InterruptedException{
        FileUploadTest fileUploadTest = new FileUploadTest();
        fileUploadTest.start("https://the-internet.herokuapp.com/upload",chromeDriver, SettingsURLsXPathsNamesOrIDs, webElements);

     }
     @AfterAll
    public static void AfterClass() throws InterruptedException{
        Thread.sleep(10000);
        chromeDriver.quit();
     }
    }
