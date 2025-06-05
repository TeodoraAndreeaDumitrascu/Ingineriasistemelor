package laborator10.dataprocessing;

import laborator10.storage.SensorData;

public class BasicStepCountStrategy implements StepCountStrategy {

    private int totalSteps = 0;


    @Override
    public void consumeMessage(SensorData sample) {
        if (sample != null) {
            totalSteps += sample.getStepsCount();
        }
    }

    /**
     * Returnează numărul total de pași calculat prin sumarea tuturor valorilor.
     */
    @Override
    public int getTotalSteps() {
        return totalSteps;
    }

    /**
     * Returnează descrierea strategiei pentru afișare.
     */
    @Override
    public String getStrategyDescription() {
        return "Basic Step Counter - sumează toate valorile";
    }
}