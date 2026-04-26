class Solution {
    public boolean isValidSerialization(String preorder) {

        String[] arr = preorder.split(",");
        Stack<pair> st = new Stack<>();

        for (int i = 0; i < arr.length; i++) {

            String ch = arr[i];


            while (ch.equals("#") && !st.isEmpty() && st.peek().child == 1) {
                st.pop();
            }

            if (ch.equals("#")) {
                if (st.isEmpty()) return i == arr.length - 1;
                st.peek().child++;
                if(st.peek().child==2) return false;
            } else {
                st.push(new pair(0)); 
            }
        }

        return st.isEmpty();
    }
}

class pair {
    int child;

    pair(int c) {
        this.child = c;
    }
}