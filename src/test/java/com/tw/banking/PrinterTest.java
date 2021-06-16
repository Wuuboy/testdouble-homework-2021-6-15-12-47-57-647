package com.tw.banking;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class PrinterTest {
    @Test
    void should_return_a_copy_of_transactions_when_invoke_printStatementLines() {
        Console console = mock(Console.class);
        Printer printer = new Printer(console);

        List<Transaction> transactions = getShuffleTransactions();

        printer.print(transactions);

        verify(console, times(3)).printLine(anyString());
    }

    private List<Transaction> getShuffleTransactions() {
        Transaction tansaction1 = new Transaction("16/6/2021", 5000);
        Transaction transaction2 = new Transaction("16/6/2021", -200);
        List<Transaction> transactions = Arrays.asList(tansaction1, transaction2);
        Collections.shuffle(transactions);
        return transactions;
    }
}
