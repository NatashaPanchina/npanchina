package ru.job4j.bank;

/**
 * Account.
 *
 * @author Natasha Panchina (panchinanata25@gmail.com)
 * @version 1
 * @since 20.11.2018
 */
public class Account {
    private double value;
    private String requisite;

    public Account(double value, String requisite) {
        this.value = value;
        this.requisite = requisite;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getRequisite() {
        return requisite;
    }

    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Method transfer
     * @param destination - account
     * @param amount
     * @return
     */
    boolean transfer(Account destination, double amount) {
        boolean success = false;
        if (amount > 0 && amount < this.value && destination != null) {
            success = true;
            this.value -= amount;
            double value = destination.getValue() + amount;
            destination.setValue(value);
        }
        return success;
    }

    public String toString() {
        return "Account{" + "value=" + this.value
                + ", requisite=" + this.requisite + "}";
    }
}
