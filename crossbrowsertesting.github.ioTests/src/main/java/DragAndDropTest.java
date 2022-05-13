import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropTest {
    /**
     *
     * @param URL = в этот параметр передается URL странцы теста
     * @param driver  = сюда передается инстанс драйвера класса WebDriver.
     * @param SettingsURLsXPathsNamesOrIDs  = сюда передается переменная класса SettingsURLsXPathsNamesOrIDs
     * @param webElements  = сюда передается переменная класса WebElementsList
     * @throws InterruptedException
     * Это класс теста функционала DragNDrop. Один элемент перетягивается на другой с помощью Actions dragAndDropAction.
     */
    public void start(String URL, WebDriver driver,
                                                       SettingsURLsXPathsNamesOrIDs SettingsURLsXPathsNamesOrIDs,
                                                       WebElementsList webElements) throws InterruptedException{
        SettingsURLsXPathsNamesOrIDs.setUrl(URL);
        driver.get(SettingsURLsXPathsNamesOrIDs.getUrl());
        Thread.sleep(2000);
        webElements.setDraggable(driver, SettingsURLsXPathsNamesOrIDs.getDraggableID());
        webElements.setDroppable(driver, SettingsURLsXPathsNamesOrIDs.getDroppableID());
        Actions dragAndDropAction = new Actions(driver);
        dragAndDropAction.pause(5000).dragAndDrop(webElements.getDraggable(),webElements.getDroppable()).pause(5000).build().perform();
    }

}
