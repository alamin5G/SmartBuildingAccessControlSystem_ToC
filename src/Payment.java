abstract class Payment {
    abstract void makePayment(double amount);
}

class CreditCardPayment extends Payment {
    @Override
    void makePayment(double amount) {
        System.out.println("Payment of " + amount + " made using Credit Card.");
    }
}

class PayPalPayment extends Payment {
    @Override
    void makePayment(double amount) {
        System.out.println("Payment of " + amount + " made using PayPal.");
    }
}
