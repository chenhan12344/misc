package design.proxy;

import java.util.List;

/**
 * Created by Sky on 2019/6/28
 *
 * @author Sky
 */
public class UserServiceImpl implements IUserService {
    @Override
    public List<String> listAllUser() {
        System.out.println("===> SELECT * FROM user;");
        System.out.println("<=== [{name: Tom}, {name: Jack}, {name: Marry}]");
        return null;
    }

    @Override
    public int deleteUserById(Long id) {
        System.out.println("===> DELETE FROM user WHERE uid=" + id + ";");
        System.out.println("<=== 1 row affected");
        return 0;
    }

    @Override
    public int saveUser(String user) {
        System.out.println("===> INSERT INTO user(name) VALUES(" + user + ");");
        System.out.println("<=== 1 row affected");
        return 0;
    }
}
