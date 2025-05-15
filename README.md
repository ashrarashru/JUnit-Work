## Project Description
In this project, I automated 3 websites using Selenium, JUnit, and Java.

## Project Objectives
**1. Webform Automation – Digital Unite** (Automate the submission of a webform with file upload and verify success)

**Steps:**
- Access the web form at [Digital Unite](https://www.digitalunite.com/practice-webform-learners)
- Fill in all required fields
    - Name
    - Phone Number
    - Date
    - Email
    - About Yourself
- Upload a file (must be ≤ 2 MB).
- Submit the form.
- Validate the presence of a success message ("Thank you for your submission!").

![01](https://github.com/user-attachments/assets/bb3e18fb-fba2-4104-a088-ecd9786cd2ed)

**2. Guest Registration Automation – WP Everest** (Automate the guest registration process on a WP Everest form)

**Steps:**
- Access the guest registration form at [WP Everest](https://demo.wpeverest.com/user-registration/guest-registration-form/)
- Fill in all mandatory fields
    - First Name
    - Last Name
    - Email
    - Phone Number
- Tick the "Terms and Conditions".
- Submit the form.
- Check for a success confirmation ("User successfully registered.").

![02](https://github.com/user-attachments/assets/26689c27-1886-44d7-8abd-8a4163721c6a)

**3. DSEBD Stock Price Scraping** (Scrape and store stock market data from DSEBD)

**Steps:**
- Visit the DSEBD website's stock market page [DSEBD](https://dsebd.org/latest_share_price_scroll_by_value.php)
- Locate the stock data table.
- Extract all cell values (Serial, Trade Code, Price, Volume and others).
- Print data to the console.
- Save the data to a **data.txt** file for future use.

![03](https://github.com/user-attachments/assets/69f4fb08-a3af-433f-a567-097b0fd014d2)

![04](https://github.com/user-attachments/assets/1dc36965-08f6-4db6-8202-931b4b0cbcd3)

## How to Run the Tests
**Setup and Configuration**
Install JDK and set up your IDE (Eclipse/IntelliJ IDEA).
Add Selenium and JUnit libraries to your project build path.
Ensure the browser driver (e.g., ChromeDriver) is installed and set in your PATH.
