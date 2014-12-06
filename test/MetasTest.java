import static org.fest.assertions.Assertions.*;

import models.Meta;
import models.dao.GenericDAO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import play.GlobalSettings;
import play.db.jpa.JPA;
import play.db.jpa.JPAPlugin;
import play.test.FakeApplication;
import play.test.Helpers;
import scala.Option;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by Filipe on 20/11/14.
 */
public class MetasTest {

    private GenericDAO dao = new GenericDAO();

    @Test
    public void iniciaVzio() throws Exception {
        List<Meta> metas = dao.findAllByClassName(Meta.class.getName());
        assertThat(metas).isEmpty();
    }

    @Test
    public void salvaMetaNoBD() throws Exception {
        Meta meta = new Meta("Logic", "Logica Matematica", Meta.Prioridade.media, "Semana 4");
        dao.persist(meta);

        List<Meta> metas = dao.findAllByClassName(Meta.class.getName());
        assertThat(metas.get(0).getDescricao()).isEqualTo("Logica Matematica");
        
        assertThat(metas.size()).isEqualTo(1);

    }

    public EntityManager em;

    @Before
    public void setUp() {
        FakeApplication app = Helpers.fakeApplication(new GlobalSettings());
        Helpers.start(app);
        Option<JPAPlugin> jpaPlugin = app.getWrappedApplication().plugin(JPAPlugin.class);
        em = jpaPlugin.get().em("default");
        JPA.bindForCurrentThread(em);
        em.getTransaction().begin();
    }

    @After
    public void tearDown() {
        em.getTransaction().commit();
        JPA.bindForCurrentThread(null);
        em.close();
    }

}
