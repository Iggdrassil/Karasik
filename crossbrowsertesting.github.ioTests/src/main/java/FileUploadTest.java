import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FileUploadTest {
    /**
     *
     * @param URL = в этот параметр передается URL странцы теста
     * @param driver = сюда передается инстанс драйвера класса WebDriver.
     * @param SettingsURLsXPathsNamesOrIDs = сюда передается переменная класса SettingsURLsXPathsNamesOrIDs
     * @param webElements = сюда передается переменная класса WebElementsList
     * @throws InterruptedException
     * Это класс теста загрузки файла. Через sendKeys указывается путь к файлу, и ожидается появление в DOMe элемента
     * с текстом File Uploaded!
     */
    public void start(String URL, WebDriver driver,
                                    SettingsURLsXPathsNamesOrIDs SettingsURLsXPathsNamesOrIDs,
                                    WebElementsList webElements) throws InterruptedException {
        SettingsURLsXPathsNamesOrIDs.setUrl(URL);
        driver.get(SettingsURLsXPathsNamesOrIDs.getUrl());
        Thread.sleep(2000);
        webElements.setChooseFileButton(driver, SettingsURLsXPathsNamesOrIDs.getChooseFileButtonID());
        webElements.getChooseFileButton().sendKeys("C:\\Users\\Navar\\Desktop\\Karasik\\crossbrowsertesting.github.ioTests\\file.txt");
        webElements.setUploadButton(driver, SettingsURLsXPathsNamesOrIDs.getUploadButton());
        webElements.getUploadButton().click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='File Uploaded!']")));
        Thread.sleep(2000);


    }
}
