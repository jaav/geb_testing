package be.collishop
import org.apache.log4j.Logger
import java.util.regex.Pattern
import java.util.regex.Matcher
import org.openqa.selenium.WebElement
import org.codehaus.groovy.runtime.GStringImpl

import java.util.regex.Pattern
import org.openqa.selenium.WebElement

class CategoryPage extends CollishopPage {		
    static at = { results }
    static content = {
        results(wait: true) { $("article.product > div.modMain") }
        result { i -> results[i] }
        firstResultLink { results[0] }
				
		menu(wait: true) { $("nav.refine li.level1 > a.heading") }
		menuItem(wait: true) { name -> $("nav.refine li.level1 > a.heading", text: name) }		
		submenuItems(cache: false, wait: true) { $("div[id='searchFacet'] .level1.open>ul>li>a") }		
		submenu(wait: true) { $("ul .open > ul > li") }	
		productsDescriptions(cache:false, wait: true) { $(".excerpt>h1>span") }			
		productInfo(wait: true) { $('footer > div[id="13014"]') } 
		buttonCompareProduct(wait: true) { $("#compare_13014>a") }
    }

	def unfoldMenuItem(item) {
		interact {
			moveToElement(menuItem(item)) 
			click()
		}
	}
	
	def unfoldProductInfo() {
		waitFor { 
			$(".excerpt>h1>span")
		}
		log.info "size: " + $(".excerpt>h1>span").size()
		log.info "first element: " + $(".excerpt>h1>span").firstElement().getText()
		def nav1 = $(".excerpt>h1>span", text: " Olympus digitaal fototoestel VG-180 ")
		log.info "nav1: " + nav1.text()		
		def nav2 = nav1.parent().parent().parent().parent().find("footer > div")
		log.info "nav2: " + nav2.text()
		
		interact {
			moveToElement(productInfo) 
			click()			
		}
		
	}
	
	def compareProduct() {		
		interact {
			moveToElement(buttonCompareProduct) 
			click()
		}
		
	}
	
    def clickOnFirstResultLink() {
        interact {
            moveToElement(firstResultLink)
            click()
            log.info firstResultLink
            log.info results
            log.info firstResultLink
        }		
    }
		
	/**
	 * Finds and returns a submenu item matched by the given pattern
	 * @param pattern Regular expression
	 * @return item (or NullPointer) that is a submenu item (of WebElement type)
	 */
	def getSubmenuItem(pattern) {
		log.info "submenuItems: " + submenuItems
		log.info "submenuItems.allElements(): " + submenuItems.allElements()
		log.info "submenuItems.allElements()[0]: " + submenuItems.allElements()[0]	
		waitFor{ submenuItems.present }
		getElement(pattern, submenuItems)
	}

	def openProductDetailsPage(pattern) {
		waitFor{ productsDescriptions.size() > 0 }
		pattern = "(.|\\s)*" + pattern + ".*"
		getElement(pattern, productsDescriptions).click()			
	}
	
}
