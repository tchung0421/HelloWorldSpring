package org.snva.hws;

import org.snva.hws.beans.Role;
import org.snva.hws.beans.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class DeveloperRunner
{
    public static void main( String[] args )
    {
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

        List<Role> rolesForThomas = new ArrayList<Role>();
        rolesForThomas.add(learner);
        rolesForThomas.add(architect);
        rolesForThomas.add(admin);

        User thomas = new User();
        thomas.setContact("+1 111 111 1111");
        thomas.setEmail("tchung0421@gmail.com");
        thomas.setUserId(1l);
        thomas.setUserName("tec");
        thomas.setPassword("123456");
        thomas.setFirstName("Thomas");
        thomas.setLastName("Chung");
        thomas.setRoles(rolesForThomas);

        List<Role> rolesForAlex = new ArrayList<Role>();
        rolesForAlex.add(admin);

        User alex = new User();
        alex.setContact("+1 111 111 1111");
        alex.setEmail("tchung0421@gmail.com");
        alex.setUserId(2l);
        alex.setUserName("alex");
        alex.setPassword("123456");
        alex.setFirstName("Alex");
        alex.setLastName("Chung");
        alex.setRoles(rolesForAlex);

        List<Role> rolesForViet = new ArrayList<Role>();
        rolesForViet.add(architect);

        User viet = new User();
        viet.setContact("+1 111 111 1111");
        viet.setEmail("tchung0421@gmail.com");
        viet.setUserId(3l);
        viet.setUserName("viet");
        viet.setPassword("123456");
        viet.setFirstName("Viet");
        viet.setLastName("Chung");
        viet.setRoles(rolesForViet);

        List<User> users = new ArrayList<User>();
        users.add(alex);
        users.add(thomas);
        users.add(viet);
        users.forEach(x->{
            System.out.print(x.getFirstName());
            System.out.print(" having ");
            System.out.print(x.getRoles().size());
            System.out.print(" role(s) details -> ");
            System.out.println(x);
        });
    }
}
