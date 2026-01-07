package SystemDesign.LLD.MockSysremDesignOne.Service;

import SystemDesign.LLD.MockSysremDesignOne.model.Item;

public class PlasticPricing implements PricingStrategy{
    
    @Override
    public double calculatePrice(Item item){
        return item.getPrice() * 1.05;
    }
}
