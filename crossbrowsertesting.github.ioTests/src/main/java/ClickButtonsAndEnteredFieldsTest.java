import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class ClickButtonsAndEnteredFieldsTest {
    public  void startClickButtonsAndEnteredFieldsTest(String URL, WebDriver driver,
                                                             SettingsURLsXPathsNamesOrIDs SettingsURLsXPathsNamesOrIDs,
                                                             WebElementsList webElements) throws InterruptedException{
        SettingsURLsXPathsNamesOrIDs.setUrl(URL); //Задание URL
        driver.get(SettingsURLsXPathsNamesOrIDs.getUrl()); //Получение URL
        webElements.setShowMessageButton(driver, SettingsURLsXPathsNamesOrIDs.getShowMessageButtonXPath()); //Задание вебэлемента. В метод set___ передается драйвер и локатор элеманта
        webElements.setEntryField(driver, SettingsURLsXPathsNamesOrIDs.getEntryFieldXPath());
        webElements.setCheckBox(driver, SettingsURLsXPathsNamesOrIDs.getCheckBoxXPath());
        webElements.setDropdownList(driver, SettingsURLsXPathsNamesOrIDs.getDropdownListXPath());
        webElements.setRadioButton(driver, SettingsURLsXPathsNamesOrIDs.getRadioButtonID());
        webElements.setTextArea(driver, SettingsURLsXPathsNamesOrIDs.getTextAreaName());
        webElements.setSubmitButton(driver, SettingsURLsXPathsNamesOrIDs.getSubmitButtonID());
        Thread.sleep(2000);
        webElements.getShowMessageButton().click();
        Thread.sleep(2000);
        webElements.getEntryField().sendKeys("SomeTestText");
        webElements.getCheckBox().click();
        webElements.getDropdownList().click();
        webElements.getDropdownList().sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
        webElements.getRadioButton().click();
        webElements.getTextArea().sendKeys("Entered Some text for test");
        webElements.getEntryField().clear();
        webElements.getEntryField().sendKeys("New Text");
        Thread.sleep(2000);
        webElements.getSubmitButton().click();
    }

}
