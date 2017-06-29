package com.tymek.board;

/**
 * Created by Mateusz on 29.06.2017.
 */
public class BoardField {

    private String sign;
    private int fieldNumber;

    BoardField(int fieldNumber) {
        this.fieldNumber = fieldNumber;
    }

    public void setFieldNumber(int fieldNumber) {
        this.fieldNumber = fieldNumber;
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
        return sign == null ? String.valueOf(String.format("%02d", fieldNumber)) + " " : sign + " ";
    }
}
