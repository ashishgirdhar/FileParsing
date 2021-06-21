package com.abn.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import com.abn.pojo.TransactionDetail;
import org.springframework.stereotype.Component;

import com.abn.pojo.Client;
import com.abn.pojo.FileFormat;
import com.abn.pojo.Product;
import com.opencsv.CSVWriter;

//@Slf4j
@Component
public class FileParsingService {


	
	private Map<TransactionDetail,Integer> transactionDetailMap = new HashMap<TransactionDetail,Integer>();
	
    
	public String load(String fileName) {
        //LOGGER.info("Reading file {}...", fileName);
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            stream.forEach(this::parse);
        } catch (IOException e) {
            throw new RuntimeException("Fail to open file ", e);
        }
      
        createCSV("output.csv");
        return "Data Loaded Sucesfully";
    }

    private void parse(String line) {
    	if(!line.isEmpty()) {
	        System.out.println(" Record Code "+getFieldValue(line, FileFormat.RECORD_CODE));
	    	System.out.println(" Client Type :  "+getFieldValue(line, FileFormat.CLIENT_TYPE)+" Client Number "+getFieldValue(line, FileFormat.CLIENT_NUMBER)+" Account Number "+getFieldValue(line, FileFormat.ACCOUNT_NUMBER)+" Sub Account Number "+getFieldValue(line, FileFormat.SUBACCOUNT_NUMBER));
	        System.out.println(" Exchange Code :  "+getFieldValue(line, FileFormat.EXCHANGE_CODE)+" Product Group "+getFieldValue(line, FileFormat.PRODUCT_GROUP_CODE)+" Symbol "+getFieldValue(line, FileFormat.SYMBOL)+" Expiration Code "+getFieldValue(line, FileFormat.EXPIRATION_DATE));
	        System.out.println(" QTY Long  :  "+getFieldValue(line, FileFormat.QTY_LONG)+" QTY Short "+getFieldValue(line, FileFormat.QTY_SHORT));
	        System.out.println("End of line ");
	        Client clientDetails = new Client();
		    clientDetails.setAccountNumber(getFieldValue(line, FileFormat.ACCOUNT_NUMBER));
		    clientDetails.setClientNumber(getFieldValue(line, FileFormat.CLIENT_NUMBER));
		    clientDetails.setClientType(getFieldValue(line, FileFormat.CLIENT_TYPE));
		    clientDetails.setSubAccountNumber(getFieldValue(line, FileFormat.SUBACCOUNT_NUMBER));
		    
	        Product productDetails = new Product();
	        productDetails.setExchangeCode(getFieldValue(line, FileFormat.EXCHANGE_CODE));
	        productDetails.setExprirationDate(Long.parseLong(getFieldValue(line, FileFormat.EXPIRATION_DATE)));
	        productDetails.setProductGroupCode(getFieldValue(line, FileFormat.PRODUCT_GROUP_CODE));
	        productDetails.setSymbol(getFieldValue(line, FileFormat.SYMBOL));
	        
	        int qtyLong = Integer.parseInt(getFieldValue(line, FileFormat.QTY_LONG));
	        int qtyShort = Integer.parseInt(getFieldValue(line, FileFormat.QTY_SHORT));
	        int finalQty = qtyLong - qtyShort;
	        TransactionDetail transactionDetail = new TransactionDetail();
	        if(transactionDetailMap.containsKey(transactionDetail)) {
	        	int amount = transactionDetailMap.get(transactionDetail);
	        	transactionDetailMap.put(transactionDetail, amount+finalQty);
	        } else {
	        	transactionDetail.setClient(clientDetails);
	        	transactionDetail.setProduct(productDetails);
	        	transactionDetailMap.put(transactionDetail, finalQty);
	        	
	        }
	        	
	        
	     }
        
    }

    public void createCSV(String filePath) 
    { 
      
        File file = new File(filePath); 
      
        try { 
            FileWriter outputfile = new FileWriter(file); 
      
            CSVWriter writer = new CSVWriter(outputfile); 
      
            List<String[]> data = new ArrayList<String[]>(); 
            data.add(new String[] { "CLIENT TYPE", "CLIENT NUMBER", "ACCOUNT NUMBER", "SUBACCOUNT NUMBER","EXCHANGE CODE","PRODUCT GROUP CODE","SYMBOL","EXPIRATION DATE","Total Transaction Amount"}); 
           
            Iterator iterator = transactionDetailMap.keySet().iterator();
            
            while (iterator.hasNext()) {
               TransactionDetail tDetail = (TransactionDetail) iterator.next();
               String value = transactionDetailMap.get(tDetail).toString();
              
               
               data.add(new String[] {tDetail.getClient().getClientType(),tDetail.getClient().getClientNumber(),
            		   tDetail.getClient().getAccountNumber(),tDetail.getClient().getSubAccountNumber(),
            		   tDetail.getProduct().getExchangeCode(),tDetail.getProduct().getProductGroupCode(),
            		   tDetail.getProduct().getSymbol(),String.valueOf(tDetail.getProduct().getExprirationDate()),
            		   value});
            }
            
            writer.writeAll(data); 
      
            writer.close(); 
        } 
        catch (IOException e) { 
            // TODO Auto-generated catch block 
            e.printStackTrace(); 
        } 
    } 
    
    private String getFieldValue(String line,FileFormat fileFormat) {
    	return line.substring(fileFormat.getStartPosition() - 1, fileFormat.getEndPosition());
    }
    
}
