package com.giotto.rgjc.controller;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.giotto.rgjc.bean.Order;
import com.giotto.rgjc.bean.Result;
import com.giotto.rgjc.bean.User;
import com.giotto.rgjc.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Controller    //相当于@Controller+@RequestBody
@Api(value = "UserController ")
@RequestMapping("/user")
public class UserController {

 

    @Autowired

    private UserService userService;
    


    @PostMapping(value = "/regist",produces="application/json;charset=UTF-8")
    public String regist(User user,Model model){
    	
        Result r=userService.regist(user);
        model.addAttribute("msg", r.getMsg());
        return "registResult";
    }


    @PostMapping(value = "/login",produces="application/json;charset=UTF-8")
    public String login(User user,Model model){

    	Result r=userService.login(user);
    	if(r.getSuccess())
    	{
        	model.addAttribute("u", user);
        	if(user.getPos().equals("管理员"))
        	{
                return "adminPage";
        	}
        	else if(user.getPos().equals("技术员"))
        	{
        		List<Order>o=userService.getPass();
            	model.addAttribute("o", o);
        		return "Jishuyuan";
        	}
        	else
        	{
        		List<Order>o=userService.getUnsucess();
            	model.addAttribute("o", o);
        		return "JudUnsucess";
        	}
    	}
    	else
    	{
    		return "WrongPassword";
    	}
        

    }

    @PostMapping(value = "/neworder",produces="application/json;charset=UTF-8")
    public String neworder(User user,Model model){

    	Result r=userService.neworder(user);
    	
    	model.addAttribute("u", user);
    	
    	return "NewOrder";
        

    }
    
    @PostMapping(value = "/newResult",produces="application/json;charset=UTF-8")
    public String newResult(Order order,User user,Model model){

    	Result r1=userService.neworder(user);
    	
    	Result r2=userService.newOrder(order);
    	
    	model.addAttribute("u", user);
    	model.addAttribute("msg", r2.getMsg());
    	
    	return "adminPage";
        

    }
    
    @PostMapping(value = "/unsucess",produces="application/json;charset=UTF-8")
    public String unsucess(User user,Model model){

    	Result r1=userService.neworder(user);
    	
    	List<Order>o=userService.getUnsucess();
    	
    	model.addAttribute("u", user);
    	model.addAttribute("o", o);
    	
    	return "Unsucess";
        

    }
    
    @PostMapping(value = "/judge",produces="application/json;charset=UTF-8")
    public String judge(User user,Order order,Model model){

    	Result r1=userService.neworder(user);
    	
    	userService.judge(order);
    	
    	List<Order>o=userService.getUnsucess();
    	
    	model.addAttribute("u", user);
    	model.addAttribute("o", o);
    	
    	return "JudUnsucess";
        

    }
    
    @PostMapping(value = "/notpass",produces="application/json;charset=UTF-8")
    public String nopass(User user,Model model){

    	Result r1=userService.neworder(user);
    	
    	
    	List<Order>o=userService.getNoPass();
    	
    	model.addAttribute("u", user);
    	model.addAttribute("o", o);
    	
    	return "NoPass";
        

    }
    
    @PostMapping(value = "/processing",produces="application/json;charset=UTF-8")
    public String processing(User user,Model model){

    	Result r1=userService.neworder(user);
    	
    	
    	List<Order>o=userService.getPass();
    	
    	model.addAttribute("u", user);
    	model.addAttribute("o", o);
    	
    	return "Processing";
        

    }
    
    @PostMapping(value = "/arrange",produces="application/json;charset=UTF-8")
    public String arrange(User user,Order order,Model model){

    	Result r1=userService.neworder(user);
    	userService.arrange(order);
    	
    	List<Order>o=userService.getPass();
    	
    	model.addAttribute("u", user);
    	model.addAttribute("o", o);
    	
    	return "Jishuyuan";
        
    }
    
    @PostMapping(value = "/complete",produces="application/json;charset=UTF-8")
    public String complete(User user,Order order,Model model){

    	Result r1=userService.neworder(user);
    	
    	userService.Complete(order);
    	
    	List<Order>o=userService.getPass();
    	
    	model.addAttribute("u", user);
    	model.addAttribute("o", o);
    	
    	return "Jishuyuan";
        
    }
    
    @PostMapping(value = "/completed",produces="application/json;charset=UTF-8")
    public String completed(User user,Model model){

    	Result r1=userService.neworder(user);
    	
    	
    	List<Order>o=userService.getComplete();
    	
    	model.addAttribute("u", user);
    	model.addAttribute("o", o);
    	
    	return "Processing";
        
    }
    
    @PostMapping(value = "/alterPage",produces="application/json;charset=UTF-8")
    public String alterPage(User user,Order order,Model model){

    	Result r1=userService.neworder(user);
    	
    	
    	Order o=userService.getOrderByNo(order);
    	
    	model.addAttribute("u", user);
    	model.addAttribute("o", o);
    	
    	return "AlterPage";
        

    }
    
    
    @PostMapping(value = "/alterConfirm",produces="application/json;charset=UTF-8")
    public String alterConfirm(User user,Order order,Model model){

    	Result r1=userService.neworder(user);
    	
    	
    	userService.AlterConfirm(order);
    	List<Order>o=userService.getNoPass();
    	
    	model.addAttribute("u", user);
    	model.addAttribute("o", o);
    	
    	return "NoPass";
        

    }
}

