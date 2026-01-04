package SystemDesign.LLD.RefactorHeavyDesign;

public class ComposeAtRunTimeMain {
    public static void main(String[] args) {
        PaymentProcessor processor = new LoggingPaymentProcessor(
                new RetryPaymentProcessor(new FraudCheckPaymentProcessor(new CreditCardPayment())));

        processor.pay(5000);
    }
}
