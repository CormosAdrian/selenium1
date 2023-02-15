package Formy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestPlan {
    private static final WebDriver driver = new ChromeDriver();

    @BeforeSuite
    public static void main(String[] args) {
        // ChromeDriver location set up in Utils class
        System.setProperty("webdriver.chrome.driver", Utils.CHROME_DRIVER_LOCATION);
    }

    @Test(testName = "Submit a WebForm")
     public static void submitForm() throws InterruptedException {
        driver.get(Utils.BASE_URL);
        //Assert.assertFalse(driver.getTitle().contains("Formy"));
        driver.manage().window().maximize();
        WebForm webForm = new WebForm(driver);

        webForm.enterFirstName();
        Thread.sleep(1000);
        webForm.enterLastName();
        Thread.sleep(1000);
        webForm.enterJobTitle();
        Thread.sleep(1000);
        webForm.enterEducation();
        Thread.sleep(1000);
        webForm.enterSex();
        Thread.sleep(1000);
        webForm.enterExperience();
        Thread.sleep(1000);
        webForm.enterDate();
        //WebDriverWait Wait=new WebDriverWait (driver, Duration.ofSeconds(5));
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(3000);
        webForm.pressSubmitButton();
        Thread.sleep(3000);
        webForm.verifyAlertSuccess();
    }
    @AfterSuite
    public static void cleanUp() {
        driver.manage().deleteAllCookies();
        driver.close();
    }
}