import play.*;
import models.Meta;
import models.dao.GenericDAO;
import play.db.jpa.JPA;

public class Global extends GlobalSettings {

    private static GenericDAO dao = new GenericDAO();

    public void onStart(Application app) {


        JPA.withTransaction(() -> {
            dao.persist(new Meta("Logica", "Resolver Listas de Logica Matematica.", Meta.Prioridade.media, "1° semana"));

            dao.persist(new Meta("Saúde", "Correr todos os dias da semana as 5h da manha.", Meta.Prioridade.media, "1° semana"));

            dao.persist(new Meta("Saúde", "Comer duas frutas por dia.", Meta.Prioridade.alta, "1° semana"));

            dao.persist(new Meta("Filmes", "Assitir Big Hero 6.", Meta.Prioridade.baixa, "2° semana"));

            dao.persist(new Meta("SI1", "Estudar SI1.", Meta.Prioridade.alta, "2° semana"));

            dao.persist(new Meta("Prob", "Começar a estudar para Probabilidade e Estatistica.", Meta.Prioridade.alta, "1° semana"));

            dao.persist(new Meta("Projeto", "Produzir os materiais do Projeto antes, para folgar um pouco nas ferias.", Meta.Prioridade.media, "3° semana"));

            dao.persist(new Meta("PLP", "Estudar Programacao Funcional para PLP.", Meta.Prioridade.media, "2° semana"));

            dao.persist(new Meta("Ferias", "Sorrir quando chegarem as ferias.", Meta.Prioridade.alta, "3° semana"));

            dao.persist(new Meta("Ferias", "Sorrir outra vez quando chegarem as ferias.", Meta.Prioridade.alta, "3° semana"));
        });
    }
}
