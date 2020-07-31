package ngWebDriver

import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver

import com.kms.katalon.core.annotation.Keyword
import com.paulhammant.ngwebdriver.NgWebDriver

public class BaseClass {

	WebDriver driver
	NgWebDriver ngWebDriver;
	JavascriptExecutor jsDriver

	public BaseClass(){
	}






	@Keyword
	def findElement(){
	}
}
