import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.assertj.core.api.Assertions.*;

public class MercuryToursTests {
    private WebDriver driver;

    @Before
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "files\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void CheckIt() throws InterruptedException {
        String actualTittle = "";
        String baseUrl = "http://newtours.demoaut.com/";
        String expectedTitle = "Your user name is Dorota123";

        driver.get(baseUrl);

        actualTittle = driver.getTitle();

        assertThat(actualTittle).isEqualTo(expectedTitle);

    }



    @Test
    public void CheckPage() throws Exception{
        String baseUrl = "http://newtours.demoaut.com/";
        driver.get(baseUrl);
        String actualText = " ";

        driver.findElement(By.cssSelector("body > div > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(2) > td > table > tbody > tr > td:nth-child(2) > a")).click();
        driver.findElement(By.name("firstName")).sendKeys("Dorota");
        driver.findElement(By.name("lastName")).sendKeys("DAbc");
        driver.findElement(By.name("phone")).sendKeys("123456789");
        driver.findElement(By.id("userName")).sendKeys("dabc@bb.vv");
        driver.findElement(By.id("email")).sendKeys("Dorota123");
        driver.findElement(By.name("password")).sendKeys("abc123");
        driver.findElement(By.name("confirmPassword")).sendKeys("abc123");
        driver.findElement(By.name("register")).submit();
        Thread.sleep(8000);

        actualText =  driver.findElement(By.cssSelector("body > div > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(3) > td > p:nth-child(3) > a > font > b")).getText();
        System.out.println(actualText);
    }

    @After
    public void tearDown(){
        driver.quit();


    }


}
