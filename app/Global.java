/*import play.*;
import models.Meta;
import models.dao.GenericDAO;
import play.db.jpa.JPA;

public class Global extends GlobalSettings {

    private static GenericDAO dao = new GenericDAO();

    public void onStart(Application app) {
        Logger.info("Aplicação inicializada...");

        JPA.withTransaction(() -> {
            dao.persist(new Meta("Html", "Aprender html para conseguir pagar SI1", "media", "1° semana"));

            dao.persist(new Meta("Javascript", "Aprender javascript para conseguir pagar SI1", "alta", "1° semana"));

            dao.persist(new Meta("BD", "Aprender BD para conseguir pagar SI1", "media", "2° semana"));

            dao.persist(new Meta("Play", "Aprender a mexer no play framework para conseguir pagar SI1", "baixa", "2° semana"));

            dao.persist(new Meta("Física", "Estudar física para pagar a cadeira por média(ta pau)", "alta", "3° semana"));

            dao.persist(new Meta("Lógica", "Estudar lógica matemática para conseguir uma nota maior na segunda prova", "media", "3° semana"));

            dao.persist(new Meta("Projeto", "Começar a estudar sobre padrões de projeto", "baixa", "3° semana"));

            dao.persist(new Meta("Revisar", "Revisar os assunto aprendidos na semana", "media", "5° semana"));

            dao.persist(new Meta("Período", "Pagar todas as cadeiras do período e conseguir projeto", "alta", "5° semana"));
        });
    }
}
*/