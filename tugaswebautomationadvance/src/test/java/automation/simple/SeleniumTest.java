package automation.simple;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class SeleniumTest {
    WebDriver driver;

    @Test
    public void loginTest(){
        WebDriverManager.firefoxdriver();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://makemytrip.com");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[.='Search']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='commonOverlay ']")));

        driver.findElement(By.xpath("//button[@class='button buttonSecondry buttonBig fontSize12 relative']")).click();

        String txtHarga = driver.findElement((By.xpath("//div[@class='blackText fontSize18 blackFont white-space-no-wrap clusterViewPrice']"))).getText();
        System.out.println(txtHarga);
    }
}
