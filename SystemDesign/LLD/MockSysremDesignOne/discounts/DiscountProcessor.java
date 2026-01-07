package SystemDesign.LLD.MockSysremDesignOne.discounts;

import java.util.List;

public class DiscountProcessor {
    
    private final List<Discount> discounts;

    DiscountProcessor(List<Discount> discounts){
        this.discounts = discounts;
    }

    public double apply(double amount){
        double result = amount;
        for(Discount d : discounts){
            result = d.apply(result);
        }

        return result;
    }
}
