import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

public class Before {
	WebDriver driver= new EdgeDriver();
	SoftAssert Assert = new SoftAssert ();
	

	
	  

@BeforeTest
	public void before () {
driver.get("https://www.saucedemo.com/");
}

}
