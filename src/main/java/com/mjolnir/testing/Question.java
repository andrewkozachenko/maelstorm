package com.mjolnir.testing;

public class Question {
    String question;
    String answer;
    String variant1;
    String variant2;
    String variant3;
    int mark;

    public Question() {
    }

    public Question(String question, String answer, int mark) {
        this.question = question;
        this.answer = answer;
        this.mark = mark;
    }

    public Question(String question, String answer, String variant1, String variant2, String variant3, int mark) {
        this.question = question;
        this.answer = answer;
        this.variant1 = variant1;
        this.variant2 = variant2;
        this.variant3 = variant3;
        this.mark = mark;
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

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getVariant1() {
        return variant1;
    }

    public void setVariant1(String variant1) {
        this.variant1 = variant1;
    }

    public String getVariant2() {
        return variant2;
    }

    public void setVariant2(String variant2) {
        this.variant2 = variant2;
    }

    public String getVariant3() {
        return variant3;
    }

    public void setVariant3(String variant3) {
        this.variant3 = variant3;
    }
}
