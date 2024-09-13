package com.sale_management.sale_campaign.modules;


import java.util.ArrayList;
import java.util.List;



public class product_pagination {
   private List<Products> productsList=new ArrayList<Products>();
    private int page;
    private int pageSize;
    private int totalPages;


    public product_pagination(List<Products> productsList, int pageNumber, int pageSize, int i) {
      this.productsList = productsList;
        this.page = pageNumber;
        this.pageSize = pageSize;
        this.totalPages = i;
    }
}
