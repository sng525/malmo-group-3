package se.vejbystrand.ourapplication;

public class Exercise {


        private int id;
        private String activity;
        private int weight;
        private int set;
        private int reps;
        private String date;

        public Exercise(){
            id = weight = set = reps = 0;
            activity = date = "";
        }

        public Exercise(int id, String activity, int weight, int set, int reps, String date) {
            this.id = id;
            this.activity = activity;
            this.weight = weight;
            this.set = set;
            this.reps = reps;
            this.date = date;

        }

        public int getId() {
            return id;
        }

        public Exercise setId(int id) {
            this.id = id;
            return this;
        }

        public String getActivity() {
            return activity;
        }

        public Exercise setActivity(String activity) {
            this.activity = activity;
            return this;
        }

        public int getWeight() {
            return weight;
        }

        public Exercise setWeight(int weight) {
            this.weight = weight;
            return this;
        }

        public int getSet() {
            return set;
        }

        public Exercise setSet(int set) {
            this.set = set;
            return this;
        }

        public int getReps() {
            return reps;
        }

        public Exercise setReps(int reps) {
            this.reps = reps;
            return this;
        }

        public String getDate() {
            return date;
        }

        public Exercise setDate(String date) {
            this.date = date;
            return this;
        }
}
