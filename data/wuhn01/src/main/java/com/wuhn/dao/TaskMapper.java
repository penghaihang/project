package com.wuhn.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wuhn.module.Task;
/**
 * 
 * @author Naomi Peng
 * @version 1.0
 * 任务数据库操作接口
 */
public interface TaskMapper {
  int deleteByPrimaryKey(String taskid);

  int insert(Task record);

  int insertSelective(Task record);

  Task selectByPrimaryKey(String taskid);

  int updateByPrimaryKeySelective(Task record);

  int updateByPrimaryKey(Task record);
  
  List<Task> selectAll();
  
  int selectTaskCount();
  
  List<Task> selectTaskbyPages(@Param("limit")int limit,
          @Param("offset")int offset,
          @Param("taskTitle")String taskTitle
          );
  
  int batchDeleteByPrimaryKey(List<String> taskids);
  
  List<Task> selectByTask(Task record);

  List<Task> getAllTaskUser(String userid);
}
