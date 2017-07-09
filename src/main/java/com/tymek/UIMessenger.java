package com.tymek;

import java.io.OutputStream;
import java.io.PrintStream;

/**
 * Created by bratek on 10.07.17.
 */
public class UIMessenger implements Messenger{

    PrintStream outputStream;

    public UIMessenger(PrintStream outputStream) {
        this.outputStream = outputStream;
    }

    @Override
    public void printMessage(String message) {
        outputStream.println(message);
    }
}
