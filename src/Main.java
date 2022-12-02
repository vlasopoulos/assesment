import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        FlightMovieSuggestor fms = new FlightMovieSuggestor();
        if (args[0].equals("sample")){
            System.out.println("Sample data\nMovie Durations: {90, 85, 75, 60, 120, 150, 125}\nFlight Duration: 250");
            System.out.println(Arrays.toString(fms.suggest(new int[] {90, 85, 75, 60, 120, 150, 125}, 250 )));
        } else {
            if (args.length < 3) {
                System.out.println("Expected at least 3 arguments (List of movie durations, Flight duration), or 1 argument \"sample\"");
                return;
            }

            if (args.length > 1001) {
                System.out.println("Expected at most 1000 movie durations)");
                return;
            }

            int[] movieDurations = new int[args.length - 1];
            int flightDuration = Integer.parseInt(args[args.length - 1]);
            if (flightDuration < 60) {
                System.out.println("Expected flight duration longer than 60 minutes");
                return;
            }
            for (int i = 0; i < args.length - 1; i++) {
                movieDurations[i] = Integer.parseInt(args[i]);
            }
            System.out.println(Arrays.toString(fms.suggest(movieDurations, flightDuration)));
        }
    }
}