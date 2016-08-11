package com.wuhn.service;

import java.util.List;

import com.wuhn.module.Task;

public interface TaskService {

  /**
   * @功能 保存任务
   * @param task 任务
   * **/
  public boolean saveTask(Task task);
  
  /**
   * @功能 删除任务 
   * @param taskid 任务主键
   * **/
  public boolean deleteTask(String taskid);
  
  /**
   * @功能 修改任务
   * @param Task【必须有Taskid】
   * **/
  public boolean updateTask(Task task);
  
  /**
   * @功能 获取任务详细信息
   * @param Taskid 任务主键
   * **/
  public Task getTask(String Taskid);
  
  /**
   * @功能 查询所有任务【不分页】 
   * @param null
   * **/
  public List<Task> getAllTask();
  
  /**
   * @功能 查询任务信息【包括任务处理人】
   * @param Taskid
   * **/
  public List<Task> getAllTaskUser(String taskid);
  
 
  
  /**
   * @功能 获取任务总数
   * @param null
   * **/
  public int getTaskCount();
  
  /**
   * @功能 分页、条件查询
   * @param limit 页面大小
   * @param offset 页码
   * @param nickname 昵称
   * @param email 电子邮箱
   * **/
  public List<Task> getTaskbyPages(int limit,int offset,String taskTitle);
  
  /**
   * @功能 批量删除任务 
   * @param Taskids 任务主键
   * **/
  public boolean batchDeleteTask(List<String> taskids);
  
  /**
   * @功能 根据某一属性查询任务 
   * @param Task Task
   * **/
  public List<Task> getByTask(Task task);


}
