class Solution {
    public int calculate(String s) {

        int res = 0;
        int curr = 0;
        char op = '+';

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                curr = (curr * 10) + (ch - '0');
            }

            if(!Character.isDigit(ch) && ch != ' ' || i == s.length() - 1){
                if(op == '*'){
                    stack.push(stack.pop() * curr);
                }else if(op == '/'){
                    stack.push(stack.pop() / curr);
                }else if(op == '-'){
                    stack.push(-curr);
                }else{
                    stack.push(curr);
                }
                op = ch;
                curr = 0;
            }
        }

        for (int num : stack) {
            res += num;
        }

        return res;
    }
}