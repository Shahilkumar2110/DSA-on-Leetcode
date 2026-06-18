class Solution {
    public double angleClock(int hour, int minutes) {
        double ang_hour=(hour*30)+(minutes*0.5);
        double ang_min=6*minutes;

        double diff=Math.abs(ang_hour-ang_min);

        return Math.min(diff,360-diff);
    }
}