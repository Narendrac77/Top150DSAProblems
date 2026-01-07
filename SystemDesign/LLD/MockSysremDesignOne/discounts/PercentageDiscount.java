package SystemDesign.LLD.MockSysremDesignOne.discounts;

public class PercentageDiscount {
    
    double percent;

    public double apply(double amount){
        return amount - (amount * percent / 100);
    }
}
