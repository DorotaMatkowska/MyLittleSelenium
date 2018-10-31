import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.assertj.core.api.Assertions.*;

public class PracujPlTests {
    private WebDriver driver;

    @Before
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "files\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void CheckIfPracujPlTittleIsCorrect() throws InterruptedException {
        String actualTittle = "";
        String baseUrl = "https://www.pracuj.pl";
        String expectedTitle = "Oferty pracy - Pracuj.pl";

        driver.get(baseUrl);

        actualTittle = driver.getTitle();

        assertThat(actualTittle).isEqualTo(expectedTitle);

    }



    @Test
    public void CheckHowManyOffersAreAvailable() throws Exception{
        String baseUrl = "https://www.pracuj.pl";
        driver.get(baseUrl);
        String actualText = " ";

        driver.findElement(By.name("kw")).sendKeys("Tester oprogramowania");
        driver.findElement(By.name("wp")).sendKeys("pomorskie");
        driver.findElement(By.id("searchBtn")).submit();
        Thread.sleep(8000);

       actualText =  driver.findElement(By.className("o__search_results_title_number")).getText();
        System.out.println(actualText);
    }

    @After
    public void tearDown(){
        driver.quit();


    }


}
