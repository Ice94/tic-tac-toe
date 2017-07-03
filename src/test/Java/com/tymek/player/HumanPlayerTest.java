package com.tymek.player;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by bratek on 03.07.17.
 */
public class HumanPlayerTest {


    @DataProvider(name = "correctNamesAndSigns")
    public static Object[][] correctNamesAndSigns(){
        return new Object[][]{
                {"Mateusz", "X"},
                {"Karol", "O"},
                {"Kamil", "X"}
        };
    }



    @Test (dataProvider = "correctNamesAndSigns")
    public void testCreationOfPlayerWithGivenNameAndSign(String name, String sign){
        HumanPlayer humanPlayer = new HumanPlayer.PlayerBuilder()
                .addName(name)
                .addSign(sign)
                .build();


    }

}