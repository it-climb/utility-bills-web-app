package alex.pol.service;

import alex.pol.domain.Avatar;
import alex.pol.domain.City;

import java.sql.SQLException;
import java.util.List;

public interface AvatarService extends Service<Avatar> {
    @Override
    List<Avatar> getAll() throws SQLException;

    @Override
    Avatar getById(Integer id) throws SQLException;

    Avatar getByPath(String path) throws SQLException;

}
