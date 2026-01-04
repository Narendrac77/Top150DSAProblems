package SystemDesign.LLD.RefactorHeavyDesign;

public class FraudCheckPaymentProcessor implements PaymentProcessor {
    
    private final PaymentProcessor delegate;

    public FraudCheckPaymentProcessor(PaymentProcessor delegate){
        this.delegate = delegate;
    }

    public void pay(double amount){
        if(amount > 100000){
            throw new RuntimeException("Fraud suspected");
        }
        delegate.pay(amount);
    }
}
