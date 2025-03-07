package id.ac.ui.cs.advprog.eshop.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.HashMap;
import java.util.Map;

class PaymentTest {
    private Map<String, String> paymentData;

    @BeforeEach
    void setUp() {
        paymentData = new HashMap<>();
        paymentData.put("voucherCode", "ESHOP9876XYZ5432");
    }

    @Test
    void testCreatePaymentSuccessfully() {
        Payment payment = new Payment("6012e2fa-5bf4-4b8d-bc16-e6a17e80e7fd", "voucherCode", paymentData, "SUCCESS");
        assertEquals("6012e2fa-5bf4-4b8d-bc16-e6a17e80e7fd", payment.getId());
        assertEquals("voucherCode", payment.getMethod());
        assertEquals("ESHOP9876XYZ5432", payment.getPaymentData().get("voucherCode"));
        assertEquals("SUCCESS", payment.getStatus());
    }

    @Test
    void testCreatePaymentWithInvalidStatus() {
        assertThrows(IllegalArgumentException.class, () ->
                new Payment("6012e2fa-5bf4-4b8d-bc16-e6a17e80e7fd", "voucherCode", paymentData, "MEOW")
        );
    }

    @Test
    void testSetStatusToSuccess() {
        Payment payment = new Payment("6012e2fa-5bf4-4b8d-bc16-e6a17e80e7fd", "voucherCode", paymentData, "REJECTED");
        assertEquals("REJECTED", payment.getStatus());
        payment.setStatus("SUCCESS");
        assertEquals("SUCCESS", payment.getStatus());
    }

    @Test
    void testSetStatusToInvalid() {
        Payment payment = new Payment("6012e2fa-5bf4-4b8d-bc16-e6a17e80e7fd", "voucherCode", paymentData, "REJECTED");
        assertThrows(IllegalArgumentException.class, () -> payment.setStatus("MEOW"));
    }
}
