package be.collishop
import java.awt.MenuItem;

import geb.spock.*

class CollishopSpec extends GebReportingSpec {
//	final String EUR = "\u20AC"
//	def setup() {
//		browser.config.autoClearCookies = false
//	 }
//	
	def "search and buy a smartphone"(){
		given: "user types Collishop address"
		to CollishopHomePage
		
		expect: "user lands on Collishop homepage"
		at CollishopHomePage
		
		and: "scroll the page"
		scrolldown()
		
		when: "user selects subcategory from the menu"
		selectCategory "Sport, Reizen & Vrije tijd", "Fotografie & Video"

		then: "category page opens"
		at CategoryPage
		
		when: "user selects subcategory from the menu"
		selectCategory "Huishouden & Opbergen", "Strijken & Naaien"

		then: "category page opens"
		at CategoryPage
		
		when: "user want to search for phones"
		searchItem("smartphone")
		
		then: "look at the results"
		at SearchPage
		
		and: "user click on search result"
		firstResultLink1.click()
		
		and: "select the phone type"
		selectRes()
		
		and: "click on phone dimension 1"
		elems.click()
		
		and: "click on phone dimension 2"
		elems1.click()
		
		and: "click on phone dimension 3"
		elems2.click()
		
		and: "click on phone dimension 4"
		elems3.click()
		
		and: "click on phone dimension 5"
		elems4.click()
				
		when: "user press add cart"
		addCartLink().click()
		
		then: "cart page opens"
		waitFor{at CartPage}
	}
	
//	def "search an item"(){
//		given: "user types Collishop address"
//		to CollishopHomePage
//
//		expect: "user lands on Collishop homepage"
//		at CollishopHomePage
//
//		when: "user search for books"
//		searchItem("books")
//
//		then: "look at the results"
//		at SearchPage
//		
//		and: "click on first result"
//		addSearchItem()
//
//		then: "user lands at cart Page"
//		waitFor{at CartPage}
//	}
//
//	def "adding a product to the shopping cart 01"() {
//		given: "user types Collishop address"
//		to CollishopHomePage
//
//		expect: "user lands on Collishop homepage"
//		at CollishopHomePage
//
//		when: "user selects subcategory from the menu"
//		selectCategory "Sport, Reizen & Vrije tijd", "Fotografie & Video"
//
//		then: "category page opens"
//		at CategoryPage
//		
//		when: "click on first result"
//		waitFor {addItem()}
//
//		then: "user lands at category view Page"
//		waitFor{at CartPage}
//	}
//	
//	def "adding a home appliance item to cart"(){
//		given: "user types Collishop address"
//		to CollishopHomePage
//
//		expect: "user lands on Collishop homepage"
//		at CollishopHomePage
//
//		when: "user selects subcategory from the menu"
//		selectCategory "Huishouden & Opbergen", "Strijken & Naaien"
//
//		then: "category page opens"
//		at CategoryPage
//		
//		when: "click on first result"
//		waitFor {addItem()}
//
//		then: "user lands at category view Page"
//		waitFor{at CartPage}
//	}
//	
//	def "search for some mobiles"(){
//		given: "user types Collishop address"
//		to CollishopHomePage
//
//		expect: "user lands on Collishop homepage"
//		at CollishopHomePage
//
//		when: "user selects subcategory from the menu"
//		selectCategory "Gaming & Multimedia", "Gsm's & Smartphones"
//
//		then: "category page opens"
//		at CategoryPage
//		
//		and: "look at the phones"
//		scrolldown()
//	}
//	
//	def "adding Kitchen item into cart"(){
//		given: "user types Collishop address"
//		to CollishopHomePage
//
//		expect: "user lands on Collishop homepage"
//		at CollishopHomePage
//
//		when: "user selects subcategory from the menu"
//		selectCategory "Koken & Tafelen", "Kookboeken"
//
//		then: "category page opens"
//		at CategoryPage
//		
//		when: "click on first result"
//		waitFor {addItem()}
//
//		then: "user lands at category view Page"
//		waitFor{at CartPage}
//	}
	
//	def "adding mobile to the cart for chrome"() {
//		given: "user types Collishop address"
//		to CollishopHomePage
//
//		expect: "user lands on Collishop homepage"
//		at CollishopHomePage
//
//		when: "user selects subcategory from the menu"
//		selectCategory "Gaming & Multimedia", "Gsm's & Smartphones"
//
//		then: "category page opens"
//		at CategoryPage
//		
//		when: "click on first result"
//		addItem()
//
//		then: "user lands at category view Page"
//		at CartPage
//	}
}
