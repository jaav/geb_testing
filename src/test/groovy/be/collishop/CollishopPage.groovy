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

}


