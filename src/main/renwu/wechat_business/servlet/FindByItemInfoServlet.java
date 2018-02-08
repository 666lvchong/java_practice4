package wechat_business.servlet;
/**
 * @Project: Team4
 * @Package wechat_business.servlet
 * @author lvchong
 * @date 2018/1/30 10:54
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import wechat_business.entity.ItemInfo;
import wechat_business.entity.ItemRelation;
import wechat_business.service.ItemInfoServiceImpl;
import wechat_business.service.ItemRelationService;
import wechat_business.service.ItemRelationServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lvchong
 * @ClassName FindByItemInfo
 * @Description 查询全部商品信息
 * @date 2018/1/30
 */
public class FindByItemInfoServlet extends HttpServlet {
    /**
     * @Title: doGet
     * @Description: 继承父类方法
     * @author lvchong
     * @params @param null
     * @date 2018-01-27
     * @throw YnCorpSysException
     */
    public void doGet(HttpServletRequest httpServletRequest , HttpServletResponse httpServletResponse)  throws ServletException, IOException {
        doPost(httpServletRequest,httpServletResponse);
    }
    /**
     * @Title: doPost
     * @Description: 继承父类方法
     * @author lvchong
     * @params @param null
     * @date 2018-01-27
     * @throw YnCorpSysException
     */
    public void doPost(HttpServletRequest httpServletRequest , HttpServletResponse httpServletResponse) throws ServletException, IOException{
        //创建一个商品关系的service
        ItemRelationServiceImpl itemRelationService = new ItemRelationServiceImpl();
        ItemInfoServiceImpl itemInfoService = new ItemInfoServiceImpl();
        //创建一个条件的map key值条件字段名  value值 条件的值
        Map<String,Object> map = new HashMap<String, Object>();
        List<ItemInfo> itemInfoList =null;
        //判断传过来的条件是否存在 如果存在则添加到map中
        if (httpServletRequest.getParameter("name")!=null){
            map.put("name",httpServletRequest.getParameter("name"));
        }
        try {
            itemInfoList = itemInfoService.findByCondtion(map);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            itemInfoService.release();
        }
        try {
            //通过service的分页条件查询 获得商品关系表中的数据
            List<ItemRelation> list= new ArrayList<ItemRelation>();
            for (ItemInfo item :itemInfoList){
                map = new HashMap<String, Object>();
                map.put("ITEM_INFO_ID",item.getId());
                list.addAll(itemRelationService.findByCondtion(map));
            }
            //将查询的数据添加到request中
            httpServletRequest.setAttribute("list", list);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            itemRelationService.release();
        }
        //转发到主页面
        httpServletRequest.getRequestDispatcher("jsp/home_page.jsp").forward(httpServletRequest, httpServletResponse);
    }
}
