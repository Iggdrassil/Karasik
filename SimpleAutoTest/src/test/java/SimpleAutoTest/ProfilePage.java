package SimpleAutoTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {
    public WebDriver webDriver;
    public ProfilePage(WebDriver webDriver2){
        PageFactory.initElements(webDriver2, this); //Конструктор класса PageFactory чтобы работала аннотация FindBy
        this.webDriver = webDriver2;
    }

    //Локатор меню пользователя
    @FindBy(xpath = "//*[contains(@class, 'popup2 popup2_view_default popup2_theme_normal popup2_target_anchor popup2_autoclosable_yes popup2_alt-shadow_yes i-bem popup2_js_inited popup2_direction_bottom-right')]")
    private WebElement userMenu;

    //Локатор кнопки выхода из аккаунта
    @FindBy(xpath = "//*[contains(@aria-label, 'Выйти')]")
    private WebElement exitBtn;

    //Метод получения имени пользователя
    public String getUserName(){
        userMenu.click();
        String userName = userMenu.getText();
        return userName;
    }

    //Метод нажатия кнопки в меню пользователя
    public void prssMenuBtnn(){
        userMenu.click();
    }

    //Метод выхода
    public void logout(){
        exitBtn.click();
    }
}
