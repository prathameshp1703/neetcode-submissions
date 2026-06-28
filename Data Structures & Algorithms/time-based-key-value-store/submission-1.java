class TimeMap {
    class Pair{
        int timestamp;
        String value;

        Pair(int timestamp, String value){
            this.timestamp = timestamp;
            this.value = value;
        }
    }

    private Map<String, List<Pair>> lookup;

    public TimeMap() {
        lookup = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(lookup.containsKey(key)){
            lookup.get(key).add(new Pair(timestamp, value));
        }
        else{
            List<Pair> values = new ArrayList<>();
            values.add(new Pair(timestamp, value));
            lookup.put(key, values);
        }
    }
    
    private String getMostRecentValue(List<Pair> values, int timestamp){
        int left = 0; int right = values.size()-1;
        String ans = "";
        while(left <= right){
            int mid = left + (right-left)/2;
            if(values.get(mid).timestamp == timestamp){
                return values.get(mid).value;
            }
            else if(values.get(mid).timestamp > timestamp){
                right = mid-1;
            }
            else{
                ans = values.get(mid).value;
                left = mid+1;
            }
        }

        return ans;
    }

    public String get(String key, int timestamp) {
        if(!lookup.containsKey(key)) return "";
        List<Pair> values = lookup.get(key);
        String ans = getMostRecentValue(values, timestamp);
        return ans;
    }
}
