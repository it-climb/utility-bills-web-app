package alex.pol.service.impl;


import alex.pol.dao.AvatarDao;
import alex.pol.domain.Avatar;
import alex.pol.service.AvatarService;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;


/**
 * Created by Abashkin Aleksandr on 26.06.2016.
 */

@Service
public class AvatarServiceImpl extends BaseService<Avatar, AvatarDao> implements AvatarService {

    @Override
    public List<Avatar> getAll() throws SQLException {
        return super.getAll();
    }

    @Override
    public Avatar getByPath(String path) throws SQLException {
        Avatar avatar = dao.getByPath(path);
        if (avatar != null) {
            return avatar;
        } else {
            avatar = new Avatar();
            avatar.setPath(path);
            dao.save(avatar);
            return avatar;
        }
    }

}