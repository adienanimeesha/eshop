package id.ac.ui.cs.advprog.eshop.model;

import id.ac.ui.cs.advprog.eshop.enums.PaymentStatus;
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
        Payment payment = new Payment(
                "6012e2fa-5bf4-4b8d-bc16-e6a17e80e7fd", "voucherCode",
                paymentData, PaymentStatus.SUCCESS.getValue()
        );
        assertEquals("6012e2fa-5bf4-4b8d-bc16-e6a17e80e7fd", payment.getId());
        assertEquals("voucherCode", payment.getMethod());
        assertEquals("ESHOP9876XYZ5432", payment.getPaymentData().get("voucherCode"));
        assertEquals(PaymentStatus.SUCCESS.getValue(), payment.getStatus());
    }

    @Test
    void testCreatePaymentWithInvalidStatus() {
        assertThrows(IllegalArgumentException.class, () ->
                new Payment(
                        "6012e2fa-5bf4-4b8d-bc16-e6a17e80e7fd", "voucherCode",
                        paymentData, "MEOW"  // invalid status
                )
        );
    }

    @Test
    void testSetStatusToSuccess() {
        Payment payment = new Payment(
                "6012e2fa-5bf4-4b8d-bc16-e6a17e80e7fd", "voucherCode",
                paymentData, PaymentStatus.REJECTED.getValue()
        );
        assertEquals(PaymentStatus.REJECTED.getValue(), payment.getStatus());
        payment.setStatus(PaymentStatus.SUCCESS.getValue());
        assertEquals(PaymentStatus.SUCCESS.getValue(), payment.getStatus());
    }

    @Test
    void testSetStatusToInvalid() {
        Payment payment = new Payment("6012e2fa-5bf4-4b8d-bc16-e6a17e80e7fd", "voucherCode",
                paymentData, PaymentStatus.REJECTED.getValue()
        );
        assertThrows(IllegalArgumentException.class, () -> payment.setStatus("MEOW"));
    }
}