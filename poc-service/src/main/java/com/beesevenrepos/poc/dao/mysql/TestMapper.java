package com.beesevenrepos.poc.dao.mysql;

import org.apache.ibatis.annotations.Select;

/**
 * @Description:
 * @Auther: chenmingjian
 * @Date: 18-10-23 10:13
 */
public interface TestMapper {

    @Select("select agent_num from t_agent_agentinfo limit 1")
    public String test();


    public String test002();
}
