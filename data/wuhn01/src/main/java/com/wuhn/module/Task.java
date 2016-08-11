package com.wuhn.module;

import java.util.Date;
/**
 * 
 * @author Naomi Peng
 * @version 1.0
 * 任务类
 */
public class Task {

  private String taskid;
  private String taskTitle;
  
  private String taskInfo;
  
  private String taskStauts;
  
  private String userid;
  
  private Date creatTime;
  
  private Date completeTime;
  
  private User user;
 
  public Task() {
    super();
  }

  public Task(String taskid, String taskTitle, String taskInfo, String taskStauts, String userid,
      Date creatTime, Date completeTime) {
    super();
    this.taskid = taskid;
    this.taskTitle = taskTitle;
    this.taskInfo = taskInfo;
    this.taskStauts = taskStauts;
    this.userid = userid;
    this.creatTime = creatTime;
    this.completeTime = completeTime;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public String getTaskTitle() {
    return taskTitle;
  }

  public void setTaskTitle(String taskTitle) {
    this.taskTitle = taskTitle;
  }

  public String getTaskid() {
    return taskid;
  }

  public void setTaskid(String taskid) {
    this.taskid = taskid;
  }

  public String getTaskInfo() {
    return taskInfo;
  }

  public void setTaskInfo(String taskInfo) {
    this.taskInfo = taskInfo;
  }

  public String getTaskStauts() {
    return taskStauts;
  }

  public void setTaskStauts(String taskStauts) {
    this.taskStauts = taskStauts;
  }

  public String getUserid() {
    return userid;
  }

  public void setUserid(String userid) {
    this.userid = userid;
  }

  public Date getCreatTime() {
    return creatTime;
  }

  public void setCreatTime(Date creatTime) {
    this.creatTime = creatTime;
  }

  public Date getCompleteTime() {
    return completeTime;
  }

  public void setCompleteTime(Date completeTime) {
    this.completeTime = completeTime;
  }
  
  
  
}
