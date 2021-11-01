package frame;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frame1class {

	public static void main(String[] args) throws InterruptedException, IOException {
		 WebDriverManager.chromedriver().setup();
		 ChromeDriver driver=new ChromeDriver();
		 driver.get("http://leafground.com/pages/frame.html");
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 
		WebElement fram1= driver.findElement(By.xpath("//div[@id='wrapframe']/iframe"));
		driver.switchTo().frame(fram1);
		
		WebElement obj = driver.findElement(By.xpath("//button[@id='Click']"));
		File scr=obj.getScreenshotAs(OutputType.FILE);
		File obj1=new File("./snaps/scr.png");
		FileUtils.copyFile(scr, obj1);

		driver.switchTo().defaultContent();
		List<WebElement> frames = driver.findElements(By.xpath("//iframe"));
		int a = frames.size();
		System.out.println(a); 
				
		
		
	}
}
