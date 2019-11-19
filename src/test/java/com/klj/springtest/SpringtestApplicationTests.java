package com.klj.springtest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.klj.springtest.controller.ExportController;
import com.klj.springtest.mapper.UserMapper;
import com.klj.springtest.model.User;
import com.klj.springtest.util.file.FileOperate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAutoConfiguration
public class SpringtestApplicationTests {

	@Resource
	private FileOperate fo;

	@Autowired(required = false)
	private UserMapper userMapper;

	@Autowired
	private ApplicationContext ac;


	@Test
	public void contextLoads() {
		String s = "${123}";
		s = s.substring(2,s.length()-1);
		System.out.println(s);
	}

	@Test
	public void fileOperateTest(){
		String filePath = "D:\\klj\\PowerDesigner165.exe";
		fo.readFileByByte(filePath);
		/*fo.readByCharacter(filePath);
		fo.readByLine(filePath);*/
		fo.readByByteBuffer(filePath);
	}

	@Test
	public void JsonSelect() {
		User user = userMapper.selectByPrimaryKey(1);
		System.out.println(
				user.toString()
		);
	}

	@Test
	public void JsonInsert() {


		/*User newUser = new User();

		newUser.setAge(1);
		newUser.setCtm(new Date());

		*//*User.Desc desc = new User.Desc();
		desc.setAddress("武汉");
		desc.setAge(1);
		desc.setName("王五他哥");
		JSON j = (JSON) JSONObject.toJSON(desc);*//*
		String str = "{" + "\"" + "latitude" + "\"" + ":" + 30.23 + "," + "\"" + "longitude"
				+ "\"" + ":" + 114.57 + "}";
		JSONObject j = JSON.parseObject(str);

		newUser.setUserName(j.toJSONString());
		newUser.setDescription(j);
		userMapper.insert(newUser);*/
	}


	@Test
	public void IocTest(){
		ExportController ec = (ExportController) ac.getBean("exportController");
		System.out.println("................");
	}


}
