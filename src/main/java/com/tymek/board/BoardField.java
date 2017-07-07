package com.tymek.board;

/**
 * Created by Mateusz on 29.06.2017.
 */
public class BoardField {

    private String sign;
    private int fieldNumber;


    BoardField(int fieldNumber) {
        this.fieldNumber = fieldNumber;
        sign = String.valueOf(fieldNumber);
    }

    public int getFieldNumber() {
        return fieldNumber;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getSign() {
        return sign;
    }

    @Override
    public String toString() {
        if (sign.equals(String.valueOf(fieldNumber))) {
            if (fieldNumberLessThanTen()) {
                return "0" + sign + " ";
            }
            else return sign + " ";
        }
        return sign;
    }

    private boolean fieldNumberLessThanTen() {
        return fieldNumber < 10;
    }

    boolean isTaken() {
        return !sign.equals(String.valueOf(fieldNumber));
    }
}
