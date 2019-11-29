package im430.xmas.dao.gift;

import im430.xmas.business.Gift;

import java.util.List;

public interface GiftDAO {
    void addGift(Gift gift);
    void removeGift(Gift gift);
    void updateGift(Gift gift);
    Gift getGiftById(int id);
    List<Gift> getAllGifts();
}
