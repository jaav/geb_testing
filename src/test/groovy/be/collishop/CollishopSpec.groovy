package be.collishop
import java.awt.MenuItem;

import geb.spock.*

class CollishopSpec extends GebReportingSpec {

	def "buying process"(){
		given: "user types Collishop address"
		to CollishopHomePage

		expect: "user lands on Collishop homepage"
		at CollishopHomePage

		when: "user selects subcategory from the menu"
		selectCategory "Gaming & Multimedia", "Gsm's & Smartphones"

		then: "category page opens"
		at CategoryPage
		
		when: "user selects 'Prijs' menu entry"
		unfoldMenuItem "Prijs"
		
		then: "price range selection becomes available"
		at CategoryPageWithPriceListing
		
		when: "user selects 'Tussen € 100 en € 200' menu entry"
		openSubCategoryWithPrice(between: 100, and: 200)
		
		then: "user sees that results are filtered by price"
		at CategoryPageWithActiveFilter
		
		when: "user selects Huawei smartphone G525 Ascend"
		openProductDetailsPage "Huawei smartphone G525 Ascend"
		
		then: "product details page is opened"
		at ProductDetailsPage
		
		when: "user changes product color"
		selectProductColor "zwart"
		
		then: "product details page is opened"
		at ProductDetailsPage
		
		when: "user clicks on Thumbnails to closely look at phone"
		validateProductThumbnails()
		
		and: "user clicks on Vergelijken"
		clickOnCompareButton "Vergelijken"
		
		then: "product compare page is opened"
		at ProductComparePage
		
		when: "user clicks on number of Compacte smartphone"
		smartphoneButton "Smartphones"
		
		then: "category page opens"
		at CategoryPage
		
		when: "user selects 'Prijs' menu entry"
		unfoldMenuItem "Prijs"
		
		then: "price range selection becomes available"
		at CategoryPageWithPriceListing
		
		when: "user selects 'Tussen € 100 en € 200' menu entry"
		openSubCategoryWithPrice(between: 100, and: 200)
		
		then: "user sees that results are filtered by price"
		at CategoryPageWithActiveFilter
		
		then: "user clicks on subcategory page"
		at SubCategoryPage
		
		when: "user unfolds LG smartphone E460 Optimus L5 II menu entry"
		unfoldProductInfo()
					
		and:  "user click on In winkelmandje"
		compareProduct()
		
		then: "product details page is opened"
		at ProductDetailsPage
		
		when: "user changes product color"
		selectProductColorOnModalWindow "wit"
		
		and: "user clicks on Vergelijken"
		clickOnCompareButtonOnModalWindow()
		
		then: "product compare page is opened"
		at ProductComparePage
		
		when: "user clicks on button which shows all criteria"
		clickOnShowAllCriteriaButton()
		
		then: "user deletes Huawei smartphone G525 Ascend"
		productDeleted()
		
		when: "user unfolds LG wit"
		unfoldProductInfoOnComparePage()
		
		and: "user adds  LG wit"
		addProductToBasket()
		
		then: "basket page is opened"
		at BasketPage
		
		and: "user put product in the basket"
		to BasketPage
		
	}

}
