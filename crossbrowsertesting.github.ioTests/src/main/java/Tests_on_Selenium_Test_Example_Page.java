import org.junit.jupiter.api.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.fail;


//TODO Добавить логгирование в файл(уровня INFO, ERROR)
//TODO Добавить обработку исключений, если не найден веб-элемент на странице
//TODO Написать тесты для работы с всплывающими окнами, выгрузки файла, с переключением страниц
//TODO Написать Assert проверки
//TODO Поработать с JUnit и TestNG

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Tests_on_Selenium_Test_Example_Page {
    /*
    Здесь создаются перeменные, которые понадобятся в тестах
     */
    public static WebDriver chromeDriver; //Переменная драйвера
    public static SettingsURLsXPathsNamesOrIDs SettingsURLsXPathsNamesOrIDs; //Переменная для доступа к xpath, id и тд вебэлементов
    public static WebElementsList webElements; //Переменная для доступа к  вэбэлементам, используемых в тестах
    public final static Logger logger = LogManager.getLogger();

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
        try {
            System.setProperty(SettingsURLsXPathsNamesOrIDs.getDriverName(), SettingsURLsXPathsNamesOrIDs.getDriverPath()); //Задание системных настроек
            chromeDriver = new ChromeDriver(); //Объявление инстанса драйвера
        } catch (WebDriverException e){
            logger.error("WebDriver error", e.getSystemInformation(), e.getStackTrace(), e.getCause());
            fail(e.getCause());
        }
    }

    @Test
    @Order(1)
    public void ClickButtonsAndEnteredFields() throws InterruptedException{
        logger.info("ClickButtonsAndEnteredFields Test Start");
        try {
            ClickButtonsAndEnteredFieldsTest clickButtonsAndEnteredFieldsTest = new ClickButtonsAndEnteredFieldsTest();
            clickButtonsAndEnteredFieldsTest.start("https://crossbrowsertesting.github.io/selenium_example_page.html",
                    chromeDriver, SettingsURLsXPathsNamesOrIDs, webElements);
        } catch (NoSuchElementException e){
            logger.error("WebElement not found! \n"+ e.getMessage());
            logger.info("Test "+ClickButtonsAndEnteredFieldsTest.class+ " Failed!");
            fail();
        } finally {
            logger.info("ClickButtonsAndEnteredFields Test End");
        }
    }

    @Test
    @Order(2)
    public void DragAndDrop() throws InterruptedException{
        logger.info("DragAndDrop Test Start");
        try {
            DragAndDropTest dragAndDropTest = new DragAndDropTest();
            dragAndDropTest.start("https://crossbrowsertesting.github.io/drag-and-drop.html",
                    chromeDriver, SettingsURLsXPathsNamesOrIDs, webElements);
        } catch (NoSuchElementException e){
            logger.error("WebElement not found! \n"+ e.getMessage());
            logger.info("Test "+DragAndDropTest.class+ " Failed!");
            fail();
        }finally {
            logger.info("DragAndDrop Test End");
        }
    }

     @Test
     @Order(3)
     public void LoginForm() throws InterruptedException{
        logger.info("LoginForm Test Start");
        try {
            LoginFormTest loginFormTest = new LoginFormTest();
            loginFormTest.start("https://crossbrowsertesting.github.io/login-form.html",
                chromeDriver, SettingsURLsXPathsNamesOrIDs, webElements);
        }catch (NoSuchElementException e){
            logger.error("WebElement not found! \n"+ e.getMessage());
            logger.info("Test "+LoginFormTest.class+ " Failed!");
            fail();
        } finally {
            logger.info("LoginForm Test End");
        }
     }

     @Test
     @Order(4)
     public void FileUpload() throws InterruptedException{
        logger.info("FileUpload Test Start");
        try {
            FileUploadTest fileUploadTest = new FileUploadTest();
            fileUploadTest.start("https://the-internet.herokuapp.com/upload",chromeDriver, SettingsURLsXPathsNamesOrIDs, webElements);
        } catch (NoSuchElementException e){
            logger.error("WebElement not found! \n"+ e.getMessage());
            logger.info("Test "+FileUploadTest.class+ " Failed!");
            fail();
        } finally {
            logger.info("FileUpload Test End");
        }
     }
     @Test
     @Order(5)
     public void PopUpWindows() throws InterruptedException{
        logger.info("PopUpWindows Test Start");
        try {
            PopUpWindowsTest popUpWindowsTest = new PopUpWindowsTest();
            popUpWindowsTest.start("https://the-internet.herokuapp.com/javascript_alerts", chromeDriver, SettingsURLsXPathsNamesOrIDs, webElements);
        } catch (NoSuchElementException e){
            logger.error("WebElement not found! \n"+ e.getMessage());
            logger.info("Test "+PopUpWindowsTest.class+ " Failed!");
            fail();
        } catch (TimeoutException e){
            logger.error("WebElement Timeout \n"+ e.getMessage());
            logger.info("Test "+PopUpWindowsTest.class+ " Failed!");
            fail();
        }finally {
            logger.info("FileUpload Test End");
        }
     }

     @AfterAll
    public static void AfterClass() throws InterruptedException{
        Thread.sleep(10000);
        chromeDriver.quit();
        logger.info("All Tests Ends");
    }
}
