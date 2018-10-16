package cn.tedu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import cn.tedu.feign.EurekaServiceFeign;

@RestController
public class HelloController {

	//调用接口
	@Autowired
	private EurekaServiceFeign feign;
	@RequestMapping("/hello/{name}")
	@HystrixCommand(fallbackMethod = "fallbackHello")
	public String hello(@PathVariable String name){
		return feign.hello(name);//调用服务提供着
	}
	
	//失败是调用这个方法
	//方法名字和fallbackMethod必须一致,参数类型，和名称一致
	public String fallbackHello(String name){
		//设置一个失败是默认值
		return "tony";
	}
}
