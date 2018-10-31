import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.assertj.core.api.Assertions.*;


public class XkomTests {
    private WebDriver driver;

    @Before
    public void seUp() {

        System.setProperty("webdriver.chrome.driver", "files\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
    }

    @Test
    public void CheckIt() throws Exception {

        String baseUrl = "http://www.x-kom.pl";
        driver.get(baseUrl);
        driver.findElement(By.name("q")).sendKeys("ASUS WT465 czarny");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("button.button")).click();
        Thread.sleep(5000);
        driver.findElement(By.cssSelector("button.basket.js-add-to-cart")).click();
        Thread.sleep(5000);
        assertThat(driver.findElement(By.cssSelector("span.price-value-label.js-basket-price")).getText()).isEqualTo("59,00 zł");







    }

    @After
    public void tearDown() {
        driver.quit();


    }
}

