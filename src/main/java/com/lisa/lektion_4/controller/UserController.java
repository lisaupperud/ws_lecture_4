package com.lisa.lektion_4.controller;

import com.lisa.lektion_4.model.CustomUser;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController // contains @Controller & @ResponseBody
//@Controller      // is a specialized @Component for classpath Scanning & Mappings
//@Component       //  enables naming of stereotype Annotations (Service, Repository, RestController), activation of classpath Scanning
//@ResponseBody    // send a result (JSON/HTML)
@RequestMapping(value = "/v1/user")
public class UserController {

    // Debugging User List (Database users)
    List<CustomUser> userList = new ArrayList<>(
            List.of(
                    new CustomUser("Benny", "123", true),
                    new CustomUser("Frida", "abc", true),
                    new CustomUser("Anton", "456", true),
                    new CustomUser("Arvid", "789", true),
                    new CustomUser("Arvid", "def", false)
            )
    );

    @GetMapping("/")
    public List<CustomUser> userList() {
        return userList;
    }

    // RequestParam URL:
    // localhost:8080/find?username=Benny
    @GetMapping("/find")
    // looks for and returns usernames
    public List<CustomUser> findUser(@RequestParam("username") String username) {

        return userList().stream().filter(i -> Objects.equals(i.username(), username)).toList();
    }

    @DeleteMapping("/{username}")
    public CustomUser deleteUser(@PathVariable("username") String username) {

        CustomUser customUserToBeDeleted;

        for (int i = 0; i < userList.size(); i++) {
            if (Objects.equals(userList.get((i)).username(), username)) {
                customUserToBeDeleted = userList.get(i);
                userList.remove(customUserToBeDeleted);

                return customUserToBeDeleted;
            }
        }
        return null;
    }

}
