/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs310moreno;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Joseph Moreno
 */
public class CS310Moreno {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        final String INPUT_FILENAME = "input/assn1input.txt";
        //final String INPUT_FILENAME = "input/assn2input.txt";
        
        //TEST SET 1
        
        // Test 1a:
        Broker test_1a = new Broker("ASD45632", "Joe", "Moreno", "321-999", 33.5);
        System.out.println("test 1a:\n" + test_1a);
        
        // Test 1b:
        StockTrade test_1b = new StockTrade("AAPL", 185.72, 25, test_1a.getBrokerLicense(), true);
        System.out.println(test_1b);
        
        
        //TEST SET 2
        
        // Test 2a
        Broker test_2a = new Broker("ASD45632", "Joe", "Moreno", "321-999", 33.5);
        System.out.println("\ntest_2a:\n" + test_2a.toString());
        System.out.println("\nDoes Test 2a equal Test 1a?:\n" + test_2a.equals(test_1a));
        
        // Test 2b
        Broker test_2b = new Broker("FSD12345", "Joe", "Smith", "123-727", 25.2);
        System.out.println("\ntest_2b:\n" + test_2b.toString());
        System.out.println("\nDoes Test 2b equal Test 1a?:\n" + test_2b.equals(test_1a));
        
        // Test 2c
        StockTrade test_2c = new StockTrade("AAPL", 185.72, 25, test_1a.getBrokerLicense(), true);
        System.out.println("\nStockTrade\ntest_2c:\n" + test_2c.toString());
        System.out.println("\nDoes Test 2c equal Test 1b?:\n" + test_2c.equals(test_1b));
        
        // Test 2d
        StockTrade test_2d = new StockTrade("SNAP", 10.11, 40, test_1a.getBrokerLicense(), true);
        System.out.println("\nStockTrade\ntest_2d:\n" + test_2d.toString());
        System.out.println("\nDoes Test 2d equal Test 2c?:\n" + test_2d.equals(test_2c));
        
        
        //TEST SET 3
        System.out.println("\n\n\nTEST SET 3\n\n\n\n");

        // read file
        
        
        File file = new File(INPUT_FILENAME);
        try 
        {
            Scanner input = new Scanner(file);
            while(input.hasNext())
            {
                String line = input.next();
                String values [] = line.split(",");
                
                for (int i = 0; i < values.length; i++) {
                    if(values[i].equals("BROKER"))
                    {
                    System.out.println(values[i + 1]);
                    Broker broker = new Broker();
                    Broker brokerobj = setBrokerAttributes(broker, values);
                    
                    // Tests if broker license and department is valid
                    boolean brokerTest = !brokerobj.isValidLicense(brokerobj.getBrokerLicense()) || !brokerobj.isValidDept(brokerobj.getDepartment());
                    if(brokerTest)
                    {
                        System.out.println(brokerobj.toString());
                        
                        if(!brokerobj.isValidLicense(brokerobj.getBrokerLicense()))
                        {
                            System.out.println("\nA Broker License Must Contain the Following:\n3 letters followed by 5 numbers");
                            System.out.println("Example: ABC12345\n");
                        }
                        if(!brokerobj.isValidDept(brokerobj.getDepartment()))
                        {
                            System.out.println("\nA Valid Department Number Must Contain the Following:\nThe first 3 digits are 1, 2, or 3 in any order\nThere must contain a \'-\' surrounded 3 numbers, 0-9\nTotal length max 7 characters");
                            System.out.println("Example: 123-456\n");
                        }
                    } 
                    else
                    {
                        displayBrokerAttributes(brokerobj);
                    }
                    } 
                    if (values[i].equals("TRADE")) 
                    {
                        // TRADE
                        System.out.println("Trade: " + values[i + 1]);
                        StockTrade stockTrade = new StockTrade();
                        StockTrade stockTradeObj = setStockTradeAttributes(stockTrade, values);
                        
                        // Tests if stock symbol, price per share, and whole shares are valid
                        boolean stockTradeTest = !stockTradeObj.isValidStockSymbol(stockTradeObj.getStockSymbol()) || !stockTradeObj.isValidPrice() || !stockTradeObj.isValidWholeShares();
                        if(stockTradeTest){
                            System.out.println("\n" + stockTradeObj.toString() + "\n");
                            
                            if(!stockTradeObj.isValidStockSymbol(stockTradeObj.getStockSymbol())){
                            System.out.println("STOCK SYMBOL INVALID:\n3 or 4 uppercased alphabetic characters in length, A-Z\n");
                            }
                            if(!stockTradeObj.isValidPrice())
                            {
                                System.out.println("INVALID PRICE:\nPrice must not be exceed $1,000.00 per share\n");
                            }
                            if(!stockTradeObj.isValidWholeShares())
                            {
                                System.out.println("MAX SHARE WARNING:\nTotal share quantity must not exceed 100,000 shares\n");
                            }
                        }else {
                            displayStockTradeAttributes(stockTradeObj);
                        }
                        
                    }
                    
                } 
            }
            input.close();
            
        } 
        catch (Exception e) 
        {
            System.out.println(e);
            System.exit(1);
        }

    }
    public static Broker setBrokerAttributes(Broker brokerObj, String[] line)
    {    
        brokerObj.setBrokerLicense(line[2]);
        brokerObj.setFirstName(line[3]);
        brokerObj.setLastName(line[4]);
        brokerObj.setDepartment(line[5]);
        brokerObj.setCommissionRate(Double.parseDouble(line[6]));
        
        return brokerObj;
    }
    
    public static void displayBrokerAttributes(Broker brokerObj)
    {
        System.out.println("\n"+brokerObj.getBrokerLicense());
        System.out.println(brokerObj.getFirstName());
        System.out.println(brokerObj.getLastName());
        System.out.println(brokerObj.getDepartment());
        System.out.println(brokerObj.getCommissionRate()+"\n");
    }
    
    public static StockTrade setStockTradeAttributes(StockTrade stockTradeObj, String[] line)
    {
        stockTradeObj.setStockSymbol(line[2]);
        stockTradeObj.setPricePerShare(Double.parseDouble(line[3]));
        stockTradeObj.setWholeShares(Integer.parseInt(line[4]));
        stockTradeObj.setBrokerLicense(line[5]);
        stockTradeObj.setTaxable(Boolean.parseBoolean(line[6]));
        
        return stockTradeObj;
    }
    
    public static void displayStockTradeAttributes(StockTrade stockTradeObj){
        System.out.println("\n" + stockTradeObj.getStockSymbol());
        System.out.println(stockTradeObj.getPricePerShare());
        System.out.println(stockTradeObj.getWholeShares());
        System.out.println(stockTradeObj.getBrokerLicense());
        System.out.println(stockTradeObj.isTaxable() + "\n");
    }
    
}
