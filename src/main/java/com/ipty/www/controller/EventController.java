package com.ipty.www.controller;
import java.util.Deque;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.ipty.www.pojo.Event;
import com.ipty.www.service.EventService;

import com.ipty.www.entity.PageResult;
import com.ipty.www.entity.Result;
/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/event")
public class EventController {
	@Autowired
	private EventService eventService;
	java.util.Stack<E>
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<Event> findAll(){			
		return eventService.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult  findPage(int page,int rows){			
		return eventService.findPage(page, rows);
	}
	
	/**
	 * 增加
	 * @param event
	 * @return
	 */
	@RequestMapping("/add")
	public Result add(@RequestBody Event event){
		try {
			eventService.add(event);
			return new Result(true, "增加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "增加失败");
		}
	}
	
	/**
	 * 修改
	 * @param event
	 * @return
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody Event event){
		try {
			eventService.update(event);
			return new Result(true, "修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "修改失败");
		}
	}	
	
	/**
	 * 获取实体
	 * @param id
	 * @return
	 */
	@RequestMapping("/findOne")
	public Event findOne(String id){
		return eventService.findOne(id);		
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public Result delete(String [] ids){
		try {
			eventService.delete(ids);
			return new Result(true, "删除成功"); 
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "删除失败");
		}
	}
	
		/**
	 * 查询+分页
	 * @param brand
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/search")
	public PageResult search(@RequestBody Event event, int page, int rows  ){
		return eventService.findPage(event, page, rows);		
	}
	
}
