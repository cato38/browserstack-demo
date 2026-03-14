# BrowserStack Demo

A Selenium + TestNG test automation project that runs UI tests against [BrowserStack](https://www.browserstack.com) Automate.

## Project Structure

```
browserstack-demo/
├── src/
│   ├── main/java/com/browserstack/demo/
│   │   ├── constants/
│   │   │   └── MainPageXPathConstants.java   # XPath locator constants
│   │   ├── interfaces/
│   │   │   ├── PageInterface.java            # Base page action contract
│   │   │   └── MainPageInterface.java        # Main page action contract
│   │   ├── pages/
│   │   │   ├── PageObject.java               # Base page object (Selenium helpers)
│   │   │   └── MainPage.java                 # Main page implementation
│   │   └── util/
│   │       └── WebDriverFactory.java         # Driver creation utilities
│   └── test/java/com/browserstack/demo/
│       ├── BaseTest.java                     # Test setup / teardown
│       └── StackTest.java                    # Test cases
├── testng.xml                                # TestNG suite definition
└── pom.xml                                   # Maven build config
```

## Prerequisites

- Java 11+
- Maven 3.6+
- A [BrowserStack Automate](https://automate.browserstack.com/) account

## Setup

### 1. Set BrowserStack credentials as environment variables

**macOS / Linux:**
```bash
export BROWSERSTACK_USERNAME="your_username"
export BROWSERSTACK_ACCESS_KEY="your_access_key"
```

**Windows (Command Prompt):**
```cmd
set BROWSERSTACK_USERNAME=your_username
set BROWSERSTACK_ACCESS_KEY=your_access_key
```

**Windows (PowerShell):**
```powershell
$env:BROWSERSTACK_USERNAME = "your_username"
$env:BROWSERSTACK_ACCESS_KEY = "your_access_key"
```

> Find your credentials at [automate.browserstack.com/dashboard](https://automate.browserstack.com/dashboard)

### 2. Install dependencies

```bash
mvn install -DskipTests
```

## Running Tests

Run the full test suite:

```bash
mvn test
```

Run a specific test class:

```bash
mvn test -Dtest=StackTest
```

## What It Tests

The suite currently covers:

| Test | Description |
|------|-------------|
| `testClickApplyNow` | Navigates to `testing-axp-career.proxify.io` and clicks the "Apply now" button |

## Architecture

### Page Object Model

- **`PageObject`** — Base class with reusable Selenium helpers (`click`, `hover`, `type`, `isVisible`, etc.). All actions use explicit waits via `WebDriverWait` to avoid flakiness.
- **`MainPage`** — Extends `PageObject` and implements `MainPageInterface`. Contains page-specific actions.
- **`MainPageXPathConstants`** — Centralizes XPath locators so they are easy to update.

### Test Base

- **`BaseTest`** — Initialises a `RemoteWebDriver` connected to BrowserStack before each test and tears it down after. Credentials are read from environment variables.

## Adding New Tests

1. Add XPath constants to `MainPageXPathConstants` (or create a new `*XPathConstants` class).
2. Add action methods to the relevant page class (or create a new page class extending `PageObject`).
3. Write a new `@Test` method in `StackTest` (or a new test class extending `BaseTest`).
4. Register the new class in `testng.xml`.

## Common Issues

| Issue | Fix |
|-------|-----|
| `NullPointerException` on `USERNAME` | Ensure `BROWSERSTACK_USERNAME` env var is set |
| `SessionNotCreatedException` | Check BrowserStack credentials and plan limits |
| Element not found | Update the XPath in `MainPageXPathConstants` if the page structure changed |
