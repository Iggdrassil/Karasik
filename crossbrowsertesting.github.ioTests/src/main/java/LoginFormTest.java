import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginFormTest {
    public void startLoginFormTest(String URL, WebDriver driver,
                                     SettingsURLsXPathsNamesOrIDs SettingsURLsXPathsNamesOrIDs,
                                     WebElementsList webElements) throws InterruptedException {
        SettingsURLsXPathsNamesOrIDs.setUrl(URL);
        driver.get(SettingsURLsXPathsNamesOrIDs.getUrl());
        Thread.sleep(2000);
        webElements.setNameField(driver,SettingsURLsXPathsNamesOrIDs.getUsernameFieldID());
        webElements.setPassField(driver,SettingsURLsXPathsNamesOrIDs.getPassFieldID());
        webElements.setLoginButton(driver, SettingsURLsXPathsNamesOrIDs.getLoginButtonText());
        webElements.getNameField().sendKeys("tester@crossbrowsertesting.com");
        webElements.getPassField().sendKeys("test123");
        webElements.getLoginButton().click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()=\"You are now logged in!\"]"))); //Ожидание появления текста You are now  logged in!
        Thread.sleep(2000);
    }
}
