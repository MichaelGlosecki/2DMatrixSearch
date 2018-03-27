class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int low = 0;
        int high = matrix.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid == 0 && high == 0) {
                return searchRow(matrix[mid], target);
            } else if (target < matrix[mid][0]) {
                high = mid - 1 > 0 ? mid - 1 : 0;
            } else if (target > matrix[mid][0]) {
                low = mid + 1 > 0 ? mid + 1 : 0;
            } else {
                return searchRow(matrix[mid], target);
            }
        }

        return searchRow(matrix[high], target);
    }

    private boolean searchRow(int[] row, int target) {
        int low = 0;
        int high = row.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (target < row[mid]) {
                high = mid - 1;
            } else if (target > row[mid]) {
                low = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},
                {10,11,16,20},
                {23,30,34,50}};

        Solution solution = new Solution();
        System.out.println(solution.searchMatrix(matrix, 11));
    }
}
