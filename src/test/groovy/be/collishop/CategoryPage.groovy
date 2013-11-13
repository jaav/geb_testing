package be.collishop
import org.apache.log4j.Logger
import java.util.regex.Pattern
import org.openqa.selenium.WebElement

class CategoryPage extends CollishopPage {
    static at = { results }
    static content = {
        results(wait: true) { $("article.product > div.modMain") }
        result { i -> results[i] }
        firstResultLink { results[0] }
		
		
		cartDialogBtn { firstResultLink.find("div.toggleSlidebox") }
		theResultDiv(required: false) { firstResultLink.find("div.actions") }
		addtoCartBtn {firstResultLink.find("a",0)}
		
		menu(wait: true) { $("nav.refine li.level1 > a.heading") }
		menuItem(wait: true) { name -> $("nav.refine li.level1 > a.heading", text: name) }
		productsDescriptions(cache:false, wait: true) { $(".excerpt>h1>span") }
		submenu(wait: true) { $("ul .open > ul > li") }
		submenuItem(wait: true) { name -> $("ul .open > ul > li > a ".text.contains , text: name) }
		
    }
	
	def unfoldMenuItem(item) {
		interact {
			moveToElement(menuItem(item))
			click()
		}
	}

    def clickOnFirstResultLink() {
        def log = Logger.getLogger( getClass() )
        interact {
            moveToElement(firstResultLink)
            click()
            log.info firstResultLink
            log.info results
            log.info firstResultLink
        }		
    }
	
	def searchItem(name){
		$("form").find("input", name: "searchTerm").value(name)
		$("form").find("button", name: "searchBtn").click()
	}
	
	def selectSubmenu(Pattern regex) {
		WebElement item = submenu.collect().find { it -> it.getText() == regex }		
	}

	def addItem(){
			cartDialogBtn.click()
			waitFor { theResultDiv.present }
			addtoCartBtn.click()
	}
	
	def openProductDetailsPage(pattern) {
		waitFor{ productsDescriptions.size() > 0 }
		pattern = "(.|\\s)*" + pattern + ".*"
		getElement(pattern, productsDescriptions).click()
	}
}
