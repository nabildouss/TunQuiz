package com.example.android.quizapp;

/**
 * Created by n_douss on 06.02.18.
 */

public class ScoreSingleton {

        private static ScoreSingleton instance;

        // Global variable
        private int score;

        // Restrict the constructor from being instantiated
        private ScoreSingleton(){}

        public void setScore(int s){
            this.score= s;
        }
        public int getScore(){
            return this.score;
        }

        public static synchronized ScoreSingleton getInstance(){
            if(instance==null){
                instance=new ScoreSingleton();
            }
            return instance;
        }

}
