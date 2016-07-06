package alex.pol.service.impl;

import alex.pol.dao.StreetDao;
import alex.pol.domain.Street;
import alex.pol.service.StreetService;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Abashkin Aleksandr on 26.06.2016.
 */

@Service
public class StreetServiceImpl extends BaseService<Street, StreetDao> implements StreetService {
    @Override
    public List<Street> getAll() throws SQLException {
        return super.getAll();
    }

}