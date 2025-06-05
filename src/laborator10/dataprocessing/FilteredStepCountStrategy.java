package laborator10.dataprocessing;

import laborator10.storage.SensorData;

import java.util.ArrayList;
import java.util.List;

public class FilteredStepCountStrategy implements StepCountStrategy {

    private int totalSteps = 0;
    private List<SensorData> recentData = new ArrayList<>();
    private static final int MAX_STEPS_PER_MINUTE = 1000;
    private static final long ONE_MINUTE_MILLIS = 60 * 1000; // 1 minut în milisecunde

     //Consumă un eșantion de date și îl procesează conform filtrelor.

    @Override
    public void consumeMessage(SensorData sample) {
        if (sample == null) {
            return;
        }

        // Condiția 1: Acceptă doar numere pozitive
        if (sample.getStepsCount() <= 0) {
            return; // Ignoră valorile negative sau zero
        }

        // Curăță datele vechi (mai vechi de 1 minut)
        cleanOldData(sample.getTimestamp());

        // Condiția 2: Verifică dacă adăugarea acestor pași nu depășește limita pe minut
        int stepsInLastMinute = calculateStepsInLastMinute(sample.getTimestamp());

        if (stepsInLastMinute + sample.getStepsCount() <= MAX_STEPS_PER_MINUTE) {
            // Acceptă datele și le adaugă la total
            totalSteps += sample.getStepsCount();
            recentData.add(sample);
        }
        // Altfel, ignoră datele (depășesc limita de 1000 pași pe minut)
    }

    //Calculează câți pași au fost înregistrați în ultimul minut.

    private int calculateStepsInLastMinute(long currentTimestamp) {
        return recentData.stream()
                .filter(data -> currentTimestamp - data.getTimestamp() <= ONE_MINUTE_MILLIS)
                .mapToInt(SensorData::getStepsCount)
                .sum();
    }

    //Elimină datele mai vechi de 1 minut pentru a optimiza memoria.

    private void cleanOldData(long currentTimestamp) {
        recentData.removeIf(data ->
                currentTimestamp - data.getTimestamp() > ONE_MINUTE_MILLIS);
    }

     //Returnează numărul total de pași validați.

    @Override
    public int getTotalSteps() {
        return totalSteps;
    }

    // Returnează descrierea strategiei pentru afișare.


    @Override
    public String getStrategyDescription() {
        return "Filtered Step Counter - doar valori pozitive, max 1000 pași/minut";
    }
}