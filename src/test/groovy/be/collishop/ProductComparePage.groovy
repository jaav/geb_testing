package be.collishop

class ProductComparePage extends CollishopPage {	
	static at = { title.contains "Vergelijk artikelen op collishop.be" }
	static content = {
		photosetButton(wait: true) { $(".category>ul>li>a") }
		showAllCriteriaButton(wait: true) { $(".lnkShowSecondary.buttonSecondary>a") }
		productDeletedIcon(wait: true) { $("*[alt='Olympus digitaal fototoestel VG-180 zwart']") }
		productInfoOnComparePage(wait: true) { $("section[id='availableSection_11968'] .flyoutHeader") }
		productToBasket(wait: true) { $(".lnkBuy_11968>a") }		
	}
	
	def getPhotosetButton(pattern) {
		pattern = "(.|\\s)*" + pattern + ".*"
		getElement(pattern, photosetButton).click()		
	}
	
	def unfoldProductInfoOnComparePage() {
		productInfoOnComparePage.click()
	}
	
	def addProductToBasket() {
		productToBasket.click()
	}
	
	def clickOnShowAllCriteriaButton() {
		showAllCriteriaButton.click()
	}
	
	def productDeleted() {
		productDeletedIcon.click()
	}

}
