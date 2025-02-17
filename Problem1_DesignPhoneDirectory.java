// Time Complexity :o(N)
// Space Complexity : o(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class PhoneDirectory {

    /** Initialize your data structure here
        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    
    Queue<Integer> queue;
    Set<Integer> set;
    int max;
    public PhoneDirectory(int maxNumbers) {
        
        queue=new LinkedList<>();
        set=new HashSet<>();
        max=maxNumbers;
        
        for(int i=0;i<maxNumbers;i++)
        {
            queue.add(i);
        }
    }
    
    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    public int get() {
        
        if(!queue.isEmpty())
        {
            int curr=queue.poll(); // not available for anymore
            set.add(curr);
            return curr;
        }
        return -1;
    }
    
    /** Check if a number is available or not. */
    public boolean check(int number) {
      
        if(number<0 || number>max)
        {
            return false;
        }
        if(!set.contains(number))
            return true;
        return false;
    }
    
    /** Recycle or release a number. */
    public void release(int number) {
        
        if(set.contains(number))
        {
            set.remove(number);
            queue.add(number);
        }
            
    }
}

/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */