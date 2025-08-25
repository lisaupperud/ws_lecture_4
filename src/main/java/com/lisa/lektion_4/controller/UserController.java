package com.lisa.lektion_4.controller;

import com.lisa.lektion_4.model.CustomUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController // contains @Controller & @ResponseBody
//@Controller      // is a specialized @Component for classpath Scanning & Mappings
//@Component       //  enables naming of stereotype Annotations (Service, Repository, RestController), activation of classpath Scanning
//@ResponseBody    // send a result (JSON/HTML)
public class UserController {

    // Debugging User List (Database users)
    List<CustomUser> userList = new ArrayList<>(
            List.of(
                    new CustomUser("Benny", "123", true),
                    new CustomUser("Frida", "abc", true),
                    new CustomUser("Anton", "456", true),
                    new CustomUser("Arvid", "789", true)
            )
    );

    @GetMapping("/userList")
    public List<CustomUser> test(){
        return userList;
    }

}
