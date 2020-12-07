```java
package com.ameng.Test.Use_Mapper;

import com.ameng.entity.User;
import com.ameng.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: Java-Basic
 * @description: 查询
 * @author: Ameng
 * @create: 2020-11-11
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class SelectTest {

    @Autowired
    private UserMapper userMapper;



    @Test
    public void testSelect() {
        User user = userMapper.selectById(5);
        System.out.println(user);
    }

    @Test
    public void selectIds() {
        List<Integer> idlist =  Arrays.asList(1,2,3);
        List<User> userList = userMapper.selectBatchIds(idlist);
        userList.forEach(System.out::println);


    }
    //where
    @Test
    public void selectByMap(){
        //map.put("NAME","张三")
        //map.put("age",20)
        //where NAME = "张三" and age = 20
        Map<String,Object> columnMap = new HashMap<>();
        columnMap.put("NAME","张三");

        List<User> userList = userMapper.selectByMap(columnMap);
        userList.forEach(System.out::println);
    }
    /*
    * 查询名字为like三,age < 49
    *条件构造器
    * */
    @Test
    public void selectByWrapper(){
        //两种创建querywrapper
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        //创建方式二：  QueryWrapper<User> query = Wrapper.<User>query();
        queryWrapper.like("NAME","三").lt("age",49);

        List<User> userlist =userMapper.selectList(queryWrapper);
        userlist.forEach(System.out::println);

    }
    /*
     * 查询名字为like三,age between 20 and 40  并且email不为空
     *条件构造器
     * */
    @Test
    public void selectByWrappr2(){
        //两种创建querywrapper
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        //创建方式二：  QueryWrapper<User> query = Wrapper.<User>query();
        queryWrapper.like("NAME","三").between("age",20,49).isNull("email");

        List<User> userlist =userMapper.selectList(queryWrapper);
        userlist.forEach(System.out::println);

    }
    /*
     * 查询名字为like三 or age >= 30  order by age desc ,id asc
     *条件构造器
     * */
    @Test
    public void selectByWrappr3(){
        //两种创建querywrapper
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        //创建方式二：  QueryWrapper<User> query = Wrapper.<User>query();
        queryWrapper.likeRight("NAME","三").or().ge("age",30).orderByDesc("age");

        List<User> userlist =userMapper.selectList(queryWrapper);
        userlist.forEach(System.out::println);

    }
    /**
     * 创建日期2019年2月14 并且直属上级姓名为jone
     *date_from(create_time,"%Y-%m-%d" and manager_id in (select id from user where name like "jone%")
     */

    @Test
    public void selectByWrappr4(){
        //两种创建querywrapper
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        //创建方式二：  QueryWrapper<User> query = Wrapper.<User>query();
        //分开%Y-%m-%d'写结果，否则会有sql注入的风险
        queryWrapper.apply("date_from(create_time,'%Y-%m-%d'={0}","2019-02-14")
                .inSql("manager_id","select id from user where name like 'jone%'");

        List<User> userlist =userMapper.selectList(queryWrapper);
        userlist.forEach(System.out::println);

    }

    /**
     * 姓名为王 并且（年龄小于40 或邮箱不为空）
     * name like '王%' and (age <40 or email is not null)
     */
    @Test
    public void selectByWrappr5(){
        //两种创建querywrapper
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        //创建方式二：  QueryWrapper<User> query = Wrapper.<User>query();
        //分开%Y-%m-%d'写结果，否则会有sql注入的风险
        queryWrapper.likeRight("name","王").and(wq->wq.lt("age",40).or().isNotNull("eamil"));
        List<User> userlist =userMapper.selectList(queryWrapper);
        userlist.forEach(System.out::println);

    }

    /**
     * （年龄小于40 或邮箱不为空）并且姓名为王
     * (age <40 or email is not null) and name like '王%'
     */
    @Test
    public void selectByWrappr6(){
        //两种创建querywrapper
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        //创建方式二：  QueryWrapper<User> query = Wrapper.<User>query();
        //分开%Y-%m-%d'写结果，否则会有sql注入的风险
        queryWrapper.nested(wq->wq.lt("age",40).or().isNotNull("eamil"));
        List<User> userlist =userMapper.selectList(queryWrapper);
        userlist.forEach(System.out::println);

    }

    /**
     * 姓名为王 或者（年龄小于40并且大于20 并且邮箱不为空）
     * name like '王%' or (age <40 and age >20 and email is not null)
     */
    @Test
    public void selectByWrappr7(){
        //两种创建querywrapper
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();

        queryWrapper.likeRight("name","王").or(wq->wq.lt("age",40).gt("age",20).isNotNull("eamil")).likeRight("name","王");
        List<User> userlist =userMapper.selectList(queryWrapper);
        userlist.forEach(System.out::println);

    }

    /**
     * 年龄为30 ，31,34,35
     * age in (30、31、34、35)
     */
    @Test
    public void selectByWrappr8(){
        //两种创建querywrapper
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();

        queryWrapper.in("age",Arrays.asList(30,31,34,35));
        List<User> userlist =userMapper.selectList(queryWrapper);
        userlist.forEach(System.out::println);

    }

    /*
     * 查询名字为like三,age < 49
     *条件构造器,指定返回特定的字段id","NAME","age"
     * */
    @Test
    public void selectByWrapperSupper(){
        //两种创建querywrapper
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        //创建方式二：  QueryWrapper<User> query = Wrapper.<User>query();
        queryWrapper.select("id","NAME","age").like("NAME","三").lt("age",49);

        List<User> userlist =userMapper.selectList(queryWrapper);
        userlist.forEach(System.out::println);

    }

    /*
     * 查询名字为like三,age < 49
     *条件构造器,排除特定的字段
     * select（）写前写后都可以
     * */
    @Test
    public void selectByWrapperSupper2(){
        //两种创建querywrapper
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        //创建方式二：  QueryWrapper<User> query = Wrapper.<User>query();
        queryWrapper.like("NAME","三").lt("age",49).select(User.class,info->!info.getColumn().equals("creat_time")&&
                !info.getColumn().equals("manager_id"));

        List<User> userlist =userMapper.selectList(queryWrapper);
        userlist.forEach(System.out::println);

    }


    /*
    构造方法的查询，通过查询传入参数
     */
    @Test
    public void testCondition(){
        String name = "张";
        String email = "";
        condition(name ,email);

    }
    private void condition(String name,String email){
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
  /*      //判断是否为空，为空则不进行拼接
        if (StringUtils.isNotBlank(name)){
            queryWrapper.like("name",name);

        }

        if (StringUtils.isNotBlank(email)){
            queryWrapper.like("email",email);

        }*/
        //第二种写法
        queryWrapper.like(StringUtils.isNotBlank(name),"name",name).like(StringUtils.isNotBlank(email),"email",email);

        List<User> userlist =userMapper.selectList(queryWrapper);
        userlist.forEach(System.out::println);
    }



    /*
    实体作为查询参数
     */
    @Test
    public void selectByWrapperEntity(){
        User whereUser = new User();
        whereUser.setName("张三");
        whereUser.setAge(20);

        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
//如果实体设置了参数，还使用下边的like则会重复
//        queryWrapper.like("NAME","三").lt("age",49);

        List<User> userlist =userMapper.selectList(queryWrapper);
        userlist.forEach(System.out::println);
    }


    /*
    实体作为查询参数
     */
    @Test
    public void selectByWrapperAllEq(){

        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();

        Map<String,Object> params = new HashMap<String,Object>();
        params.put("name","李四");
        params.put("age",31);
        queryWrapper.allEq(params);
        /*queryWrapper.allEq(params,false);过滤age为空
        *
        *   allEq(Map<R, V> params)
            allEq(Map<R, V> params, boolean null2IsNull)
            allEq(boolean condition, Map<R, V> params, boolean null2IsNull)
        参数说明：
         params : key为数据库字段名,value为字段值
            null2IsNull : 为true则在map的value为null时调用 isNull 方法,为false时则忽略value为null的
        * */

        List<User> userlist =userMapper.selectList(queryWrapper);
        userlist.forEach(System.out::println);
    }

    /*
    Map作为结果，
    使用场景：统计查询。
    */
    @Test
    public void selectByWrapperMaps(){

        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        queryWrapper.select("id","name").like("NAME","三").lt("age",25);
        //使用Maps类型，则会将其他没有要求显示的列，不显示，如果是实体类的话，就会将没有选择的列为NULl
        List<Map<String,Object>> userlist =userMapper.selectMaps(queryWrapper);
        userlist.forEach(System.out::println);
    }
    /*
    统计查询
    要求：按照直属上级分组，查询每组的平均年龄，最大年龄，最小年龄。并且只取年龄总和小于500的组
    sql: select avg(age) avg_age，min(age) min_age,max(age) max_age
            from user
            group by manager_id
            having sum(age) <500
         */
    @Test
    public void selectByWrapperMaps2(){

        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        queryWrapper.select("avg(age) avg_age","min(age) min_age","max(age) max_age").groupBy("manager_id").having("sum(age) <{0}",500);


        List<Map<String,Object>> userlist =userMapper.selectMaps(queryWrapper);
        userlist.forEach(System.out::println);
    }

    /**
     * object
     */
    @Test
    public void selectByWrapperObjs(){

        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        queryWrapper.select("id","name").like("NAME","三").lt("age",25);
        //只返回第一列，其他列就会被舍弃
        List<Object> userlist =userMapper.selectObjs(queryWrapper);
        userlist.forEach(System.out::println);
    }

    /**
     * Count 返回记录数，这里就不能设置列了
     */
    @Test
    public void selectByWrapperCount(){

        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        queryWrapper.like("NAME","三").lt("age",25);
        //只返回第一列，其他列就会被舍弃
        Integer count =userMapper.selectCount(queryWrapper);
        System.out.println(count);
    }

    /**
     * One 返回的是一个实体，只能查询一条，或者查询不到,如果是多条就会报错
     */
    @Test
    public void selectByWrapperOne(){

        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        queryWrapper.like("NAME","三").lt("age",25);
        //只返回第一列，其他列就会被舍弃
        User user =userMapper.selectOne(queryWrapper);
        System.out.println(user);
    }

    @Test
    public void selectLambda() {
        //三种方式创建
        //LambdaQueryWrapper<User> lambda = new QueryWrapper<User>().lambda();
        //LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<User>();
        LambdaQueryWrapper<User> lambdaQuery = Wrappers.<User>lambdaQuery();
        //getName 如果写错，就会直接报错，可以很好的解决误写错误
        lambdaQuery.like(User::getName,"王").lt(User::getAge,40);
        //where name like "%王%"
        List<User> userList = userMapper.selectList(lambdaQuery);

        //迭代输出
        userList.forEach(System.out::println);

    }

    /**
     * 自定义方法Selectall()
     */
    @Test
    public void selectMy(){

        LambdaQueryWrapper<User> lambdaQuery = Wrappers.<User>lambdaQuery();
        //getName 如果写错，就会直接报错，可以很好的解决误写错误
        lambdaQuery.like(User::getName,"王").lt(User::getAge,40);

        List<User> userlist =userMapper.getAll(lambdaQuery);
        userlist.forEach(System.out::println);
    }
}

```

