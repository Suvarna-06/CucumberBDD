# 🥒 Cucumber BDD Framework

**Creator: Sandhya Sankeshwar**

> *Transform manual test cases into automated executable specifications with this powerful BDD framework*

---

## 📋 Project Overview

This comprehensive framework implements **Behavior-Driven Development (BDD)** for end-to-end functional test automation. Built with a robust tech stack including **Java**, **Selenium WebDriver**, **Cucumber**, **TestNG**, and **Maven**, it follows the **Page Object Model (POM)** design pattern for maximum maintainability and scalability.

---

## 🛠️ Tech Stack

| Technology | Purpose |
|------------|---------|
| **Java** | Programming language |
| **Selenium WebDriver** | Browser automation |
| **Cucumber** | BDD implementation with Gherkin syntax |
| **TestNG** | Test execution and assertions |
| **Maven** | Build and dependency management |
| **Extent Reports / Allure** | Advanced test reporting (optional) |
| **Log4j** | Comprehensive logging (optional) |
| **Git & GitHub** | Version control |

---

## 📂 Project Structure

```
/src
  /main
    /java
      /pages        # Page Object classes (POM)
      /utils        # Utility classes (WebDriver, Waits, Config)
  /test
    /java
      /stepDefinitions  # Step definition classes
      /runners          # TestNG runner classes
    /resources
      /features         # Cucumber feature files (.feature)
      /testdata         # Test data files
      /config           # Configuration properties
pom.xml                 # Maven dependencies
README.md               # Project documentation
```




<img width="393" alt="image" src="https://github.com/user-attachments/assets/d5599ce8-fe02-41f5-b08b-fefc08e16ef7" />







---

## 🧪 How to Run Tests

### 1️⃣ Clone the repository
```bash
git clone https://github.com/your-username/cucumber-bdd-framework.git
```

### 2️⃣ Navigate to project directory
```bash
cd cucumber-bdd-framework
```

### 3️⃣ Install dependencies
Maven will automatically download dependencies defined in pom.xml

### 4️⃣ Run tests using Maven
```bash
# Run all tests
mvn clean test

# Run specific tag
mvn clean test -Dcucumber.filter.tags="@Smoke"
```

---

## ✅ Sample Feature File (Gherkin syntax)

```gherkin
Feature: Login functionality for the application
  As a registered user
  I want to log into my account
  So that I can access secure features

  @Smoke @Regression
  Scenario: Successful login with valid credentials
    Given User is on Login Page
    When User enters valid username and password
    And clicks on login button
    Then User should be navigated to the Home Page
    
  @Regression
  Scenario Outline: Login with multiple users
    Given User is on Login Page
    When User enters username "<username>" and password "<password>"
    And clicks on login button
    Then User should get the "<status>"
    
    Examples:
      | username | password | status  |
      | admin    | admin123 | success |
      | invalid  | invalid  | failure |
```

---

## ⚙️ Sample Step Definition

```java
@Given("User is on Login Page")
public void user_is_on_login_page() {
    loginPage.openLoginPage();
    logger.info("User is on login page");
}

@When("User enters valid username and password")
public void user_enters_valid_username_and_password() {
    loginPage.enterCredentials("username", "password");
    logger.info("User entered credentials");
}

@And("clicks on login button")
public void clicks_on_login_button() {
    loginPage.clickLogin();
    logger.info("User clicked login button");
}

@Then("User should be navigated to the Home Page")
public void user_should_be_navigated_to_the_home_page() {
    Assert.assertTrue(homePage.isHomePageDisplayed(), "Home page is not displayed");
    logger.info("User is successfully navigated to home page");
}
```

---

## 📊 Test Configuration & Execution

### Runner Class

```java
@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"stepDefinitions"},
    plugin = {
        "pretty",
        "html:target/cucumber-reports/cucumber-pretty.html",
        "json:target/cucumber-reports/CucumberTestReport.json",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
    },
    tags = "@Smoke or @Regression",
    monochrome = true,
    dryRun = false
)
public class TestRunner extends AbstractTestNGCucumberTests {
    // Parallel execution configuration
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
```

---

## 📈 Reporting

After test execution, comprehensive reports will be generated in multiple formats:

- HTML reports: `/target/cucumber-reports/cucumber-pretty.html`
- JSON reports: `/target/cucumber-reports/CucumberTestReport.json`
- Extent Reports (if configured): `/test-output/SparkReport/`
- Allure Reports (if configured): Run `allure serve allure-results` after tests

![Sample Report](https://via.placeholder.com/800x400?text=Cucumber+Report+Sample)

---

## 🔍 Best Practices

| Category | Recommendation |
|----------|---------------|
| **Feature Files** | Keep scenarios business-focused and jargon-free |
| **Step Definitions** | Create reusable steps with appropriate granularity |
| **Page Objects** | Implement one class per page with all related actions |
| **Data Management** | Externalize test data in CSV/Excel/JSON files |
| **CI/CD** | Configure pipeline to run tests on each commit |
| **Tagging** | Use meaningful tags (@Smoke, @Regression, @Critical) |

---

## 🛠️ Utilities Included

- **WebDriverManager**: Handles browser selection and configuration
- **ConfigReader**: Manages properties and environment settings
- **ExcelUtils**: Provides data-driven testing capabilities
- **WaitUtils**: Implements smart waiting strategies
- **ScreenshotUtils**: Captures evidence on test failures
- **ApiUtils**: Supports API testing when needed

---

## 📢 Important Notes

1. ✓ Maintain reusability and readability in step definitions
2. ✓ Follow naming conventions strictly for better maintenance
3. ✓ Keep feature files simple and understandable for business users
4. ✓ Use Tags strategically for organizing test execution
5. ✓ Update WebDriver dependencies regularly for browser compatibility

---

## 🔄 Continuous Integration

This framework is designed to integrate seamlessly with CI/CD tools:

```yaml
# Sample Jenkins Pipeline
pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/your-username/cucumber-bdd-framework.git'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn clean test -Dcucumber.filter.tags="@Smoke"'
            }
        }
        stage('Report') {
            steps {
                publishHTML([
                    allowMissing: false,
                    alwaysLinkToLastBuild: true,
                    keepAll: true,
                    reportDir: 'target/cucumber-reports',
                    reportFiles: 'cucumber-pretty.html',
                    reportName: 'Cucumber Report'
                ])
            }
        }
    }
}
```

---

## ✨ Happy Testing with Cucumber BDD! ✨

*"Behavior Driven Development is about having conversations, not writing features."*
