package SystemDesign.LLD.MockSysremDesignOne.Service;

import SystemDesign.LLD.MockSysremDesignOne.model.Item;

public interface PricingStrategy {
    public double calculatePrice(Item item);
}
