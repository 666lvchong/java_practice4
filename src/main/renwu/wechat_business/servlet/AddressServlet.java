package wechat_business.servlet;

import wechat_business.entity.Address;
import wechat_business.entity.TaobaoAccount;
import wechat_business.service.AddressServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

/**
 * *****************************************************************
 * /**
 *
 * @author hehongju
 * @version V1.0
 * @Project: Team4
 * @Package ${PACKAGE_NAME}
 * @date 2018/3/4 14:14
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 */
@WebServlet(name = "AddressServlet")
public class AddressServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id=request.getParameter("id");
        String edit=request.getParameter("edit");
        Long ids=0l ;
        if(id!=null) ids=Long.valueOf(id);

        Object buyer=request.getSession().getAttribute("TaobaoAccount");
        TaobaoAccount taobaoAccount;
        taobaoAccount= (TaobaoAccount) buyer;
        Map<String,Object> stringObjectMap=new HashMap<String, Object>();
        stringObjectMap.put("ADDRESS_TYPE",(byte)1);
//        stringObjectMap.put("TAOBAO_ACCOUNT_ID",taobaoAccount.getId());
        stringObjectMap.put("TAOBAO_ACCOUNT_ID",(long)2);

        System.out.println(""+edit);
        Boolean indexAddress=false;
        if (edit==null){
            edit="0";
        }
        if (edit.equals("is")){
            AddressServiceImpl isAddressService=new AddressServiceImpl();
            List<Address> isAddressList=new ArrayList<Address>();
            Address isAddress=new Address();
            try {
                isAddressList=isAddressService.findByCondtion(stringObjectMap);
                for (int i=0;i<isAddressList.size();i++){
                    isAddressList.get(i).setIsDefault(false);
                    save(isAddressList.get(i));
                }
                isAddress=isAddressService.findById(ids);
                isAddress.setIsDefault(true);
                save(isAddress);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        if (edit.equals("del")){
            del(ids);
        }
        Address updateAddress=new Address();
        if (edit.equals("update")){
            AddressServiceImpl updateAddressService=new AddressServiceImpl();
            try {
                updateAddress=updateAddressService.findById(ids);
                indexAddress=true;
                System.out.println("123"+updateAddress.getId());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (edit.equals("save")){
            String address=request.getParameter("addres");
            String name=request.getParameter("name");
            String tel=request.getParameter("tel");
            System.out.println("address"+address);
            Address saveAddress=new Address();
            saveAddress.setAddress(address);
            saveAddress.setTelephone(tel);
            saveAddress.setLinkmanContacts(name);
            saveAddress.setAddressType((byte) 1);
            saveAddress.setIsDefault(false);
            saveAddress.setCreateTime(new Date());
            saveAddress.setUpdateTime(new Date());
//            saveAddress.setTaobaoAccountID(taobaoAccount.getId());
            saveAddress.setTaobaoAccountID((long)2);
            save(saveAddress);
            System.out.println("保存");
        }
        if (edit.equals("saveId")){
            String address=request.getParameter("addres");
            String name=request.getParameter("name");
            String tel=request.getParameter("tel");
            System.out.println(ids+"address"+address);
            Address saveAddress=new Address();
            saveAddress.setAddress(address);
            saveAddress.setTelephone(tel);
            saveAddress.setLinkmanContacts(name);
            saveAddress.setAddressType((byte) 1);
            saveAddress.setIsDefault(false);
            saveAddress.setCreateTime(new Date());
            saveAddress.setUpdateTime(new Date());
//            saveAddress.setTaobaoAccountID(taobaoAccount.getId());
            saveAddress.setTaobaoAccountID((long)2);
            saveAddress.setId(ids);
            save(saveAddress);
        }

        AddressServiceImpl addressServices=new AddressServiceImpl();
        List<Address> addressList=new ArrayList<Address>();
        int index=0;
        try {
            addressList=addressServices.findByCondtion(stringObjectMap);
            index=addressList.size();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("list",addressList);
        request.setAttribute("index",index);
        request.setAttribute("indexAddress",indexAddress);
        request.setAttribute("address",updateAddress);
        request.getRequestDispatcher("jsp/address_info.jsp").forward(request, response);
    }
    /**
     * @Title:
     * @Description: 地址删除
     * @author hehongju
     * @date 2018-03-04
     */
    public void del(long id){
        AddressServiceImpl addressServicesDel=new AddressServiceImpl();
        try {
            addressServicesDel.deleteById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * @Title:
     * @Description: 地址保存
     * @author hehongju
     * @date 2018-03-04
     */
    public void save(Address address){
        AddressServiceImpl addressServicesSave=new AddressServiceImpl();
        try {
            addressServicesSave.save(address);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * @Title:
     * @Description: 地址保存
     * @author hehongju
     * @date 2018-03-04
     */
    public void update(Address address){
        AddressServiceImpl addressServicesSave=new AddressServiceImpl();
        try {
            addressServicesSave.update(address);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
