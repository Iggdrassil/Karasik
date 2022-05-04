import org.omg.CORBA.TIMEOUT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:/Users/Navar/Desktop/Karasik/chromedriver.exe"); //Путь к файлу драйвера
        WebDriver chromeDriver = new ChromeDriver(); //Создание нового инстанса драйвера
        chromeDriver.get("https://habr.com/ru/"); //Открытие любого url
        WebElement element0 = chromeDriver.findElement(By.xpath("//a[@href=\"/ru/news/\"][@class=\"tm-tabs__tab-link\"]")); //Локатор по xpath(поиск одного элемента на странице)
        chromeDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // Задание явного ожидания(такой вид задания ожидания устарел)
        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // Задание явного ожидания(актуальный метод)

        element0.click(); //нажатие найденного элемента

    }
}
