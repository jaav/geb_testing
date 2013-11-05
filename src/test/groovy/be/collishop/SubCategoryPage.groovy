package be.collishop;

import org.openqa.selenium.WebElement

public class SubCategoryPage extends CollishopPage {	
	static at = { title.contains "Compacte fototoestellen | Collishop" }	
	static content = {
		productInfo(wait: true) { $("form").has("input", value: "13014").parent() }
		buttonCompareProduct(wait: true) { $("#compare_13014>a") }
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


