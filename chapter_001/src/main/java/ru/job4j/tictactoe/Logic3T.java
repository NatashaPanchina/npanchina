package ru.job4j.tictactoe;


public class Logic3T {
    private final Figure3T[][] table;

    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    public boolean isWinnerX() {
        boolean result = false;
        //диагонали
        if (this.table[0][0].hasMarkX() && this.table[1][1].hasMarkX() && this.table[2][2].hasMarkX()
                || this.table[2][0].hasMarkX() && this.table[1][1].hasMarkX() && this.table[0][2].hasMarkX()) {
              result = true;
        }
        //горизонтали
        if (!result) {
            for (int out = 0; out < this.table.length; out++) {
                if (this.table[out][0].hasMarkX() && this.table[out][1].hasMarkX() && this.table[out][2].hasMarkX()) {
                    result = true;
                    break;
                }
            }
        }
        //вертикали
        if (!result) {
            for (int in = 0; in < this.table.length; in++) {
                if (this.table[0][in].hasMarkX() && this.table[1][in].hasMarkX() && this.table[2][in].hasMarkX()) {
                        result = true;
                        break;
                }
            }
        }
        return result;
    }

    public boolean isWinnerO() {
        boolean result = false;
        //диагонали
        if (this.table[0][0].hasMarkO() && this.table[1][1].hasMarkO() && this.table[2][2].hasMarkO()
                || this.table[0][0].hasMarkO() && this.table[1][1].hasMarkO() && this.table[2][2].hasMarkO()) {
            result = true;
        }
        //горизонтали
        if (!result) {
            for (int out = 0; out < this.table.length; out++) {
                if (this.table[out][0].hasMarkO() && this.table[out][1].hasMarkO() && this.table[out][2].hasMarkO()) {
                    result = true;
                    break;
                }
            }
        }
        //вертикали
        if (!result) {
            for (int in = 0; in < this.table[in].length; in++) {
                if (this.table[0][in].hasMarkO() && this.table[1][in].hasMarkO() && this.table[2][in].hasMarkO()) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    public boolean hasGap() {
        boolean result =  false;
        for (int out = 0; out < this.table.length; out++) {
            for (int in = 0; in < this.table[out].length; in++) {
                if (!this.table[out][in].hasMarkO() & !this.table[out][in].hasMarkX()) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }
}

