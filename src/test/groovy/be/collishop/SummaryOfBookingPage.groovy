package be.collishop

class SummaryOfBookingPage extends CollishopPage {
	static at = { title.contains "Overzicht van je reservatie" }	
	static content = {	
		acceptingTheTermsButton(wait: true) { $("#inpConditions") }
	}
		
	def acceptingReservation() {	
		acceptingTheTermsButton.click()
	}
}
