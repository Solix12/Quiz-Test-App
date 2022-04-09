package com.salikh.nurtest;

import java.util.ArrayList;
import java.util.Collections;

public class QuestionManager {


    private final ArrayList<String> mistakes = new ArrayList<>();
    private ArrayList<QuestionData> data;
    private int totalQuestion = 0;
    private int currentPosition = 0;
    private int totalTrue = 0;
    private int totalFalse = 0;

    public QuestionManager(ArrayList<QuestionData> data) {
        this.data = data;
        Collections.shuffle(this.data);
        totalQuestion = data.size();
    }

    public QuestionManager() {
    }

    public int getTotalTrue() {
        return totalTrue;
    }

    public int getTotalFalse() {
        return totalFalse;
    }

    public void setData(ArrayList<QuestionData> data) {
        this.data = data;
        Collections.shuffle(this.data);
        totalQuestion = data.size();
    }

    public ArrayList<String> getMistakes() {
        return mistakes;
    }

    private QuestionData getCurrentQuestion() {
        return this.data.get(currentPosition);
    }

    private String getCurrentQ() {
        return this.data.get(currentPosition).getQuestion();
    }

    public String getQuestion() {
        return getCurrentQuestion().getQuestion();
    }

    public String getVariantA() {
        return getCurrentQuestion().getAnswerA();
    }

    public String getVariantB() {
        return getCurrentQuestion().getAnswerB();
    }

    public String getVariantC() {
        return getCurrentQuestion().getAnswerC();
    }

    public boolean checkAnswer(String answer) {
        boolean isTrue = false;

        if (answer.equalsIgnoreCase(getCurrentQuestion().getAnswer())) {
            isTrue = true;
            totalTrue++;
            System.out.println(totalTrue);
        } else {
            mistakes.add(getCurrentQ());
            isTrue = false;
            totalFalse++;
        }

        if (hasQuestion()) {
            currentPosition++;
        }
        return isTrue;
    }


    public boolean hasQuestion() {

        return currentPosition < totalQuestion;
    }

    public int getCurrentLevel() {
        return currentPosition + 1;
    }


    public int getTotal() {
        return data.size();
    }

    private boolean canGetNext() {
        return currentPosition < totalQuestion - 1;
    }

}
