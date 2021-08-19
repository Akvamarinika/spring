package many_to_many;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.*;

import static org.junit.Assert.*;

public class ManyToManyTest {
    EntityManagerFactory factory;
    EntityManager manager;

    @Before
    public void setUp() {
        factory = Persistence.createEntityManagerFactory("QuickStart");
        manager = factory.createEntityManager();
        manager.getTransaction().begin();
    }

    @After
    public void tearDown() {
        manager.getTransaction().commit();
        factory.close();
    }

    @Test
    public void saveSectionWithChildren(){
        Child child = new Child("Ivan", 7);
        Child child2 = new Child("Masha", 10);
        Child child3 = new Child("Pavlik", 5);
        Child child4 = new Child("Misha", 8);
        Child child5 = new Child("Igor", 7);

        Section section = new Section("Football");
        Section section2 = new Section("Dance");
        Section section3 = new Section("Chess");

        section.addChild(child);
        section.addChild(child2);
        section2.addChild(child3);
        section2.addChild(child4);
        section3.addChild(child5);

        manager.persist(section);
        manager.persist(section2);
        manager.persist(section3);
    }

    @Test
    public void saveChildWithSections(){
        Child child = new Child("Sasha", 11);

        Section section = new Section("Volleyball");
        Section section2 = new Section("Swimming");
        Section section3 = new Section("Painting");

        child.addSection(section);
        child.addSection(section2);
        child.addSection(section3);

        manager.persist(child);
    }

    @Test
    public void deleteChildWithoutSection(){
        TypedQuery<Child> childQuery = manager.createQuery("SELECT child FROM Child child WHERE child.name = 'Sasha'", Child.class);
        childQuery.getResultStream()
                .forEach(c -> manager.remove(c));
    }

    @Test
    public void deleteSectionWithoutChildren(){
        TypedQuery<Section> sectionTypedQuery = manager.createQuery("SELECT s FROM Section s WHERE s.name=:sectionName", Section.class);
        sectionTypedQuery.setParameter("sectionName", "Football");
        Section section = sectionTypedQuery.getSingleResult();

        manager.remove(section);
    }
}