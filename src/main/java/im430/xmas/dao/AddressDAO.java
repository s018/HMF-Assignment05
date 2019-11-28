package im430.xmas.dao;

import im430.xmas.business.Address;

import java.util.List;

public interface AddressDAO {
    void addAddress(Address address);
    void removeAddress(Address address);
    void updateAddress(Address address);
    Address getAddressById(int id);
    List<Address> getAllAddresses();
}
