package SystemDesign.LLD.MockSysremDesignOne.discounts;

public class FlatDiscount implements Discount{
    
    double value;

    public double apply(double amount){
        return amount - value;
    }
}
