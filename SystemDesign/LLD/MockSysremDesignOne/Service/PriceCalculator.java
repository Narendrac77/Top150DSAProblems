package SystemDesign.LLD.MockSysremDesignOne.Service;

import SystemDesign.LLD.MockSysremDesignOne.discounts.DiscountProcessor;
import SystemDesign.LLD.MockSysremDesignOne.model.Item;
import SystemDesign.LLD.MockSysremDesignOne.model.Order;

public class PriceCalculator {

    private final DiscountProcessor discountProcessor;

    PriceCalculator(DiscountProcessor discountProcessor){
        this.discountProcessor = discountProcessor;
    }

    public double calculate(Order order) {
        double base =  order.getItems().stream().mapToDouble(Item::finalPrice).sum();
        return discountProcessor.apply(base);
    }
}
