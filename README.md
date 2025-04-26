🥒 Cucumber BDD Framework
Author: Sandhya Sankeshwar

📋 Project Overview
This project uses Cucumber (Behavior-Driven Development - BDD) for automating functional tests.
It is built using Java, Selenium WebDriver, Cucumber, TestNG, Maven, and follows a Page Object Model (POM) design pattern.

🛠 Tech Stack
Java

Selenium WebDriver

Cucumber (Gherkin syntax)

TestNG

Maven

Extent Reports / Allure Reports (optional)

Log4j (optional for logging)

Git and GitHub (for version control)

📂 Project Structure
bash
Copy
Edit
/src
  /main
    /java
      /pages               # Page classes (POM)
      /utils               # Utility classes (driver, waits, config)
  /test
    /java
      /stepDefinitions     # Step Definitions
      /runners             # Cucumber Test Runners
    /resources
      /features            # Gherkin Feature Files
pom.xml                    # Maven Build File
README.md                  # Project Documentation
🧪 How to Run Tests
Clone the repository

bash
Copy
Edit
git clone https://github.com/your-username/cucumber-bdd-framework.git
Navigate to the project directory

bash
Copy
Edit
cd cucumber-bdd-framework
Install dependencies
Maven will automatically download dependencies mentioned in pom.xml.

Execute tests
Run from terminal:

bash
Copy
Edit
mvn clean test
🧾 Sample Feature File (Gherkin Syntax)
gherkin
Copy
Edit
Feature: Login functionality for the application

  Scenario: Successful login with valid credentials
    Given User is on Login Page
    When User enters valid username and password
    And clicks on login button
    Then User should be navigated to the Home Page
⚙️ Sample Step Definition
java
Copy
Edit
@Given("User is on Login Page")
public void user_is_on_login_page() {
    loginPage.openLoginPage();
}

@When("User enters valid username and password")
public void user_enters_valid_username_and_password() {
    loginPage.enterCredentials("username", "password");
}

@And("clicks on login button")
public void clicks_on_login_button() {
    loginPage.clickLogin();
}

@Then("User should be navigated to the Home Page")
public void user_should_be_navigated_to_the_home_page() {
    Assert.assertTrue(homePage.isHomePageDisplayed());
}
📋 Reporting
After execution, Cucumber HTML reports will be available in /target/cucumber-reports/.

You can also integrate Extent Reports or Allure Reports for better advanced reporting.

📢 Important Notes
Follow consistent naming conventions for better readability.

Keep your Step Definitions reusable and clean.

Feature files should be simple, business-readable, and modular.

Use Tags like @Smoke, @Regression to organize and filter tests.

✨ Happy Testing with Cucumber BDD! ✨
