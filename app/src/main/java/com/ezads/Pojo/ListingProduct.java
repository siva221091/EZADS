package com.ezads.Pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class ListingProduct implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;


    private String id;

    private String productName;

    private String categoryName;

    private String brandName;

    private String shopName;

    private String mallName;

    private List<Documents> documents;

    private String discount;

    private Date createdDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getMallName() {
        return mallName;
    }

    public void setMallName(String mallName) {
        this.mallName = mallName;
    }

    public List<Documents> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Documents> documents) {
        this.documents = documents;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "ListingProduct [id=" + id + ", productName=" + productName + ", categoryName=" + categoryName
                + ", brandName=" + brandName + ", shopName=" + shopName + ", mallName=" + mallName + ", documents="
                + documents + ", discount=" + discount + ", createdDate=" + createdDate + "]";
    }

}
