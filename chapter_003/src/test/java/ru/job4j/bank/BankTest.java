package ru.job4j.bank;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * BankTest.
 *
 * @author Natasha Panchina (panchinanata25@gmail.com)
 * @version 1
 * @since 20.11.2018
 */
public class BankTest {
    @Test
    public void whenAddUser() {
        Bank bank = new Bank();
        bank.addUser(new User("Ivan", "123"));
        assertThat(bank.users.size(), is(1));
    }

    @Test
    public void whenDeleteUser() {
        Bank bank = new Bank();
        User user = new User("Ivan", "123");
        bank.addUser(user);
        bank.deleteUser(user);
        assertThat(bank.users.size(), is(0));
    }

    @Test
    public void whenAddAccountsToUser() {
        Bank bank = new Bank();
        User user = new User("Ivan", "1234");
        bank.addUser(user);
        bank.addAccountToUser("1234", new Account(10.0, "10"));
        assertThat(bank.users.get(user).size(), is(1));
    }

    @Test
    public void whenDeleteAccounts() {
        Bank bank = new Bank();
        Account account = new Account(4000, "four thousand");
        User user = new User("Peter", "1000");
        bank.addUser(user);
        bank.addAccountToUser("1000", account);
        bank.deleteAccountFromUser("1000", account);
        assertThat(bank.users.get(user).size(), is(0));
    }

    @Test
    public void whenOneAccountTransferMoneyToOtherAccount() {
        Bank bank = new Bank();
        bank.addUser(new User("Peter", "peter"));
        bank.addUser(new User("Alex", "alex"));
        bank.addAccountToUser("peter", new Account(2000, "two thousand"));
        bank.addAccountToUser("alex", new Account(8000, "eight thousand"));
        bank.transferMoney("alex", "eight thousand", "peter", "two thousand", 3000);
        Account account = bank.getUserAccounts("peter").get(0);
        assertThat(account.getValue(), is(5000.0));
    }
}
