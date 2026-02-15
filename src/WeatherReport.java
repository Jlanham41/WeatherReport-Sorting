import java.text.DecimalFormatSymbols;
import java.util.LinkedList;

public class WeatherReport {
    private LinkedList<Temperature> temps;

    public WeatherReport() {
        temps = new LinkedList<>();
        temps.add(new Temperature("Chicago", "Illinois", 12, 26));
        temps.add(new Temperature("Dallas","Texas", 38, 61));
        temps.add(new Temperature("Miami","Florida", 70, 82));
        temps.add(new Temperature("Denver", "Colorado", 5, 31));
        temps.add(new Temperature("Seattle", "Washington", 40, 49));
        temps.add(new Temperature("Boston", "Massachusetts", 18, 34));
        temps.add(new Temperature("Phoenix", "Arizona", 45, 73));
        temps.add(new Temperature("Atlanta", "Arizona", 45, 73));
        temps.add(new Temperature("Atlanta", "Georgia", 29, 50));
        temps.add(new Temperature("Portland", "Oregon", 36, 47));
    }
    public boolean isSortedByCity() {
        for (int i=1; i < temps.size(); i++) {
            String prev = temps.get(i - 1).getCity();
            String curr = temps.get(i).getCity();
            if(prev.compareToIgnoreCase(curr) > 0) return false;
        }
        return true;
    }
    public boolean isSortedByHigh() {
        for (int i=1; i < temps.size(); i++) {
            int prev = temps.get(i - 1).getHigh();
            int curr = temps.get(i).getHigh();
            if (prev > curr) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        WeatherReport wr = new WeatherReport();
        System.out.println("Sorted by City? " + wr.isSortedByCity());
        System.err.println("Sorted by High? " + wr.isSortedByHigh());
    }
}
