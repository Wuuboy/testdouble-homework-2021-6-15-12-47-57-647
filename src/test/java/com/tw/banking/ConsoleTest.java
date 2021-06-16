package com.tw.banking;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ConsoleTest {
    @Test
    void should_invoke_println_1_time_when_printLine_given_test() {
        //given
        PrintStream printStream = mock(PrintStream.class);
        System.setOut(printStream);
        String expectedResult = "test";
        Console console = new Console();

        //when
        console.printLine(expectedResult);

        //then
        verify(printStream, Mockito.times(1)).println(expectedResult);
    }

    @Test
    void should_print_test_and_line_when_printLine_given_test() {
        //given
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);
        String expectedResult = "test";
        Console console = new Console();

        //when
        console.printLine(expectedResult);

        //then
        assertEquals(expectedResult + "\r\n", byteArrayOutputStream.toString());
    }
}
