package com.sale_management.sale_campaign.modules;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.*;
import java.time.LocalDate;


@Entity
@Table(name = "campaign")
public class Campaigns {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "campaign_id")
    private int campaignId;

    @Column(name = "title")
    private String title;

    @Column(name = "start_date")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate startDate;

    @Column(name = "end_date")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate endDate;

    @OneToMany(mappedBy = "campaign", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DiscountEntry> campaignDiscountEntries;

    public int getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(int campaignId) {
        this.campaignId = campaignId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public List<DiscountEntry> getCampaignDiscountEntries() {
        return campaignDiscountEntries;
    }

    public void setCampaignDiscountEntries(List<DiscountEntry> campaignDiscountEntries) {
        this.campaignDiscountEntries = campaignDiscountEntries;
    }


}
