import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Простое скачивание файла. Простое - потому что делается в хроме, в котором не вызывается системное окно для выбора
 * места сохранения файла.
 */
public class SimpleFileDownloadTest {
    public void start(String URL, WebDriver driver,
                      SettingsURLsXPathsNamesOrIDs SettingsURLsXPathsNamesOrIDs,
                      WebElementsList webElements) throws InterruptedException, IOException {
        SettingsURLsXPathsNamesOrIDs.setUrl(URL);
        driver.get(SettingsURLsXPathsNamesOrIDs.getUrl());
        Thread.sleep(2000); //Задержка для того, чтобы все элементы страницы успели отобразится
        WebElement downloadFileLink = driver.findElement(By.xpath("//a[@href='download/text.txt']"));
        URL url = new URL(downloadFileLink.getAttribute("href"));
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();
        if (connection.getResponseCode()==200){
            downloadFileLink.click();
        }
    }
}
