class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> records = new Stack<>();

        for (String op : operations){
            if (op.equals("+")){
                int top = records.pop();
                int sum = top + records.peek();

                records.push(top);
                records.push(sum); 
            }else if (op.equals("D")){
                records.push(2 * records.peek());
            }else if (op.equals("C")){
                records.pop();
            }else {
                records.push(Integer.parseInt(op));
            }
        }

        int sum = 0;

        for (int n : records){
            sum += n;
        }

        return sum;

    }
}