package com.ipty.www.util;

import java.util.List;

/**
 * 分页插件
 * @author 89520
 *
 */
public class PageUtil {
	public static List helpPage(List total,int pageNum, int pageSize) {

		int size = total.size();
		 
		int fromIndex = pageSize * (pageNum - 1);
		
		int toIndex = fromIndex + pageSize;
		
		if(toIndex >= size) {
			
			toIndex = size;
		
		}
		
		return total.subList(fromIndex, toIndex);
	}
}
