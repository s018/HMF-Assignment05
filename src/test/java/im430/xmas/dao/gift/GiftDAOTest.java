package im430.xmas.dao.gift;

import im430.xmas.business.Child;
import im430.xmas.business.Gift;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@ContextConfiguration
class GiftDAOTest {

    @Autowired
    private GiftDAO giftDAO;

    @Test
    void testGetAllGifts() {
        final List<Gift> gifts = giftDAO.getAllGifts();

        assertNotNull(gifts);
        assertEquals(3, gifts.size());
    }

    @Test
    void testGetGiftById() {
        final int giftId = 1;

        Gift gift = giftDAO.getGiftById(giftId);

        assertNotNull(gift);
        assertEquals(giftId, gift.getId());
        assertEquals("iPhone XL 20 Plus Dreißig ist vierzig", gift.getDescription());
        assertNotNull(gift.getChild());
    }

    @Test
    @Rollback
    void testInsertGift() {
        final Child child = new Child();
        child.setId(1);
        final Gift gift = new Gift("Test", child);

        giftDAO.addGift(gift);

        final Gift readGift = giftDAO.getGiftById(gift.getId());
        assertEquals(gift.getDescription(), readGift.getDescription());
        assertEquals(gift.getChild(), readGift.getChild());
    }

}
