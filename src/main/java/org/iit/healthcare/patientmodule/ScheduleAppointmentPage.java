package org.iit.healthcare.patientmodule;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ScheduleAppointmentPage {
	private WebDriver driver;

 	
	public ScheduleAppointmentPage(WebDriver driver)
	{
		this.driver = driver;
	
	}
	
	public static void scheduleNewAppointment(WebDriver driver){
		driver.findElement(By.xpath("(//span[@class='recent-lozenge'][normalize-space()='Recent'])[1]/ancestor::td")).click();
		driver.findElement(By.xpath("//div[contains(text(),'Schedule Appointment')]")).click();
		driver.findElement(By.xpath("//div[@id='viewAllAppointmentTypes']")).click();
		//driver.findElement(By.xpath("//a[contains(@class,'ng-binding')and  (normalize-space()='Urology (New Patient)')]")).click();
		//driver.findElement(By.xpath("//button[normalize-space()='Search']")).click();
		driver.findElement(By.xpath("//a[contains(@class,'ng-binding')and  (normalize-space()='General Medicine')]")).click();
		driver.findElement(By.xpath("//button[normalize-space()='Search']")).click();
		String sceduletimepath="body div[id='body-wrapper'] "
				+ "div[id='content']"
				+ " div div[id='appointmentscheduling-manageAppointments']"
				+ " div[id='appointmentscheduling-scheduleAppointment'] "
				+ "div[ng-show='showScheduleAppointment'] "
				+ "table[id='appointmentTable'] "
				+ "div[class='ngViewport ng-scope'] "
				+ "div[class='ngCanvas'] "
				+ "div[class='ng-scope ngRow even'] "
				+ "div[class='ng-scope'] "
				+ "div:nth-child(1) div:nth-child(2) div:nth-child(1)";
		driver.findElement(By.cssSelector(sceduletimepath)).click();
		driver.findElement(By.xpath("//button[normalize-space()='Next']")).click();
		driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();

	}

	 
}
