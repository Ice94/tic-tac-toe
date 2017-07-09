package com.tymek;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.testng.Assert.*;

/**
 * Created by bratek on 10.07.17.
 */

@Test
public class UIMessengerTest {

    @DataProvider
    public static Object[][] textToUser(){
        return new Object[][]{
                {"Some text!"},
                {"Other text!"},
                {"Some stupid text!"}
        };
    }

    @Test(dataProvider = "textToUser")
    public void shouldPrintGivenText(String text){
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        UIMessenger uiMessenger = new UIMessenger(new PrintStream(outContent));

        uiMessenger.printMessage(text);


        assertEquals(text + "\n", outContent.toString());
    }
}