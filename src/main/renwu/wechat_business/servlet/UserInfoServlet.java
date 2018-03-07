package wechat_business.servlet;/********************************************************************
 /**
 * @Project: Team4
 * @Package wechat_business.servlet
 * @author dengchao
 * @date 2018/1/31 16:49
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import wechat_business.dao.TaobaoAccountDao;
import wechat_business.entity.TaobaoAccount;
import wechat_business.service.TaobaoAccountServicelmpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author dengchao
 * @ClassName UserInfoServlet
 * @Description 管理者页面servlet
 * @date 2018/1/31
 */
public class UserInfoServlet extends HttpServlet {
    int i;
    //定义taobaoAccountDao
    TaobaoAccountDao taobaoAccountDao=new TaobaoAccountDao();

    /**
     * @Title: doGet
     * @Description: 继承父类
     * @author dengchao
     * @date 2018/1/30
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //设置字符集编码格式
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        //定义响应输出
        PrintWriter out = response.getWriter();
        //淘宝账户方法实例化
        TaobaoAccountServicelmpl taobaoAccountService = new TaobaoAccountServicelmpl();
        //定义管理页面搜索条件
        Map<String, Object> mapTaobaoCondition = new HashMap<String, Object>();

        //获取管理页面搜索条件
        String keyword = request.getParameter("keyword");
        //删除
        String method=request.getParameter("method");
        if ("del".equals(method) ){
            del(request,response);
        }
        //管理者页面
        try {
            if (keyword != null && keyword != ""){
                //将获取到的搜索条件放入map对象
                mapTaobaoCondition.put("PERSONNEL_ACCOUNT", keyword);
            }
            //按条件查询
            List<TaobaoAccount> listResult = taobaoAccountService.findByCondtionForPage(mapTaobaoCondition, 0, 20);
            //保存查询结果
            request.setAttribute("listResult", listResult);
            //将数据以json格式返回
//            response.getWriter().write(JSONArray.fromObject(listResult).toString());
            //转发页面
            request.getRequestDispatcher("jsp/user_info.jsp").forward(request, response);
        } catch (SQLException e) {
            try {
                taobaoAccountDao.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            taobaoAccountDao.release();
        }
    }

    /**
     * @Title: doPost
     * @Description: 继承父类
     * @author dengchao
     * @date 2018/1/30
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doGet(request, response);
    }

    /**
     * @Title: del
     * @Description: 删除
     * @author dengchao
     * @date 2018/2/5
     */
    private void del(HttpServletRequest req, HttpServletResponse resp) {
        try {
            System.out.println("执行删除" + (++i));
            TaobaoAccountServicelmpl taobaoAccountService = new TaobaoAccountServicelmpl();
            Long id = new Long(req.getParameter("id"));
            int rows = taobaoAccountService.deleteById(id);
        } catch (Exception e) {

        }
    }
}