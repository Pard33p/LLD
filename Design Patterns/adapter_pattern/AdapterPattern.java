package adapter_pattern;

public class AdapterPattern {

    public static void main(String[] args) {
        PaymentProcessor bankPayment = new BankPaymentProcessor();
        bankPayment.payViaBank("12345678", 1000.0);

        PaymentProcessor upiAdapter = new UPIToOldPaymentAdapter();
        upiAdapter.payViaBank("9999888812", 3000.0);
    }

}

interface PaymentProcessor {
    void payViaBank(String accountNumber, double amount);
}

class BankPaymentProcessor implements PaymentProcessor {

    public void payViaBank(String accountNumber, double amount) {
        System.out.println("Sending Rs." + amount + " to account number: " + accountNumber);
    }
}

class UPIPayment {
    public void payViaUPI(String upiId, double amount) {
        System.out.println("Sending Rs." + amount + " to UPI ID: " + upiId);
    }
}

class UPIToOldPaymentAdapter implements PaymentProcessor {
    private UPIPayment upiPayment;

    public UPIToOldPaymentAdapter() {
        this.upiPayment = new UPIPayment();
    }

    public void payViaBank(String accountNumber, double amount) {
        String upiId = accountNumber + "@okaxis";
        upiPayment.payViaUPI(upiId, amount);
    }
}