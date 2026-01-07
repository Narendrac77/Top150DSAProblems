package SystemDesign.LLD.MockSysremDesignOne.PaymentStrategy;

public class PaymentService {
    private final PaymentProcessor processor;

    PaymentService(PaymentProcessor processor) {
        this.processor = processor;
    }

    void pay(double amount) {
        processor.pay(amount);
    }
}
