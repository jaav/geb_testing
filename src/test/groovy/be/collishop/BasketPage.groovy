package be.collishop
import org.openqa.selenium.Keys

class BasketPage extends CollishopPage {
	static url = "http://www.collishop.be/e/nl/cs/basket-overview"
	static at = { title.contains "collishop.be" }
	static content = {
		inputPlace(wait: true) { locationBeginNumberOfProduct.$(".control") }
		submitButtonOnModalWindow(wait: true) { locationBeginNumberOfProduct.$(".lnkSubmit.buttonPrimary>a") }
		locationBeginNumberOfProduct(wait: true) { $("span [href='http://www.collishop.be/e/nl/cs/326170-127-nikon-digitaal-fototoestel-coolpix-s3500-zwart-2969353']").parent().parent().parent().parent().parent().next() }
		locationBeginRemoveProduct(wait: true) { $("span [href='http://www.collishop.be/e/nl/cs/326182-127-vivitar-digitaal-fototoestel-s830-rood-2974431']").parent().parent().parent().parent().parent().parent() }		
		numberOfProduct(wait: true) { locationBeginNumberOfProduct.$("section[class='flyout unitSelector toggleSlidebox bottomSlidebox'] h1") }
		removeProduct(wait: true) { locationBeginRemoveProduct.$(".lnkDelete>a") }
		descriptionQuickAddProducts(cache: false, wait: true) { $("tfoot .toggleText") }
		footBasketTable(cache: false, wait: true) { $(".basketTable>table>tfoot>tr>td") }
		continueToNextPage(cache: false, wait: true) { $("footer .advance .lnkSubmit.buttonPrimary>a") }
	}

	def removeProductFromBasket() {
		removeProduct.click()
	}

	def changeNumberOfProduct() {

		numberOfProduct.click()
	}

	def setNumberOfProductFromInput() {
		inputPlace.find("input", class: "textfield").value("2")
		submitButtonOnModalWindow().click()
	}

	def clickOnDescriptionQuickAddProducts() {
		descriptionQuickAddProducts.click()
	}

	def clickOnFootBasketTable() {
		footBasketTable.click()
	}

	def clickOnContinueToNextPage() {
		continueToNextPage.click()
	}
}
