package parallel;

import org.testng.*;

import com.pages.ExercisePage;
import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {

	private ExercisePage ePage = new ExercisePage(DriverFactory.getDriver());

	
	@Given("user is on exercise page")
	public void user_is_on_exercise_page() {
		// To get application URL
		String URL= ConfigReader.init_prop("url");
		DriverFactory.getDriver().get(URL);
	}
	
	@When("value Labels and value text fields are displayed")
	public void values_labels_text_fields_are_displayed() {
		Assert.assertTrue(ePage.isLabelExistsforVal1());
		Assert.assertTrue(ePage.isLabelExistsforVal2());
		Assert.assertTrue(ePage.isLabelExistsforVal3());
		Assert.assertTrue(ePage.isLabelExistsforVal4());
		Assert.assertTrue(ePage.isLabelExistsforVal5());
		Assert.assertTrue(ePage.isLabelExistsforTotalBalance());
		Assert.assertTrue(ePage.isTextBoxExistsforVal1());
		Assert.assertTrue(ePage.isTextBoxExistsforVal2());
		Assert.assertTrue(ePage.isTextBoxExistsforVal3());
		Assert.assertTrue(ePage.isTextBoxExistsforVal4());
		Assert.assertTrue(ePage.isTextBoxExistsforVal5());
		Assert.assertTrue(ePage.isTextBoxExistsforTotalBalance());
	}
	@Then("right count of field values should appear on the screen")
	public void right_count_values_should_be_displayed()
	{
		Assert.assertEquals(ePage.checkValueCount(), ConfigReader.init_prop("totalvaluescount"));
	}
	
	@Then("value should exist in the value text boxes")
	public void values_should_be_displayed_in_textbox()
	{
		Assert.assertTrue(ePage.dataexistsinValue1Textbox());
		Assert.assertTrue(ePage.dataexistsinValue2Textbox());
		Assert.assertTrue(ePage.dataexistsinValue3Textbox());
		Assert.assertTrue(ePage.dataexistsinValue4Textbox());
		Assert.assertTrue(ePage.dataexistsinValue5Textbox());
	}
	
	@Then("count of each text box value should be greater than zero")
	public void each_textbox_value_greater_than_zero()
	{
		Assert.assertTrue(ePage.dataexistsinValue1Textbox());
		Assert.assertTrue(ePage.dataexistsinValue2Textbox());
		Assert.assertTrue(ePage.dataexistsinValue3Textbox());
		Assert.assertTrue(ePage.dataexistsinValue4Textbox());
		Assert.assertTrue(ePage.dataexistsinValue5Textbox());

	}
	
	@Then("value should exist in total Balance text box")
	public void value_should_exist_in_totalBalance_textBox()
	{
		Assert.assertTrue(ePage.dataexistsinTotalValueTextbox());
	}
	
	@Then("total balance should be correct as per listed values")
	public void total_balance_should_be_correct_asper_listed_values()
	{
		Assert.assertTrue(ePage.checkValuesMatchesTotalBalance());
	}
	
	@Then("all the values listed on the screen must be in dollar currency format")
	public void values_should_be_in_dollar_currecy_format()
	{
		Assert.assertTrue(ePage.checkCurrencyFormatforValue1());
		Assert.assertTrue(ePage.checkCurrencyFormatforValue2());
		Assert.assertTrue(ePage.checkCurrencyFormatforValue3());
		Assert.assertTrue(ePage.checkCurrencyFormatforValue4());
		Assert.assertTrue(ePage.checkCurrencyFormatforValue5());
		Assert.assertTrue(ePage.checkCurrencyFormatforTotalBalanceValue());
	}
	
	@Then("Sum of all the values listed on the screen must be equal to Total balance")
	public void sum_of_values_equal_to_totalBalance()
	{
		Assert.assertTrue(ePage.checkValuesMatchesTotalBalance());
	}
}
