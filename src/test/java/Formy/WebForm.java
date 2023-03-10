package Formy;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebForm extends PageObject{
    private final String FIRST_NAME = "Cormos";
    private final String LAST_NAME = "Adrian";
    private final String JOB_TITLE= "Automated Tester";
   // private final String LEVEL_EDUCATION="High School";

    @FindBy(id = "first-name")
    private WebElement first_name;

    @FindBy(id = "last-name")
    private WebElement last_name;
    @FindBy(id="job-title")
    private WebElement job_title;
    @FindBy(id="radio-button-1")
    private  WebElement education_hs;
    @FindBy(id ="checkbox-1" )
    private WebElement choose_sex_masculin;
    @FindBy(id="select-menu")
    private WebElement experience;
    @FindBy(id="datepicker")
    private WebElement chosee_date;

    @FindBy(xpath = "//a[contains(text(),'Submit')]")
    private WebElement submit_button;

    @FindBy(xpath = "//div[contains(text(),'The form was successfully submitted!')]")
    private WebElement alertSuccess;

    @FindBy(css="body > div > h1")
    private WebElement showTitle;




    public WebForm(WebDriver driver) {
        super(driver);
    }

    public void enterFirstName(){
        this.first_name.sendKeys(FIRST_NAME);
    }

    public void enterLastName(){
        this.last_name.sendKeys(LAST_NAME);
    }
    public void enterJobTitle(){
        this.job_title.sendKeys(JOB_TITLE);
    }
    public void enterEducation(){
        this.education_hs.click();
    }
    public void enterSex(){
        this.choose_sex_masculin.click();
    }
    public void enterExperience() {
        this.experience.click();
        this.experience.sendKeys("0");
        this.experience.click();
    }
    public void enterDate(){
        this.chosee_date.click();
        this.chosee_date.sendKeys(Keys.ENTER);

    }

    public void pressSubmitButton(){
        this.submit_button.click();
    }

    public void verifyAlertSuccess(){
        this.alertSuccess.isDisplayed();
    }
    public void verifyTitle(){
        this.showTitle.isDisplayed();
    }


}
