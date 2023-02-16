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
        driver.manage().window().maximize();
        WebForm webForm = new WebForm(driver);

        webForm.verifyTitle();
        webForm.enterFirstName();
        Thread.sleep(500);
        webForm.enterLastName();
        Thread.sleep(500);
        webForm.enterJobTitle();
        Thread.sleep(500);
        webForm.enterEducation();
        Thread.sleep(500);
        webForm.enterSex();
        Thread.sleep(500);
        webForm.enterExperience();
        Thread.sleep(500);
        webForm.enterDate();
        Thread.sleep(1000);
        webForm.pressSubmitButton();
        Thread.sleep(1000);
        webForm.verifyAlertSuccess();
    }
    @AfterSuite
    public static void cleanUp() {
        driver.manage().deleteAllCookies();
        //driver.close();
    }
}