class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < asteroids.length; i++){
            if(asteroids[i] >= 0){
                stack.push(asteroids[i]);
            }else{
                boolean destroyed = false;

                while(!stack.isEmpty() && stack.peek() >= 0 && stack.peek() <= -(asteroids[i])){
                    if(stack.peek() == -(asteroids[i])){
                        destroyed = true;
                        stack.pop();
                        break;
                    }else if(stack.peek() < -(asteroids[i])){
                        stack.pop();
                    }
                }
                
                if(!destroyed && (stack.isEmpty() || stack.peek() < 0)){
                    stack.push(asteroids[i]);
                }
            }
        }

        int[] res = new int[stack.size()];
        int idx = stack.size() - 1;

        while(!stack.isEmpty()){
            res[idx] = stack.pop();
            idx--;
        }

        return res;

    }
}