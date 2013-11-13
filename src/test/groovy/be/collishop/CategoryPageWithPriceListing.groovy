package be.collishop;

public class CategoryPageWithPriceListing extends CategoryPage {
	
	static at = {
		activeSubmenu.text().contains("Prijs")
	}
	
	static content = {
		activeSubmenu(cache: false, wait: true) { $("div[id='searchFacet'] .level1.open > a") }
		submenuItems(cache: false, wait: true) { $("div[id='searchFacet'] .level1.open>ul>li>a") }
	}
	
	def openSubCategoryWithPrice(Map map) {
		def pattern = "(.|\\s)*" + map.between + ".*" + map.and + ".*"
		interact{
			moveToElement(getElement(pattern, submenuItems))
			click()
		}
	}
}
