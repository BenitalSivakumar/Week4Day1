package frame;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Chercher {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		 WebDriverManager.chromedriver().setup();
		 ChromeDriver driver=new ChromeDriver();
		 driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 WebElement fram1=driver.findElement(By.xpath("//iframe[@id='frame1']"));
		 driver.switchTo().frame(fram1);
		 
	driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Good to learn");
	WebElement fram2=driver.findElement(By.xpath("//iframe[@id='frame3']"));
	 driver.switchTo().frame(fram2);
	 driver.findElement(By.xpath("//input[@id='a']")).click();
	 
driver.switchTo().defaultContent();
WebElement fram3=driver.findElement(By.xpath("//iframe[@id='frame2']"));
driver.switchTo().frame(fram3);

WebElement dro=driver.findElement(By.xpath("//select[@id='animals']"));
Select obj=new Select (dro);
obj.selectByIndex(2);
	}
	
}
