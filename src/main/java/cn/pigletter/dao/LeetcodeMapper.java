package cn.pigletter.dao;


import cn.pigletter.model.Leetcode;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface LeetcodeMapper {

    List<Leetcode> selectLeetcodes();
    void insertLeetcode(Leetcode leetcode);
    void deleteLeetcodeByID(int id);

    Leetcode selectLeetcodeByID(int id);

    void updateLeetcode(Leetcode leetcode);

    List<Leetcode> selectLeetcodesPage(@Param("id") int id, @Param("size") int size);

    int selectLeetcodesPageNum();
}
