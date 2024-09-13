package com.sale_management.sale_campaign.respository;

import com.sale_management.sale_campaign.modules.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SalesRepo extends JpaRepository<Campaigns,Integer> {
     @Query("SELECT c FROM Campaigns c JOIN FETCH c.campaignDiscountEntries WHERE c.startDate = :startDate")
     List<Campaigns> findAllByStartDate(@Param("startDate") LocalDate startDate);


    @Query(value="SELECT * FROM campaign where end_date=?",nativeQuery = true)
    List<Campaigns> findAllByEndDate(LocalDate endDate);
}
