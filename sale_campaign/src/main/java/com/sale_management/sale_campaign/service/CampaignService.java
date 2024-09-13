package com.sale_management.sale_campaign.service;

import com.sale_management.sale_campaign.modules.Campaigns;
import com.sale_management.sale_campaign.modules.DiscountEntry;
import com.sale_management.sale_campaign.modules.Price_History;
import com.sale_management.sale_campaign.modules.Products;
import com.sale_management.sale_campaign.respository.PriceHistoryRepo;
import com.sale_management.sale_campaign.respository.ProductRepo;
import com.sale_management.sale_campaign.respository.SalesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CampaignService {
    @Autowired
    SalesRepo campaignsRepo;

    @Autowired
    ProductRepo productRepo;

    @Autowired
    PriceHistoryRepo priceHistoryRepo;
    public ResponseEntity<Campaigns> getCampaigns(Campaigns campaigns)  {
        try {
            // Ensure campaigns and its discount entries are not null
            if (campaigns == null || campaigns.getCampaignDiscountEntries() == null) {
                return ResponseEntity.badRequest().body(null);
            }

            // Process each discount entry
            for (DiscountEntry discount : campaigns.getCampaignDiscountEntries()) {
                discount.setCampaign(campaigns);
            }

            // Save the campaign after processing all discounts
            return ResponseEntity.ok(campaignsRepo.save(campaigns));
        } catch (Exception e) {
            e.printStackTrace(); // Consider using a logger for production code
            return ResponseEntity.status(500).body(null); // Internal Server Error
        }
    }

}
