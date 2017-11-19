package mang.demo.cxf.publish;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * 
 * @author renliang
 * webservice的服务类中必须至少有一个方法
 * jdk发布webservice服务的时候服务类上必须需要加@webService注解
 */
@WebService
public class PersonServiceJDK {
	
	/**
	 * 1.不能是静态的
	 * 2.不能是final
	 * @param name
	 * @return
	 */
	public String sayHello(String name){
		return name + " hello";
	}
	
	@WebMethod(exclude=true)//可以禁用某个方法
	public String sayLove(String name){
		return name + "love you";
	}

}

