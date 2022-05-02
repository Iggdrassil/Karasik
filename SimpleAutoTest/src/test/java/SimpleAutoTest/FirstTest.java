package SimpleAutoTest;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;


public class FirstTest {
    public static LoginPage loginPage;
    public static ProfilePage profilePage;
    public static WebDriver webDriver;
    @BeforeClass //Аннотация говорит о том, что этот участок кода является подготовкой к тесту
    public static void beforeTest() {
        System.setProperty("webdriver.gecko.driver","C:/Users/Navar/Desktop/Karasik/geckodriver.exe"); //зависимость, определяющая путь к webdriver.gecko.driver
        webDriver = new FirefoxDriver();  //Создание объекта драйвера
        loginPage = new LoginPage(webDriver);
        profilePage = new ProfilePage(webDriver);
        webDriver.manage().window().maximize(); //Чтобы ход теста отображался в полностью открытом окне
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); /* неявное ожидание Implicitly Wait,
        если элемент не найден, то драйвер будет ждать его появления в течении заданного времени (10 секунд) и шагом
        в 500 мс. Как только элемент будет найден, драйвер продолжит работу,
        однако, в противном случае тест упадет по истечению времени. */
        webDriver.get(ConfProperties.getProp("loginpage")); // передача драйверу адреса страницы
    }
    @Test //Аннотация самого теста
    public void LoginTest () {
        loginPage.InputLogin(ConfProperties.getProp("login")); //Ввод логина
        loginPage.ClickLoginBtn(); //Нажатие кнопки входа
        loginPage.InputPass(ConfProperties.getProp("pass")); //Ввод пароля
        loginPage.ClickLoginBtn(); //Нажатие кнопки входа
        String userTest = profilePage.getUserName();
        Assert.assertEquals(ConfProperties.getProp("login"), userTest);
    }
    @AfterClass //Завершение теста
    public static void End (){
        //profilePage.prssMenuBtnn(); //Открытие меню пользователя
        webDriver.get("https://passport.yandex.ru/profile");
        webDriver.findElement(By.xpath("//div[contains(@class,'user-pic user-pic_has-plus_')]//img")).click();
        webDriver.findElement(By.xpath("//span[text()='Выйти']")).click();
        //profilePage.logout(); //Нажатие кнопки выхода
        webDriver.quit(); //Закрытие окна браузера
    }
}