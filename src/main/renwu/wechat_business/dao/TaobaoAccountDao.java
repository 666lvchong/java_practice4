package wechat_business.dao;

import org.springframework.stereotype.Repository;
import wechat_business.entity.TaobaoAccount;

/**
 * Created by Lenovo on 2018/1/22.
 */
    @Repository
    public class TaobaoAccountDao extends Dao<TaobaoAccount> {
//    private String sql = null;
//    private Integer result;
//
//
//    @Override
//    /**
//     * @Title: deleteById
//     * @Description: 根据Id删除数据
//     * @author huangpai
//     * @date 2018-01-19
//     */
//    public Integer deleteById(Long id) throws SQLException {
//        sql = "DELETE FROM TAOBAO_ACCOUNT WHERE ID=?";
//        preparedStatement = getPreparedStatement(sql);
//        preparedStatement.setLong(1, id);
//        result = preparedStatement.executeUpdate();
//        commit();
//        return result;
//    }
//
//    @Override
//    /**
//     * @Title: deleteByIds
//     * @Description: 根据Id删除多个
//     * @author huangpai
//     * @date 2018-01-19
//     */
//    public Integer deleteByIds(Long[] ids) throws SQLException {
//        if (ids.length > 0) {
//            sql = "DELETE FROM TAOBAO_ACCOUNT WHERE ID=?";
//            for (int i = 0; i < ids.length; i++) {
//                sql += "or id = " + ids[i];
//            }
//            preparedStatement = getPreparedStatement(sql);
//            result = preparedStatement.executeUpdate();
//            commit();
//        }
//        return result;
//    }
//
//
//    @Override
//    /**
//     * @Title: saveOrUpdate
//     * @Description: 添加或者删除
//     * @author huangpai
//     * @date 2018-01-19
//     */
//    public Integer saveOrUpdate(TaobaoAccount test) throws SQLException {
//        if (test.getId() != 0){
//            sql ="UPDATE TAOBAO_ACCOUNT " +
//                    "SET " +
//                    " PERSONNEL_ACCOUNT = ?," +
//                    " PASSWORD = ?," +
//                    " IS_FROZEN = ?," +
//                    " IS_CANCELLATION = ?," +
//                    " IS_DELETE = ?," +
//                    " PEOPLE_INFO_ID = ?," +
//                    " ADD_TIME = ? ," +
//                    " UPDATE_TIME =? ," +
//                    " GRADE_ID =?"+
//                    "WHERE ID = ?";
//            preparedStatement = getPreparedStatement(sql);
//            preparedStatement.setString(1, test.getPersonnelAccount());
//            preparedStatement.setString(2, test.getPassword());
//            preparedStatement.setByte(3, test.getIsFrozen());
//            preparedStatement.setByte(4, test.getIsCancellation());
//            preparedStatement.setByte(8, test.getIsDelete());
//            preparedStatement.setLong(6, test.getPeopleInfo().getId());
//            preparedStatement.setDate(7,  test.getAddTime());
//            preparedStatement.setDate(8, test.getUpdateTime());
//            preparedStatement.setLong(9, test.getGrade().getId());
//            preparedStatement.setLong(10, test.getId());
//            result = preparedStatement.executeUpdate();
//            commit();
//        }else{
//            sql = "INSERT INTO TAOBAO_ACCOUNT" +
//                    "(ID,PERSONNEL_ACCOUNT,PASSWORD,IS_FROZEN,IS_CANCELLATION,IS_DELETE,PEOPLE_INFO_ID,ADD_TIME,UPDATE_TIME,GRADE_ID)" +
//                    "VALUES(DEFAULT,?,?,?,?,?,?,?,?,?);";
//            preparedStatement = getPreparedStatement(sql);
//            preparedStatement.setString(1, test.getPersonnelAccount());
//            preparedStatement.setString(2, test.getPassword());
//            preparedStatement.setByte(3, test.getIsFrozen());
//            preparedStatement.setByte(4, test.getIsCancellation());
//            preparedStatement.setByte(8, test.getIsDelete());
//            preparedStatement.setLong(6, test.getPeopleInfo().getId());
//            preparedStatement.setDate(7, test.getAddTime());
//            preparedStatement.setDate(8, test.getUpdateTime());
//            preparedStatement.setLong(9, test.getGrade().getId());
//            result = preparedStatement.executeUpdate();
//            commit();
//        }
//        return result;
//    }
//
//    @Override
//    /**
//     * @Title: findById
//     * @Description: 根据id查找数据
//     * @author huangpai
//     * @date 2018-01-19
//     */
//    public TaobaoAccount findById(Long id) throws SQLException {
//        sql = " SELECT " +
//                " ID, PERSONNEL_ACCOUNT, PASSWORD,  " +
//                " IS_FROZEN, IS_CANCELLATION, IS_DELETE, PEOPLE_INFO_ID, ADD_TIME,UPDATE_TIME,GRADE_ID " +
//                " FROM TAOBAO_ACCOUNT WHERE ID = ?";
//        preparedStatement = getPreparedStatement(sql);
//        preparedStatement.setLong(1,id);
//        resultSet = preparedStatement.executeQuery();
//        PeopleInfoServiceImpl peopleInfoService = new PeopleInfoServiceImpl();
//        GradeService gradeService=new GradeServiceImpl();
//        TaobaoAccount taobaoAccount = null;
//        if (resultSet.next()){
//            taobaoAccount = new TaobaoAccount();
//            taobaoAccount.setId(resultSet.getLong(1));
//            taobaoAccount.setPersonnelAccount(resultSet.getString(2));
//            taobaoAccount.setPassword(resultSet.getString(3));
//            taobaoAccount.setIsFrozen(resultSet.getByte(4));
//            taobaoAccount.setIsCancellation(resultSet.getByte(5));
//            taobaoAccount.setIsDelete(resultSet.getByte(6));
//            taobaoAccount.setPeopleInfo(peopleInfoService.findById(resultSet.getLong(7)));
//            taobaoAccount.setAddTime( resultSet.getDate(8));
//            taobaoAccount.setUpdateTime( resultSet.getDate(9));
//            taobaoAccount.setGrade(gradeService.findById(resultSet.getLong(10)));
//        }
//        return taobaoAccount;
//    }
//
//    @Override
//    /**
//     * @Title: findByCondtion
//     * @Description: 根据表查询数据
//     * @author huangpai
//     * @date 2018-01-19
//     */
//    public List<TaobaoAccount> findByCondtion(Map<String, Object> stringObjectMap) throws SQLException {
//        List<TaobaoAccount> list = new ArrayList<TaobaoAccount>();
//        if(stringObjectMap != null){
//            sql = " SELECT " +
//                    " ID,PERSONNEL_ACCOUNT,PASSWORD," +
//                    " IS_FROZEN,IS_CANCELLATION,IS_DELETE,PEOPLE_INFO_ID,ADD_TIME,UPDATE_TIME,GRADE_ID " +
//                    " FROM TAOBAO_ACCOUNT WHERE 1 = 1 ";
//            Set<Map.Entry<String, Object>> set = stringObjectMap.entrySet();
//            Iterator<Map.Entry<String, Object>> iterator = set.iterator();
//            while (iterator.hasNext()){
//                Map.Entry<String, Object> map = iterator.next();
//                sql += " OR "+map.getKey()+" = '"+map.getValue()+"'";
//            }
//            preparedStatement = getPreparedStatement(sql);
//            resultSet = preparedStatement.executeQuery();
//            PeopleInfoServiceImpl peopleInfoService = new PeopleInfoServiceImpl();
//            GradeService gradeService=new GradeServiceImpl();
//            TaobaoAccount taobaoAccount = new TaobaoAccount();
//            while (resultSet.next()){
//                taobaoAccount.setId(resultSet.getLong(1));
//                taobaoAccount.setPersonnelAccount(resultSet.getString(2));
//                taobaoAccount.setPassword(resultSet.getString(3));
//                taobaoAccount.setIsFrozen(resultSet.getByte(4));
//                taobaoAccount.setIsCancellation(resultSet.getByte(5));
//                taobaoAccount.setIsDelete(resultSet.getByte(6));
//                taobaoAccount.setPeopleInfo(peopleInfoService.findById(resultSet.getLong(7)));
//                taobaoAccount.setAddTime(resultSet.getDate(8));
//                taobaoAccount.setUpdateTime( resultSet.getDate(9));
//                taobaoAccount.setGrade(gradeService.findById(resultSet.getLong(10)));
//                list.add(taobaoAccount);
//            }
//        }
//        return list;
//    }
//
//    @Override
//    public List<TaobaoAccount> findByCondtionForPage(Map<String, Object> stringObjectMap, Integer startRows, Integer size) throws SQLException {
//        List<TaobaoAccount> list =  new ArrayList<TaobaoAccount>();
//        if(stringObjectMap != null){
//            sql = " SELECT " +
//                    " ID,PERSONNEL_ACCOUNT,PASSWORD," +
//                    " IS_FROZEN,IS_CANCELLATION,IS_DELETE,PEOPLE_INFO_ID,ADD_TIME,UPDATE_TIME,GRADE_ID " +
//                    " FROM TAOBAO_ACCOUNT WHERE 1 = 1 ";
//            Set<Map.Entry<String, Object>> set = stringObjectMap.entrySet();
//            Iterator<Map.Entry<String, Object>> iterator = set.iterator();
//            if (stringObjectMap != null){
//                while (iterator.hasNext()){
//                    Map.Entry<String, Object> map = iterator.next();
//                    sql += " AND "+map.getKey()+" = '"+map.getValue()+"'";
//                }
//            }
//            sql += " LIMIT "+startRows+","+size;
//            preparedStatement = getPreparedStatement(sql);
//            resultSet = preparedStatement.executeQuery();
//            PeopleInfoServiceImpl peopleInfoService = new PeopleInfoServiceImpl();
//            GradeService gradeService=new GradeServiceImpl();
//            TaobaoAccount taobaoAccount = null;
//            while (resultSet.next()){
//                taobaoAccount = new TaobaoAccount();
//                taobaoAccount.setId(resultSet.getLong(1));
//                taobaoAccount.setPersonnelAccount(resultSet.getString(2));
//                taobaoAccount.setPassword(resultSet.getString(3));
//                taobaoAccount.setIsFrozen(resultSet.getByte(4));
//                taobaoAccount.setIsCancellation(resultSet.getByte(5));
//                taobaoAccount.setIsDelete(resultSet.getByte(6));
//                taobaoAccount.setPeopleInfo(peopleInfoService.findById(resultSet.getLong(7)));
//                taobaoAccount.setAddTime(resultSet.getDate(8));
//                taobaoAccount.setUpdateTime(resultSet.getDate(9));
//                taobaoAccount.setGrade(gradeService.findById(resultSet.getLong(10)));
//                list.add(taobaoAccount);
//            }
//        }
//        return list;
//    }
    }

