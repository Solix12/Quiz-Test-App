package com.salikh.nurtest;

import android.os.Parcel;
import android.os.Parcelable;

public class QuestionData implements Parcelable {

    public static final Creator<QuestionData> CREATOR = new Creator<QuestionData>() {
        @Override
        public QuestionData createFromParcel(Parcel in) {
            return new QuestionData(in);
        }

        @Override
        public QuestionData[] newArray(int size) {
            return new QuestionData[size];
        }
    };
    private String question, answer;
    private String answerA;
    private String answerB;
    private String answerC;

    public QuestionData() {

    }


    public QuestionData(String question, String answer, String answerA, String answerB, String answerC) {
        this.question = question;
        this.answer = answer;
        this.answerA = answerA;
        this.answerB = answerB;
        this.answerC = answerC;
    }

    protected QuestionData(Parcel in) {
        question = in.readString();
        answer = in.readString();
        answerA = in.readString();
        answerB = in.readString();
        answerC = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(question);
        dest.writeString(answer);
        dest.writeString(answerA);
        dest.writeString(answerB);
        dest.writeString(answerC);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getAnswerA() {
        return answerA;
    }

    public void setAnswerA(String answerA) {
        this.answerA = answerA;
    }

    public String getAnswerB() {
        return answerB;
    }

    public void setAnswerB(String answerB) {
        this.answerB = answerB;
    }

    public String getAnswerC() {
        return answerC;
    }

    public void setAnswerC(String answerC) {
        this.answerC = answerC;
    }
}
