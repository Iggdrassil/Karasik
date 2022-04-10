package SimpleAutoTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public WebDriver webDriver;
    public LoginPage(WebDriver webDriver2){
        PageFactory.initElements(webDriver2, this); //Конструктор класса PageFactory чтобы работала аннотация FindBy
        this.webDriver = webDriver2;
    }

    //Локатор поля логина
    @FindBy(xpath = "//*[contains(@id, 'passp-field-login')]")
    private WebElement loginField;

    //Локатор кнопки "Войти"
    @FindBy(xpath = "//*[contains(@id, 'passp:sign-in')]")
    private WebElement SighInButton;

    //Локатор поля ввода пароля
    @FindBy(xpath = "//*[contains(@id, 'passp-field-passwd')]")
    private WebElement passField;

    public void InputLogin (String login) { //метод ввода логина
        loginField.sendKeys(login);
    }

    public void InputPass (String pass) { //метод ввода пароля
        passField.sendKeys(pass);
    }

    public void ClickLoginBtn (){ //Метод нажатия кнопки входа
        SighInButton.click();
    }

}
