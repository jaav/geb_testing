package be.collishop
import java.util.regex.Pattern;
import org.openqa.selenium.WebElement

import geb.Page

class SearchPage extends Page {

    static at = { title.contains "collishop" }	
	
	static content = {
		results(wait: true) { $("article.product > footer.modFooter") }
		result { i -> results[i] }
		firstResultLink { results[1] }
		ajaxBtn { firstResultLink.find("div.toggleSlidebox") }
		theResultDiv(required: false) { firstResultLink.find("div.actions") }
		link(wait: true) {firstResultLink.find("a",1)}
	
		menuItem(wait: true) { name -> $("nav.refine li.level1 > a.heading", text: name) }
		submenu(wait: true) { $("li. open > ul > li") }
		
		submenuItem(wait:true) {name -> $("li. open > ul > li > a",text:name)}
		
		results1(wait: true) { $("article.product > div.modMain") }
		result1 { i -> results1[i] }
		firstResultLink1 { results1[3] }
		
		
		//selecting the phone type
		selectRes {$("form")."product_Kleur" ="zwart"}
		//check the phone for different dimensions
		elems(wait: true) {$("div.carouselPanel > div.navElement").next()}
		elems1(wait: true) {elems.next()}
		elems2(wait: true) {elems1.next()}
		elems3(wait: true) {elems2.next()}
		elems4(wait: true) {elems3.next()}
		//add the selected phone to cart
		addCartLink(wait:true) {$("div.frmActions").find("a",0)}
	}

	def scrolldown(){
		waitFor(12){js.exec("var ret=false;var obj=document.body; var iScrollHeight = obj.scrollHeight;var iScrollTop = obj.scrollTop;var t;function scrollPage(i){"
		+"if(iScrollHeight > window.pageYOffset+window.innerHeight){window.scrollBy(i,i++);i=i+1;t=setTimeout(function(){scrollPage(i)},2000);"
		+"}else{clearTimeout(t);setTimeout(function(){window.scroll(0,0)},2000);ret=true;}}scrollPage(0);return ret;")}
	}
	
	def selectSubmenu(String regex) {
		WebElement item = submenu.collect().find { it -> it.getText() == regex }
	}
	
	def addSearchItem(){
		ajaxBtn.click()
		waitFor { theResultDiv.present }
		link.click()
	}
	
	def selectCategory (cat, subcat) {
		interact {
			moveToElement($("a", 'data-gacustomvar': contains(cat)))
			moveToElement($("a", 'data-gacustomvar': contains(subcat)))
			click()
		}
	}
}


