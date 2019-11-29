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

    @Autowired
    private GiftDAO giftDAO;

    @Test
    void testInsertChild() {
        final Child child = new Child();
        child.setName("Thomas");
        Address address = addressDAO.getAddressById(3);
        child.setAddress(address);
        childDAO.addChild(child);
        Child readChild = childDAO.getChildById(child.getId());
        assertNotNull(readChild);
        assertEquals("Thomas", readChild.getName());
        assertEquals(3, readChild.getAddress().getId());
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
        final int id = 1;

        Child child = childDAO.getChildById(id);

        Address address = addressDAO.getAddressById(3);
        assertEquals(1, child.getId());
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
    void testAddGift() {
        Gift gift = new Gift();
        gift.setDescription("Tupperware 1");
        giftDAO.addGift(gift);
        List<Child> children = childDAO.getAllChildren();
        Child richard = children.get(children.size()-1);
        childDAO.addGift(richard, gift);

        Child readRichard = childDAO.getChildById(richard.getId());
        assertEquals(richard.getGifts().size(), readRichard.getGifts().size());
        assertEquals(richard.getGifts().get(0).getId(), readRichard.getGifts().get(0).getId());
        
    }
}
