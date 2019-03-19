package com.cg.project.stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.cg.project.pagebeans.RegistrationPageBean;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class RegistrationStepDefinition {
	private static WebDriver driver;
	private RegistrationPageBean pageBean;
	
	@Before
	public static void setUpStepEnv() {
		System.setProperty("webdriver.chrome.driver", "D:\\Software_backup\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.google.com");
	}

	@Given("^User is accing RegistrationPage on Browser$")
	public void user_is_accing_RegistrationPage_on_Browser() throws Throwable {
		driver.get("D:\\WebPages\\RegistrationForm.html");
		pageBean = PageFactory.initElements(driver, RegistrationPageBean.class);
	}

	@When("^User is trying to submit data without entring 'User Id'$")
	public void user_is_trying_to_submit_data_without_entring_User_Id() throws Throwable {
		pageBean.clickSignUp();
	}

	@Then("^'User Id should not be empty / length be between (\\d+) to (\\d+)' alert message should display$")
	public void user_Id_should_not_be_empty_length_be_between_to_alert_message_should_display(int arg1, int arg2) throws Throwable {
		String expectedAlertMessage = "User Id should not be empty / length be between 5 to 12";
		String actualAlertMessage=driver.switchTo().alert().getText();
		Assert.assertEquals(expectedAlertMessage, actualAlertMessage);
	}

	@When("^User is trying to submit request without entring 'Password'$")
	public void user_is_trying_to_submit_request_without_entring_Password() throws Throwable {
		driver.switchTo().alert().dismiss();
		pageBean.setUsername("Abhinav");
		pageBean.clickSignUp();
	}

	@Then("^'Password should not be empty / length be between (\\d+) to (\\d+)' alert message should display$")
	public void password_should_not_be_empty_length_be_between_to_alert_message_should_display(int arg1, int arg2) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@When("^User is trying to submit request without entring 'username'$")
	public void user_is_trying_to_submit_request_without_entring_username() throws Throwable {
		driver.switchTo().alert().dismiss();
		pageBean.setUserId("Abhinav123");
		pageBean.clickSignUp();
	}

	@Then("^'Name should not be empty and must have alphabet characters only' alert message should display$")
	public void name_should_not_be_empty_and_must_have_alphabet_characters_only_alert_message_should_display() throws Throwable {
		String expectedAlertMessage = "Name should not be empty and must have alphabet characters only";
		String actualAlertMessage=driver.switchTo().alert().getText();
		Assert.assertEquals(expectedAlertMessage, actualAlertMessage);
	}

	@When("^User is trying to submit request without entring valid 'address'$")
	public void user_is_trying_to_submit_request_without_entring_valid_address() throws Throwable {
		driver.switchTo().alert().dismiss();
		pageBean.setUserId("Abhinav123");
		pageBean.setPassword("saregama");
		pageBean.setAddress("Pune@");
		pageBean.clickSignUp();
	}

	@Then("^'User address must have alphanumeric characters only' alert message should display$")
	public void user_address_must_have_alphanumeric_characters_only_alert_message_should_display() throws Throwable {
		String expectedAlertMessage = "User address must have alphanumeric characters only";
		String actualAlertMessage=driver.switchTo().alert().getText();
		Assert.assertEquals(expectedAlertMessage, actualAlertMessage);
	}

	@When("^User is trying to submit request without selecting valid 'country'$")
	public void user_is_trying_to_submit_request_without_selecting_valid_country() throws Throwable {
		driver.switchTo().alert().dismiss();
		pageBean.setAddress("Pune@");
		pageBean.clickSignUp();
	}

	@Then("^'Select your country from the list' alert message should display$")
	public void select_your_country_from_the_list_alert_message_should_display() throws Throwable {
		String expectedAlertMessage = "Select your country from the list";
		String actualAlertMessage=driver.switchTo().alert().getText();
		Assert.assertEquals(expectedAlertMessage, actualAlertMessage);
	}

	@When("^User is trying to submit request without entring valid 'zipCode'$")
	public void user_is_trying_to_submit_request_without_entring_valid_zipCode() throws Throwable {
		driver.switchTo().alert().dismiss();
		pageBean.setCountry("India");
		pageBean.clickSignUp();
	}

	@Then("^'Zip code must have numeric characters only' alert message should display$")
	public void zip_code_must_have_numeric_characters_only_alert_message_should_display() throws Throwable {
		String expectedAlertMessage = "Zip code must have numeric characters only";
		String actualAlertMessage=driver.switchTo().alert().getText();
		Assert.assertEquals(expectedAlertMessage, actualAlertMessage);
	}

	@When("^User is trying to submit request without entring valid 'email'$")
	public void user_is_trying_to_submit_request_without_entring_valid_email() throws Throwable {
		driver.switchTo().alert().dismiss();
		pageBean.setZip("445467");
		pageBean.setEmail("abhiwarney#gmail.com");
		pageBean.clickSignUp();

	}

	@Then("^'You have entered an invalid email address!' alert message should display$")
	public void you_have_entered_an_invalid_email_address_alert_message_should_display() throws Throwable {
		String expectedAlertMessage = "You have entered an invalid email address!";
		String actualAlertMessage=driver.switchTo().alert().getText();
		Assert.assertEquals(expectedAlertMessage, actualAlertMessage);
	}

	@When("^User is trying to submit request without selecting valid 'gender'$")
	public void user_is_trying_to_submit_request_without_selecting_valid_gender() throws Throwable {
		driver.switchTo().alert().dismiss();
		pageBean.setEmail("abhiwarney@gmail.com");
		pageBean.clickSignUp();

	}

	@Then("^'Please select gender' alert message should display$")
	public void please_select_gender_alert_message_should_display() throws Throwable {
		String expectedAlertMessage = "Please select gender";
		String actualAlertMessage=driver.switchTo().alert().getText();
		Assert.assertEquals(expectedAlertMessage, actualAlertMessage);
	}

	@When("^User is trying to submit request after entring valid set of information$")
	public void user_is_trying_to_submit_request_after_entring_valid_set_of_information() throws Throwable {
		pageBean.setUserId("Abhinav123");
		pageBean.setUsername("AbhinavWarney");
		pageBean.setPassword("saregama");
		pageBean.setAddress("Pune@");
		pageBean.setCountry("India");
		pageBean.setZip("445646");
		pageBean.setEmail("abhiwarney@gmail.com");
		pageBean.setGender("Male");
		pageBean.clickSignUp();
	}

	@Then("^'Your Registration with JobsWorld\\.com is Successfully done please check your registered email address to activate' alert message should display$")
	public void your_Registration_with_JobsWorld_com_is_Successfully_done_please_check_your_registered_email_address_to_activate_alert_message_should_display() throws Throwable {
		String expectedAlertMessage = "Your Registration with JobsWorld.com is Successfully done please check your registered email address to activate";
		String actualAlertMessage=driver.switchTo().alert().getText();
		Assert.assertEquals(expectedAlertMessage, actualAlertMessage);
	}
	@After
	public void tearDownStepEnv() {
		driver.close();
	}
}
