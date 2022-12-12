package se.vejbystrand.ourapplication;

public class Exercise {


        private int id;
        private String activity;
        private int weight;
        private int set;
        private int reps;
        private String date;


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

        public void setId(int id) {
            this.id = id;
        }

        public String getActivity() {
            return activity;
        }

        public void setActivity(String activity) {
            this.activity = activity;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public int getSet() {
            return set;
        }

        public void setSet(int set) {
            this.set = set;
        }

        public int getReps() {
            return reps;
        }

        public void setReps(int reps) {
            this.reps = reps;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }
}
