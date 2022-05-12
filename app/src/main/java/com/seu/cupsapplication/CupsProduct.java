package com.seu.cupsapplication;

import java.io.Serializable;

public class CupsProduct implements Serializable {

    Integer cupId;
    String cupName;
    Integer cupImg;
    String cupDtl;
    String cupPrice;


    public String getCupName() {
        return cupName;
    }

    public Integer getCupImg() {
        return cupImg;
    }

    public String getCupDtl() {return cupDtl;}
    public String getCupPrice(){return cupPrice;}


    public CupsProduct(Integer cupId, String cupName, Integer cupImg, String cupDtl,String cupPrice) {
        this.cupId = cupId;
        this.cupName = cupName;
        this.cupImg = cupImg;
        this.cupDtl = cupDtl;
        this.cupPrice = cupPrice;

    }
}
