package com.sale_management.sale_campaign.modules;

import jakarta.persistence.*;


@Entity
@Table(name = "discount_entry")
public class DiscountEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private float discount;
    private int product_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }


//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "campaign_id")
//    private Campaigns campaign;

//

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "campaign_id")
    private Campaigns campaign;


    public Campaigns getCampaign() {
        return campaign;
    }

    public void setCampaign(Campaigns campaign) {
        this.campaign = campaign;
    }

}
