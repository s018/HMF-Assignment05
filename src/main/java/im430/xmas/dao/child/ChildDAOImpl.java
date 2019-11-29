package im430.xmas.dao.child;

import im430.xmas.business.Child;
import im430.xmas.business.Gift;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Resource
@Transactional
public class ChildDAOImpl implements ChildDAO {

    @Autowired
    private SqlSession sqlSession;


    public void addChild(Child child) {
        this.sqlSession.insert("im430.xmas.dao.child.ChildDAO.addChild", child);
    }

    public void removeChild(Child child) {
        this.sqlSession.delete("im430.xmas.dao.child.ChildDAO.removeChild", child);
        child.setId(-1);
    }

    public void updateChild(Child child) {
        this.sqlSession.update("im430.xmas.dao.child.ChildDAO.updateChild", child);
    }

    @Transactional(readOnly=true)
    public Child getChildById(int id) {
        return this.sqlSession.selectOne("im430.xmas.dao.child.ChildDAO.getChildById", id);
    }

    @Transactional(readOnly=true)
    public List<Child> getAllChildren() {
        return this.sqlSession.selectList("im430.xmas.dao.child.ChildDAO.getAllChildren");
    }

    @Override
    @Transactional
    public void addGift(Child child, Gift gift) {
        Map<String, Object> sqlParameters = new HashMap<String, Object>();
        sqlParameters.put("child", child);
        sqlParameters.put("gift", gift);

        this.sqlSession.insert("im430.xmas.dao.child.ChildDAO.addGift",
                sqlParameters);
        child.getGifts().add(gift);
    }

    @Override
    @Transactional
    public void removeGift(Child child, Gift gift) {
        this.sqlSession.delete("im430.xmas.dao.child.ChildDAO.removeGift", gift);
        child.getGifts().remove(gift);
    }
}
