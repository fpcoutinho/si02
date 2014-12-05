package models;

/**
 * Created by Filipe on 24/11/2014.
 */
import java.util.GregorianCalendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Meta{
    @Id
    @GeneratedValue
    private long id;

    private String nome;
    private String descricao;
    private int prioridade;
    private GregorianCalendar data;


    public Meta(String nome, String descricao, int prioridade, GregorianCalendar data) {
        this.nome = nome;
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.data = data;
    }

    public Meta() {
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public GregorianCalendar getData() {
        return data;
    }

}
