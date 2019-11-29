package im430.xmas.dao.gift;

import im430.xmas.business.Child;
import im430.xmas.business.Gift;
import im430.xmas.dao.child.ChildDAO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration
class GiftDAOTest {

    @Autowired
    private GiftDAO giftDAO;

    @Autowired
    ChildDAO childDAO;

    @Test
    @Transactional(readOnly = true)
    void testGetAllGifts() {
        final List<Gift> gifts = giftDAO.getAllGifts();

        assertNotNull(gifts);
        assertEquals(3, gifts.size());
    }

    @Test
    @Transactional(readOnly = true)
    void testGetGiftById() {
        final int giftId = 1;

        Gift gift = giftDAO.getGiftById(giftId);

        assertNotNull(gift);
        assertEquals(giftId, gift.getId());
        assertEquals("iPhone X", gift.getDescription());
        assertNotNull(gift.getChild());
    }

    @Test
    @Transactional
    @Rollback
    void testInsertGift() {
        final Child child = childDAO.getChildById(3);
        final Gift gift = new Gift("Test", child);

        giftDAO.addGift(gift);

        final Gift readGift = giftDAO.getGiftById(gift.getId());
        assertEquals(gift.getDescription(), readGift.getDescription());
        assertEquals(gift.getChild(), readGift.getChild());
    }

    @Test
    @Transactional
    @Rollback
    void testUpdatePropertyGift() {
        final Gift gift = giftDAO.getGiftById(1);

        gift.setDescription("Test");
        giftDAO.updateGift(gift);

        final Gift readGift = giftDAO.getGiftById(gift.getId());
        assertEquals(gift.getDescription(), readGift.getDescription());
        assertEquals(gift.getChild(), readGift.getChild());
    }

    @Test
    @Transactional
    @Rollback
    void testUpdateAssociationGift() {
        final Child child = childDAO.getChildById(3);
        final Gift gift = giftDAO.getGiftById(1);

        gift.setChild(child);
        giftDAO.updateGift(gift);

        final Gift readGift = giftDAO.getGiftById(gift.getId());
        assertEquals(gift.getId(), readGift.getId());
        assertEquals(gift.getDescription(), readGift.getDescription());
        assertEquals(gift.getChild(), readGift.getChild());
    }

    @Test
    @Transactional
    @Rollback
    void testRemoveGift() {
        final Gift gift = giftDAO.getGiftById(1);
        final int giftIdBeforeDelete = gift.getId();

        giftDAO.removeGift(gift);

        assertEquals(-1, gift.getId());
        assertNull(giftDAO.getGiftById(giftIdBeforeDelete));
    }
}
