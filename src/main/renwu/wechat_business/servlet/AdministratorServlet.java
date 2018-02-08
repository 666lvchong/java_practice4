package wechat_business.servlet;/********************************************************************
 /**
 * @Project: Team4
 * @Package wechat_business.servlet
 * @author dengchao
 * @date 2018/1/30 17:50
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import wechat_business.entity.TaobaoAccount;
import wechat_business.service.TaobaoAccountService;
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
 * @ClassName AdministratorServlet
 * @Description servlet实现类
 * @date 2018/1/30
 */
public class AdministratorServlet extends HttpServlet {

    /**
     * @Title: doGet
     * @Description: 继承父类
     * @author dengchao
     * @date 2018/1/30
     */
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        //设置字符集编码格式
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        //定义响应输出
        PrintWriter out = response.getWriter();
        //淘宝账户方法实例化
        TaobaoAccountService taobaoAccountService = new TaobaoAccountServicelmpl();
        //定义登录页面用户名和密码条件条件
        Map<String, Object> mapTaobao = new HashMap<String, Object>();
        //获取登录页面用户名和密码请求参数值
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //判断登录页面登录账号和密码是否正确
        if (username == null ) {
            out.print("<script language='javaScript'> alert('用户名不能为空');</script>");
            request.getRequestDispatcher("jsp/administrator_login.jsp").forward(request,response);
        } else {
            //将登录页面输入的用户名和密码放入map对象
            mapTaobao.put("username", username);
            mapTaobao.put("password", password);
            try {
                //根据用户名和密码查询
                List<TaobaoAccount> listTaobao = taobaoAccountService.findByCondtion(mapTaobao);
                //保存查询结果
                request.setAttribute("listTaobao", listTaobao);
                System.out.println("大小:" + listTaobao.size());
                //判断查询结果是否大于0，是则验证登录成功
                if (listTaobao.size() > 0) {
                    System.out.println("登录成功");
                    out.print("<script language='javaScript'> alert('登录成功');</script>");
                    //转发页面
                    request.getRequestDispatcher("user_info.jsp").forward(request,response);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @Title: doPost
     * @Description: 继承父类
     * @author dengchao
     * @date 2018/1/30
     */
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        doGet(request,response);
    }
}