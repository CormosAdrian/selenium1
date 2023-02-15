package Ex1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ArduShop {
    WebDriver driver;
    @BeforeClass
     void testGoogle() {
        //create driver
      System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver= new ChromeDriver();

      // System.setProperty("webdriver.gecko.driver","C:\\Users\\Ale\\IdeaProjects\\Selenium1\\src\\main\\resources\\geckodriver.exe");
       //driver=new FirefoxDriver();


       //driver.manage().deleteAllCookies();
       //driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
       //driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);

        String url = "https://ardushop.ro/ro/";
        driver.get(url);
        System.out.println("Opening ArduShop Page");
        driver.manage().window().maximize();
    }
    @Test
    void logotest() {
        WebElement logo = driver.findElement(By.cssSelector("#header_logo"));
        Assert.assertTrue(logo.isDisplayed(),"The logo is not displayed!");
    }
    @Test

      void Pagetitle() {
            String title = driver.getTitle();
            Assert.assertEquals("ArduShop - ARDUSHOP", title);
        }
        @Test
        void Serch() throws InterruptedException {

            WebElement serchBar = driver.findElement(By.id("search_query_top"));
            serchBar.sendKeys("Ramps 1.5");
            serchBar.sendKeys(Keys.ENTER);
            Thread.sleep(500);

            WebElement sortare = driver.findElement(By.id("selectProductSort"));
            Select selectSortare = new Select(sortare);
            selectSortare.selectByValue("reference:asc");

        }

            @Test
           private void Produs() throws InterruptedException {
        Thread.sleep(500);

             //WebElement verificaStocul= driver.findElement(By.cssSelector("#center_column > h1 > span.heading-counter"));
                //WebElement verificaStocul = driver.findElement(By.xpath("//*[@id="center_column"]/h1/span[2]"));
               // WebElement verificaStocul = driver.findElement(By.xpath("//*[@id='center_column']/h1/span[2]"));
                WebElement verificaRezultate = driver.findElement(By.id("center_column"));
                String rezultate=" au fost gasite 0 rezultate. ";
                // String rezultate = " au fost gasite rezultate. ";
                Assert.assertFalse(verificaRezultate.getText().contains(rezultate),"Nu exista produsul !");

                //WebElement verificaStocul = driver.findElement(By.xpath("//*[@id='center_column']/ul/li[1]/div/div[2]/span/span"));
               // WebElement verificaStocul = driver.findElement(By.xpath("(//span[contains(@class,'label-success')][normalize-space()='In stoc'])[1]"));
                //WebElement verificaStocul = driver.findElement(By.cssSelector("#center_column > ul > li.ajax_block_product.col-xs-12.col-sm-6.col-md-4.col-lg-3.first-in-line.first-item-of-tablet-line.first-item-of-mobile-line > div > div.right-block > span > span"));
                WebElement verificaStocul = driver.findElement(By.cssSelector("li[class='ajax_block_product col-xs-12 col-sm-6 col-md-4 col-lg-3 first-in-line first-item-of-tablet-line first-item-of-mobile-line'] span[class=' label-success']"));
               String inStoc = " In stoc ";
                Assert.assertTrue(verificaRezultate.getText().contains(inStoc),"Produsul nu se afla in stock");


               WebElement adaugaInCos= driver.findElement(By.xpath("(//span[contains(text(),'Adauga in cos')])[1]"));
               adaugaInCos.click();
               Thread.sleep(1000);


                WebElement finalComanda= driver.findElement(By.xpath("(//span[contains(text(),'Finalizează comanda')])[1]"));
                finalComanda.click();



                WebElement sumarCos=driver.findElement(By.id("summary_products_quantity"));
                String cos="1 produs";
                Assert.assertTrue(sumarCos.getText().contains(cos),"Nu a fost adaugat in cos/ Sunt mai mult de un produs in cos!");


        }
      @AfterClass
    void tearDown(){
          driver.manage().deleteAllCookies();
        //driver.quit();
      }
    }
