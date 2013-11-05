package be.collishop
import geb.spock.*
import java.util.regex.Pattern


class CollishopSpec extends GebReportingSpec {
	final String EUR = "\u20AC"
//    def "adding a product to the shopping cart updates the list of products"() {
//        given: "user types Collishop address"
//        to CollishopHomePage
//
//        expect: "user lands on Collishop homepage"
//        at CollishopHomePage
//
//        when: "user selects subcategory from the menu"
//        selectCategory "Gaming & Multimedia", "XBOX 360"
//
//        then: "category page opens"
//        at CategoryPage
//
//        and: "user sees that the displayed item is related to the selected category"
//        firstResultLink.text().contains("XBOX 360")
//
//        and: "user clicks on the item name"
//        clickOnFirstResultLink() == null    // GEB-142
//
//        then: "a product page is displayed"
//        waitFor { at ProductDetailsPage }
//
//        and: "user clicks 'add to cart' button"
//        addToCartButton.click()
//
//        then: "a cart content is displayed"
//        waitFor {at CartPage}
//    }
	
	def "ordering process"() {
		given: "user types Collishop address"
		to CollishopHomePage

		expect: "user lands on Collishop homepage"
		at CollishopHomePage

		when: "user selects subcategory from the menu"
		selectCategory "Sport, Reizen & Vrije tijd", "Fotografie & Video"

		then: "category page opens"
		at CategoryPage
		
		when: "user selects 'Prijs' menu entry"
		unfoldMenuItem "Prijs"
		
		then: "price range selection becomes available"
		at CategoryPageWithPriceListing
				
		when: "user selects 'Tussen € 75 en € 100' menu entry"
		openSubCategoryWithPrice(between: 75, and: 100)
		
		then: "user sees that results are filtered by price"
		at CategoryPageWithActiveFilter
				
		when: "user selects Vivitar digitaal fototoestel"
		openProductDetailsPage "Vivitar digitaal fototoestel S830"
		
		then: "product details page is opened"
		at ProductDetailsPage
		
		when: "user changes product color"
		selectProductColor "rood"
		
		and: "user adds product to shopping cart"
		clickOnBuyButton "In winkelmandje"
		
		then: "product details page is available"
		at ProductDetailsPage
	
		// Actual screen flow starts here
		// but you may notice that there's a product in
		// shopping cart already.
		// Specification above adds that prerequisite and
		// actual screen flow starts below.
		when: "user types Collishop address"
		to CollishopHomePage

		then: "user lands on Collishop homepage"
		at CollishopHomePage

		when: "user selects subcategory from the menu"
		selectCategory "Sport, Reizen & Vrije tijd", "Fotografie & Video"

		then: "category page opens"
		at CategoryPage
		
		when: "user selects 'Prijs' menu entry"
		unfoldMenuItem "Prijs"		
		
		then: "price range selection becomes available"
		at CategoryPageWithPriceListing		
		
		when: "user selects 'Tussen € 75 en € 100' menu entry"
		openSubCategoryWithPrice(between: 75, and: 100)	
				
		then: "user sees that results are filtered by price"
		at CategoryPageWithActiveFilter
		
		when: "user selects Nikon Coolpix S3500"
		openProductDetailsPage "Nikon digitaal fototoestel Coolpix S3500" 
		
		then: "product details page is opened"
		at ProductDetailsPage
		
		when: "user changes product color"
		selectProductColor "zwart"
		
		and: "user clicks on Vergelijken"
		clickOnCompareButton "Vergelijken"
		
		then: "product compare page is opened"
		at ProductComparePage
		
		when: "user clicks on number of Compacte fotoestellen"		
		getPhotosetButton "Compacte fototoestellen"		
		
		then: "category page opens"
		at CategoryPage
			
		when: "user selects 'Prijs' menu entry"
		unfoldMenuItem "Prijs"		
		
		then: "price range selection becomes available"
		at CategoryPageWithPriceListing
		
		when: "user selects 'Tussen € 75 en € 100' menu entry"
		openSubCategoryWithPrice(between: 75, and: 100)
		
		then: "user sees that results are filtered by price"
		at CategoryPageWithActiveFilter
		
		//when: "user selects Panasonic digitaal fototoestel DMC-XS1"    - This product is no longer available
		//openProductDetailsPage "Panasonic digitaal fototoestel DMC-XS1"
		
		when: "user selects Fuji digitaal fototoestel Finepix JX500"
		openProductDetailsPage "Fuji digitaal fototoestel Finepix JX500"
		
		then: "product details page is opened"
		at ProductDetailsPage
		
		when: "user changes product color"
		selectProductColor "grijs"
		
		// It seems that the product in specific color is not available
//		and: "user changes product color"
//		selectProductColor "rood"
		
		then: "product details page is opened"
		at ProductDetailsPage
		
		when: "user clicks on Fuji digitaal fototoestel Finepix JX500"
		validateProductThumbnails()
		
		and: "user clicks on Vergelijken"
		clickOnCompareButton "Vergelijken"
		
		then: "product compare page is opened"
		at ProductComparePage
		
		when: "user clicks on number of Compacte fotoestellen"
		getPhotosetButton "Compacte fototoestellen"
								
		then: "category page opens"
		at CategoryPage
		
		when: "user selects 'Prijs' menu entry"
		unfoldMenuItem "Prijs"
		
		then: "price range selection becomes available"
		at CategoryPageWithPriceListing
		
		when: "user selects 'Tussen € 75 en € 100' menu entry"
		openSubCategoryWithPrice(between: 75, and: 100)
		
		then: "user sees that results are filtered by price"
		at CategoryPageWithActiveFilter
				
		then: "user clicks on subcategory page"
		at SubCategoryPage
		
		when: "user unfolds Olympus digitaal fototoestel VG-180 menu entry"
		unfoldProductInfo()
					
		and:  "user compares Olympus digitaal fototoestel VG-180"
		compareProduct()
						
		then: "product details page is opened"
		at ProductDetailsPage
		
		when: "user changes product color"
		selectProductColorOnModalWindow "zwart"
		
		and: "user clicks on Vergelijken"
		clickOnCompareButtonOnModalWindow()
		
		then: "product compare page is opened"
		at ProductComparePage
		
		when: "user clicks on button which shows all criteria"
		clickOnShowAllCriteriaButton()
		
		then: "user deletes last choosen product"
		productDeleted()
				
		when: "user unfolds Nikon digitaal fototoestel Coolpix S3500 menu entry"
		unfoldProductInfoOnComparePage()
		
		and: "user adds Nikon digitaal fototoestel Coolpix S3500 to basket"
		addProductToBasket()
		
		then: "basket page is opened"
		at BasketPage
				
		when: "user removes product"
		removeProductFromBasket()
		
		then: "user moves to basket page"
		to BasketPage
		
		when: "user clicks on setting number of product"
		changeNumberOfProduct()
		
		and: "user sets number of product from input"
	    setNumberOfProductFromInput()		
		
		then: "basket is updated"
		at BasketPage
		
		when: "user clicks on description 'quick add products'"
		clickOnDescriptionQuickAddProducts()
		
		then: "user still remains on basket page"
		at BasketPage
		
		when: "user clicks outside info message to close that helper message"
		clickOnFootBasketTable()
		
		then: "basket page is still available"
		at BasketPage
		
		when: "user clicks on continue to next page"
		clickOnContinueToNextPage()
		
		//then: "delivery and payment page is opened"
		//to DeliveryPaymentPage
		
		then: "delivery and payment page is opened"
		waitFor { at DeliveryPaymentPage }
		
		when: "user clicks on link to create account"
		clickOnLinkToCreateAccount()
				
		then: "create account page is open"
		at CreateAccountPage
		
		when: "user creates account"
		createAccount()
		
		then: "overview shopping basket page is opened"
		at OverwievShoppingBasketPage
		
		when: "user clicks on link to choose collection point"
		chooseCollectionPoint "Kies je afhaalpunt"
		
		then: "overview shopping basket page is opened"
		at OverwievShoppingBasketPage
		
		when: "user sets text to collection point"
		setTextToCollectionPoint "1000"
		
		then: "overview shopping basket page is opened"
		at SummaryOfBookingPage
		
		when: "user accepts reservation"
		acceptingReservation()
		
		then: "overview shopping basket page is opened"
		at SummaryOfBookingPage		
	}
	
}
