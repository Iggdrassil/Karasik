package SimpleAutoTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;


public class FirstTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver","D:/Intellij IDEA Projects/SimpleAutoTest/geckodriver.exe"); //зависимость, определяющая путь к webdriver.gecko.driver
        WebDriver firefox = new FirefoxDriver();  //Создание объекта драйвера
        firefox.manage().window().maximize(); //Чтобы ход теста отображался в полностью открытом окне
        firefox.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); /* неявное ожидание Implicitly Wait,
        если элемент не найден, то драйвер будет ждать его появления в течении заданного времени (10 секунд) и шагом
        в 500 мс. Как только элемент будет найден, драйвер продолжит работу,
        однако, в противном случае тест упадем по истечению времени. */
        firefox.get("https://passport.yandex.ru/auth/welcome?origin=home_yandexid&retpath=https%3A%2F%2Fyandex.ru&backpath=https%3A%2F%2Fyandex.ru"); // передача драйверу адреса страницы

    }



}