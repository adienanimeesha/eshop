package id.ac.ui.cs.advprog.eshop.functional;

import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@ExtendWith(SeleniumJupiter.class)
class CreateProductFunctionalTest {

    @LocalServerPort
    private int serverPort;

    @Value("${app.baseUrl:http://localhost}")
    private String testBaseUrl;

    private String baseUrl;

    @BeforeEach
    void setupTest() {
        baseUrl = String.format("%s:%d", testBaseUrl, serverPort);
    }

    @Test
    void userCanCreateProduct(ChromeDriver driver) {
        // open Create Product page
        driver.get(baseUrl + "/product/create");

        // fill in the product details
        WebElement nameField = driver.findElement(By.name("productName"));
        WebElement quantityField = driver.findElement(By.name("productQuantity"));
        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));

        nameField.sendKeys("Test Product");
        quantityField.sendKeys("8");

        // submit the form
        submitButton.click();

        // redirected to the product list
        driver.get(baseUrl + "/product/list");

        // check if the new product is in the table
        WebElement productTable = driver.findElement(By.tagName("table"));
        assertTrue(productTable.getText().contains("Test Product"));
        assertTrue(productTable.getText().contains("8"));
    }
}
