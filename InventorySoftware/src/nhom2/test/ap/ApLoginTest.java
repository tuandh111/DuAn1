package nhom2.test.ap;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ApLoginTest {
	private WebDriver driver;
	private String url = "https://viindoo.com/web/login";

	@BeforeMethod
	public void setupBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		driver.navigate().to(url);
	}
	@AfterMethod
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(3000);
		System.out.println("browser Sucessfully closed");
		driver.close();
	}
	@Test(dataProvider = "dataLogin")
	public void login(String user, String pass) {
		driver.findElement(By.xpath("//input[@id='login']")).sendKeys(user);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(pass);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	@DataProvider
	public Object[][] dataLogin() {
		return new Object[][] { new Object[] { "", "ceo" }, new Object[] { "ceo", "" },
				new Object[] { "kk", "123" },
				new Object[] {"",""},
				new Object[] {"ceo","123"},
				new Object[] {"kk","ceo"},
				new Object[] {"ceo","ceo"}
		};
	}

}
