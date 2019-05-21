 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs310moreno;

import java.util.Objects;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 *
 * @author Joseph Moreno
 */
public class StockTrade {
    private String stockSymbol;
    private double pricePerShare;
    private int wholeShares;
    private String brokerLicense;
    private boolean taxable;

    // constructors
    
    public StockTrade() {
    }

    public StockTrade(String stockSymbol, double pricePerShare, int wholeShares, String brokerLicense, boolean taxable) {
        this.stockSymbol = stockSymbol;
        this.pricePerShare = pricePerShare;
        this.wholeShares = wholeShares;
        this.brokerLicense = brokerLicense;
        this.taxable = taxable;
    }
    
    // getters & setters

    public String getStockSymbol() {
        return stockSymbol;
    }

    public void setStockSymbol(String stockSymbol) {
        this.stockSymbol = stockSymbol;
    }

    public double getPricePerShare() {
        return pricePerShare;
    }

    public void setPricePerShare(double pricePerShare) {
        this.pricePerShare = pricePerShare;
    }

    public int getWholeShares() {
        return wholeShares;
    }

    public void setWholeShares(int wholeShares) {
        this.wholeShares = wholeShares;
    }

    public String getBrokerLicense() {
        return brokerLicense;
    }

    public void setBrokerLicense(String brokerLicense) {
        this.brokerLicense = brokerLicense;
    }

    public boolean isTaxable() {
        return taxable;
    }

    public void setTaxable(boolean taxable) {
        this.taxable = taxable;
    }
    
    // toString - includes all attribute values

    @Override
    public String toString() {
        return "StockTrade{" + "stockSymbol=" + stockSymbol + ", pricePerShare=" + pricePerShare + ", wholeShares=" + wholeShares + ", brokerLicense=" + brokerLicense + ", taxable=" + taxable + '}';
    }
    
     // equals - compares all attribute values

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final StockTrade other = (StockTrade) obj;
        if (Double.doubleToLongBits(this.pricePerShare) != Double.doubleToLongBits(other.pricePerShare)) {
            return false;
        }
        if (this.wholeShares != other.wholeShares) {
            return false;
        }
        if (this.taxable != other.taxable) {
            return false;
        }
        if (!Objects.equals(this.stockSymbol, other.stockSymbol)) {
            return false;
        }
        if (!Objects.equals(this.brokerLicense, other.brokerLicense)) {
            return false;
        }
        return true;
    }
    
        //Error Checking Methods - StockTrade - retun Boolean        

        /*      
            Check the stock symbol
                - is 3 or 4 uppercased alphabetic characters long 
        */
        public boolean isValidStockSymbol(String symbolCheck)
        {
            String regex = "[A-Z]{3,4}";
            Pattern pattern = Pattern.compile(regex);
            Matcher match = pattern.matcher(symbolCheck);
            return match.matches();
        }

        /*      
            Check the stock price
                - is not over $1,000.00 per share 
        */
        public boolean isValidPrice()
        {
            return this.pricePerShare <= 1000;
        }

        /*      
            Check the number of shares
                - is not over 100,000 
        */
        public boolean isValidWholeShares()
        {
            return this.wholeShares <= 100000;
        }
    

}
