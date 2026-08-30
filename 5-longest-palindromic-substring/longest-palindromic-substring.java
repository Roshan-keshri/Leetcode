class Solution {

    public String longestPalindrome(String s) {
        int n = s.length();
        String[][] dp = new String[n][n];
        Boolean[][] pal = new Boolean[n][n];
        return findstr(s, 0, n - 1, dp, pal);
    }

    public String findstr(String s, int i, int j,
                          String[][] dp, Boolean[][] pal) {
        if (i > j) return "";
        if (i == j)
            return String.valueOf(s.charAt(i));
        if (dp[i][j] != null)
            return dp[i][j];
        if (isPalindrome(s, i, j, pal)) {
            return dp[i][j] = s.substring(i, j + 1);
        }
        String left = findstr(s, i + 1, j, dp, pal);
        String right = findstr(s, i, j - 1, dp, pal);
        if (left.length() > right.length()) {
            dp[i][j] = left;
        } else {
            dp[i][j] = right;
        }
        return dp[i][j];
    }


    public boolean isPalindrome(String s, int i, int j,
                                Boolean[][] pal) {
        if (i >= j)
            return true;
        if (pal[i][j] != null)
            return pal[i][j];
        if (s.charAt(i) != s.charAt(j))
            return pal[i][j] = false;
        return pal[i][j] =
                isPalindrome(s, i + 1, j - 1, pal);
    }
}