import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import static org.assertj.core.api.Assertions.*;

public class CinkciarzTests {
    private WebDriver driver;
    @Before
    public void seUp(){

        System.setProperty("webdriver.chrome.driver","files\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void CheckIt() throws Exception{
        String actualPhrase = "";
        String baseUrl = "https://cinkciarz.pl/";
        String expectedPhrase = "231,27";


        driver.get(baseUrl);
        driver.findElement(By.id("amount-in")).sendKeys("1000");
        driver.findElement(By.cssSelector("#calculator > form > div:nth-child(3) > div > button.btn.btn-style-03.btn-primary.ml-16.d-lg-none")).submit();
        Thread.sleep(4000);
     assertThat(driver.findElement(By.id("amount-out")).getAttribute("value").contains("23"));





    }

    @After
    public void tearDown(){
        driver.quit();


    }


}