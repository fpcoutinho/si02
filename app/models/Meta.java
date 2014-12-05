package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Erick on 20/11/2014.
 */

@Entity
public class Meta {

    public static enum Status { cumprida, emProcesso }
    public static enum Prioridade {

        alta("Alta"), media("Media"), baixa("Baixa");
        private String valor;

        Prioridade(String valor) {
            this.valor = valor;
        }
    }

    @Id
    @GeneratedValue
    private Long id;

    private String nome;
    private String prazo;
    private Status status;
    private String descricao;
    private Prioridade prioridade;


    public Meta(String nome, String descricao, Prioridade prioridade, String prazo) {
        this.nome = nome;
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.prazo = prazo;
        this.status = status.emProcesso;
    }

    public Meta() {
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getDescricao() {
        return descricao;
    }

    public Prioridade getPrioridade() {
       return prioridade;
    }

    public String getPrazo() {
        return prazo;
    }

}

