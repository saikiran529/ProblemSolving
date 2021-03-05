package com.pages;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;
import java.util.Locale;
import java.util.spi.CurrencyNameProvider;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.ConfigReader;

public class ExercisePage {

	private WebDriver driver;

	// 1. By Locators: id
	@FindBy(id = "lbl_val_1")
	private By lbl_Value1;
	
	@FindBy(id = "txt_val_1")
	private By txt_Value1 ;
	
	@FindBy(id = "lbl_val_2")
	private By lbl_Value2;
	
	@FindBy(id = "txt_val_2")
	private By txt_Value2 ;
	
	@FindBy(id = "lbl_val_3")
	private By lbl_Value3;
	
	@FindBy(id = "txt_val_3")
	private By txt_Value3 ;
	
	@FindBy(id = "lbl_val_4")
	private By lbl_Value4;
	
	@FindBy(id = "txt_val_4")
	private By txt_Value4;
	
	@FindBy(id = "lbl_val_5")
	private By lbl_Value5;
	
	@FindBy(id = "txt_val_5")
	private By txt_Value5;
	
	@FindBy(id = "lbl_ttl_val")
	private By lbl_Total_Value;
	
	@FindBy(id = "txt_ttl_val")
	private By txt_Total_Value;
	
	
	@FindAll({
		   @FindBy(xpath = "label[starts-with(@id,'txt_val_')]")
		   
		})
		private List<WebElement> valuesCount;
	
	// 2. Constructor of the page class:
	public ExercisePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// 3. page actions: features(behavior) of the page the form of methods:

	public boolean checkValuesMatchesTotalBalance(){
		Boolean status=false;
		Double sum =null;
		
		try {
		for(int i=0;i<valuesCount.size();i++)
		{
			WebElement data= driver.findElement(By.xpath(valuesCount+""+i));
			String Textboxdata=data.getText();
			Textboxdata.replaceAll("$", "");
			Double c=Double.valueOf(Textboxdata);
			if(c>0)
			sum=sum+c;
		}
		WebElement Tsum=driver.findElement((txt_Total_Value));
		String total=Tsum.getText();
		total.replaceAll("$", "");
		Double cStatus=Double.valueOf(total);
		if(sum.equals(cStatus))
				{
			status =true;
				}
		else
		{
			status= false;
			}
		
				
	}catch(ElementNotVisibleException e)
		{
		e.printStackTrace();
		}
		catch(Exception e)
		{
		e.printStackTrace();
		}
		return status;
		
	}
	public boolean checkCurrencyFormatforValue1()
	{
		String status=driver.findElement(txt_Value1).getText();
		boolean ValueCurrencyStatus=checkCurrencyFormat(status);
		return ValueCurrencyStatus;
	}
	
	public boolean checkCurrencyFormatforValue2()
	{
		String status=driver.findElement(txt_Value2).getText();
		boolean ValueCurrencyStatus=checkCurrencyFormat(status);
		return ValueCurrencyStatus;
	}
	
	public boolean checkCurrencyFormatforValue3()
	{
		String status=driver.findElement(txt_Value3).getText();
		boolean ValueCurrencyStatus=checkCurrencyFormat(status);
		return ValueCurrencyStatus;
	}
	
	public boolean checkCurrencyFormatforValue4()
	{
		String status=driver.findElement(txt_Value4).getText();
		boolean ValueCurrencyStatus=checkCurrencyFormat(status);
		return ValueCurrencyStatus;
	}
	
	public boolean checkCurrencyFormatforValue5()
	{
		String status=driver.findElement(txt_Value5).getText();
		boolean ValueCurrencyStatus=checkCurrencyFormat(status);
		return ValueCurrencyStatus;
	}
	
	public boolean checkCurrencyFormatforTotalBalanceValue()
	{
		String status=driver.findElement(txt_Total_Value).getText();
		boolean ValueCurrencyStatus=checkCurrencyFormat(status);
		return ValueCurrencyStatus;
	}
	
