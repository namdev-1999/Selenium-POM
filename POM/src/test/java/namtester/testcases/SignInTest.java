package namtester.testcases;

import common.helper.ExcelHelpers;
import namtester.base.BaseSetup;
import common.helper.ValidateUIHelpers;
import namtester.pages.DashBoardPage;
import namtester.pages.SignInPage;
import namtester.pages.TotalCustomerPage;
import org.junit.experimental.theories.Theories;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;

public class SignInTest extends BaseSetup {

    private WebDriver driver;
    public SignInPage signInPage;
    public DashBoardPage dashBoardPage;
    public TotalCustomerPage totalCustomerPage;
    private ValidateUIHelpers validateUIHelpers;
    private ExcelHelpers excelHelpers;

    @BeforeClass
    public void setUp() {
        driver = new BaseSetup().setUpDriver("chrome");
        validateUIHelpers = new ValidateUIHelpers(driver);
        excelHelpers = new ExcelHelpers();

    }

    @Test(priority = 1)
    public void signIn(ITestContext result) throws Exception {
        excelHelpers.setExcelFile("/resources/Book1.xlsx", "Sheet1");
        signInPage = new SignInPage(driver);
        driver.get(new BaseSetup().getUrl());

        dashBoardPage = signInPage.signin(excelHelpers.getCellData("username", 1),
                excelHelpers.getCellData("password", 1));
        validateUIHelpers.waitForPageLoaded();

        Thread.sleep(5000);
    }

    public void openTotalCustomer() throws Exception {
        totalCustomerPage = dashBoardPage.openToTalCustomer();
    }

    @AfterClass
    public void close() {
        driver.close();
        driver.quit();
    }
}
