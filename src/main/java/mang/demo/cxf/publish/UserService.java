package mang.demo.cxf.publish;

import javax.jws.WebService;

@WebService//如果发布的带有接口的服务需要在接口上加@WebService
public interface UserService {
	
	public String sayLove(String name);

}