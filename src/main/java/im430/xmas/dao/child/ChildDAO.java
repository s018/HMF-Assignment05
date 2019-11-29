package im430.xmas.dao.child;

import im430.xmas.business.Child;
import im430.xmas.business.Gift;

import java.util.List;

public interface ChildDAO {
    void addChild(Child child);
    void removeChild(Child child);
    void updateChild(Child child);
    Child getChildById(int id);
    List<Child> getAllChildren();
    void addGift(Child child, Gift gift); // save unpersisted gifts automatically
    void removeGift(Child child, Gift gift);
}
