package cn.pigletter.dao;


import cn.pigletter.model.Leetcode;

import java.util.List;

public interface LeetcodeMapper {

    List<Leetcode> selectLeetcodes();
    void insertLeetcode(Leetcode leetcode);
    void deleteLeetcodeByID(int id);

    Leetcode selectLeetcodeByID(int id);

    void updateLeetcode(Leetcode leetcode);
}
