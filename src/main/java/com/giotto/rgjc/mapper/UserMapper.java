package com.giotto.rgjc.mapper;



import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.giotto.rgjc.bean.Order;
import com.giotto.rgjc.bean.User;


@Mapper //标记mapper文件位置，否则在Application.class启动类上配置mapper包扫描

@Repository

public interface UserMapper {

 

    @Select(value = "select u.username,u.password from user u where u.username=#{username}")

    @Results

            ({@Result(property = "username",column = "username"),

              @Result(property = "password",column = "password")})

    User findUserByName(@Param("username") String username);



    @Insert("insert into user values(#{id},#{username},#{password},#{pos})")

    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")

    void regist(User user);

    
    @Select("select u.id from user u where u.username = #{username} and password = #{password}")

    Long login(User user);
    
    @Select("select u.pos from user u where u.username = #{username} and password = #{password}")

    String getPos(User user);
    
    @Select("select u.password from user u where u.username = #{username}")

    String getPassword(User user);
    
    @Select("select u.id from user u where u.username = #{username} and pos = #{pos}")

    Long neworderpage(User user);
    
    @Insert("insert into orderTable values(#{no},#{status},null,#{newMan},null,#{proType},#{material},#{amount},#{attention},#{qualify},#{date},#{ifTry},'未安排','未完成')")	

    @Options(useGeneratedKeys = true,keyProperty = "no",keyColumn = "no")

    void neworder(Order order);
    
    
    @Select("select * from orderTable o where o.status = '未审核'")

    List<Order> getUnsucess();
    
    @Update("Update orderTable set status=#{status} where no= #{no}")

    void judgeStatus(Order order);
    
    @Update("Update orderTable set reason=#{reason} where no= #{no}")

    void judgeReason(Order order);
    
    @Update("Update orderTable set judMan=#{judMan} where no= #{no}")

    void judgeMan(Order order);
    
    @Select("select * from orderTable o where o.status = '不通过审核'")

    List<Order> getNopass();
    
    @Select("select * from orderTable o where o.status = '通过审核'")

    List<Order> getpass();

    
    @Update("Update orderTable set process=#{process} where no= #{no}")

    void arrange(Order order);
    
    @Update("Update orderTable set Status='完成'  where no= #{no}")

    void completeStatus(Order order);
    
    @Update("Update orderTable set jindu='完成'  where no= #{no}")

    void completeJindu(Order order);
    
    
    @Select("select * from orderTable o where o.status = '完成'")

    List<Order> getComplete();
    
    @Select("select * from orderTable o where o.no = #{no}")

    Order getOrderByNo(@Param("no") int no);
    
    @Update("Update orderTable set status='未审核' ,proType=#{proType},material=#{material},amount=#{amount},attention=#{attention},qualify=#{qualify},date=#{date},ifTry=#{ifTry}  where no= #{no}")

    void AlterConfirm(Order order);
    
}



//用户信息




