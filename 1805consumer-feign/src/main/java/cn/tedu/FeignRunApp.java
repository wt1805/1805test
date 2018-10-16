package cn.tedu;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringCloudApplication//启用feign时必须
@EnableFeignClients
public class FeignRunApp {

	public static void main(String[] args) {
		SpringApplication.run(FeignRunApp.class, args);

	}

}
