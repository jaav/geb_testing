package be.collishop
import geb.Page
import org.apache.log4j.Logger

class CollishopPage extends Page {
	def log = Logger.getLogger( getClass() )
	
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
		log.info "elements: " + elements
		def items = elements.allElements()
		log.info "items: " + items		
		for(item in items) {			
			log.info "item: " + item			
			def label = item.getText()			
			log.info "label = " + label			
			if( label ==~ pattern) {				
				return item
			}
		}
	}

}
