package be.collishop
class CollishopHomePage extends CollishopPage {
    static url = "http://www.collishop.be/e/nl/cs/home"
	
	def searchItem(name){
		$("form").find("input", name: "searchTerm").value(name)
		$("form").find("button", name: "searchBtn").click()
	}
	
	def scrolldown(){
		waitFor(20){js.exec("var ret=false;var obj=document.body; var iScrollHeight = obj.scrollHeight;var iScrollTop = obj.scrollTop;var t;function scrollPage(i){"
		+"if(iScrollHeight > window.pageYOffset+window.innerHeight){window.scrollBy(i,i++);i=i+1;t=setTimeout(function(){scrollPage(i)},2000);"
		+"}else{clearTimeout(t);setTimeout(function(){window.scroll(0,0)},2000);ret=true;}}scrollPage(0);return ret;")}
	}
}