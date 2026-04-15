class MedianFinder {

        PriorityQueue<Integer> minheap;
        PriorityQueue<Integer> maxheap;

    public MedianFinder() {
        minheap=new PriorityQueue<>();
        maxheap=new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        maxheap.offer(num);

        minheap.offer(maxheap.poll());

        if(maxheap.size()!=minheap.size()){
            maxheap.offer(minheap.poll());
        }
        
    }
    
    public double findMedian() {
        if(maxheap.size()==minheap.size()){
            return (maxheap.peek()+minheap.peek())/2.0;
        }
        return maxheap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */