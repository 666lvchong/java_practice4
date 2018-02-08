package wechat_business.servlet;

import wechat_business.entity.PeopleInfo;
import wechat_business.entity.TaobaoAccount;
import wechat_business.service.PeopleInfoServiceImpl;
import wechat_business.service.TaobaoAccountServicelmpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

/**
 * @author 黄派
 * @ClassName AddByPeopleInfoServlet
 * @Description 添加人员信息
 * @date 2018/1/30
 */
public class AddByPeopleInfoServlet extends HttpServlet {
    /**
     * @Title: doget
     * @Description: 继承父类方法
     * @author huangpai
     * @date 2018-01-30
     */
    public void doGet(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("进入");
        //人员信息方法实例化
        TaobaoAccountServicelmpl taobaoAccountServicelmpl = new TaobaoAccountServicelmpl();
        //定义时间属性
        byte one = 1;
        byte zero = 0;
        //赋值
        PeopleInfo peopleInfo = new PeopleInfo();
        peopleInfo.setName(req.getParameter("name"));
        System.out.println(req.getParameter("sex"));
        peopleInfo.setSex(req.getParameter("sex").equals("男") ? one : zero);
        peopleInfo.setAge(11);
        peopleInfo.setNation(req.getParameter("nation"));
        String string =req.getParameter("birthdate");
        String[] strings = string.split("-");
        peopleInfo.setBirthdate(new Date( Integer.parseInt(strings[0])-1900,Integer.parseInt(strings[1])-1,Integer.parseInt(strings[2])));
        peopleInfo.setIdNumber(req.getParameter("id_number"));
        peopleInfo.setMobilePhone(req.getParameter("phone"));
        peopleInfo.setNativePlace(req.getParameter("place"));
        peopleInfo.setMailBox(req.getParameter("email"));
        peopleInfo.setPermanentAdress(req.getParameter("address"));
        peopleInfo.setProfession(req.getParameter("job"));
        peopleInfo.setWorkUnit(req.getParameter("work"));
        PeopleInfoServiceImpl peopleInfoService = new PeopleInfoServiceImpl();
        try {

            System.out.println(peopleInfoService.saveOrUpdate(peopleInfo));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            req.getRequestDispatcher("jsp/en_roll.jsp").forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //淘宝账户方法实例化
        TaobaoAccountServicelmpl taobaoAccountServicelmpl1=new TaobaoAccountServicelmpl();
        TaobaoAccount taobaoAccount=new TaobaoAccount();
        //赋值
        taobaoAccount.setPersonnelAccount(req.getParameter("personnelaccount"));
        taobaoAccount.setPassword(req.getParameter("password"));
        taobaoAccount.setGrade(req.getParameter("grade"));
        taobaoAccount.setIsFrozen(req.getParameter("isfrozen").equals("否") ? one : zero );
        taobaoAccount.setIsCancellation(req.getParameter("iscancellation").equals("否")? one : zero);
        taobaoAccount.setIsDelete(req.getParameter("isdelete").equals("否")? one : zero);
        taobaoAccount.setPeopleInfo(req.getParameter("peopleinfo"));
        TaobaoAccountServicelmpl accountServicel =new TaobaoAccountServicelmpl();
        try {
            System.out.println(accountServicel.saveOrUpdate(taobaoAccount));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            req.getRequestDispatcher("jsp/en_roll.jsp").forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    /**
     * @Title: doPost
     * @Description: 继承父类方法
     * @author huangpai
     * @date 2018-01-30
     */

public void doPost (HttpServletRequest req, HttpServletResponse resp){
    doGet(req,resp);
}



}
