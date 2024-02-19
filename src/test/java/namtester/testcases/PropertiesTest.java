package namtester.testcases;

import namtester.base.BaseSetup;
import namtester.pages.SignInPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ultilities.PropertiesFile;

public class PropertiesTest {

    private WebDriver driver;
    private SignInPage signInPage;

    @BeforeClass
    public void createDriver() {
        // Gọi hàm để khởi tạo file properties
        PropertiesFile.setPropertiesFile();

        // Đọc data từ file properties với key là "browser"
        driver = new BaseSetup().setUpDriver(PropertiesFile.getPropValue("browser"));
    }

    @Test
    public void signinCRM() throws Exception {
        signInPage = new SignInPage(driver);
        driver.get("https://demo.rajodiya.com/erpgo-saas/login");

        // Đọc data từ file properties
        signInPage.signin(PropertiesFile.getPropValue("username"),PropertiesFile.getPropValue("password"));

    }

    @AfterClass
    public void closeDriver() {
        driver.quit();
    }
}
