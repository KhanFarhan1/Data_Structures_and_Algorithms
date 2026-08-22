class MinStack {
    ArrayList<Integer> stack ;
    ArrayList<Integer> min;
    public MinStack() {
        stack = new ArrayList<>();
        min = new ArrayList<>();
    }
    
    public void push(int val) {
        stack.add(val);
        if(min.size()-1 < 0){
            min.add(val);
        }else{
            int min_val = Math.min(val,min.get(min.size()-1));
            min.add(min_val);
        }
    }
    
    public void pop() {
        stack.remove(stack.size()-1);
        min.remove(min.size()-1);
    }
    
    public int top() {  
        return stack.get(stack.size()-1);
    }
    
    public int getMin() {
        return min.get(min.size()-1);
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */