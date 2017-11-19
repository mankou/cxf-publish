package mang.demo.cxf.publish;

import javax.jws.WebService;

@WebService
public class PersonService1 {
	
	public String sayHello(String name){
		return "hello " + name;
	}

}
