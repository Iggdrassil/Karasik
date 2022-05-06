import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tests_on_Selenium_Test_Example_Page {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:/Users/Navar/Desktop/Karasik/chromedriver.exe");
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://crossbrowsertesting.github.io/selenium_example_page.html");
        Thread.sleep(2000);
        WebElement showMessageButton = chromeDriver.findElement(By.xpath("//button[@id=\"btn\"]"));
        WebElement entryField = chromeDriver.findElement(By.xpath("//input[@type=\"text\"]"));
        WebElement checkBox = chromeDriver.findElement(By.xpath("//input[@type=\"checkbox\"]"));
        WebElement dropdownList = chromeDriver.findElement(By.xpath("//select[@id=\"dropdown\"]"));
        WebElement radioButton = chromeDriver.findElement(By.id("radiobtn1"));
        WebElement textArea = chromeDriver.findElement(By.name("textarea"));
        WebElement submitButton = chromeDriver.findElement(By.id("submitbtn"));
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
}
