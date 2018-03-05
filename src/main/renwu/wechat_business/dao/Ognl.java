package wechat_business.dao;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;

 
public class Ognl {

	/** 
	* @Title: isEmpty 
	* @Description: 用于Mybatis  Ognl扩展for Map,Collection,String,Array isNotEmpty
	* @param @param o
	* @param @return
	* @param @throws IllegalArgumentException    设定文件 
	* @return boolean    返回类型 
	* @throws 
	*/ 
	public static boolean isEmpty(Object o) throws IllegalArgumentException {
		if (o == null)
			return true;
		if (o instanceof String) {
			if (((String) o).length() == 0) {
				return true;
			}
		} else if (o instanceof Collection) {
			if (((Collection) o).isEmpty()) {
				return true;
			}
		} else if (o.getClass().isArray()) {
			if (Array.getLength(o) == 0) {
				return true;
			}
		} else if (o instanceof Map) {
			if (((Map) o).isEmpty()) {
				return true;
			}
		} else {
			return false;
		}

		return false;
	}

	 
	/** 
	
	* @Title: isNotEmpty 
	
	* @Description: for Map,Collection,String,Array isNotEmpty
	
	* @param @param o
	* @param @return    设定文件 
	
	* @return boolean    返回类型 
	
	* @throws 
	
	*/ 
	public static boolean isNotEmpty(Object o) {
		return !isEmpty(o);
	}
}
