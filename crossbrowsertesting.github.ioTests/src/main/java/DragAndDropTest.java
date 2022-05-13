import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropTest {
    public void startDragAndDropTest(String URL, WebDriver driver,
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
