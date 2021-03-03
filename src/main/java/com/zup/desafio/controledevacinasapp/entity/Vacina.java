package com.zup.desafio.controledevacinasapp.entity;



import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "VACINA")
public class Vacina{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email_usuario", nullable = false)
    private String email;

    @Column(nullable = false)
    private String nomeVacina;

    @Column(nullable = false)
    private LocalDate dataVacinacao;




    public Vacina() {
    }

    public Vacina(String nomeVacina, LocalDate dataVacinacao, String email) {
        this.nomeVacina = nomeVacina;
        this.dataVacinacao = dataVacinacao;
        this.email = email;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeVacina() {
        return nomeVacina;
    }

    public void setNomeVacina(String nomeVacina) {
        this.nomeVacina = nomeVacina;
    }

    public LocalDate getDataVacinacao() {
        return dataVacinacao;
    }

    public void setDataVacinacao(LocalDate dataVacinacao) {
        this.dataVacinacao = dataVacinacao;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vacina)) return false;
        Vacina vacina = (Vacina) o;
        return id.equals(vacina.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
