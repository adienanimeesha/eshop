package id.ac.ui.cs.advprog.eshop.model;

import lombok.Getter;
import java.util.Map;

@Getter
public class Payment {
    private String id;
    private String method;
    private String status;
    private Map<String, String> paymentData;

    public Payment(String id, String method, Map<String, String> paymentData) {
        this.id = id;
        this.method = method;
        this.paymentData = paymentData;
        this.status = validatePayment(method, paymentData);
    }

    public Payment(String id, String method, Map<String, String> paymentData, String status) {
        this.id = id;
        this.method = method;
        this.paymentData = paymentData;
        setStatus(status);
    }

    private String validatePayment(String method, Map<String, String> paymentData) {
        return "SUCCESS";
    }

    public void setStatus(String status) {
        if (!("SUCCESS".equals(status) || "REJECTED".equals(status))) {
            throw new IllegalArgumentException("Invalid status: " + status);
        }
        this.status = status;
    }
}
