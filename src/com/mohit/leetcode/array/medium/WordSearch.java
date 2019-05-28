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
                if (isMatch(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isMatch(char[][] board, String word, int start, int i, int j) {
        if (word.length() == start) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || word.charAt(start) != board[i][j]) {
            return false;
        }
        char temp = board[i][j];
        board[i][j] = '*';
        boolean result =
                isMatch(board, word, start + 1, i + 1, j) ||
                        isMatch(board, word, start + 1, i - 1, j) ||
                        isMatch(board, word, start + 1, i, j - 1) ||
                        isMatch(board, word, start + 1, i, j + 1);
        board[i][j] = temp;
        return result;
    }
}