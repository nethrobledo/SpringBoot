package com.jobhunt.sample.dto;

import java.math.BigDecimal;

public class QuoteResponseFilter {

    private String buyCurrency;
    private String sellCurrency;

    private BigDecimal buyAmount;
    private BigDecimal sellAmount;
    private BigDecimal customerRate;
    private BigDecimal inverseCustomerRate;

    public BigDecimal getInverseCustomerRate() {
        return inverseCustomerRate;
    }

    public void setInverseCustomerRate(BigDecimal inverseCustomerRate) {
        this.inverseCustomerRate = inverseCustomerRate;
    }

    public String getBuyCurrency() {
        return buyCurrency;
    }

    public void setBuyCurrency(String buyCurrency) {
        this.buyCurrency = buyCurrency;
    }

    public BigDecimal getBuyAmount() {
        return buyAmount;
    }

    public void setBuyAmount(BigDecimal buyAmount) {
        this.buyAmount = buyAmount;
    }

    public String getSellCurrency() {
        return sellCurrency;
    }

    public void setSellCurrency(String sellCurrency) {
        this.sellCurrency = sellCurrency;
    }

    public BigDecimal getSellAmount() {
        return sellAmount;
    }

    public void setSellAmount(BigDecimal sellAmount) {
        this.sellAmount = sellAmount;
    }

    public BigDecimal getCustomerRate() {
        return customerRate;
    }

    public void setCustomerRate(BigDecimal customerRate) {
        this.customerRate = customerRate;
    }


}
