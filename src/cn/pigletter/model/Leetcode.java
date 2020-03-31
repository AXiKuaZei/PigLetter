package cn.pigletter.model;

public class Leetcode {
    int leetcode_id;
    String leetcode_title;
    String leetcode_question;
    String leetcode_answer;

    public Leetcode(){};

    public Leetcode(int leetcode_id, String leetcode_title, String leetcode_question, String leetcode_answer) {
        this.leetcode_id = leetcode_id;
        this.leetcode_title = leetcode_title;
        this.leetcode_question = leetcode_question;
        this.leetcode_answer = leetcode_answer;
    }



    @Override
    public String toString() {
        return "Leetcode{" +
                "leetcode_id=" + leetcode_id +
                ", leetcode_title='" + leetcode_title + '\'' +
                ", leetcode_question='" + leetcode_question + '\'' +
                ", leetcode_answer='" + leetcode_answer + '\'' +
                '}';
    }

    public int getLeetcode_id() {
        return leetcode_id;
    }

    public void setLeetcode_id(int leetcode_id) {
        this.leetcode_id = leetcode_id;
    }

    public String getLeetcode_title() {
        return leetcode_title;
    }

    public void setLeetcode_title(String leetcode_title) {
        this.leetcode_title = leetcode_title;
    }

    public String getLeetcode_question() {
        return leetcode_question;
    }

    public void setLeetcode_question(String leetcode_question) {
        this.leetcode_question = leetcode_question;
    }

    public String getLeetcode_answer() {
        return leetcode_answer;
    }

    public void setLeetcode_answer(String leetcode_answer) {
        this.leetcode_answer = leetcode_answer;
    }
}
