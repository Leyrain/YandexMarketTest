import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class MyFirstTry {
    public static void main(String[] argh) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://market.yandex.ru");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
        driver.findElement(By.id("catalogPopupButton")).click();
        driver.findElement(By.xpath("//a[@href='/catalog--kompiuternaia-tekhnika/54425']")).click();
        driver.findElement(By.xpath("//a[@class='egKyN _2oLyz _9qbcy']")).click();
        WebElement min = driver.findElements(By.xpath("//*[@class='_3qxDp']")).get(0);
        min.sendKeys("25000");
        WebElement max = driver.findElements(By.xpath("//*[@class='_3qxDp']")).get(1);
        max.sendKeys("35000");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//span[@class='_2Pukk']")).click();
        Thread.sleep(2000);
        WebElement producer = driver.findElements(By.xpath("//*[@class='_3qxDp']")).get(2);
        producer.sendKeys("Lenovo");
        Thread.sleep(2000);
        WebElement CheckboxClick = driver.findElements(By.xpath("//span[@class='_2XaWK']")).get(2);
        CheckboxClick.click();




    }
}
