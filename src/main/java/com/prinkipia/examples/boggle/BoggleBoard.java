package com.prinkipia.examples.boggle;

import java.util.Random;

public class BoggleBoard {
    final char[][] board;
    final int size;

    public BoggleBoard(int size) {
        this.size = size;
        board = new char[size][size];
        Random r = new Random();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = (char) ('A' + r.nextInt(26));
            }
        }
    }

    public BoggleBoard(final char[][] board, final int size) {
        this.board = board;
        this.size = size;
    }

    public char getLetter(int i, int j) {
        return board[i][j];
    }

    int getSize() {
        return size;
    }

    public void printBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}
