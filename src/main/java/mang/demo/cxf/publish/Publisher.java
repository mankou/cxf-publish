package mang.demo.cxf.publish;

import org.apache.cxf.frontend.ServerFactoryBean;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

/**
* ServerFactoryBean:
* 		服务类上不需要加注解
* 		服务类中没有发布的方法不会报错
* 	缺点：生成的wsdl的文档的命名不规范，很重要
* 
* 
* WsJaxServerFactoryBean
* 		发布的服务类上必须要加@WebService
* 		服务类中没有发布的方法不会报错但是wsdl无效
* 		生成的wsdl的文档是规范的
*/
public class Publisher {
	
	public static void main(String[] args) {
		// 用ServerFactoryBean 发布webservice
		publishWSWithServerFactoryBean();
		
		
		//JaxWsServerFactoryBean 发布webservice 并且服务类是一个类 不是接口
		//TODO 目前对我试验有问题
		publishWSWithJaxWsServerFactoryBean();
		
		//JaxWsServerFactoryBean 发布带有接口的服务
		publishWSWithJaxWsServerFactoryBean1();
		
		
		//JaxWsServerFactoryBean 发布的服务带有拦截器
		publishWSWithJaxWsServerFactoryBean2();
	}

	/**
	 * 演示 用ServerFactoryBean 发布webservice
	 * */
	public static void publishWSWithServerFactoryBean() {
		// 创建cxf发布的服务对象
		ServerFactoryBean sfb = new ServerFactoryBean();
		// 设置服务的类
		sfb.setServiceClass(PersonService.class);
		// 设置服务地址
		sfb.setAddress("http://localhost:5555/hello");
		// 设置服务类对象
		// sfb.setServiceBean(new PersonService());
		// 发布
		sfb.create();
	}
	
	/**
	 * 演示 用JaxWsServerFactoryBean 发布webservice
	 * 其发布的服务就是一个类，不是接口
	 * 注意: 我试验了在浏览器里访问  http://localhost:6666/hello?wsdl 访问不了，不知道为什么 ,但我一般发布的服务都是带接口的 所以这里也没有深入研究
	 * */
	public static  void publishWSWithJaxWsServerFactoryBean(){
		//创建cxf发布的服务对象
		JaxWsServerFactoryBean sfb = new JaxWsServerFactoryBean();
		//设置服务的类
		sfb.setServiceClass(PersonService1.class);
		//设置服务地址
		sfb.setAddress("http://localhost:6666/hello");
		//设置服务类对象
		sfb.setServiceBean(new PersonService1());
		//发布
		sfb.create();
	}
	
	
	/**
	 * 演示 用JaxWsServerFactoryBean 发布webservice 
	 * 发布带有接口的服务
	 */
	public static void publishWSWithJaxWsServerFactoryBean1(){
		//创建cxf发布的服务对象
		JaxWsServerFactoryBean sfb = new JaxWsServerFactoryBean();
		//设置服务的接口类
		sfb.setServiceClass(UserService.class);
		//设置服务地址
		sfb.setAddress("http://localhost:7777/hello");
		//设置服务类对象
		sfb.setServiceBean(new UserServiceImpl());
		//发布
		sfb.create();
	}
	
	/**
	 * 发布的服务带有拦截器
	 * */
	public static void publishWSWithJaxWsServerFactoryBean2(){
		//创建cxf发布的服务对象
		JaxWsServerFactoryBean sfb = new JaxWsServerFactoryBean();
		//设置服务的接口类
		sfb.setServiceClass(UserService.class);
		//设置服务地址
		sfb.setAddress("http://localhost:8888/hello");
		//设置服务类对象
		sfb.setServiceBean(new UserServiceImpl());
		//设置输入输出的消息拦截器
		sfb.getInInterceptors().add(new LoggingInInterceptor());
		sfb.getOutInterceptors().add(new LoggingOutInterceptor());
		//发布
		sfb.create();
	}
}
