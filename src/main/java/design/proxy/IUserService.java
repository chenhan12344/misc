package design.proxy;

import java.util.List;

/**
 * Created by Sky on 2019/6/28
 *
 * @author Sky
 */
public interface IUserService {
    List<String> listAllUser();

    int deleteUserById(Long id);

    int saveUser(String user);
}
