package im430.xmas.dao.child;

import im430.xmas.business.Child;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@ContextConfiguration
class ChildDAOTest {

    @Autowired
    private ChildDAO childDAO;

    @Test
    void testInsertChild() {
        final Child child = new Child();
    }

    @Test
    void testGetAllChildren() {
        List<Child> children = childDAO.getAllChildren();

        assertNotNull(children);
    }

    @Test
    void testGetChildById() {
        final int id = 1;

        Child child = childDAO.getChildById(id);

        assertNotNull(child);
    }
}
