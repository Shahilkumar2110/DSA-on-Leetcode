class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {

        int num1 = length(p1, p2);
        int num2 = length(p1, p3);
        int num3 = length(p1, p4);

        int side;
        int[] l1, l2, l3;

        if (num1 == 0 || num2 == 0 || num3 == 0) {
            return false;
        }

        if (num1 == num2 && num1 < num3) {
            l1 = p2;
            l2 = p3;
            l3 = p4;
            side = num1;
        } else if (num1 == num3 && num1 < num2) {
            l1 = p2;
            l2 = p4;
            l3 = p3;
            side = num1;
        } else if (num2 == num3 && num2 < num1) {
            l1 = p3;
            l2 = p4;
            l3 = p2;
            side = num2;
        } else {
            return false;
        }

        return length(l3, l1) == side
            && length(l3, l2) == side
            && length(l1, l2) == 2 * side;
    }

    int length(int[] x1, int[] x2) {
        int dx = x1[0] - x2[0];
        int dy = x1[1] - x2[1];

        return dx * dx + dy * dy;
    }
}