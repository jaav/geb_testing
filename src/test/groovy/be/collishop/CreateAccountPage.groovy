package be.collishop

class CreateAccountPage extends CollishopPage {
	static at = { title.contains "Maak een account aan op collishop.be" }	
	static content = {		
		fieldLogin(wait: true) { $("[id='LogonSection'] .control") }
		fieldPassword(wait: true) { $("[id='passwordSection'] .control") }
		fieldVerifyPassword(wait: true) { $("[id='passwordVerifySection'] .control") }
		fieldRememberMe(wait: true) { $("#rememberMe") }		
		formRegister(wait: true) { $("form[id=Register]") }		
		fieldFirstName(wait: true) { $("[id='firstNameDiv'] .control") }
		fieldLastName(wait: true) { $("[id='lastNameDiv'] .control") }		
		fieldAdressStreet(wait: true) { $("[id='address1Div'] .control") }
		fieldAdressNumber(wait: true) { $("[id='address2Div'] .control") }		
		fieldPostalCode(wait: true) { $("[id='zipCodeDiv'] .control") }
		fieldAdressCity(wait: true) { $("[id='cityDiv'] .control") }		
		fieldTelephoneLandline(wait: true) { $("[id='phone1Div'] .control") }
		fieldTelephoneGSM(wait: true) { $("[id='phone2Div'] .control") }		
		fieldEMailAdress(wait: true) { $("[id='emailDiv'] .control") }		
		buttonRegistered(wait: true) { $(".buttonPrimary.lnkSubmit>a") }		
		descriptionTelephone(wait: true) { $("[class='groupLabel'] [class='infoIcon toggleSlidebox']") }		
	}
	
	
	def createAccount() {		
		fieldLogin.find("input", class: "textfield").value("AdamCat")
		fieldPassword.find("input", class: "textfield").value("Password")
		fieldVerifyPassword.find("input", class: "textfield").value("PasswordTTTTTT")
		fieldRememberMe.click()
		selectGender "De Heer"
		fieldFirstName.find("input", class: "textfield").value("Adam")
		fieldLastName.find("input", class: "textfield").value("Cat")		
		fieldAdressStreet.find("input", class: "textfield").value("TestLaan")
		fieldAdressNumber.find("input", class: "textfield").value("1")		
		fieldPostalCode.find("input", class: "textfield").value("1000")
		fieldAdressCity.find("input", class: "textfield").value("Brussel")		
		fieldTelephoneLandline.find("input", class: "textfield").value("77777777")
		fieldTelephoneGSM.find("input", class: "textfield").value("7777777777777777")		
		fieldEMailAdress.find("input", class: "textfield").value("Test")				
		buttonRegistered.click()		
		firstAttemptToCorrectDataForCreateAccount()	
	}
	
	def selectGender = { gender -> formRegister.personTitle = gender}
	
	def selectCountry = { country -> formRegister.country = country}
	
	def selectAddressDrop = { addressDrop -> formRegister.addressDrop1 = addressDrop}
	
	def firstAttemptToCorrectDataForCreateAccount() {		
		def todayDate = new Date()
		def actualMilliseconds = todayDate.toTimestamp().getTime()
		fieldLogin.find("input", class: "textfield").value("AdamCat"+actualMilliseconds)
		fieldPassword.find("input", class: "textfield").value("PasswoTT")
		fieldVerifyPassword.find("input", class: "textfield").value("Password")
		fieldRememberMe.click()
		fieldEMailAdress.find("input", class: "textfield").value("45454588@mailismagic.com")
		buttonRegistered.click()
		secondAttemptToCorrectDataForCreateAccount()
	}
	
	def secondAttemptToCorrectDataForCreateAccount() {	
		fieldPassword.find("input", class: "textfield").value("Password")
		fieldVerifyPassword.find("input", class: "textfield").value("Password")
		fieldRememberMe.click()		
		buttonRegistered.click()
		thirdAttemptToCorrectDataForCreateAccount()
	}
	
	def thirdAttemptToCorrectDataForCreateAccount() {		
		fieldPassword.find("input", class: "textfield").value("Password")
		fieldVerifyPassword.find("input", class: "textfield").value("Password")
		fieldRememberMe.click()		
		buttonRegistered.click()		
		fourthAttemptToCorrectDataForCreateAccount()		
	}
	
	def fourthAttemptToCorrectDataForCreateAccount() {
		selectAddressDrop "ADONISSENPAD"
		descriptionTelephone.click()
		fieldTelephoneGSM.find("input", class: "textfield").value("")		
		buttonRegistered.click()		
		fifthAttemptToCorrectDataForCreateAccount()
	}
	
	def fifthAttemptToCorrectDataForCreateAccount() {		
		fieldTelephoneLandline.find("input", class: "textfield").value("23333333")	
		buttonRegistered.click()
	}
	
}
