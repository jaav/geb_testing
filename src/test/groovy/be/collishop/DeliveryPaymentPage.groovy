package be.collishop

class DeliveryPaymentPage extends CollishopPage {	
	static url = "https://www.collishop.be/e/nl/cs/checkout-customer-overview"	
	static at = { title.contains "Levering en betaling" }	
	static content = {
		linkToCreateAccount(wait: true) { $(".notificationMain>p>a") }
	}
	
	def clickOnLinkToCreateAccount() {
		linkToCreateAccount.click()
	}
		
}
