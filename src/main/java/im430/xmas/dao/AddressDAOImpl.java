package im430.xmas.dao;

import im430.xmas.business.Address;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Resource
@Transactional
public class AddressDAOImpl implements AddressDAO {

    @Autowired
    private SqlSession sqlSession;

    public void addAddress(Address address) {
        this.sqlSession.insert("im430.xmas.im430.xmas.dao.AddressDAOImpl.addAddress", address);
    }

    public void removeAddress(Address address) {
        this.sqlSession.delete("im430.xmas.im430.xmas.dao.AddressDAOImpl.removeAddress", address);
        address.setId(-1);
    }

    public void updateAddress(Address address) {
        this.sqlSession.update("im430.xmas.im430.xmas.dao.AddressDAOImpl.updateAddress", address);
    }

    @Transactional(readOnly=true)
    public Address getAddressById(int id) {
        return this.sqlSession.selectOne("im430.xmas.im430.xmas.dao.AddressDAOImpl.getAddressById", id);
    }

    @Transactional(readOnly=true)
    public List<Address> getAllAddresses() {
        return sqlSession.selectList("im430.xmas.im430.xmas.dao.AddressDAOImpl.getAllAddresses");
    }
}
