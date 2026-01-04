package SystemDesign.LLD.RefactorHeavyDesign;

public class RetryPaymentProcessor implements PaymentProcessor {

    private final PaymentProcessor delegate;

    public RetryPaymentProcessor(PaymentProcessor delegate) {
        this.delegate = delegate;
    }

    public void pay(double amount) {
        for (int i = 0; i < 3; i++) {
            try {
                delegate.pay(amount);
                return;
            } catch (Exception e) {
                // retry
            }
        }
        throw new RuntimeException("Payment failed after retries");
    }
}
