import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class GoogleTests {
    private WebDriver driver;

    @Before
    public void seUp() {

        System.setProperty("webdriver.chrome.driver", "files\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
    }

    @Test
    public void CheckIt() throws Exception {

        String baseUrl = "https://www.google.pl";
        String adres = " ";
        String telefon = " ";
        String opinie = " ";


        driver.get(baseUrl);
        driver.findElement(By.name("q")).sendKeys("Intel Gdańsk");
        driver.findElement(By.name("btnK")).submit();
        Thread.sleep(4000);

        adres = driver.findElement(By.cssSelector("#rhs_block > div > div.kp-blk.knowledge-panel.Wnoohf.OJXvsb > div > div.ifM9O > div:nth-child(2) > div.SALvLe.farUxc.mJ2Mod > div > div:nth-child(2) > div > div > span.LrzXr")).getText();
        System.out.println(adres);

        telefon = driver.findElement(By.xpath("//*[@id=\"rhs_block\"]/div/div[1]/div/div[1]/div[2]/div[3]/div/div[4]/div/div")).getText();
        System.out.println(telefon);

        opinie = driver.findElement(By.cssSelector("#rhs_block > div > div.kp-blk.knowledge-panel.Wnoohf.OJXvsb > div > div.ifM9O > div:nth-child(2) > div.kp-header > div > div.fYOrjf.kp-hc > div:nth-child(2) > div > div > span.fl > span > a > span")).getText();
        System.out.println(opinie);





    }

    @After
    public void tearDown() {
        driver.quit();


    }
}

