package Demo_Package;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Listeners(Demo_Package.Listener.class)
public class TestNG_DemoClass {
	
	@Test(groups = {"MobileLogin"})
	public void MobilePersonalLoan()
	{
		System.out.println("MobilePersonalLoan passed");
	}
	
	@Test(groups = {"WebLogin"})
	public void WebPersonalLoan()
	{
		System.out.println("WebPersonalLoan passed");
	}
	
	@Test(groups = {"APILogin"}, dependsOnMethods = {"MobilePersonalLoan"})
	public void APIPersonalLoan()
	{
		System.out.println("APIPersonalLoan passed");
	}

}
