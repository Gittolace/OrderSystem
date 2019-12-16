package com.giotto.rgjc.service;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.giotto.rgjc.bean.Order;
import com.giotto.rgjc.bean.Result;
import com.giotto.rgjc.bean.User;
import com.giotto.rgjc.mapper.UserMapper;

@Service

@Transactional(rollbackFor = RuntimeException.class)

public class UserService {

 

    @Autowired

    private UserMapper userMapper;

    /**

     * 注册

     * @param user 参数封装

     * @return Result

     */

    public Result regist(User user) {

        Result result = new Result();

        result.setSuccess(false);

        result.setDetail(null);

        try {

            User existUser = userMapper.findUserByName(user.getUsername());

            if(existUser != null){

                //如果用户名已存在

                result.setMsg("用户名已存在");

 

            }
            else if(user.getPos().equals("管理员")||user.getPos().equals("审核员")||user.getPos().equals("技术员"))
            {
            	userMapper.regist(user);
                
                result.setMsg("注册成功");

                result.setSuccess(true);

                result.setDetail(user);
            }
            else{

            	result.setMsg("注册失败，用户职位只可填管理员、审核员、技术员其中之一");

                result.setSuccess(false);

            }

        } catch (Exception e) {

            result.setMsg(e.getMessage());

            e.printStackTrace();

        }

        return result;

    }

    /**

     * 登录

     * @param user 用户名和密码

     * @return Result

     */

    public Result login(User user) {

        Result result = new Result();

        result.setSuccess(false);

        result.setDetail(null);

        try {

            Long userId= userMapper.login(user);

            if(userId == null){

                result.setMsg("用户名或密码错误");

            }else{

                result.setMsg("登录成功");

                result.setSuccess(true);

                user.setId(userId);
                String pos=userMapper.getPos(user);
                
                user.setPos(pos);

                result.setDetail(user);

            }

        } catch (Exception e) {

            result.setMsg(e.getMessage());

            e.printStackTrace();

        }

        return result;

    }
    
    
    public Result neworder(User user) {

        Result result = new Result();

        result.setSuccess(false);

        result.setDetail(null);

        try {

            Long userId= userMapper.neworderpage(user);

            

            result.setMsg("登录成功");

            result.setSuccess(true);

            user.setId(userId);
            
            String password=userMapper.getPassword(user);
            
            user.setPassword(password);
            
            result.setDetail(user);

            

        } catch (Exception e) {

            result.setMsg(e.getMessage());

            e.printStackTrace();

        }

        return result;

    }
    
    public Result newOrder(Order order) {

        Result result = new Result();

        result.setSuccess(false);

        result.setDetail(null);

        try {
        	userMapper.neworder(order);
        	result.setMsg("创建成功");
            result.setSuccess(true);
            result.setDetail(order);


        } catch (Exception e) {

            result.setMsg(e.getMessage());

            e.printStackTrace();

        }

        return result;

    }
    
    public List<Order>getUnsucess()
    {
    	return userMapper.getUnsucess();
    }
    
    public void judge(Order order)
    {
    	userMapper.judgeStatus(order);
    	userMapper.judgeMan(order);
    	userMapper.judgeReason(order);
    }
    
    public List<Order>getNoPass()
    {
    	return userMapper.getNopass();
    }
    
    public List<Order>getPass()
    {
    	return userMapper.getpass();
    }
    
    public void arrange(Order order)
    {
    	userMapper.arrange(order);
    }

    public void Complete(Order order)
    {
    	userMapper.completeStatus(order);
    	userMapper.completeJindu(order);
    }
    
    public List<Order>getComplete()
    {
    	return userMapper.getComplete();
    }
    
    public Order getOrderByNo(Order order)
    {
    	return userMapper.getOrderByNo(order.getNo());
    }
    
    public void AlterConfirm(Order order)
    {
    	userMapper.AlterConfirm(order);
    }
}

