import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.io.FileWriter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class StatusCodesTest {
    public void start(String URL, WebDriver driver,
                      SettingsURLsXPathsNamesOrIDs SettingsURLsXPathsNamesOrIDs,
                      WebElementsList webElements) throws InterruptedException, IOException {
        SettingsURLsXPathsNamesOrIDs.setUrl(URL);
        driver.get(SettingsURLsXPathsNamesOrIDs.getUrl());
        Thread.sleep(2000); //Задержка для того, чтобы все элементы страницы успели отобразится
        FileWriter fileWithStatusCodes = new FileWriter("C:\\Users\\Navar\\Desktop\\Karasik\\TestNG\\StatusCodes.txt");
        webElements.setCode200(driver, SettingsURLsXPathsNamesOrIDs.getCode200Xpath());
        webElements.setCode301(driver, SettingsURLsXPathsNamesOrIDs.getCode301Xpath());
        webElements.setCode404(driver, SettingsURLsXPathsNamesOrIDs.getCode404Xpath());
        webElements.setCode500(driver, SettingsURLsXPathsNamesOrIDs.getCode500Xpath());
        List<WebElement> elements = new ArrayList<>();
        elements.add(webElements.getCode200());
        elements.add(webElements.getCode301());
        elements.add(webElements.getCode404());
        elements.add(webElements.getCode500());
        for (WebElement element:elements) {
            URL url = new URL(element.getAttribute("href"));
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            if (connection.getResponseCode()==200){
                fileWithStatusCodes.write("HTTP OK: "+connection.getResponseCode()+" \n");
            }
            if (connection.getResponseCode()==301){
                fileWithStatusCodes.write("HTTP Moved Permanently: "+connection.getResponseCode()+" \n");
            }
            if (connection.getResponseCode()==404){
                fileWithStatusCodes.write("HTTP Not Found: "+connection.getResponseCode()+" \n");
            }
            if (connection.getResponseCode()==500){
                fileWithStatusCodes.write("HTTP Internal Server Error: "+connection.getResponseCode()+" \n");
            }
        }
        fileWithStatusCodes.close();
    }
}
