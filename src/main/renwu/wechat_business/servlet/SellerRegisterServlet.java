package wechat_business.servlet;

import org.apache.taglibs.standard.lang.jstl.NullLiteral;
import wechat_business.dao.PeopleInfoDao;
import wechat_business.dao.SellerInfoDao;
import wechat_business.entity.PeopleInfo;
import wechat_business.entity.SellerInfo;
import wechat_business.service.PeopleInfoServiceImpl;
import wechat_business.service.SellerInfoService;
import wechat_business.service.SellerInfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@WebServlet(name = "SellerRegisterServlet")
/********************************************************************
 /**
 * @Project: Team4
 * @Package wechat_business.servlet
 * @author wangjunjie
 * @date 2018/1/31 8:520
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

public class SellerRegisterServlet extends HttpServlet {
    public SellerRegisterServlet() {
        super();
    }



    /**
     * @Title: doGet
     * @Description: 继承父类方法
     * @author lvchong
     * @params @param null
     * @date 2018-01-27
     * @throw YnCorpSysException
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        doGet(request, response);
        request.getRequestDispatcher("jsp/seller_center.jsp").forward(request, response);

    }

    /**
     * @Title: doPost
     * @Description: 继承父类方法
     * @author wangjunjie
     * @params @param null
     * @date 2018-01-31
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置字符集编码格式
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        //定义响应输出
        PrintWriter out = response.getWriter();
        //方法实例化
        SellerInfoDao sellerInfoDao=new SellerInfoDao();
        PeopleInfoDao peopleInfoDao=new PeopleInfoDao();
        //定义卖家注册页面商铺名字和人员信息条件
        Map<String, Object> mapSeller = new HashMap<String, Object>();
        Map<String, Object> mapPeople = new HashMap<String, Object>();
        //获取卖家注册页面商铺名字和人员信息请求参数
        String shopName = request.getParameter("SHOP_NAME");
        String name = request.getParameter("NAME");
        String idNumber = request.getParameter("ID_NUMBER");
        String shopType =request.getParameter("SHOP_TYPE");
        String commercialRegistrationNum =request.getParameter("COMMERCIAL_REGISTRATION_NUM");
        String address =request.getParameter("ADDRESS");
        String email =request.getParameter("EMAIL");
        String affiliatedCompany =request.getParameter("AFFILIATED_COMPANY");
        String deposit =request.getParameter("DEPOSIT");
        String registrationTime =request.getParameter("REGISTRATION_TIME");


        //判断卖家输入信息是否为空
        if (shopName == null || name == null || idNumber == null|| address==null||commercialRegistrationNum==null||deposit==null||registrationTime==null) {
            out.print("<script language='javaScript'> alert('输入信息不正确，请重新输入');</script>");
            request.getRequestDispatcher("jsp/seller_center.jsp").forward(request, response);
        } else {
            //将参数放入map对象
            mapSeller.put("SHOP_NAME", shopName);
            mapPeople.put("NAME", name);
            mapPeople.put("ID_NUMBER", idNumber);
            mapSeller.put("COMMERCIAL_REGISTRATION_NUM", commercialRegistrationNum);
            mapSeller.put("ADDRESS", address);
            try {
                //根据用户名和密码查询
                List<SellerInfo> listSeller = sellerInfoDao.findByCondtion(mapSeller);
                List<PeopleInfo> listPeople = peopleInfoDao.findByCondtion(mapPeople);
                System.out.println(listSeller);
                System.out.println(listPeople);
                //保存查询结果
                request.setAttribute("listSeller", listSeller);
                request.setAttribute("listPeople", listPeople);
                //判断身份信息查询结果是否存在，是返回错误信息
                if (listSeller.size()>0){
                    System.out.println("注册失败，商铺名已存在，请重新输入");
                    out.print("<script language='javaScript'> alert('注册失败，商铺名已存在，请重新输入\');</script>");
                    //转发页面
                    request.getRequestDispatcher("jsp/seller_center.jsp").forward(request, response);
                } else if (listPeople.size()>0) {
                    String taobaoAccountId= null;
                    SellerInfo sellerInfo=new SellerInfo();
                    sellerInfo.setShopName(shopName);
                    sellerInfo.setTaobaoAccountId(listPeople.get(0).getId());
                    if (shopType.equals("0"))
                    {
                        sellerInfo.setShopType("企业商铺");
                    }else if(shopType.equals("1")){
                        sellerInfo.setShopType("个人商铺");
                    }
                    mapSeller.put("SHOP_NAME", shopName);
                    mapSeller.put("TAOBAO_ACCOUNT_ID", taobaoAccountId);
                    mapSeller.put("SHOP_TYPE", shopType);
                    mapSeller.put("COMMERCIAL_REGISTRATION_NUM", commercialRegistrationNum);
                    mapSeller.put("ADDRESS", address);
                    if (email!=null){
                        mapSeller.put("EMAIL", email);
                    } else if (affiliatedCompany!=null) {
                        mapSeller.put("AFFILIATED_COMPANY", email);
                    }
                    sellerInfoDao.saveOrUpdate(sellerInfo);
                    System.out.println("注册成功");
                    out.print("<script language='javaScript'> alert('注册成功');</script>");
                    //转发页面
                    request.getRequestDispatcher("jsp/publish_commodity.jsp").forward(request, response);
                }else{
                    System.out.println("注册失败,请重新输入");
                    out.print("<script language='javaScript'> alert('注册失败,请重新输入');</script>");
                    request.getRequestDispatcher("jsp/seller_center.jsp").forward(request, response);
                }
            } catch (SQLException e) {

                e.printStackTrace();
                try {
                    sellerInfoDao.rollback();
                    peopleInfoDao.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }finally {
                sellerInfoDao.release();
                peopleInfoDao.release();
            }
        }
    }
}



