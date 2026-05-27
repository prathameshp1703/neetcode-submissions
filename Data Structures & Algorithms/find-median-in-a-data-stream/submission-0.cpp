class MedianFinder {
public:
    priority_queue<int, vector<int>> maxHeap;
    priority_queue<int, vector<int>, greater<int>> minHeap;

    MedianFinder() {
        
    }
    
    void addNum(int num) {
        if(maxHeap.size() == 0){
            maxHeap.push(num);
        }
        else{
            if(maxHeap.top()>=num){
                maxHeap.push(num);
            }
            else{
                minHeap.push(num);
            }
        }
        if(maxHeap.size()>1+minHeap.size()){
            int ele = maxHeap.top(); maxHeap.pop();
            minHeap.push(ele);
        }
        else if(minHeap.size()>1+maxHeap.size()){
            int ele = minHeap.top(); minHeap.pop();
            maxHeap.push(ele);
        }
    }
    
    double findMedian() {
        double ans = 0.0;
        int count = minHeap.size() + maxHeap.size();
        if(count % 2 == 0){
            ans = minHeap.top() + maxHeap.top();
            ans = ans / 2.0;
        }
        else{
            if(maxHeap.size()>minHeap.size()){
                ans = maxHeap.top();
            }
            else{
                ans = minHeap.top();
            }
        }
        return ans;
    }
};
