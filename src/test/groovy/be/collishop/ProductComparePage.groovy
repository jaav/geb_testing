package be.collishop

class ProductComparePage extends CollishopPage {	
	static at = { title.contains "Vergelijk artikelen op collishop.be" }
	static content = {
		smartphoneButton(wait: true) { $(".category>ul>li>a") }
		showAllCriteriaButton(wait: true) { $(".lnkShowSecondary.buttonSecondary>a") }
		productDeletedIcon(wait: true) { $("*[alt='Huawei smartphone G525 Ascend zwart']") }
		productInfoOnComparePage(wait: true) { $("section[id='availableSection_559039'] .flyoutHeader") }
		productToBasket(wait: true) { $(".lnkBuy_559039>a") }	
		//productToBasket(wait: true) { $("div[id='lnkBuy_559039']>a") }
	}
	
	def smartphoneButton(pattern) {
		pattern = "(.|\\s)*" + pattern + ".*"
		getElement(pattern, smartphoneButton).click()		
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
