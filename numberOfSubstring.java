class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int ct = 0;
        for(String pattern : patterns){
            if(word.indexOf(pattern) > -1) ct++;
        }
        return ct;
    }
}