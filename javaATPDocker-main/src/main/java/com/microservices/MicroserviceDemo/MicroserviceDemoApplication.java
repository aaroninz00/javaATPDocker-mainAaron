package com.microservices.MicroserviceDemo;

import com.microservices.MicroserviceDemo.model.SomeTable;
import com.microservices.MicroserviceDemo.service.SomeTableService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.time.OffsetDateTime;

@SpringBootApplication
@RestController
public class MicroserviceDemoApplication {

	@Autowired
    private SomeTableService someTableService;

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceDemoApplication.class, args);
	}

	@GetMapping("/function")
    public String function(){
		OffsetDateTime creation_ts = OffsetDateTime.now();
		SomeTable td = someTableService.addSomeTable(new SomeTable(1,"desc",creation_ts,true));
        return "Hello World";
    }

}
