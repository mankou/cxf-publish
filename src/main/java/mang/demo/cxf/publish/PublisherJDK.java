package mang.demo.cxf.publish;

import javax.xml.ws.Endpoint;

public class PublisherJDK {

	/**
	 * 演示用jdk发布webservice服务
	 * */
	public static void main(String[] args) {
		Endpoint.publish("http://127.0.0.1:8099/hello", new PersonServiceJDK());
	}

}
