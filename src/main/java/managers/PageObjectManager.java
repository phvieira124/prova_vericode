package managers;

import org.openqa.selenium.WebDriver;

import pageObjects.BuscarCepPage;

public class PageObjectManager {
	
	private WebDriver driver;
	private BuscarCepPage buscarCepPage;
	
	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}

	public BuscarCepPage getBuscarCepPage(){
		return (buscarCepPage == null) ? buscarCepPage = new BuscarCepPage(driver) : buscarCepPage;
	}
}
