package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class SampleSteps {
    private WebDriver driver;

    public SampleSteps() {
        this.driver = Hooks.driver;
    }

    @Given("^I am on the home page$")
    public void iAmOnTheHomePage() throws Throwable {
        driver.get("https://kristinek.github.io/site");
    }

    @Then("^I should see home page header$")
    public void iShouldSeeHomePageHeader() throws Throwable {
        assertEquals("This is a home page",
                driver.findElement(By.cssSelector("h1")).getText());
    }

    @And("^I should see home page description$")
    public void iShouldSeeHomePageDescription() throws Throwable {
        assertEquals("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                driver.findElement(By.cssSelector("p")).getText());
    }

    @When("^I enter name: \"([^\"]*)\"$")
    public void iEnterName(String name) throws Throwable {
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys(name);
    }

    @And("^I enter age: (\\d+)$")
    public void iEnterAge(int age) throws Throwable {
        driver.findElement(By.id("age")).sendKeys(String.valueOf(age));
    }

    @Given("^I (?:am on|open) age page$")
    public void iAmOnAgePage() throws Throwable {
        driver.get("https://kristinek.github.io/site/examples/age");
    }

    @And("^I click submit age$")
    public void iClickSubmitAge() throws Throwable {
        driver.findElement(By.id("submit")).click();
    }

    @Then("^I see message: \"([^\"]*)\"$")
    public void iSeeMessage(String message) throws Throwable {
        assertEquals(message, driver.findElement(By.id("message")).getText());
    }

    @When("^I enter values:$")
    public void iEnterValues(Map<String, String> valuesToEnter) throws Throwable {
        for (Map.Entry<String, String> e : valuesToEnter.entrySet()) {
            driver.findElement(By.id(e.getKey())).clear();
            driver.findElement(By.id(e.getKey())).sendKeys(e.getValue());
            System.out.println("key is " + e.getKey());
            System.out.println("value is " + e.getValue());
        }
    }

    @And("^I should see menu$")
    public void iShouldSeeMenu() throws Throwable {
        assertTrue(driver.findElement(By.className("w3-navbar")).isDisplayed());
    }

    @And("^I click the result checkbox button$")
    public void iClickTheResultCheckboxButton() throws Throwable {
        driver.findElement(By.id("result_button_checkbox")).click();
    }

    @When("^I clicked on checkboxes:$")
    public void iClickedOnCheckboxes(List<String> values) throws Throwable {
        for (String value : values) {
            driver.findElement(By.cssSelector("[value='" + value + "']")).click();
        }
    }

    @Then("^message for checkboxes \"([^\"]*)\" is seen$")
    public void messageForCheckboxesIsSeen(String message) throws Throwable {
        assertEquals(message, driver.findElement(By.id("result_checkbox")).getText());
    }

    @Given("^I am on action page$")
    public void iAmOnActionPage() {
        driver.get("https://kristinek.github.io/site/examples/actions");
    }

    @Given("^Navigate to url \"([^\"]*)\"$")
    public void navigateToUrl(String url) throws Throwable {
        driver.get(url);
    }


    @When("^I Press the agree button in google$")
    public void iPressTheAgreeButtonInGoogle() {
        WebElement popUp = driver.findElement(By.cssSelector("iframe[src*='https://consent.google.com?hl=lv&origin=https://www.google.com&continue=https://www.google.com/&if=1&m=0&pc=s&wp=-1&gl=LV']"));
        driver.switchTo().frame(popUp);
        driver.findElement(By.xpath("//*[@id=\"introAgreeButton\"]/span/span")).click();
        driver.switchTo().defaultContent();
    }

    @When("^I write \"([^\"]*)\" in search textbox$")
    public void iWriteInSearchTextbox(String arg0) throws Throwable {
        driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input")).sendKeys(arg0);
    }

    @Then("^I see 'I feel lucky' button$")
    public void iSeeIFeelLuckyButton() {
        assertTrue(driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/center/input[2]")).isDisplayed());
    }


    @Given("^I am on a Page Enter a number page$")
    public void iAmOnAPageEnterANumberPage() {
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
    }


    @When("^i enter a number: \"([^\"]*)\"$")
    public void iEnterANumber(String number) throws Throwable {
        driver.findElement(By.id("numb")).sendKeys(String.valueOf(number));
    }

    @And("^I click submit button$")
    public void iClickSubmitButton() throws Throwable {
        driver.findElement(By.className("w3-btn")).click();
    }

    @Then("^I see the square with \"([^\"]*)\" in popup box$")
    public void iSeeTheSquareWithInPopupBox(String arg0) throws Throwable {
        Alert alert = driver.switchTo().alert();
        assertEquals("Square root of 57 is 7.55", alert.getText());
        alert.accept();
    }

    @Then("^I see a message: \"([^\"]*)\"$")
    public void iSeeAMessage(String arg0) throws Throwable {
        assertEquals(arg0, driver.findElement(By.id("ch1_error")).getText());
    }

    @Given("^I am on a People with jobs page$")
    public void iAmOnAPeopleWithJobsPage() {
        driver.get("https://kristinek.github.io/site/tasks/list_of_people_with_jobs.html");
    }


    @When("^i click on add a Person button$")
    public void iClickOnAddAPersonButton() {
        WebElement addPerson = driver.findElement(By.id("addPersonBtn"));
        addPerson.click();
    }

    @And("^I enter the \"([^\"]*)\"$")
    public void iEnterTheName(String name2) throws Throwable {
        WebElement enterName = driver.findElement(By.id("name"));
        enterName.click();
        enterName.sendKeys(name2);
    }

    @And("^I enter the job \"([^\"]*)\"$")
    public void iEnterTheJob(String job2) throws Throwable {
        WebElement enterJob = driver.findElement(By.id("job"));
        enterJob.click();
        enterJob.sendKeys(job2);
    }

    @Then("^I click on Add button$")
    public void iClickOnAddButton() {
        WebElement addButton = driver.findElement(By.id("modal_button"));
        addButton.click();
    }

    @Then("^Person appears in the main list with \"([^\"]*)\"$")
    public void personAppearsInTheMainListWith(String arg0) throws Throwable {
        assertEquals("Anastasija",driver.findElement(By.xpath("*//span[contains(text(),'Anastasija')]")).getText());
    }


    @When("^I click on a person pencil sign to Edit$")
    public void iClickOnAPersonPencilSignToEdit() {
        WebElement pencilSign = driver.findElement(By.xpath("//*[@id=\"person3\"]/span[2]/i"));
        pencilSign.click();
    }


    @And("^I edit the name of the person to \"([^\"]*)\"$")
    public void iEditTheNameOfThePersonTo(String name3) throws Throwable {
        WebElement editName = driver.findElement(By.id("name"));
        editName.clear();
        editName.click();
        editName.sendKeys(name3);
    }

    @And("^I click on edit button$")
    public void iClickOnEditButton() {
        WebElement editButton = driver.findElement(By.id("modal_button"));
        editButton.click();
    }

    @Then("^Person edited name appears in the main list with \"([^\"]*)\"$")
    public void personEditedNameAppearsInTheMainListWith(String arg0) throws Throwable {
        assertEquals(arg0,driver.findElement(By.xpath("//*[@id=\"person3\"]/span[3]")).getText());
    }

    @And("^I click on Reset list button$")
    public void iClickOnResetListButton() {
        driver.findElement(By.xpath("//*[contains(@onclick, 'resetListOfPeople()')]")).click();
    }

    @Then("^Person \"([^\"]*)\" is not present in the list$")
    public void personIsNotPresentInTheList(String name2) throws Throwable {
            List<WebElement> listOfElements = driver.findElements(By.xpath("//span[text() = 'Anastasija']"));
            assertFalse(listOfElements.size()>0);
    }


    @Then("^Person \"([^\"]*)\" not present in the list$")
    public void personNotPresentInTheList(String arg0) throws Throwable {
        List<WebElement> listOfElements = driver.findElements(By.xpath("//span[text() = 'Dmitrijs']"));
        assertFalse(listOfElements.size()>0);
    }

    @And("^I click on Remove button$")
    public void iClickOnRemoveButton() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"person3\"]/span[1]")).click();
    }

    @Then("^Only original names are displayed$")
    public void onlyOriginalNamesAreDisplayed() {
        WebElement mike = driver.findElement(By.xpath("//*[@id=\"person0\"]"));
        assertTrue(mike.isDisplayed());
        WebElement jill = driver.findElement(By.xpath("//*[@id=\"person1\"]"));
        assertTrue(jill.isDisplayed());
        WebElement jane = driver.findElement(By.xpath("//*[@id=\"person2\"]"));
        assertTrue(jane.isDisplayed());
        //driver.findElements(By.xpath("//*[@id=\"person3\"]/span[3]")).size() > 0
       // WebElement anastasija = driver.findElement(By.xpath("//*[@id=\"person3\"]/span[3]"));
        assertFalse(driver.findElements(By.xpath("//*[@id=\"person3\"]/span[3]")).size() > 0);
    }

    @Then("^I click on Clear button$")
    public void iClickOnClearButton() {
        driver.findElement(By.xpath("//*[@id=\"addPersonBtn\"]")).click();
    }

    @Then("^All fields are empty$")
    public void allFieldsAreEmpty() {
        assertEquals("",driver.findElement(By.id("name")).getText());
        assertEquals("",driver.findElement(By.id("job")).getText());
    }
}
