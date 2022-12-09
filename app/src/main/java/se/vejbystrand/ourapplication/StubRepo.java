package se.vejbystrand.ourapplication;

import java.util.ArrayList;

public class StubRepo<exercises> {
    private ArrayList<Exercise> exercises;

    public StubRepo() {
        exercises = new ArrayList<>();
        exercises.add(new Exercise()
                .setId(15)
                .setActivity("Squats")
                .setWeight(12)
                .setSet(12)
                .setReps(2)
                .setDate("2022-03-22"));

        exercises.add(new Exercise()
                .setId(17)
                .setActivity("Rodd")
                .setWeight(45)
                .setSet(3)
                .setReps(5)
                .setDate("2022-03-26"));

        exercises.add(new Exercise()
                .setId(2)
                .setActivity("Benchpress")
                .setWeight(45)
                .setSet(4)
                .setReps(6)
                .setDate("2022-03-28"));

        exercises.add(new Exercise()
                .setId(7)
                .setActivity("bicep curl")
                .setWeight(22)
                .setSet(10)
                .setReps(5)
                .setDate("2022-03-26"));
    }
}
