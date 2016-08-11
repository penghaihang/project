package com.wuhn.controller.admin.task;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wuhn.module.Task;
import com.wuhn.module.User;
import com.wuhn.service.TaskService;
import com.wuhn.utils.ConstantEnum;

@Controller
@RequestMapping("/task")
public class TaskController {

  @Resource
  private TaskService taskService; 
  
  private static final Logger log = LoggerFactory.getLogger(TaskController.class);
  /**
   * @功能 用户新增
   * **/
  @RequestMapping(value="/addTask",method=RequestMethod.POST,produces = "text/html;charset=UTF-8")
  @ResponseBody
  public String addTask(Task task){
      log.info("*****开始执行任务新增操作*****");
      System.out.println("*****用户新增*****");
      String resultJson = ConstantEnum.FAILURE_SUBMITDATA;
      try {
          if (taskService.saveTask(task)) { 
            log.info("*****任务新增操作成功*****");
              System.out.println("*****用户新增成功*****");
              resultJson = ConstantEnum.SUCCESS_SUBMITDATA;
          } 
      } catch (Exception e) {
          e.printStackTrace();
      }
      log.info("*****执行任务新增操作结束*****");
      return resultJson;
      
  }
  
  
  /**
   * @功能 用户修改
   * **/
  @RequestMapping(value="/editTask",method=RequestMethod.POST,produces = "text/html;charset=UTF-8")
  @ResponseBody
  public String editTask(Task task){
      System.out.println("*****任务修改*****");
      String resultJson = ConstantEnum.FAILURE_SUBMITDATA;
      try {
          if (taskService.updateTask(task)) { 
              System.out.println("*****用户修改成功*****");
              resultJson = ConstantEnum.SUCCESS_SUBMITDATA;
          }
      } catch (Exception e) {
          e.printStackTrace();
      }
      return resultJson;
  }
  
  
  /**
   * @功能 用户删除
   * **/
  @RequestMapping(value="/deleteTask",method=RequestMethod.POST)
  @ResponseBody
  public String deleteTask(@RequestBody List<Task> tasks){
      System.out.println("*****用户删除*****");
      String resultJson = ConstantEnum.SUCCESS_SUBMITDATA;
      try {
          //System.out.println("用户主键："+users);
          List<String> taskids = new ArrayList<String>();
          for (Task task : tasks) {
            taskids.add(task.getTaskid());
          }
          if (!taskService.batchDeleteTask(taskids)) {
              resultJson = ConstantEnum.FAILURE_SUBMITDATA;   
          }
      } catch (Exception e) {
          e.printStackTrace();
      }
      System.out.println(resultJson);
      return resultJson;
  }
  
  
  
  /**
   * @功能 用户详细
   * **/
  @RequestMapping(value="/taskInfo",method=RequestMethod.GET)
  public String getUserInfo(@RequestParam("taskid") String taskid,@RequestParam("type") String type,Model model){
      Task task  = new Task();
      String result = "admin/common/task/taskInfo";
      try {
          //System.out.println("用户主键："+userid);
        task = taskService.getTask(taskid);
          model.addAttribute(task);
          if (type!=null&&type.equals("edit")) {
              result = "admin/common/task/taskEdit";
          }
      } catch (Exception e) {
          e.printStackTrace();
      }
      //System.out.println(result);
      return result;
  }
  
  /**
   * @功能 用户列表
   * **/
  @RequestMapping(value="/taskList",method=RequestMethod.GET)
  @ResponseBody
  public JSONObject getUserList(@RequestParam("limit") int limit,
                                @RequestParam("offset") int offset,
                                @RequestParam("taskTitle") String taskTitle,
                                @RequestParam("type") String type){
      /*
      try {
          System.out.println("解码："+URLDecoder.decode(nickname, "utf-8"));
          
      } catch (UnsupportedEncodingException e) {
          e.printStackTrace();
      }*/
      //System.out.println("limit:"+limit+" offset:"+offset+" nickname:"+nickname+" email:"+email);
      JSONObject jsonResult = new JSONObject();
      int total = 0;
      List<Task> tasks = new ArrayList<Task>();
      
      if(type!=null&&type.equals("Condition")){
        tasks = taskService.getTaskbyPages(limit, offset,
            taskTitle.equals("")?null:taskTitle);
          total = tasks.size();
      }else{
          total = taskService.getTaskCount();
          if(total>0){
            tasks = taskService.getTaskbyPages(limit, offset, 
                taskTitle.equals("")?null:taskTitle);
          }           
      }
      
      jsonResult.put("total", total); 
      jsonResult.put("rows", JSONArray.fromObject(tasks));
      //System.out.println(jsonResult.toString());
      return jsonResult;
  }
  
  
  /**
   * @功能 获取当前登录者所有的任务信息
   * **/
  @RequestMapping(value="/currentTask",method=RequestMethod.GET)
  @ResponseBody
  public JSONObject getCurrentTask(HttpSession httpSession){
      User user = new User();
      user = (User) httpSession.getAttribute("currentUser");
      List<Task> t = taskService.getAllTaskUser(user.getUserid());
      int total = 0;
      total = t.size();
//      t.get(0).setUser(user);
     JSONObject jsonResult = new JSONObject();
      jsonResult.put("total", total);
      jsonResult.put("rows", JSONArray.fromObject(t));
      //System.out.println("昵称:"+user.getNickname());
      //System.out.println("电子邮件:"+user.getEmail());
      return  jsonResult;
  }
  
  
  
  /**
   * @功能 行编辑
   * **/
  @RequestMapping(value="/rowEdit",method=RequestMethod.POST)
  @ResponseBody
  public String rowEdit(@RequestBody Task task){
      //System.out.println(user.getUserid());
      String resultJson = ConstantEnum.FAILURE_SUBMITDATA;
      try {
          if (taskService.updateTask(task)) { 
              System.out.println("*****用户修改成功*****");
              resultJson = ConstantEnum.SUCCESS_SUBMITDATA;
          }
      } catch (Exception e) {
          e.printStackTrace();
      }
      return resultJson;
  }

}
