package pay.subscription;

import io.micronaut.core.annotation.*;

@Introspected
public class PaySubscription {
    private String customerId;
    private String planId;
    private String paymentNonce;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    public String getPaymentNonce() {
        return paymentNonce;
    }

    public void setPaymentNonce(String paymentNonce) {
        this.paymentNonce = paymentNonce;
    }
}

