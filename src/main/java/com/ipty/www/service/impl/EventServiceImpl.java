package com.ipty.www.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ipty.www.mapper.EventMapper;
import com.ipty.www.pojo.Event;
import com.ipty.www.pojo.EventExample;
import com.ipty.www.pojo.EventExample.Criteria;
import com.ipty.www.service.EventService;
import com.ipty.www.util.NoteUtil;
import com.ipty.www.entity.PageResult;
import org.springframework.stereotype.Service;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class EventServiceImpl implements EventService {

	@Autowired
	private EventMapper eventMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<Event> findAll() {
		return eventMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<Event> page=   (Page<Event>) eventMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(Event event) {
		event.setId(NoteUtil.createId());
		eventMapper.insert(event);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(Event event){
		eventMapper.updateByPrimaryKey(event);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public Event findOne(String id){
		return eventMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(String[] ids) {
		for(String id:ids){
			eventMapper.deleteByPrimaryKey(id);
		}		
	}
	
	
		@Override
	public PageResult findPage(Event event, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		EventExample example=new EventExample();
		Criteria criteria = example.createCriteria();
		
		if(event!=null){			
						if(event.getId()!=null && event.getId().length()>0){
				criteria.andIdLike("%"+event.getId()+"%");
			}
			if(event.getCategories()!=null && event.getCategories().length()>0){
				criteria.andCategoriesLike("%"+event.getCategories()+"%");
			}
			if(event.getPrice()!=null && event.getPrice().length()>0){
				criteria.andPriceLike("%"+event.getPrice()+"%");
			}
			if(event.getStart()!=null && event.getStart().length()>0){
				criteria.andStartLike("%"+event.getStart()+"%");
			}
			if(event.getLectures()!=null && event.getLectures().length()>0){
				criteria.andLecturesLike("%"+event.getLectures()+"%");
			}
			if(event.getOrganizer()!=null && event.getOrganizer().length()>0){
				criteria.andOrganizerLike("%"+event.getOrganizer()+"%");
			}
			if(event.getAddress()!=null && event.getAddress().length()>0){
				criteria.andAddressLike("%"+event.getAddress()+"%");
			}
		}
		
		Page<Event> page= (Page<Event>)eventMapper.selectByExample(example);		
		return new PageResult(page.getTotal(), page.getResult());
	}
	
}
