package com.Phean.Tool;

import java.util.Base64;

public class Utility {

     public String ConvertToBase64String(String stringValue) throws CustomException {
         try{
             return Base64.getEncoder().encodeToString(stringValue.getBytes("UTF-8"));
         }catch (Exception ex)
         {
             throw new CustomException(ex);
         }
     }
     public String ConvertBase64ToString(String stringBase64) throws CustomException {
         try {
             byte[] data = Base64.getDecoder().decode(stringBase64);
             return new String(data);
         }catch (Exception ex)
         {
             throw new CustomException(ex);
         }
     }
}
