import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import sun.security.util.Password;

import static org.assertj.core.api.Assertions.*;

public class Guru99Tests {
    private WebDriver driver;
    @Before
    public void seUp(){

        System.setProperty("webdriver.chrome.driver","files\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void CheckIfUserCanLogIn() throws Exception{
        String actualTittle = "";
        String baseUrl = "http://demo.guru99.com/V4";
        String actualName = "";
        String expectedName = "Guru99 Bank";

        driver.get(baseUrl);
        driver.findElement(By.name("uid")).sendKeys("mgr123");
        driver.findElement(By.name("password")).sendKeys("mgr!23");
        driver.findElement(By.name("btnLogin")).click();
        Thread.sleep(4000);
        actualName = driver.findElement(By.className("barone")).getText();

        assertThat(actualName).isEqualTo(expectedName);



    }
    @Test
    public void CheckIfTitleSuccesfullyIsOK() throws Exception{
        String baseUrl = "https://demo.guru99.com/test/login.html";
        driver.get(baseUrl);
        String actualText = " ";
        String expectedText = "Successfully Logged in...";

        driver.findElement(By.name("email")).sendKeys("abc@gmail.com");
        driver.findElement(By.name("passwd")).sendKeys("abc");
        driver.findElement(By.id("SubmitLogin")).submit();
        Thread.sleep(8000);


        actualText = driver.findElement(By.className("error-copy")).getText();

        assertThat(actualText).isEqualTo(expectedText);
    }

    @After
    public void tearDown(){
        driver.quit();


    }


}
