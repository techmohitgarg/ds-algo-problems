
public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.minDistance("sea", "eat"));
    }


    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        if (n1 == 0) return n2;
        if (n2 == 0) return n1;
        int[][] temp = new int[n1 + 1][n2 + 1];
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    temp[i][j] = temp[i - 1][j - 1] + 1;
                } else {
                    temp[i][j] = Math.max(temp[i - 1][j], temp[i][j - 1]);
                }
            }
        }
        int minMatch = temp[n1][n2];
        int ans = (n1 - minMatch) + (n2 - minMatch);
        return ans;
    }
}

