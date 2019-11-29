package im430.xmas.dao.child;

import im430.xmas.business.Address;
import im430.xmas.business.Child;
import im430.xmas.business.Gift;
import im430.xmas.dao.address.AddressDAO;
import im430.xmas.dao.gift.GiftDAO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@ContextConfiguration
class ChildDAOTest {

    @Autowired
    private ChildDAO childDAO;

    @Autowired
    private AddressDAO addressDAO;

    @Test
    void testInsertChild() {
        final Child child = new Child();
        child.setId(1);
        child.setName("Thomas");
        Address address = addressDAO.getAddressById(3);
        child.setAddress(address);
        int size = childDAO.getAllChildren().size();
        childDAO.addChild(child);
        assertEquals(size+1, childDAO.getAllChildren().size());

    }

    @Test
    void testGetAllChildren() {
        List<Child> allChildren = childDAO.getAllChildren();
        int size = allChildren.size();
        Child thomas = allChildren.get(size-1);

        assertEquals("Thomas", thomas.getName());
        assertEquals(3, thomas.getAddress().getId());
    }

    @Test
    void testGetChildById() {
        int id = 3;

        Child child = childDAO.getChildById(id);

        Address address = addressDAO.getAddressById(3);
        assertEquals(id, child.getId());
        Child richard = new Child();
        richard.setName("Richard");
        richard.setAddress(address);
        childDAO.addChild(richard);

        Child readRichard = childDAO.getChildById(richard.getId());
        assertEquals(richard.getId(), readRichard.getId());
    }

    @Test
    void testUpdateChild() {
        List<Child> children = childDAO.getAllChildren();
        int size = children.size();
        Child richard = children.get(size-1);
        richard.setName("Richard Josef");
        childDAO.updateChild(richard);

        assertEquals(size, childDAO.getAllChildren().size());
        Child readRichardThomas = childDAO.getChildById(richard.getId());
        assertEquals("Richard Josef", readRichardThomas.getName());
    }

    @Test
    void testRemoveChild() {
        List<Child> children = childDAO.getAllChildren();
        int size = children.size();
        Child richard = children.get(size-1);
        assertEquals("Richard Josef", richard.getName());
        childDAO.removeChild(richard);

        children = childDAO.getAllChildren();
        assertEquals(size-1, children.size());
        Child thomas = children.get(size-2);
        assertEquals("Thomas", thomas.getName());
        childDAO.removeChild(thomas);
        children = childDAO.getAllChildren();
        assertEquals(size-2, children.size());
    }
}
