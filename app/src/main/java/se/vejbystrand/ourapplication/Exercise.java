package se.vejbystrand.ourapplication;

public class Exercise {


        private int id;
        private static String activity;
        private static int weight;
        private static int set;
        private static int reps;
        private static String date;


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

        public static String getActivity() {
            return activity;
        }

        public void setActivity(String activity) {
            this.activity = activity;
        }

        public static int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public static int getSet() {
            return set;
        }

        public void setSet(int set) {
            this.set = set;
        }

        public static int getReps() {
            return reps;
        }

        public void setReps(int reps) {
            this.reps = reps;
        }

        public static String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }
}
