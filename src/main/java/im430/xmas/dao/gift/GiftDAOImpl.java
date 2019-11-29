package im430.xmas.dao.gift;

import im430.xmas.business.Gift;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Resource
@Transactional
public class GiftDAOImpl implements GiftDAO {

    @Autowired
    private SqlSession sqlSession;

    public void addGift(Gift gift) {
        this.sqlSession.insert("im430.xmas.dao.gift.GiftDAO.addGift", gift);
    }

    public void removeGift(Gift gift) {
        this.sqlSession.delete("im430.xmas.dao.gift.GiftDAO.removeGift", gift);
        gift.setId(-1);
    }

    public void updateGift(Gift gift) {
        this.sqlSession.update("im430.xmas.dao.gift.GiftDAO.updateGift", gift);
    }

    @Transactional(readOnly=true)
    public Gift getGiftById(int id) {
        return this.sqlSession.selectOne("im430.xmas.dao.gift.GiftDAO.getGiftById");
    }

    @Transactional(readOnly=true)
    public List<Gift> getAllGifts() {
        return this.sqlSession.selectList("im430.xmas.dao.gift.GiftDAO.getAllGifts");
    }
}
