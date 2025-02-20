package id.ac.ui.cs.advprog.eshop;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest
class EshopApplicationTests {

	@Test
	void contextLoads() {
		/*
		 * This test is intentionally left empty.
		 * Its purpose is to verify that the Spring application context loads successfully.
		 * If the context fails to load, this test will automatically fail.
		 */
	}

	@Test
	void mainMethodTest() {
		/*
		 * This test calls the main method of the application.
		 * It verifies that the application starts without throwing exceptions during bootstrapping.
		 * Any exception thrown would cause the test to fail.
		 */
		assertDoesNotThrow(() -> EshopApplication.main(new String[]{}));
	}
}
