package com.utils;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.List;
import java.util.Random;

public class Base {
	
	public static WebDriver driver;

    /***
     * get random number from the list size
     * @param element - list of elements
     * @return
     */
    public int getRandomNumber(List<WebElement> element){

        Random rand = new Random();
        return  rand.nextInt(element.size());
    }

    /***
     * get random number from the list size
     * @param //int - list of number
     * @return
     */
    public int getRandomNumber(int i){

        Random rand = new Random();
        return  rand.nextInt(i);
    }

    /***
     * Method getStringValue(String value) returns String value only from string(Seperate Numbers from String)
     * @param value - pass like "test(1s-)"....
     * @return - String
     */
    public String getStringValue(String value){

        String string="";
        for (int i =0; i<value.length(); i++ ){

            char character = value.charAt(i);
            if(Character.isLetter(character) || character == '/'
                    || character == '-' || Character.isSpaceChar(character)) string = string+character;
        }
        return string;
    }

    public String getIntegerValue(String value){

        String string="";
        for (int i =0; i<value.length(); i++ ){

            char character = value.charAt(i);
            if(!Character.isLetter(character)
                    || !Character.isSpaceChar(character)) string = string+character;
        }
        return string;
    }


    public static String setPunctuationMarkWithTitleSize(String title, String punctuationMark){

        String hyphen= "";
        for(int i= 0; i<title.length()+1;++i){

            hyphen += punctuationMark;
        }
        return hyphen;
    }

    public String fetchQueryFromTxtFile(String txtFile){

        String query ="";
        try {
            query = new String(Files.readAllBytes(Paths.get(txtFile)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return query;
    }

    public String convertBooleanToString(boolean status){

        return String.valueOf(status);
    }
    
    
   // public void createNw(){
    ///	Robot r=new Robot();
    	
   // }
    public void openNewTab() {
    	Actions action = new Actions(driver);
    	action.sendKeys(Keys.CONTROL + "t");
    	
    }



}
