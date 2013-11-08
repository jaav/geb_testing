package be.collishop
import org.apache.log4j.Logger
import java.util.regex.Pattern
import org.openqa.selenium.WebElement

class CategoryPage extends CollishopPage {
    static at = { results }
    static content = {
        results(wait: true) { $("article.product > footer.modFooter") }
        result { i -> results[i] }
        firstResultLink { results[1] }
		cartDialogBtn { firstResultLink.find("div.toggleSlidebox") }
		theResultDiv(required: false) { firstResultLink.find("div.actions") }
		addtoCartBtn {firstResultLink.find("a",0)}
		
		menu(wait: true) { $("nav.refine li.level1 > a.heading") }
		menuItem(wait: true) { name -> $("nav.refine li.level1 > a.heading", text: name) }
		
		submenu(wait: true) { $("ul .open > ul > li") }
		submenuItem(wait: true) { name -> $("ul .open > ul > li > a ".text.contains , text: name) }
		
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
}
