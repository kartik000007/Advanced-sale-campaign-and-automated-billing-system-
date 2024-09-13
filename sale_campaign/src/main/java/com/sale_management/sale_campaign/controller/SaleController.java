package com.sale_management.sale_campaign.controller;

import com.sale_management.sale_campaign.modules.Campaigns;
import com.sale_management.sale_campaign.respository.SalesRepo;
import com.sale_management.sale_campaign.service.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SaleController {

    @Autowired
    CampaignService campaignService;

    @Autowired
    private SalesRepo campaignsRepo;


    @PostMapping("/saveCampaign")
    private ResponseEntity<Campaigns> SavedCampaign(@RequestBody Campaigns campaigns){
        return campaignService.getCampaigns(campaigns);
    }

     @GetMapping
     private List<Campaigns> GetAllProducts(){
        return campaignsRepo.findAll();
    }

}
