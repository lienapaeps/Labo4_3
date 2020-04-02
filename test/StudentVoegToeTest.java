import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class StudentVoegToeTest {

	// verander de <projectnaam> naar de naam van jouw project
	private static final String url = "http://localhost:8080/web_war_exploded/";
	private WebDriver driver;
	
	@Before
	public void setUp () {
		// maak een nieuwe ChromeDriver (zie vorige labo's)
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\paeps\\Documents\\19-20\\Semester2\\Webontwikkeling2\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public void test_StudentForm_alles_invullen_gaat_naar_overzicht_en_toont_nieuwe_student_in_tabel () {
		driver.get(url+"studentForm.jsp");
		
		WebElement naamField = driver.findElement(By.id("naam"));
		naamField.sendKeys("Kemme");
		
		WebElement voornaamField = driver.findElement(By.id("voornaam"));
		voornaamField.sendKeys("Mieke");
		
		WebElement leeftijdField = driver.findElement(By.id("leeftijd"));
		leeftijdField.sendKeys("18");

		WebElement studierichtingField = driver.findElement(By.id("studierichting"));
		studierichtingField.sendKeys("TI");

		WebElement button = driver.findElement(By.id("bewaar"));
		button.click();
		
		assertEquals("Overzicht studenten", driver.findElement(By.tagName("h1")).getText());
		assertNotNull(driver.findElement(By.id("Kemme")));
	}

	@Test
	public void test_StudentForm_helemaal_leeg_laten_gaat_terug_naar_formulier () {
		driver.get(url+"studentForm.jsp");
		
		WebElement button = driver.findElement(By.id("bewaar"));
		button.click();
		
		assertEquals("New Student", driver.findElement(By.tagName("h1")).getText());
	}
	
	@Test
	public void test_StudentForm_naam_leeg_laten_gaat_terug_naar_formulier () {
		driver.get(url+"studentForm.jsp");
		
		WebElement naamField = driver.findElement(By.id("naam"));
		naamField.clear();
		
		WebElement voornaamField = driver.findElement(By.id("voornaam"));
		voornaamField.sendKeys("Elke");
		
		WebElement leeftijdField = driver.findElement(By.id("leeftijd"));
		leeftijdField.sendKeys("18");

		WebElement studierichtingField = driver.findElement(By.id("studierichting"));
		studierichtingField.sendKeys("TI");

		WebElement button = driver.findElement(By.id("bewaar"));
		button.click();
		
		assertEquals("New Student", driver.findElement(By.tagName("h1")).getText());
	}

	@Test
	public void test_StudentForm_naam_en_leeftijd_leeg_laten_gaat_terug_naar_formulier () {
		driver.get(url+"studentForm.jsp");
		
		WebElement naamField = driver.findElement(By.id("naam"));
		naamField.clear();
		
		WebElement voornaamField = driver.findElement(By.id("voornaam"));
		voornaamField.sendKeys("Elke");
		
		WebElement leeftijdField = driver.findElement(By.id("leeftijd"));
		leeftijdField.clear();
		
		WebElement studierichtingField = driver.findElement(By.id("studierichting"));
		studierichtingField.sendKeys("TI");

		WebElement button = driver.findElement(By.id("bewaar"));
		button.click();
		
		assertEquals("New Student", driver.findElement(By.tagName("h1")).getText());
	}

	@After
	public void tearDown () {
		driver.quit();
	}
	
}
