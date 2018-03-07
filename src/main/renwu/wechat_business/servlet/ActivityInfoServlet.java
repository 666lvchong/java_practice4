package wechat_business.servlet;/********************************************************************
 /**
 * @Project: Team4
 * @Package wechat_business.servlet
 * @author dengchao
 * @date 2018/2/14 21:24
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import wechat_business.dao.ActivityRelationDao;
import wechat_business.entity.ActivityInfo;
import wechat_business.entity.ActivityRelation;
import wechat_business.service.ActivityInfoServiceImpl;
import wechat_business.service.ActivityRelationServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author dengchao
 * @ClassName ActivityInfoServlet
 * @Description 活动信息Servlet
 * @date 2018/2/14
 */
public class ActivityInfoServlet extends HttpServlet {
    //定义ActivityInfoDao对象
    ActivityRelationDao activityRelationDao=new ActivityRelationDao();

    /**
     * @Title: doGet
     * @Description: 继承父类
     * @author dengchao
     * @date 2018/2/14
     */

    public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        //设置字符集编码格式
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        //活动信息方法实例化
        ActivityInfoServiceImpl activityInfoService=new ActivityInfoServiceImpl();
        ActivityRelationServiceImpl activityRelationService=new ActivityRelationServiceImpl();
        //定义搜索条件
        Map<String,Object> map=new HashMap<String, Object>();
        Map<String,Object> mapActivityRelation=new HashMap<String, Object>();
        //获取搜索条件
        String keyword=request.getParameter("keyword");
        if (keyword != null && keyword != "") {//若有搜索条件则继续
            //将条件存入map
            map.put("ACTIVITY_NAME", keyword);
            //按条件查询
            try {
                List<ActivityInfo> listActivityInfo = activityInfoService.findByCondtionForPage(map, 0, 10);
                for (ActivityInfo activityInfo : listActivityInfo) {
                    mapActivityRelation.put("ACTIVITY_INFO_ID", activityInfo.getId());
                }
                List<ActivityRelation> listActivityRelation = activityRelationService.findByCondtionForPage(mapActivityRelation, 0, 10);
                //保存查询结果
//            request.setAttribute("listActivityInfo",listActivityInfo);
                request.setAttribute("listActivityRelation", listActivityRelation);
                //转发页面
                request.getRequestDispatcher("jsp/activity_info.jsp").forward(request, response);
            } catch (SQLException e) {
                try {
                    activityRelationDao.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            } finally {
                activityRelationDao.release();
            }
        }else {//若无搜索条件
            try {
                //查询
                List<ActivityRelation> listActivityRelation = activityRelationService.findByCondtionForPage(mapActivityRelation,0,10);
                //保存查询结果
                request.setAttribute("listActivityRelation",listActivityRelation);
                //转发页面
                request.getRequestDispatcher("jsp/activity_info.jsp").forward(request,response);
            } catch (SQLException e) {
                try {
                    activityRelationDao.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }finally {
                activityRelationDao.release();
            }
        }
    }

    /**
     * @Title: doPost
     * @Description: 继承父类
     * @author dengchao
     * @date 2018/2/14
     */

    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        doGet(request,response);
    }
}