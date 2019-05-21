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
public class Broker {
    private String brokerLicense;
    private String firstName;
    private String lastName;
    private String department;
    private double commissionRate;

    
    // constructors
    
    public Broker() {
    }

    public Broker(String brokerLicense, String firstName, String lastName, String department, double commissionRate) {
        this.brokerLicense = brokerLicense;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.commissionRate = commissionRate;
    }
    
    // getters & setters

    public String getBrokerLicense() {
        return brokerLicense;
    }

    public void setBrokerLicense(String brokerLicense) {
        this.brokerLicense = brokerLicense;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(double commissionRate) {
        this.commissionRate = commissionRate;
    }
    
    // toString - includes all attribute values

    @Override
    public String toString() {
        return "Broker{" + "brokerLicense=" + brokerLicense + ", firstName=" + firstName + ", lastName=" + lastName + ", department=" + department + ", commissionRate=" + commissionRate + '}';
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
        final Broker other = (Broker) obj;
        if (Double.doubleToLongBits(this.commissionRate) != Double.doubleToLongBits(other.commissionRate)) {
            return false;
        }
        if (!Objects.equals(this.brokerLicense, other.brokerLicense)) {
            return false;
        }
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if (!Objects.equals(this.department, other.department)) {
            return false;
        }
        return true;
    }
    
        //Error Checking Methods - Broker - retun Boolean     
    
    
        /*
        Check the broker's License 
                isValidLicence checks the following:
                3 letters followed by 5 numbers, within a String
        */ 
        
        public boolean isValidLicense(String licenseCheck)
        {
            String regex = "[A-Za-z]{3}\\d{5}";
            Pattern pattern = Pattern.compile(regex);
            Matcher match = pattern.matcher(licenseCheck);
            return match.matches();
        }
        
        /*      
            Check the Department Number
                isValid method check for the following:
                7 Chars long and contains a dash and digits in the correct places and all of the first 3 digits are 1, 2, or 3
        */

        public boolean isValidDept(String deptCheck)
        {
            String regex = "[1-3]{3}[-]\\d{3}";
            Pattern pattern = Pattern.compile(regex);
            Matcher match = pattern.matcher(deptCheck);
            return match.matches();
        }
    
}
