package com.ezads;

public class product_promo {
    private String title;
    private String shortdesc;
    private String expire;
    private String percent;
    private String address;
    private int image;
    public product_promo(String title, String shortdesc, String expire, String percent,String address, int image) {
        this.title = title;
        this.shortdesc = shortdesc;
        this.expire = expire;
        this.percent = percent;
        this.address=address;
        this.image = image;
    }



    public String getTitle() {
        return title;
    }

    public String getShortdesc() {
        return shortdesc;
    }

    public String getExpire() {
        return expire;
    }

    public String getPercent() {
        return percent;
    }
    public String getAddress() {
        return address;
    }
    public int getImage() {
        return image;
    }
}

