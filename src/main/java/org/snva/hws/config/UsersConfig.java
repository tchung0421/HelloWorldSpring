package org.snva.hws.config;

import org.snva.hws.beans.Role;
import org.snva.hws.beans.User;
import org.springframework.context.annotation.Bean;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UsersConfig {

    public List<Role> getRolesThomas(){
        List<Role> roles = new ArrayList<Role>();
        Role learner = new Role();
        learner.setRoleId(1l);
        learner.setRoleName("learner");
        learner.setRoleDescription("This is learner role.");

        Role admin = new Role();
        admin.setRoleId(2l);
        admin.setRoleName("admin");
        admin.setRoleDescription("This is admin role.");

        Role architect = new Role();
        architect.setRoleId(3l);
        architect.setRoleName("architect");
        architect.setRoleDescription("This is architect role.");

        roles.add(learner);
        roles.add(admin);
        roles.add(architect);
        return roles;
    }

    @Bean (name="thomas")
    public User thomas(){
        User user = new User();
        user.setContact("+1 111 111 1111");
        user.setEmail("tchung0421@gmail.com");
        user.setUserId(1l);
        user.setUserName("tec");
        user.setPassword("123456");
        user.setFirstName("Thomas");
        user.setLastName("Chung");
        user.setRoles(getRolesThomas());
        return user;
    }

    @Bean (name="users")
    public List<User> users(){
        List<User> users = loadFromFile();
        return users;
    }

    private List<User> loadFromFile(){
        List<User> users = new ArrayList<>();
        try{
            byte[] allBytes=Files.readAllBytes(Paths.get("C:\\Users\\Se-Lim Oh\\Code\\HelloWorldSpring\\users.txt"));
            String allLines = new String(allBytes);
            for (String line: allLines.split("\n")) {
                String cols[] = line.split(",");
                User user = new User();
                user.setUserId(new Long(cols[0]));
                user.setUserName(cols[1]);
                user.setFirstName(cols[2]);
                user.setLastName(cols[3]);
                user.setPassword(cols[4]);
                user.setEmail(cols[5]);
                user.setContact(cols[6]);
                user.setRoles(getRoles(cols[7]));
                users.add(user);
            }
        } catch (Exception e){

        }
        return users;
    }

    private List<Role> getRoles(String rolesString) {
        List<Role> roles = new ArrayList<>();
        rolesString= rolesString.replace('\r',' ');
        rolesString= rolesString.trim();
        String[] rolesArr= rolesString.split("-");
        for (String role: rolesArr ) {
            if (role.equalsIgnoreCase("")|| role==null){
                String com=rolesString;
                roles.addAll(getRolesThomas().stream().filter(x->x.getRoleName().equalsIgnoreCase(com)).collect(Collectors.toList()));
            }
            else{

                roles.addAll(getRolesThomas().stream().filter(x->x.getRoleName().equalsIgnoreCase(role)).collect(Collectors.toList()));

            }
        }
        return  roles;
    }
}
