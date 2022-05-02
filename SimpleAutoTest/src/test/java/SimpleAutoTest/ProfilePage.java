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
    @FindBy(xpath = "//*[contains(@class, 'home-link usermenu-link__control home-link_black_yes')]")
    private WebElement userMenu;

    //Локатор кнопки выхода из аккаунта
    @FindBy(xpath = "//div[contains(@class, 'PageHeader-user')]")
    private WebElement exitBtn;

    //Метод получения имени пользователя
    public String getUserName(){
        userMenu.click();
        String userName = userMenu.getText();
        return userName;
    }

}
