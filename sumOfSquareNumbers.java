class Solution {
    public boolean judgeSquareSum(int c) {
        int high = (int) Math.sqrt(c);
        int low = 0;

        while(low <= high){
            long res = (long) low*low + (long) high * high;
            if(res < c) low++;
            else if(res > c) high--;
            else return true;
        }

        return false;
    }
}