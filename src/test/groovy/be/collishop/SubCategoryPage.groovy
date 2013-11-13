package be.collishop;

import org.openqa.selenium.WebElement

public class SubCategoryPage extends CollishopPage {	
	static at = { title.contains "Smartphones | Collishop" }	
	static content = {
		productInfo(wait: true) { $("form").has("input", value: "559002").parent() }
		buttonCompareProduct(wait: true) { $("#compare_559002>a") }
	}
	
	def unfoldProductInfo() {
		productInfo.click()
	}
	
	def compareProduct() {		
		interact {
			moveToElement(buttonCompareProduct) 
			click()
		}		
	}	
}


