# 🥒 Cucumber BDD Framework 

**Author: Sandhya Sankeshwar**

## 📋 Project Overview

This project uses **Cucumber (Behavior-Driven Development - BDD)** for automating functional tests.  
It is built using **Java**, **Selenium WebDriver**, **Cucumber**, **TestNG**, **Maven**, and follows a **Page Object Model (POM)** design pattern.

## 🛠 Tech Stack

- Java
- Selenium WebDriver
- Cucumber (Gherkin syntax)
- TestNG
- Maven
- Extent Reports / Allure Reports (optional)
- Log4j (optional for logging)
- Git and GitHub (for version control)

## 📂 Project Structure

/src
  /main
    /java
      /pages        # Page classes (POM)
      /utils        # Utility classes (driver management, waits, etc.)
  /test
    /java
      /stepDefinitions   # Step definition classes
      /runners           # Test runner classes
    /resources
      /features          # Cucumber feature files (.feature)
pom.xml                  # Maven dependencies
README.md                # Project documentation


🧪 How to Run Tests

1. Clone the repository

git clone https://github.com/your-username/cucumber-bdd-framework.git

2.Navigate to project directory

cd cucumber-bdd-framework

3.Install dependencies Maven will automatically download dependencies from pom.xml.

4. Run tests using Maven

mvn clean test

🧾 Sample Feature File (Gherkin syntax)

Feature: Login functionality for the application

  Scenario: Successful login with valid credentials
    Given User is on Login Page
    When User enters valid username and password
    And clicks on login button
    Then User should be navigated to the Home Page

⚙️ Sample Step Definition

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

After test execution, reports will be generated inside /target/cucumber-reports/.

You can also integrate Extent Reports or Allure Reports for better visualization.

📢 Important Notes
1. Maintain reusability and readability in step definitions.

2. Follow naming conventions strictly.

3. Keep your feature files simple and understandable for business users.

4. Use Tags (@Smoke, @Regression, etc.) for grouping scenarios.


✨ Happy Testing with Cucumber BDD! ✨


