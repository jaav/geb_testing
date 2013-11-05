package be.collishop

import org.openqa.selenium.support.ui.Select

class ProductDetailsPage extends CollishopPage {
    static at = {
        // check if EUR symbol is displayed
        $(".natural").text().contains "\u20AC"
        //addToCartButton
    }

    static content = {
        addToCartButton(to: CartPage, wait: true) { $(".lnkBuy.buttonPrimary>a") }
		productColor(wait: true) { $("#frmProdBasket-prodList") }
		compareButton(to: ProductComparePage, wait: true) { name -> $(".lnkCompare.buttonSecondary>a", text: name) }
		compareButtonOnModalWindow(to: ProductComparePage, wait: true) { $(".lnkCompare.buttonPrimary>a") }		
		buyButton(wait: true) { name -> $(".lnkBuy.buttonPrimary>a") }
		productImages(wait: true) { $("section[id='mediaPlayerMain'] .graphic>img") }
		productActiveVisibility(wait: true) { $("section[id='prodSKU'] .prodSectionMain .graphic>img") }
		cursorImage(wait: true) { $("section[id='prodSKU'] .caption.dialogToggle") }
		cursorProductImages(wait: true) { $("*[id='dialogfullProduct'] section[class='navPaging carousel'] .graphic>img") }
		currsorProductActiveVisibility(wait: true) { $("*[id='fullProductOverlay'] .imgLayer>img") }
		closeCursorImage(wait: true) { $("div[id='dialogfullProduct'] span[role='button']") }
    }
	
    def selectProductColor = { color -> productColor.product_Kleur = color}
	
	def selectProductColorOnModalWindow = { color -> productColor.Kleur = color}
	
	def validateProductThumbnails() {
		def items = productImages.allElements()
		def indexActiveProductVisibility
		def indexProductItem		
		// iterate through the collection
		for(item in items) {
			// and check what element contains given text										
			String stringProductItem = new String($(item).@src)									
			indexProductItem = stringProductItem.lastIndexOf("/")						
			item.click()
			String stringActiveProductVisibility = new String($(productActiveVisibility).@src)
			indexActiveProductVisibility = stringActiveProductVisibility.lastIndexOf("/")								
			assert stringActiveProductVisibility.substring(indexActiveProductVisibility) == stringProductItem.substring(indexProductItem)																						
		}
		
		items = cursorProductImages.allElements()		
		cursorImage.click()
				
		for(item in items) {
			// and check what element contains given text			
			String stringProductItem = new String($(item).@src)			
			indexProductItem = stringProductItem.lastIndexOf("/")			
			item.click()				
			String stringActiveProductVisibility = new String($(currsorProductActiveVisibility).@src)												
			indexActiveProductVisibility = stringActiveProductVisibility.lastIndexOf("/")				
			assert stringActiveProductVisibility.substring(indexActiveProductVisibility) == stringProductItem.substring(indexProductItem)																					
		}		
		closeCursorImage.click()		
		return items		
	}
	
	def clickOnCompareButtonOnModalWindow() {
		compareButtonOnModalWindow.click()
	}
	
	def clickOnBuyButton(text) {
		buyButton(text).click()
	}
	
	def clickOnCompareButton(text) {
		compareButton(text).click()
	}
	
}

