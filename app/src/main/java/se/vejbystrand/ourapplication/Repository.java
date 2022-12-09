package se.vejbystrand.ourapplication;


import java.util.ArrayList;

public interface Repository {
    Exercise findExerciseById(int id);
    ArrayList<Exercise> findAllExercises();
}
