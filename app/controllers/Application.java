package controllers;

import models.Meta;
import models.dao.GenericDAO;
import play.data.DynamicForm;
import play.data.Form;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

import java.util.List;

public class Application extends Controller {


    private static final GenericDAO dao = new GenericDAO();

    @Transactional
    public static Result index() {
        List<Meta> metas = dao.findAllByClassName(Meta.class.getName());
        return ok(index.render(metas));
    }

    @Transactional
    public static Result criaMeta(){
        DynamicForm form = Form.form().bindFromRequest();

        String nome = form.get("Nome");
        String prazo = form.get("Prazo");
        String descricao = form.get("Descricao");
        Meta.Prioridade prioridade = Meta.Prioridade.valueOf(form.get("Prioridade"));

        Meta meta = new Meta(nome, descricao, prioridade, prazo);
        dao.persist(meta);

        List<Meta> metas = dao.findAllByClassName(Meta.class.getName());
        return ok(index.render(metas));
    }

    @Transactional
    public static Result alteraMeta(long id){
        Meta meta = dao.findByEntityId(Meta.class, id);
        meta.setStatus(Meta.Status.cumprida);
        dao.merge(meta);
        return index();
    }

    @Transactional
    public static Result deletaMeta(long id){
        dao.removeById(Meta.class, id);
        return index();
    }
}

