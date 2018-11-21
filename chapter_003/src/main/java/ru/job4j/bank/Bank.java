package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Bank.
 *
 * @author Natasha Panchina (panchinanata25@gmail.com)
 * @version 1
 * @since 20.11.2018
 */
public class Bank {
    Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        this.users.putIfAbsent(user, new ArrayList<>());
    }

    public void deleteUser(User user) {
        this.users.remove(user);
    }

    /**
     * Method addAccountToUser
     * @param passport - user's passport
     * @param account
     */
    public void addAccountToUser(String passport, Account account) {
        List<Account> accounts = this.getUserAccounts(passport);
        if (accounts != null && accounts.indexOf(account) == -1) {
            accounts.add(account);
        }
    }

    /**
     * Method deleteAccountFromUser
     * @param passport - user's passport
     * @param account
     */
    public void deleteAccountFromUser(String passport, Account account) {
        List<Account> accounts = this.getUserAccounts(passport);
        if (accounts != null && accounts.indexOf(account) != -1) {
            accounts.remove(account);
        }
    }

    /**
     * Method getUserAccounts
     * @param passport - user's passport
     * @return user's accounts
     */
    public List<Account> getUserAccounts(String passport) {
        List<Account> result = null;
        if (this.users != null) {
            for (User user : this.users.keySet()) {
                if (user.getPassport().equals(passport)) {
                    result = this.users.get(user);
                }
            }
        }
        return result;
    }

    /**
     * Method getActualAccount
     * @param passport - user's passport
     * @param requisite - account's requisite
     * @return account with this requisite
     */
    private Account getActualAccount(String passport, String requisite) {
        Account result = null;
        List<Account> accounts = this.getUserAccounts(passport);
        if (accounts != null) {
            for (Account account : accounts) {
                if (account.getRequisite().equals(requisite)) {
                    result = account;
                }
            }
        }
        return result;
    }

    /**
     * Method transferMoney
     * @param srcPassport
     * @param srcRequisite
     * @param destPassport
     * @param destRequisite
     * @param amount
     * @return
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean result = false;
        Account source = this.getActualAccount(srcPassport, srcRequisite);
        Account dest = this.getActualAccount(destPassport, destRequisite);
        if (source != null && dest != null) {
            result = source.transfer(dest, amount);
        }
        return result;
    }
}
