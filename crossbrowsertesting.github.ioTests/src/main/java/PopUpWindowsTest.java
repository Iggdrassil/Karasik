import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PopUpWindowsTest {
    public void start(String URL, WebDriver driver,
                      SettingsURLsXPathsNamesOrIDs SettingsURLsXPathsNamesOrIDs,
                      WebElementsList webElements) throws InterruptedException{
        SettingsURLsXPathsNamesOrIDs.setUrl(URL);
        driver.get(SettingsURLsXPathsNamesOrIDs.getUrl());
        Thread.sleep(2000); //Задержка для того, чтобы все элементы страницы успели отобразится
        webElements.setAlertButton(driver, SettingsURLsXPathsNamesOrIDs.getAlertButtonXpath());
        webElements.setConfirmButton(driver, SettingsURLsXPathsNamesOrIDs.getConfirmButtonXpath());
        webElements.setPromptButton(driver, SettingsURLsXPathsNamesOrIDs.getPromptButtonXpath());

        webElements.getAlertButton().click();
        //Alert alertFromAlertButton = driver.switchTo().alert(); //Не очень хорошо так делать, есть риск того, что при выполнении алерта может не оказаться
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        Alert alertFromAlertButton = wait.until(ExpectedConditions.alertIsPresent()); //Переключение в тот момент, когда алерт появился
        Thread.sleep(2000);//Эта задержка нужна только для того, что бы увидеть, как нажимается кнопка, т.к. без неё кнопка нажимается очень быстро
        alertFromAlertButton.accept(); //Нажатие на кнопку
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='You successfully clicked an alert']")));

        Thread.sleep(2000);//Эта задержка нужна только для того, что бы увидеть, как нажимается кнопка, т.к. без неё кнопка нажимается очень быстро
        webElements.getConfirmButton().click();
        Alert alertFormConfirmButton = wait.until(ExpectedConditions.alertIsPresent());
        Thread.sleep(2000);//Эта задержка нужна только для того, что бы увидеть, как нажимается кнопка, т.к. без неё кнопка нажимается очень быстро
        alertFormConfirmButton.dismiss();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='You clicked: Cancel']")));
        Thread.sleep(2000);//Эта задержка нужна только для того, что бы увидеть, как нажимается кнопка, т.к. без неё кнопка нажимается очень быстро
        webElements.getConfirmButton().click();
        Thread.sleep(2000);//Эта задержка нужна только для того, что бы увидеть, как нажимается кнопка, т.к. без неё кнопка нажимается очень быстро
        alertFormConfirmButton.accept();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='You clicked: Ok']")));

        webElements.getPromptButton().click();
        Alert alertFormPromptButton= wait.until(ExpectedConditions.alertIsPresent());
        Thread.sleep(2000);//Эта задержка нужна только для того, что бы увидеть, как нажимается кнопка, т.к. без неё кнопка нажимается очень быстро
        alertFormPromptButton.sendKeys("Test text");
        Thread.sleep(2000);//Эта задержка нужна только для того, что бы увидеть, как нажимается кнопка, т.к. без неё кнопка нажимается очень быстро
        alertFormPromptButton.accept();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='You entered: Test text']")));


    }
}