	public boolean checkCurrencyFormat(String format)
	{
		boolean status= false;
		Currency currency = Currency.getInstance("US");
		String symbol = currency.getSymbol();
		if(format.startsWith(symbol) || format.endsWith(symbol)){
			status= true;
		    System.out.println("valid");
		}else{
		    System.out.println("invalid");
		}
		return status;	
	}
	
	public int checkValueCount(){
		int count=0;
		try {
		for(int i=0;i<valuesCount.size();i++)
		{
			count++;
		}
				
	}catch(ElementNotVisibleException e)
		{
		e.printStackTrace();
		}
		catch(Exception e)
		{
		e.printStackTrace();
		}
		return count;
	}


	public boolean dataexistsinValue1Textbox(){
		String status=driver.findElement(txt_Value1).getText();
		status.replaceAll("$", "");
		Double cStatus=Double.valueOf(status);
		
		if(cStatus>0) {
		return true;
			}
		else {
			return false;
			}
		}

	public boolean dataexistsinValue2Textbox(){
		String status=driver.findElement(txt_Value2).getText();
		status.replaceAll("$", "");
		Double cStatus=Double.valueOf(status);
		if(cStatus>0) {
		return true;
			}
		else {
			return false;
			}			
		}

	public boolean dataexistsinValue3Textbox(){
		String status=driver.findElement(txt_Value3).getText();
		status.replaceAll("$", "");
		Double cStatus=Double.valueOf(status);
		if(cStatus>0) {
		return true;
			}
		else {
			return false;
			}
		}
	
	public boolean dataexistsinValue4Textbox(){
		String status=driver.findElement(txt_Value4).getText();
		status.replaceAll("$", "");
		Double cStatus=Double.valueOf(status);
		if(cStatus>0) {
		return true;
			}
		else {
			return false;
			}
		}

	public boolean dataexistsinValue5Textbox(){
		String status=driver.findElement(txt_Value5).getText();
		status.replaceAll("$", "");
		Double cStatus=Double.valueOf(status);
		if(cStatus>0) {
		return true;
			}
		else {
			return false;
			}
		}

	public boolean dataexistsinTotalValueTextbox(){
		String status=driver.findElement(txt_Total_Value).getText();
		status.replaceAll("$", "");
		Double cStatus=Double.valueOf(status);
		if(cStatus>0) {
		return true;
			}
		else {
			return false;
			}
		}


	
	public boolean isLabelExistsforVal1(){
			return driver.findElement(lbl_Value1).isDisplayed();	
	}
		public boolean isLabelExistsforVal2(){
		return driver.findElement(lbl_Value2).isDisplayed();
		
	}
	public boolean isLabelExistsforVal3(){
		return driver.findElement(lbl_Value3).isDisplayed();
		
	}
	
	public boolean isLabelExistsforVal4(){
		return driver.findElement(lbl_Value4).isDisplayed();
		
	}
	public boolean isLabelExistsforVal5(){
		return driver.findElement(lbl_Value5).isDisplayed();
		
	}
	
	public boolean isLabelExistsforTotalBalance(){
		return driver.findElement(lbl_Total_Value).isDisplayed();
		
	}

	public boolean isTextBoxExistsforVal1(){
		return driver.findElement(txt_Value1).isDisplayed();
		
	}
	
	public boolean isTextBoxExistsforVal2(){
		return driver.findElement(txt_Value2).isDisplayed();
		
	}
	public boolean isTextBoxExistsforVal3(){
		return driver.findElement(txt_Value3).isDisplayed();
		
	}
	public boolean isTextBoxExistsforVal4(){
		return driver.findElement(txt_Value4).isDisplayed();
		
	}
	public boolean isTextBoxExistsforVal5(){
		return driver.findElement(txt_Value5).isDisplayed();
		
	}
	public boolean isTextBoxExistsforTotalBalance(){
		return driver.findElement(txt_Total_Value).isDisplayed();
		
	}
	
		
}
