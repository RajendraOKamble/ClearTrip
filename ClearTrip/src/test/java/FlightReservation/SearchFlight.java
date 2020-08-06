package FlightReservation;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.cucumber.java.en.*;

public class SearchFlight {

	WebDriver driver= null;

	@Given("user is cleartrip URL")
	public void user_is_cleartrip_URL() {
		String path=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",path+"\\src\\test\\resources\\Drivers\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		driver.manage().window().maximize(); 
		driver.get("http://cleartrip.com");
	}

	@When("user from and to and departure date")
	public void user_from_and_to_and_departure_date() throws InterruptedException {

		driver.findElement(By.id("FromTag")).sendKeys("Mumbai, IN - Chatrapati Shivaji Airport (BOM)");
		driver.findElement(By.id("ToTag")).sendKeys("London, GB - All airports (LON)");
		Thread.sleep(5000);
		driver.findElement(By.id("DepartDate")).click();

		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(text(),'31')]")).click();

	}

	@When("Click on Search Flights")
	public void click_on_Search_Flights() throws InterruptedException {
		driver.findElement(By.id("SearchBtn")).click();

	}

	@Then("User is navigated to details page")
	public void User_is_navigated_to_details_page() throws InterruptedException {
		Thread.sleep(10000);
		List<WebElement> list=driver.findElements(By.xpath("//p[contains(text(),',')]"));
		System.out.println("Size is"+list.size());
		for(WebElement ele:list)
		{

			System.out.println("Elements are--->"+ele.getText());
		}   
	}
}
