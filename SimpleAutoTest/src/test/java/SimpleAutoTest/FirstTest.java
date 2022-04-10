package SimpleAutoTest;

import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;


public class FirstTest {
    public static LoginPage loginPage;
    public static ProfilePage profilePage;
    public static WebDriver webDriver;
    @BeforeClass //Аннотация говорит о том, что этот участок кода является подготовкой к тесту
    public static void beforeTest(String[] args) {
        loginPage = new LoginPage(webDriver);
        profilePage = new ProfilePage(webDriver);
        System.setProperty("webdriver.gecko.driver","D:/Intellij IDEA Projects/SimpleAutoTest/geckodriver.exe"); //зависимость, определяющая путь к webdriver.gecko.driver
        webDriver = new FirefoxDriver();  //Создание объекта драйвера
        webDriver.manage().window().maximize(); //Чтобы ход теста отображался в полностью открытом окне
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); /* неявное ожидание Implicitly Wait,
        если элемент не найден, то драйвер будет ждать его появления в течении заданного времени (10 секунд) и шагом
        в 500 мс. Как только элемент будет найден, драйвер продолжит работу,
        однако, в противном случае тест упадет по истечению времени. */
        webDriver.get("https://passport.yandex.ru/auth/welcome?origin=home_yandexid&retpath=https%3A%2F%2Fyandex.ru&backpath=https%3A%2F%2Fyandex.ru"); // передача драйверу адреса страницы
    }
}