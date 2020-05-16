package cn.pigletter.service;

import cn.pigletter.model.Leetcode;

import java.util.List;

public interface LeetcodeService {
    List<Leetcode> selectLeetcodes();

    void insertLeetcode(Leetcode leetcode);
    void updateLeetcode(Leetcode leetcode);

    void deleteLeetcodeByID(int id);
    Leetcode selectLeetcodeByID(int id);

    List<Leetcode> selectLeetcodesPage(int i, int i1);

    int selectLeetcodesPageNum(int i);
}
