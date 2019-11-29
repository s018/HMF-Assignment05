package im430.xmas.dao.address;

import im430.xmas.business.Address;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@ContextConfiguration
@Transactional()
class AddressDAOTest {

    @Autowired
    private AddressDAO addressDAO;

    @Test
    void testGetAllAddresses() {
        List<Address> addresses = addressDAO.getAllAddresses();

        assertNotNull(addresses);
        assertEquals(2, addresses.size());
    }

    @Test
    void testGetAddressById() {
        final int addressId = 1;

        Address address = addressDAO.getAddressById(addressId);

        assertNotNull(address);
        assertEquals(addressId, address.getId());
        assertEquals("Softwarepark 41, 4232 Hagenberg i. M.", address.getText());
    }

    @Test
    @Rollback
    void testInsertAddress() {
        final Address address = new Address("Softwarepark 41, 4232 Hagenberg i. M.");
        final int numberOfRowsBeforeInsert = addressDAO.getAllAddresses().size();

        addressDAO.addAddress(address);

        assertEquals(numberOfRowsBeforeInsert + 1, addressDAO.getAllAddresses().size());
    }

    @Test
    @Rollback
    void testUpdateAddress() {
        final int addressId = 1;

        Address address = addressDAO.getAddressById(addressId);

        assertNotNull(address);
        assertEquals("Softwarepark 41, 4232 Hagenberg i. M.", address.getText());

        address.setText("Rosenweg 1, 4064 Oftering");
        addressDAO.updateAddress(address);

        address = addressDAO.getAddressById(addressId);

        assertNotNull(address);
        assertEquals("Rosenweg 1, 4064 Oftering", address.getText());
    }

    @Test
    @Rollback
    void testRemoveAddress() {
        final Address address = new Address("Softwarepark 41, 4232 Hagenberg i. M.");

        final int numberOfRowsBeforeInsert = addressDAO.getAllAddresses().size();

        addressDAO.addAddress(address);

        assertEquals(numberOfRowsBeforeInsert + 1, addressDAO.getAllAddresses().size());
    }
}
