package wechat_business.action;/********************************************************************
 /**
 * @Project: Team4
 * @Package wechat_business.action
 * @author hehongju
 * @date 2018/3/8 17:10
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import wechat_business.dao.AddressDao;
import wechat_business.entity.Address;
import wechat_business.service.AddressServiceImpl;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hehongju
 * @ClassName AddressAction
 * @Description 类描述
 * @date 2018/3/8
 */
@Action(value = "addressAction")
@Results({
        @Result(name = "addressInfo",location = "/jsp/address_info.jsp")
})
public class AddressAction extends BaseAction{
    @Autowired
    private AddressServiceImpl addressService;
    private Address address;
    private List<Address> addressList;

    private String addres;
    private String name;
    private String tel;
    private String strId;
    private Long id;
    private Boolean indexAddress=false;
    private Integer index;


    ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
    public AddressAction(){
        System.out.println("地址");
        addressService= (AddressServiceImpl) applicationContext.getBean("addressService");
    }
    /**
     * @Title:
     * @Description: 地址加载
     * @author hehongju
     * @date 2018-03-08
     */
    public String open(){
        Map<String,Object> stringObjectMap=new HashMap<String, Object>();
        stringObjectMap.put("ADDRESS_TYPE",(byte)1);
//        stringObjectMap.put("TAOBAO_ACCOUNT_ID",taobaoAccount.getId());
        stringObjectMap.put("TAOBAO_ACCOUNT_ID",(long)2);
        try {
            //根据条件查询出地址
            addressList=addressService.findByCondtion(stringObjectMap);
            index=addressList.size();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("地址个数" + addressList.size());
        ActionContext.getContext().put("list", addressList);
        ActionContext.getContext().put("indexAddress",indexAddress);
        ActionContext.getContext().put("index",index);

        return "addressInfo";
    }
    /**
     * @Title:
     * @Description: 更新地址
     * @author hehongju
     * @date 2018-03-08
     */
    public void update(){
        id=Long.valueOf(strId);
        try {
            //根据id查询出地址信息
            address=addressService.findById(id);
            address.setAddress(addres);
            address.setLinkmanContacts(name);
            address.setTelephone(tel);
            //更新查出地址的信息
            addressService.update(address);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        open();
    }
    /**
     * @Title:
     * @Description: 保存地址
     * @author hehongju
     * @date 2018-03-08
     */
    public void save(){
        address.setAddress(addres);
        address.setLinkmanContacts(name);
        address.setTelephone(tel);
        address.setCreateTime(new Date());
        address.setUpdateTime(new Date());
        address.setAddressType((byte) 1);
        address.setIsDefault(false);
        try {
            //保存新得地址信息
            addressService.save(address);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("保存地址");
        open();
    }
    /**
     * @Title:
     * @Description: 选择地址
     * @author hehongju
     * @date 2018-03-08
     */
    public void select(){
        id=Long.valueOf(strId);
        try {
            //根据id查询地址信息
            address=addressService.findById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        indexAddress=true;
        ActionContext.getContext().put("address",address);
//        ServletActionContext.getRequest().setAttribute("address",address);
        System.out.println("选择");
        open();
    }
    /**
     * @Title:
     * @Description: 删除地址
     * @author hehongju
     * @date 2018-03-08
     */
    public void del(){
        id=Long.valueOf(strId);
        try {
            //根据id删除地址信息
            addressService.deleteById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        open();
    }
    /**
     * @Title:
     * @Description: 设置默认地址
     * @author hehongju
     * @date 2018-03-08
     */
    public void is(){
        id=Long.valueOf(strId);
        Map<String,Object> stringObjectMapIs=new HashMap<String, Object>();
        stringObjectMapIs.put("ADDRESS_TYPE",(byte)1);
//        stringObjectMap.put("TAOBAO_ACCOUN_ID",taobaoAccount.getId());
        stringObjectMapIs.put("TAOBAO_ACCOUNT_ID",(long)2);
        addressService= (AddressServiceImpl) applicationContext.getBean("addressService");
        try {
            addressList=addressService.findByCondtion(stringObjectMapIs);
            for (int i=0;i<addressList.size();i++){
                addressList.get(i).setIsDefault(false);
                addressService.update(addressList.get(i));
            }
            //设置默认地址
            address=addressService.findById(id);
            address.setIsDefault(true);
            addressService.update(address);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        open();
    }

    public String getStrId() {
        return strId;
    }

    public void setStrId(String strId) {
        this.strId = strId;
    }

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}