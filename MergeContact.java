package frame;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {
@SuppressWarnings("deprecation")
public static void main(String[] args) throws InterruptedException {
	
		 WebDriverManager.chromedriver().setup();
	 ChromeDriver driver=new ChromeDriver();
	 driver.get("http://leaftaps.com/opentaps/control/login");
	 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	 driver.manage().window().maximize();
	 driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
	 driver.findElement(By.id("password")).sendKeys("crmsfa");
	 driver.findElement(By.className("decorativeSubmit")).click();
	 driver.findElement(By.linkText("CRM/SFA")).click();
	 driver.findElement(By.linkText("Contacts")).click();
	 driver.findElement(By.xpath("//a[text()=\"Merge Contacts\"]")).click();
	driver.findElement(By.xpath("//input[@id='partyIdFrom']/following::img")).click();
	Set<String> obj=driver.getWindowHandles();
	List<String> obj2=new ArrayList<String>(obj);
	driver.switchTo().window(obj2.get(1));
	driver.findElement(By.xpath("//a[@class='linktext']")).click();
	
	
		
	driver.switchTo().window(obj2.get(0));
	driver.findElement(By.xpath("(//input[@id='partyIdFrom']/following::img)[2]")).click();
	Set<String> one=driver.getWindowHandles();
	List<String> two=new ArrayList<String>(one);
	driver.switchTo().window(two.get(1));

	
	driver.findElement(By.xpath("//table[@class='x-grid3-row-table']/following::table/tbody[1]/tr[1]/td[1]/div[1]/a[1]")).click();
	Thread.sleep(2000);
	
	driver.switchTo().window(obj2.get(0));
	
	driver.findElement(By.xpath("//a[text()='Merge']")).click();
	Alert alert = driver.switchTo().alert();
	alert.accept();
	
	
	String a=driver.getTitle();
	System.out.println(a);
	if(a.contains("Contact"))
	{
		System.out.println("verified");
	}
}
}
