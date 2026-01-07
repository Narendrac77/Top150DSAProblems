package SystemDesign.LLD.MockSysremDesignOne.Service;

import SystemDesign.LLD.MockSysremDesignOne.model.Order;

public class OrderService {

    private final PriceCalculator priceCalculator;

    public OrderService(PriceCalculator priceCalculator){
        this.priceCalculator = priceCalculator;
    }
    
   public double placeOrder(Order order){
    return priceCalculator.calculate(order);
   }
}
