import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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

    public WeatherReport(String filename) {
        temps = new LinkedList<>();
        loadFromFile(filename);
    }

    private void loadFromFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line = br.readLine();
            if (line == null) return;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length < 11) continue;
                String city = parts[1].trim();
                int high = Integer.parseInt(parts[5].trim());
                int low = Integer.parseInt(parts[6].trim());
                String state = parts[10].trim();
                temps.add(new Temperature(city, state, low, high));
            }
        } catch (IOException e) {
            throw new RuntimeException("Could not read file: " + filename, e);
        }
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
        WeatherReport wr = new WeatherReport("weather.txt");
        System.out.println("Records loaded: " + wr.temps.size());
        System.out.println("Sorted by City? " + wr.isSortedByCity());
        System.err.println("Sorted by High? " + wr.isSortedByHigh());
    }
}
