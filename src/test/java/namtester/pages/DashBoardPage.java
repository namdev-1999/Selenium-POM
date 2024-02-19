package namtester.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoardPage {

    private WebDriver driver;

    @FindBy(xpath = "//a[contains(text(),'Total Customer')]")
    private WebElement TotalCustomer;

    public DashBoardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public TotalCustomerPage openToTalCustomer(){
        TotalCustomer.click();
        return new TotalCustomerPage(driver);
    }
}
