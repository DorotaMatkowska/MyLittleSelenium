import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class CodementorsTests {
    private WebDriver driver;

    @Before
    public void seUp() {

        System.setProperty("webdriver.chrome.driver", "files\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
    }

    @Test
    public void CheckIt() throws Exception {

        String baseUrl = "https://codementors.pl/";
        String actualText = " ";
        String actualEmail = " ";
        String actualNumber = " ";


        driver.get(baseUrl);
        driver.findElement(By.cssSelector("#menu > li:nth-child(8) > a")).click();
        Thread.sleep(4000);

        actualText = driver.findElement(By.cssSelector("body > div:nth-child(4) > div > section.contact-area.fix > div > div > div:nth-child(2) > div > div:nth-child(1) > p")).getText();
        System.out.println(actualText);

        actualEmail = driver.findElement(By.cssSelector("body > div:nth-child(4) > div > section.contact-area.fix > div > div > div:nth-child(2) > div > div:nth-child(2) > p:nth-child(2) > span")).getText();
        System.out.println(actualEmail);

        actualNumber = driver.findElement(By.cssSelector("body > div:nth-child(4) > div > section.contact-area.fix > div > div > div:nth-child(2) > div > div:nth-child(3) > p")).getText();
        System.out.println(actualNumber);





    }

    @After
    public void tearDown() {
        driver.quit();


    }
}

