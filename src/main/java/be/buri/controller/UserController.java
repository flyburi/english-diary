package be.buri.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by buri on 2015. 9. 7..
 */
@RestController
public class UserController {
  @RequestMapping("/user")
  public Principal user(Principal user) {
    return user;
  }

//  @RequestMapping(value = "/user/login/facebook")
//  public String loginFacebook(){
//    return "facebook";
//  }

  @RequestMapping("/resource")
  public Map<String, Object> home() {
    Map<String, Object> model = new HashMap<String, Object>();
    model.put("id", UUID.randomUUID().toString());
    model.put("content", "Hello World");
    return model;
  }
}
