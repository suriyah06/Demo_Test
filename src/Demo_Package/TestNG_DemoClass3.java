package Demo_Package;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Demo_Package.Listener.class)
public class TestNG_DemoClass3 {
	
	@Test(groups = {"MobileLogin"}, timeOut = 200)
	public void MobileHomeLoan() throws InterruptedException
	{
		//Thread.sleep(500);
		Assert.assertTrue(false);
		System.out.println("MobileHomeLoan passed");
		
	}
	
	@Test(groups = {"WebLogin"})
	public void WebHomeLoan()
	{
		System.out.println("WebHomeLoan passed");
	}
	
	@Test(groups = {"APILogin"})
	public void APIHomeLoan()
	{
		System.out.println("APIHomeLoan passed");
	}

}
