package com.sale_management.sale_campaign.respository;

import com.sale_management.sale_campaign.modules.Price_History;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceHistoryRepo extends JpaRepository<Price_History,Integer> {
}
