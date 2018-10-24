package zxy.demo.springboot.boot_feature.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import zxy.demo.springboot.boot_feature.dao.UserMapper;
import zxy.demo.springboot.boot_feature.entity.User;
import zxy.demo.springboot.boot_feature.entity.UserExample;

@RequestMapping("user")
@RestController
public class UserController {
	@Autowired
	private UserMapper userMapper;

	@GetMapping("/list/all")
	public Object listAll() {
		return userMapper.selectByExample(new UserExample());
	}

	@RequestMapping(value = "/userRegister", method = { RequestMethod.POST, RequestMethod.GET })
	public String loginByPost1(@RequestBody User loginBean,HttpServletRequest request) {
		userMapper.insertSelective(loginBean);
		return "0";

	}

}
