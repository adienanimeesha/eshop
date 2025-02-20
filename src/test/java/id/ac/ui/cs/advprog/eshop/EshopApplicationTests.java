package id.ac.ui.cs.advprog.eshop;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

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
		 * This test calls the main method of the application
		 * while it does not assert any outcomes, it ensures that the application starts
		 * without throwing exceptions during bootstrapping. Any failure during startup
		 * will cause the test to fail.
		 */
		EshopApplication.main(new String[]{});
	}
}
