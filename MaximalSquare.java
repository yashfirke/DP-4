public class MaximalSquare {
    public int maximalSquare3(char[][] matrix) {
        // TC:O(m*n)
        // SC:O(n)
        if(matrix == null) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;

        int[] dp = new int[n+1];
        for(int i = 1; i <= m; i++ ){
            int diagUp = 0;
            for(int j = 1; j <= n; j++){
                int temp = dp[j];
                if(matrix[i-1][j-1] == '1'){
                    dp[j] = Math.min(dp[j],Math.min(dp[j-1],diagUp)) + 1;
                    max = Math.max(max, dp[j]);
                }else{
                    dp[j] = 0;
                }
                diagUp = temp;
            }
        }
        return max * max;
    }
    public int maximalSquare2(char[][] matrix) {
        // TC:O(m*n)
        // SC:O(m*n)
        if(matrix == null) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;

        int[][] dp = new int[m+1][n+1];
        for(int i = 1; i <= m; i++ ){
            for(int j = 1; j <= n; j++){
                if(matrix[i-1][j-1] == '1'){
                    dp[i][j] = Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1])) + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max * max;
    }
    public int maximalSquare(char[][] matrix) {
//        TC:O(m*n)^2
//        SC:O(1)
        //brute force
        if(matrix == null) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] =='1'){
                    int le = 1;
                    boolean flag = true;
                    while(flag && i+le < m && j+le <n && matrix[i+le][j+le]=='1'){
                        for(int k = i+le; k >= i; k--){
                            if(matrix[k][j+le]=='0'){
                                flag = false;
                                break;

                            }
                        }
                        for(int k = j+le; k >= j; k--){
                            if(matrix[i+le][k]=='0'){
                                flag = false;
                                break;

                            }
                        }
                        if(flag) le++;

                    }
                    max = Math.max(max,le);
                }
            }
        }
        return max*max;
    }
}
