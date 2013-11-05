
/*
	This is the Geb configuration file.
	
	See: http://www.gebish.org/manual/current/configuration.html
*/


import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver

waiting {
	timeout = 7
}

// default is to use firefox
driver = { 
		def webdriver = new FirefoxDriver() 
		webdriver.manage().window().maximize()
		return webdriver
	}

driver = {
	def webdriver = new ChromeDriver()
	webdriver.manage().window().maximize()
	return webdriver
}

environments {
	
	// run via “./gradlew chromeTest”
	// See: http://code.google.com/p/selenium/wiki/ChromeDriver
	///////chrome {
	///////	driver = { new ChromeDriver() }
	///////}
	
	chrome {
		driver = {
			def webdriver = new ChromeDriver()
			webdriver.manage().window().maximize()
			return webdriver
		}
	}
	
	// run via “./gradlew firefoxTest”
	// See: http://code.google.com/p/selenium/wiki/FirefoxDriver
	firefox {
		driver = { 
            def webdriver = new FirefoxDriver()
            webdriver.manage().window().maximize()
            return webdriver
		}
	}

}

reportsDir = "target/geb-reports"

// To run the tests with all browsers just run “./gradlew test”