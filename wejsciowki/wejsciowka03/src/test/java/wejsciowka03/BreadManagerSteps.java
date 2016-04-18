package wejsciowka03;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.util.List;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class BreadManagerSteps {
	
	BreadManager breadManager;
	private IBreadManager IBreadManager;
	private List<Bread> breadlist;
	
	@Given("a bread manager")
	public void initiallizeBreadManager() {
		breadManager = new BreadManager(IBreadManager);
	}
	
	@When("add bread with name $name, price $price and code $code")
	public void addBread(String name, double price, int code) {
		Bread bread = new Bread(name, price, code);
		breadManager.Add(bread);		
	}
	
	@Then("amount of breads should be $number")
	public void checkAmount(int number) {
		assertEquals(number, breadlist.size());
	}
	
	@Then("there should exists bread with number: $code")
	public void checkConnection(int code) {
		assertNotNull(breadManager.Get(code));
	}
	
}
