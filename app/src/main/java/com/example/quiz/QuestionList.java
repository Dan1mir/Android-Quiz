package com.example.quiz;

public class QuestionList {
    private final String option1,option2,option3,option4,question,answer;
    private String selectedAnswer;

    public QuestionList(String question,String option1, String option2, String option3, String option4, String answer, String selectedAnswer) {
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.question = question;
        this.answer = answer;
        this.selectedAnswer = selectedAnswer;
    }

    public String getOption1() {
        return option1;
    }

    public String getOption2() {
        return option2;
    }

    public String getOption3() {
        return option3;
    }

    public String getOption4() {
        return option4;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public String getSelectedAnswer() {
        return selectedAnswer;
    }

    public void setSelectedAnswer(String selectedAnswer) {
        this.selectedAnswer = selectedAnswer;
    }
}
