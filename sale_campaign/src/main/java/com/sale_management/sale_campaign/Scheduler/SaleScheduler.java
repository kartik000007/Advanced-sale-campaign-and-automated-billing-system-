package com.sale_management.sale_campaign.Scheduler;


import com.sale_management.sale_campaign.modules.Campaigns;
import com.sale_management.sale_campaign.modules.DiscountEntry;
import com.sale_management.sale_campaign.modules.Price_History;
import com.sale_management.sale_campaign.modules.Products;
import com.sale_management.sale_campaign.respository.PriceHistoryRepo;
import com.sale_management.sale_campaign.respository.ProductRepo;
import com.sale_management.sale_campaign.respository.SalesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Component
public class SaleScheduler {
    @Autowired
    private SalesRepo salesRepo;

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    PriceHistoryRepo priceHistoryRepo;

    //    @Scheduled(cron = "0 0 0 * * *")
//    public void SaleStartScheduler() {
//
//        LocalDate today = LocalDate.now();
//        System.out.println(today);
//        List<Campaigns> activeSales=salesRepo.findCampaignByStartDate(today);
//        System.out.println(activeSales);
//        for(Campaigns campaign: activeSales){
//            List<DiscountEntry> discountEntries = campaign.getCampaignDiscountEntries();
//            System.out.println(discountEntries);
//            for(DiscountEntry discount: discountEntries){
//              Products product=productRepo.findById(discount.getProduct_id()).orElse(null);
//                System.out.println(product);
//              if(product!=null){
//                  float discountedPrice= (float) (product.getCurrentPrice()-(product.getCurrentPrice()*discount.getDiscount()/100));
//                  // Update product price
//                  System.out.println(discountedPrice);
//                  if(discountedPrice>0) {
//                      product.setCurrentPrice(discountedPrice);
//                      productRepo.save(product);
//                  }
//              }
//
//            }
//        }
//
//
//    }


    //    @Scheduled(fixedRate = 120000)

    @Scheduled(cron = "0 0 0 * * *")
    public void adjustProductPrices() {
        try {
            LocalDate today = LocalDate.now();
            List<Campaigns> activeSales = salesRepo.findAllByStartDate(today);
            System.out.println(activeSales);
            for (Campaigns campaign : activeSales) {
                List<DiscountEntry> discounts = campaign.getCampaignDiscountEntries();
                System.out.println(campaign);
                for (DiscountEntry discount : discounts) {
                    Products product = productRepo.getReferenceById(discount.getProduct_id());
                    System.out.println(product);
                    if (product != null) {
                        double discountAmount = (product.getCurrentPrice() * (discount.getDiscount() / 100));
                        double newPrice = (product.getCurrentPrice() - discountAmount);
                        if (newPrice >= 0) {
                            product.setCurrentPrice(newPrice);
                            Price_History priceHistory = new Price_History(discountAmount, today, newPrice, product);
                            priceHistoryRepo.save(priceHistory);
                            productRepo.save(product);
                        }
                    }
                }
            }
        }catch (Exception e){

        }
    }
//    @Scheduled(fixedRate = 120000)
//    public void RevertProductPrices(){
//
//    }



}
