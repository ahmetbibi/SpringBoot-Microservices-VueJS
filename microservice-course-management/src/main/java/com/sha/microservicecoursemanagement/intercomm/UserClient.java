package com.sha.microservicecoursemanagement.intercomm;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

// Here we want to get user names with id lists from user service
// We can connect to other services in Spring Cloud easily with Spring Cloud Open Feign
// To enable feign class in Spring App, we have to add it to our main Spring App class as an annotation
@FeignClient("user-service") // We are using this to create connection to other services from course service
public interface UserClient {
    // We will send a post request to user service to get user names according to our user id list with service name path
    // Here we will use UserController from user-service
    @RequestMapping(method = RequestMethod.POST, value = "/service/names", consumes = "application/json")
    List<String> getUserNames(@RequestBody List<Long> userIdList);
    // Now we can call it from Spring Controller Class
}
