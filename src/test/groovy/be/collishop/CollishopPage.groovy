package be.collishop
import geb.Page

class CollishopPage extends Page {

    static at = { title.contains "Collishop" }	

    def selectCategory (cat, subcat) {
        interact {
            moveToElement($("a", 'data-gacustomvar': contains(cat)))
            moveToElement($("a", 'data-gacustomvar': contains(subcat)))
            click()
        }
    }
	
	def getElement(pattern, elements) {
		waitFor{ elements.present }
		def items = elements.allElements()
		for(item in items) {
			def label = item.getText()
			if( label ==~ pattern) {
				return item
			}
		}
	}

}


