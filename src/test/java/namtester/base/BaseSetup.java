package namtester.base;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.*;

public class BaseSetup {

    private WebDriver driver;
    static String driverPath = "resources\\drivers\\";

    private String url = "https://demo.rajodiya.com/erpgo-saas/login";

    public WebDriver getDriver() {
        return driver;
    }

    private final int PageLoadTimeout = 30;
    private final int ImplicitlyWait = 20;

    public String getUrl() {
        return url;
    }

    //Hàm này để tùy chọn Browser. Cho chạy trước khi gọi class này (BeforeClass)
    public WebDriver setUpDriver(String browserType) {
        switch (browserType.trim().toLowerCase()) {
            case "chrome" -> driver = initChromeDriver();
            case "firefox" -> driver = initFirefoxDriver();
            case "opera" -> driver = initOperaDriver();
            case "edge" -> driver = initEdgeDriver();
            default -> {
                System.out.println("Browser: " + browserType + " is invalid, Launching Chrome as browser of choice...");
                driver = initChromeDriver();
            }
        }
        return driver;
    }

    public void setDriver(String browserType, String webURL) {
        switch (browserType) {
            case "chrome" -> {
                driver = initChromeDriver();
                driver.navigate().to(webURL);
            }
            case "firefox" -> {
                driver = initFirefoxDriver();
                driver.navigate().to(webURL);
            }
            case "opera" -> {
                driver = initOperaDriver();
                driver.navigate().to(webURL);
            }
            case "edge" -> {
                driver = initEdgeDriver();
                driver.navigate().to(webURL);
            }
            default -> {
                System.out.println("Browser: " + browserType + " is invalid, Launching Chrome as browser of choice...");
                driver = initChromeDriver();
            }
        }
    }

    //Khởi tạo cấu hình của các Browser để đưa vào Switch Case

    private WebDriver initChromeDriver() {
        System.out.println("Launching Chrome browser...");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(PageLoadTimeout, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(ImplicitlyWait, TimeUnit.SECONDS);
        return driver;
    }

    private WebDriver initFirefoxDriver() {
        System.out.println("Launching Firefox browser...");
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(PageLoadTimeout, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(ImplicitlyWait, TimeUnit.SECONDS);
        return driver;
    }

    private WebDriver initOperaDriver() {
        System.out.println("Launching Opera browser...");
        WebDriverManager.operadriver().setup();
        driver = new OperaDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(PageLoadTimeout, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(ImplicitlyWait, TimeUnit.SECONDS);
        return driver;
    }

    private WebDriver initEdgeDriver() {
        System.out.println("Launching Opera browser...");
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(PageLoadTimeout, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(ImplicitlyWait, TimeUnit.SECONDS);
        return driver;
    }

//    // Chạy hàm initializeTestBaseSetup trước hết khi class này được gọi
//    @Parameters({"browserType", "webURL"})
//    @BeforeSuite
//    public void initializeTestBaseSetup(String browserType, String webURL) {
//        try {
//            // Khởi tạo driver và browser
//            setDriver(browserType,webURL);
//        } catch (Exception e) {
//            System.out.println("Error..." + Arrays.toString(e.getStackTrace()));
//        }
//    }
//
//    @AfterClass
//    public void tearDown() throws Exception {
//        Thread.sleep(2000);
//        driver.quit();
//    }
}
