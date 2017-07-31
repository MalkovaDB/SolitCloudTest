import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class test {
    private WebDriver driver;
    private String baseUrl;
    private StringBuffer errors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.gecko.driver","/home/gravicapa/Job/solitcloudstest/test/resources/gecko/geckodriver");
        driver = new FirefoxDriver();
        baseUrl = "https://www.google.com/ncr";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void test() throws Exception {
        String SEARCHRESULTXPATH = "//*[@class='srg']//h3/a";
        String IMAGERESULTXPATH = "//div[@id='rg_s']//a";
        String SELENIUMSITE = "seleniumhq.org";

        driver.get(baseUrl);
        driver.findElement(By.id("lst-ib")).clear();
        driver.findElement(By.id("lst-ib")).sendKeys("selenium");
        driver.findElement(By.id("lst-ib")).submit();

        final Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);
        wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath(SEARCHRESULTXPATH))));

        String foundResult = driver.findElements(By.xpath(SEARCHRESULTXPATH)).get(0).getAttribute("href");

        try{
            assertTrue(foundResult.contains(SELENIUMSITE));
        }
        catch (Error e) {
            errors.append(e.toString() + ". The result link does not apply to \"seleniumhq.org\" website.");
        }

        driver.findElement(By.linkText("Images")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElements(By.xpath(IMAGERESULTXPATH)).get(0)));

        String foundImage = driver.findElements(By.xpath(IMAGERESULTXPATH)).get(0).getAttribute("href");

        try{
            assertTrue(foundImage.contains(SELENIUMSITE));
        }
        catch (Error e) {
            errors.append(e.toString() + ". Image link does not apply to \"seleniumhq.org\" website.");
        }

        driver.findElement(By.linkText("All")).click();
        wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//*[@class='srg']//h3/a"))));

        String repeatResult = driver.findElements(By.xpath(SEARCHRESULTXPATH)).get(0).getAttribute("href");

        try{
            assertEquals(foundResult, repeatResult);
        }
        catch (Error e) {
            errors.append(e.toString());
        }

    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        if (!"".equals(errors.toString())) {
            fail(errors.toString());
        }
    }
}
