public class FlightMovieSuggestor {

    public int[] suggest(int[] movieDurations, int flightDuration) {
        int[] suggestion = new int[2];

        int maxCombinedDuration = 0;
        for (int i = 0; i < movieDurations.length; i++) {
            for (int j = movieDurations.length -1 ; j > i; j--) {
                int currentDuration = movieDurations[i] + movieDurations[j];
                if (currentDuration > maxCombinedDuration && currentDuration <= flightDuration - 30) {
                    maxCombinedDuration = currentDuration;
                    suggestion = new int[]{i, j};
                }
            }
        }
        return suggestion;
    }
}
