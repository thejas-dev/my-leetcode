class Solution {
    public long maxPoints(int[][] points) {
        int rows = points.length - 1;
        int cols = points[0].length - 1;

        long[] curr_row = new long[cols+1];

        for(int m = 0; m <= cols; m++){
            curr_row[m] = points[0][m];
        }

        for(int i = 1; i <= rows; i++){
            long[] left = new long[cols + 1];
            long[] right = new long[cols + 1];
            long[] next_row = new long[cols + 1];

            for(int m = 0; m <= cols; m++){
                next_row[m] = points[i][m];
            }

            left[0] = curr_row[0];
            right[cols] = curr_row[cols];

            // Fill Left
            for(int j = 1; j <= cols; j++){
                left[j] = Math.max(curr_row[j],left[j-1] - 1);
            }

            // Fill Right
            for(int j = cols-1; j >= 0; j--){
                right[j] = Math.max(curr_row[j],right[j+1] - 1);
            }

            // Find Max and add to curr_row
            for(int k = 0; k <= cols; k++){
                next_row[k] += Math.max(left[k],right[k]);
            }
            curr_row = next_row;
        }
        
        long resPoints = Long.MIN_VALUE;

        for(int i = 0; i <= cols; i++){
            resPoints = Math.max(curr_row[i],resPoints);
        }

        return resPoints;       
    }
}

//Brute Method
// class Solution {
//     public long maxPoints(int[][] points) {

//         long resPoints = 0;
//         int currIdx = -1;

//         for(int i = 0; i < points.length; i++){
//             int maxPoint = -1;
//             int maxIdx = 0;

//             for(int j = 0; j < points[i].length; j++){

//                 if(currIdx > -1 && (points[i][j] - Math.abs(currIdx - j)) >= maxPoint){
//                     maxPoint = points[i][j] - Math.abs(currIdx - j);
//                     maxIdx = j;
//                 }
//                 if(currIdx > -1) continue;

//                 if(points[i][j] >= maxPoint){
//                     maxPoint = points[i][j];
//                     maxIdx = j;
//                 }
//             }
//             resPoints += maxPoint;

//             System.out.println(maxPoint +" " + maxIdx);

//             if(currIdx == -1){
//                 currIdx = maxIdx;
//             }else{
//                 // resPoints -= Math.abs(currIdx - maxIdx);
//                 currIdx = maxIdx;
//             }
//         } 

//         return resPoints;       
//     }
// }