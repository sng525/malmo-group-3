package se.vejbystrand.ourapplication;


import java.util.ArrayList;

public interface Repository {
    Exercise findExerciseById(int id);
    // Fixme This s*** is broken
    ArrayList<Exercise> findAllExercises();
    // ToDo Connect Add
    void save(Exercise exercise); // CONNECT TO ADD(?)
}
