package com.isoft.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.isoft.entity.Basic_information;
import com.isoft.entity.MyTask;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface BasicMapper extends BaseMapper<Basic_information> {
    @Select("select * from basic_information where id = #{id}")
    void findById(Integer id);

    @Update("UPDATE basic_information SET name = #{name}, card_id = #{cardId}, gender = #{gender}, " +
            "birthday = #{birthday}, education = #{education}, birthplace = #{birthplace}, " +
            "nation = #{nation}, politics = #{politics}, marriage = #{marriage} " +
            "WHERE id = #{id}")
    boolean updateBasic(Basic_information basicInformation);
}
