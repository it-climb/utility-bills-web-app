package alex.pol.service.impl;


import alex.pol.dao.CountryDao;
import alex.pol.domain.Country;
import alex.pol.service.CountryService;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;


/**
 * Created by Abashkin Aleksandr on 26.06.2016.
 */

@Service
public class CountryServiceImpl extends BaseService<Country, CountryDao> implements CountryService {

    @Override
    public List<Country> getAll() throws SQLException {
        return super.getAll();
    }

}