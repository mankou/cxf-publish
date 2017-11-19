package mang.demo.cxf.publish;

import javax.jws.WebService;


public class UserServiceImpl implements UserService {

	@Override
	public String sayLove(String name) {
		return name + " love you";
	}

}
