import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class TestCases extends Before {
	@Test(priority=1)
	public void LogIn () {
		
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
	}
	@Test(priority=2)
	public void AddItems () throws InterruptedException, IOException {
		List<WebElement> listElement = driver.findElements(By.className("btn"));
		for(int i =0;i<listElement.size();i++) {
			
			listElement.get(i).click(); 
			
			}
		//Taking screenshot of how many items have been added
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,10)");
Thread.sleep(2000);
		Date myDate = new Date();
		String myDateupdate = myDate.toString();

		String thenewDateFormat = myDateupdate.replace(":", "-");

		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

		File DestFile = new File("./screenshot/"+thenewDateFormat+".jpg");

		FileUtils.copyFile(SrcFile, DestFile);
		Thread.sleep(4000);
	}
	@Test(priority=3)
	public void RemoveItems () throws InterruptedException {List<WebElement> listElements = driver.findElements(By.className("btn"));
	
	for(int j =0;j<listElements.size();j++) {
		
		 listElements.get(j).click(); 
		 
	 }	 
	Thread.sleep(4000);}
	@Test(priority=4)
	public void CheckOut () throws InterruptedException {
		Thread.sleep(4000);

	List<WebElement> listElement = driver.findElements(By.className("btn"));
	for(int i =0;i<listElement.size();i++) {
		
		listElement.get(i).click(); }
	Thread.sleep(4000);
driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();
driver.findElement(By.xpath("//*[@id=\"checkout\"]")).click();
driver.findElement(By.xpath("//*[@id=\"first-name\"]")).sendKeys("Lujain");
driver.findElement(By.xpath("//*[@id=\"last-name\"]")).sendKeys("Nahya");
driver.findElement(By.xpath("//*[@id=\"postal-code\"]")).sendKeys("5656");
driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
Thread.sleep(2000);
driver.findElement(By.xpath("//*[@id=\"finish\"]")).click();

	}
	@Test(priority=5)
	public void SortFromZtoA() throws InterruptedException {
		Thread.sleep(2000);

		driver.get("https://www.saucedemo.com/inventory.html");
		Select sort=new Select(driver.findElement(By.className("product_sort_container")));
		sort.selectByValue("za");
	}
	@Test(priority=6)
	public void LogOut()  throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"react-burger-menu-btn\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"logout_sidebar_link\"]")).sendKeys(Keys.ENTER);

	
	
	
	}
	
	

}
