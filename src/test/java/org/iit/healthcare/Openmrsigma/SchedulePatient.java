package org.iit.healthcare.Openmrsigma;

import java.util.HashMap;

import org.iit.healthcare.patientmodule.HomePage;
import org.iit.healthcare.patientmodule.LoginPage;
import org.iit.healthcare.patientmodule.Registerpatient;
import org.iit.healthcare.patientmodule.ScheduleAppointmentPage;
import org.iit.healthcare.util.BaseClass;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SchedulePatient extends BaseClass {

	@Test
	public void ScheduleAppointment()
	{
		 
		LoginPage lPage = new LoginPage(driver);
		Registerpatient regPatient=new 	Registerpatient();
		lPage.login(prop.getProperty("patient_username"),prop.getProperty("patient_password"));
		HomePage homePage = new HomePage(driver);
		ScheduleAppointmentPage schedulePage = new ScheduleAppointmentPage(driver);
		String id=regPatient.RegisterPatient(driver ) ;
		homePage.validate(driver,id);
		 schedulePage.scheduleNewAppointment(driver);
     
	

	}

}
