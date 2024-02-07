package com.pjurczen;

import java.util.Comparator;
import java.util.PriorityQueue;

class MedianFinder {

    private final PriorityQueue<Integer> minHeap;
    private final PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
    }

    public void addNum(int num) {
        maxHeap.add(num);

        minHeap.add(maxHeap.peek());
        maxHeap.poll();

        if (maxHeap.size() < minHeap.size()){
            maxHeap.add(minHeap.peek());
            minHeap.poll();
        }
    }

    public double findMedian() {
        return maxHeap.size() > minHeap.size() ? maxHeap.peek() : ((double) maxHeap.peek() + (double) minHeap.peek()) * 0.5;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
