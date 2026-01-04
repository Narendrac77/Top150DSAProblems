Refactoring Inheritance-Heavy Design → Composition (LLD Style)

Problem Statement (Typical LLD Interview)

Design a Payment System that supports:

1. Credit Card

2. UPI

3. Retry on failure

4. Logging

Fraud check

And new requirements will keep coming.

❌ Step 1: Inheritance-Heavy (Bad Design)
Initial Design
abstract class Payment {
    abstract void pay(double amount);
}

class CreditCardPayment extends Payment {
    void pay(double amount) { }
}

class UpiPayment extends Payment {
    void pay(double amount) { }
}

Then Requirements Grow 😈

Now we need:

Retry

Logging

Fraud check

Inheritance explosion:

CreditCardPaymentWithRetry
CreditCardPaymentWithRetryAndLogging
UpiPaymentWithFraudCheck
UpiPaymentWithFraudCheckAndRetry

🚨 Problems (Interview Call-Outs)

❌ Class explosion

❌ Violates Open-Closed Principle

❌ Hard to test combinations

❌ Behavior locked at compile time

❌ Tight coupling

📌 Interviewers will stop you here and ask

“How would you improve this?”

✅ Step 2: Identify Change Dimensions (Key Skill)

Senior engineers separate what varies:

Concern	Changes Often?
Payment method	Yes
Retry policy	Yes
Fraud check	Yes
Logging	Yes

👉 Each varying behavior = separate component

✅ Step 3: Introduce Core Abstraction (Composition)
public interface PaymentProcessor {
    void pay(double amount);
}

public class CreditCardPayment implements PaymentProcessor {
    public void pay(double amount) {
        // credit card logic
    }
}

public class UpiPayment implements PaymentProcessor {
    public void pay(double amount) {
        // upi logic
    }
}


✔ Clean
✔ Replaceable
✔ Polymorphic

✅ Step 4: Add Cross-Cutting Behaviors Using Composition
Retry (Decorator)
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

Logging (Decorator)
public class LoggingPaymentProcessor implements PaymentProcessor {

    private final PaymentProcessor delegate;

    public LoggingPaymentProcessor(PaymentProcessor delegate) {
        this.delegate = delegate;
    }

    public void pay(double amount) {
        System.out.println("Payment started");
        delegate.pay(amount);
        System.out.println("Payment completed");
    }
}

Fraud Check (Decorator)
public class FraudCheckPaymentProcessor implements PaymentProcessor {

    private final PaymentProcessor delegate;

    public FraudCheckPaymentProcessor(PaymentProcessor delegate) {
        this.delegate = delegate;
    }

    public void pay(double amount) {
        if (amount > 100000) {
            throw new RuntimeException("Fraud suspected");
        }
        delegate.pay(amount);
    }
}

✅ Step 5: Compose at Runtime (POWER MOVE 💥)
PaymentProcessor processor =
    new LoggingPaymentProcessor(
        new RetryPaymentProcessor(
            new FraudCheckPaymentProcessor(
                new CreditCardPayment()
            )
        )
    );

processor.pay(5000);

🔥 What You Achieved

✔ No inheritance explosion
✔ Behavior order configurable
✔ Runtime flexibility
✔ Easy testing
✔ SOLID compliant

🧠 Patterns Used (Call This Out in Interview)
Concern	Pattern
Payment choice	Strategy
Retry / Logging / Fraud	Decorator
Construction	Factory / Builder (optional)
🧪 Step 6: Testing Becomes Trivial
PaymentProcessor mock = mock(PaymentProcessor.class);
PaymentProcessor retry = new RetryPaymentProcessor(mock);

retry.pay(1000);

verify(mock, times(3)).pay(1000);


🔥 Interviewers LOVE testability discussions.

❓ Interviewer Follow-Up Questions (Be Ready)
Q1. Why not inheritance?

“Because retry, logging, and fraud are orthogonal concerns and inheritance does not scale combinatorially.”

Q2. What if we want to disable logging?

“Just remove the decorator—no code change.”

Q3. What if retry count changes?

“Retry becomes configurable; core payment untouched.”