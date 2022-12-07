package se.vejbystrand.ourapplication;

public class Exercise {


        private int id;
        private String activity;
        private int weight;
        private int set;
        private int reps;
        private CharSequence date;


        public Exercise() {
            this.id = id;
            activity = activity;
            weight = weight;
            set = set;
            reps = reps;
            date = date;

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

        public CharSequence getDate() {
            return date;
        }

        public Exercise setDate(CharSequence date) {
            this.date = date;
            return this;
        }
}
