import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ParaBankTest {
    @Test
    public void testPara() throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.get("https://parabank.parasoft.com/");
        driver.findElement(By.xpath("//img[@class='logo']"));

        Thread.sleep(2000);

        driver.findElement(By.xpath("//a[contains(@href,'register.htm')]")).click();

        WebElement firstName = driver.findElement(By.xpath("//input[contains(@id,'firstName')]"));
        firstName.sendKeys("admin");
        WebElement lastName = driver.findElement(By.xpath("//input[@id='customer.lastName']"));
        lastName.sendKeys("admin");
        WebElement street = driver.findElement(By.xpath("//input[contains(@id,'street')]"));
        street.sendKeys("admin");
        WebElement city = driver.findElement(By.xpath("//input[contains(@name,'city')]"));
        city.sendKeys("Queens");
        WebElement state = driver.findElement(By.xpath("//input[contains(@name,'state')]"));
        state.sendKeys("NY");
        WebElement zip = driver.findElement(By.xpath("//input[@id='customer.address.zipCode']"));
        zip.sendKeys("12345");
        WebElement phone = driver.findElement(By.xpath("//input[@id='customer.phoneNumber']"));
        phone.sendKeys("123-456-7890");
        WebElement ssn = driver.findElement(By.xpath("//input[@id='customer.ssn']"));
        ssn.sendKeys("123-456-7890");

        WebElement user = driver.findElement(By.xpath("//input[@id='customer.username']"));
        user.sendKeys("admin3");
        WebElement passcode = driver.findElement(By.xpath("//input[@id='customer.password']"));
        passcode.sendKeys("admin");
        WebElement passcode2 = driver.findElement(By.xpath("//input[@id='repeatedPassword']"));
        passcode2.sendKeys("admin");

        driver.findElement(By.xpath("//input[@value='Register']")).click();

        driver.findElement(By.xpath("//h1[contains(text(),'Welcome')]"));

        driver.quit();









        //WebElement name = driver.findElement(By.xpath("//input[@type='text']"));
        //name.sendKeys();

    }
}
