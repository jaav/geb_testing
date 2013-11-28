package be.collishop

import groovy.lang.MetaClass

class CategoryPageWithActiveFilter extends CategoryPage {
	static at = {
		activeFilter.text().contains("Prijs")
	}
	
	static content = {
		activeFilter(wait:true) {$(".activeFilters>ul>li~li>span")}
	}
}
