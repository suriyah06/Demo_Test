package Demo_Package;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Listeners(Demo_Package.Listener.class)
public class Demo_Class {

	@Test(description="This test is happy path of the GreenKart application")
	@Parameters ({"url"})
	public void test1(String url) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Browser Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to(url);
		//Thread.sleep(3000);
		List<WebElement> Veggies = driver.findElements(By.xpath("//h4[@class='product-name']"));
		String[] itemsNeeded = {"Brocolli","Brinjal"};
		List<String> al = Arrays.asList(itemsNeeded);
		for(int i=0;i<Veggies.size();i++)
		{
			String[] name = Veggies.get(i).getText().split("-");
			String formattedName = name[0].trim();
			//System.out.println(name[0]);
			
			if(al.contains(formattedName))
			{
				//System.out.println(name[0]);
				driver.findElements(By.xpath("//a[@class='increment']")).get(i).click();
				driver.findElements(By.xpath("//div[@class='product-action']")).get(i).click();
				
			}
		}
		
		WebElement cart = driver.findElement(By.cssSelector("a.cart-icon"));
		cart.click();
		WebElement checkOut = driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']"));
		checkOut.click();
		Thread.sleep(3000);
		WebElement placeOrder = driver.findElement(By.xpath("//button[text()='Place Order']"));
		placeOrder.click();
		WebElement dropDown = driver.findElement(By.xpath("//select[@style='width: 200px;']"));
		Select selectCountry = new Select(dropDown);
		selectCountry.selectByVisibleText("India");
		WebElement terms = driver.findElement(By.cssSelector("input.chkAgree"));
		terms.click();
		WebElement proceed = driver.findElement(By.xpath("//button[text()='Proceed']"));
		proceed.click();
		driver.close();
		
	}
}
