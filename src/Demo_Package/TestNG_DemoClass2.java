package Demo_Package;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Demo_Package.Listener.class)
public class TestNG_DemoClass2 {
	
	@Test(groups = {"MobileLogin"}, priority = 1)
	public void MobileCarLoan()
	{
		System.out.println("MobileCarLoan passed");
	}
	
	@Test(groups = {"WebLogin"})
	public void WebCarLoan()
	{
		System.out.println("WebCarLoan passed");
	}
	
	@Test(groups = {"APILogin"}, priority = 2)
	public void APICarLoan()
	{
		System.out.println("APICarLoan passed");
	}

}
