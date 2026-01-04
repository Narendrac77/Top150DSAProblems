package SystemDesign.LLD.RefactorHeavyDesign;

public class LoggingPaymentProcessor implements PaymentProcessor {
    
    private final PaymentProcessor delegate;

    public LoggingPaymentProcessor(PaymentProcessor delegate){
        this.delegate = delegate;
    }

    public void pay(double amount){
        System.out.println("Payment started");
        delegate.pay(amount);
        System.out.println("Payment completed");
    }
}
