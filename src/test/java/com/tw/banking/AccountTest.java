package com.tw.banking;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

public class AccountTest {
    @Test
    void should_call_addDeposit_when_deposit() {
        //given
        TransactionRepository transactionRepository = mock(TransactionRepository.class);
        Printer printer = mock(Printer.class);
        Account account = new Account(transactionRepository, printer);
        int amount = 20210616;

        //when
        account.deposit(amount);

        //then
        verify(transactionRepository, times(1)).addDeposit(amount);
    }

    @Test
    void should_call_addWithdraw_when_withdraw() {
        //given
        TransactionRepository transactionRepository = mock(TransactionRepository.class);
        Printer printer = mock(Printer.class);
        Account account = new Account(transactionRepository, printer);
        int amount = 20210616;

        //when
        account.withdraw(amount);

        //then
        verify(transactionRepository, times(1)).addWithdraw(amount);
    }

    @Test
    void should_call_print_and_param_should_be_same_with_the_result_of_addTransactions_when_printStatement() {
        //given
        TransactionRepository transactionRepository = mock(TransactionRepository.class);
        Printer printer = mock(Printer.class);
        Account account = new Account(transactionRepository, printer);
        List<Transaction> transactions = Collections.singletonList(new Transaction("date", 20210616));
        given(transactionRepository.allTransactions()).willReturn(transactions);

        //when
        account.printStatement();

        //then
        verify(printer, times(1)).print(transactions);
    }

}
