package namtester.pages;

import common.helper.ValidateUIHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SignInPage {
    private WebDriver driver;
    private ValidateUIHelpers validateUIHelpers;

    private By emailInput = By.xpath("//input[@id='email']");
    private By passwordInput = By.xpath("//input[@id='password']");
    private By signinBtn = By.xpath("//button[@id='login_button']");

    public SignInPage(WebDriver driver) {
        this.driver = driver;
        validateUIHelpers = new ValidateUIHelpers(driver);
    }


    public DashBoardPage signin(String username, String password) throws Exception {
        validateUIHelpers.waitForPageLoaded();
        Assert.assertTrue(validateUIHelpers.verifyElementText(signinBtn, "Login"), "Không phải trang Login");
        validateUIHelpers.setText(emailInput, username);
        validateUIHelpers.setText(passwordInput, password);
        validateUIHelpers.clickElement(signinBtn);
        return new DashBoardPage(this.driver);
    }


}
