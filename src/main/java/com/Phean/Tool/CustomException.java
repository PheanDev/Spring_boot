package com.Phean.Tool;

public class CustomException extends Exception {
    public CustomException(){
        super();
    }
    public CustomException(String message)
    {
        super(message);
    }
    public CustomException(Exception ex)
    {
        super(ex.getMessage());
    }
}
