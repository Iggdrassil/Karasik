import org.omg.CORBA.TIMEOUT;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v99.indexeddb.model.Key;
import sun.awt.SunHints;

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
        String elementGetText = element0.getText(); //Получение текста элемента так, как он отображается в юраузере
        String elementAttr = element0.getAttribute("innerText"); //Получение атрибута найденного элемента
        System.out.printf(elementAttr, elementGetText);
        element0.click(); //нажатие найденного элемента
        WebElement element1 = chromeDriver.findElement(By.xpath("//a[@class=\"tm-header-user-menu__item tm-header-user-menu__search\"]"));
        element1.click();
        WebElement element2 = chromeDriver.findElement(By.xpath("//input[@name=\"q\"]"));//Локатор элемента поиска
        element2.sendKeys("Java", Keys.ENTER); //Ввод значения в поле поиска и нажатие клавиши Enter для начала поиска



    }
}
