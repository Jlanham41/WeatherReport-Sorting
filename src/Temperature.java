public class Temperature {
    private final String city;
    private final String state;
    private final int low;
    private final int high;

    public Temperature(String city, String state, int low, int high) {
        this.city = city;
        this.state = state;
        this.low = low;
        this.high = high;
    }
     public String getCity() { return city; }
     public String getState() {return state; }
     public int getLow() { return low; }
     public int getHigh() { return high; }

     public int differential() {
        return Math.abs(high - low);
     }
     @Override
     public String toString() {
        return city + ", " + state + " low=" + low + " high=" + high + " diff=" + differential();
     }  
}
