package SystemDesign.LLD.MockSysremDesignOne.Service;

import SystemDesign.LLD.MockSysremDesignOne.model.Item;

public class ElectricPricing implements PricingStrategy{
    
    @Override
    public double calculatePrice(Item item){
        return item.getPrice() * 1.18;
    }
}
