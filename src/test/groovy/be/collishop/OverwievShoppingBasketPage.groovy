package be.collishop
import java.util.regex.Pattern
import java.util.regex.Matcher
import org.openqa.selenium.WebElement

class OverwievShoppingBasketPage  extends CollishopPage {
	static at = { title.contains "Overzicht van je winkelmandje" }	
	static content = {
		flyoutHeaders(wait: true) { $(".flyoutHeader>h1>span>a") }
		inputCollectionPoint(wait: true) { $(".inputWrap") }
		autoSelectOptionCollectionPoint(wait: true) { $("#autoSelectOption_0") }
		selectOptionCollectionPoint(wait: true) { $("#inpColruytAddress-1") }
		submitButtonOnModalWindow(wait: true) { $(".lnkSubmit.buttonPrimary>a") }
		submitButton(cache: false, wait: true) { $("#checkoutSubmitButton>a") }		
	}
		
	def chooseCollectionPoint(pattern) {		
		waitFor{ flyoutHeaders.size() > 0 }
		pattern = "(.|\\s)*" + pattern + ".*"
		getElement(pattern, flyoutHeaders).click()			
	}
	
	def setTextToCollectionPoint(text) {
		inputCollectionPoint.find("input", class: "textfield").value(text)
		autoSelectOptionCollectionPoint.click()
		selectOptionCollectionPoint.click()
		submitButtonOnModalWindow.click()
		submitButton.click()		
	}
}
