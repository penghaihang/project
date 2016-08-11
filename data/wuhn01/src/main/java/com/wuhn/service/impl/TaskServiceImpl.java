package com.wuhn.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wuhn.dao.TaskMapper;
import com.wuhn.module.Task;
import com.wuhn.service.TaskService;
@Service("taskService")
public class TaskServiceImpl implements TaskService {
  /*注入DAO*/
  @Resource
  private TaskMapper taskDao;
  /**
   * 新增一条任务
   * @param task
   */
  @Override
  public boolean saveTask(Task task) {
    if(taskDao.insert(task)==1){
     return true; 
    }
    return false;
  }
  /**
   * 根据taskid删除一条任务
   * @param taskid
   * @return boolean
   */
  @Override
  public boolean deleteTask(String taskid) {
    if(taskDao.deleteByPrimaryKey(taskid)==1){
      return true;
    }
    return false;
  }
  /**
   * 更新一条任务
   * @param task
   * @return boolean
   */
  @Override
  public boolean updateTask(Task task) {
   if(taskDao.updateByPrimaryKeySelective(task)==1){
     return true;
   }
    return false;
  }
  /**
   * 根据taskid获取一条任务
   * @param taskid
   * @return Task
   */
  @Override
  public Task getTask(String Taskid) {
   
    return taskDao.selectByPrimaryKey(Taskid);
  }
  /**
   * 获取所有的任务
   * @return 任务集合
   */
  @Override
  public List<Task> getAllTask() {
    return taskDao.selectAll();
  }
  /**
   * 根据taskid获取任务包括任务处理人信息
   * @param taskid
   * @return 
   */
  @Override
  public List<Task> getAllTaskUser(String userid) {
   
    return taskDao.getAllTaskUser(userid);
  }
  /**
   * 
   * @return 获取任务数
   */
  @Override
  public int getTaskCount() {
    return taskDao.selectTaskCount();
  }
  /**
   * 后台分页获取任务
   * @param limit 页面大小
   * @param offset 页码
   * @param taskTitle 任务标题
   */
  @Override
  public List<Task> getTaskbyPages(int limit, int offset, String taskTitle) {
    return taskDao.selectTaskbyPages(limit, offset, taskTitle);
  }
  /**
   * 批量删除任务
   * @param taskids 任务ids
   */
  @Override
  public boolean batchDeleteTask(List<String> taskids) {
    if(taskDao.batchDeleteByPrimaryKey(taskids)>=1){
      return true;
    }
    return false;
  }
  /**
   * 获取任务
   * @param task 任务
   */
  @Override
  public List<Task> getByTask(Task task) {
   
    return taskDao.selectByTask(task);
  }

}
