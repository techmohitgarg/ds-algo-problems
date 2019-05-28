package com.mohit.leetcode.array.medium;

/*
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.
 */
public class WordSearch {

    public static void main(String[] args) {
        WordSearch search = new WordSearch();
        System.out.println(search.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCCED"));
    }

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (findWord(board, word, 0, i, j)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }


    private boolean findWord(char[][] board, String word, int val, int i, int j) {
        if (val == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(val)) {
            return false;
        }
        char c = word.charAt(val);
        board[i][j] = '*';
        boolean res = findWord(board, word, val + 1, i, j + 1) || findWord(board, word, val + 1, i + 1, j)
                || findWord(board, word, val + 1, i, j - 1) || findWord(board, word, val + 1, i - 1, j);
        board[i][j] = c;
        return res;
    }
}