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
    @FindBy(xpath = "//*[contains(@class, 'menu menu_type_navigation menu_view_classic legouser__menu i-bem')]")
    private WebElement userMenu;

    //Локатор кнопки выхода из аккаунта
    @FindBy(xpath = "//*[contains(@class, 'menu__item menu__item_type_link count-me legouser__menu-item legouser__menu-item_action_exit legouser__menu-item legouser__menu-item_action_exit')]")
    private WebElement exitBtn;

    //Метод получения имени пользователя
    public String getUserName(){
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
