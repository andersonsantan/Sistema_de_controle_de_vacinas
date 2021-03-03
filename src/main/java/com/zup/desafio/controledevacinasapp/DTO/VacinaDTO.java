package com.zup.desafio.controledevacinasapp.DTO;



import com.zup.desafio.controledevacinasapp.entity.Vacina;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Objects;


public class VacinaDTO {

    private Long id;

    @NotBlank(message = "Digite um email")
    @Email(message = "Por favor, digite um email válido.")
    private String email;

    @NotBlank(message = "Digite o nome da vacina")
    private String nomeVacina;

    @NotNull(message = "A data da vacinação é um campo obrigatório")
    private LocalDate dataVacinacao;


    public VacinaDTO() {
    }

    public VacinaDTO(String email, String nomeVacina, LocalDate dataVacinacao) {
        this.email = email;
        this.nomeVacina = nomeVacina;
        this.dataVacinacao = dataVacinacao;
    }

    public Vacina dtoParaVacina(){
        return new Vacina(nomeVacina, dataVacinacao,  email);
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
        if (!(o instanceof VacinaDTO)) return false;
        VacinaDTO vacinaDTO = (VacinaDTO) o;
        return Objects.equals(getId(), vacinaDTO.getId()) && Objects.equals(getEmail(), vacinaDTO.getEmail()) && Objects.equals(getNomeVacina(), vacinaDTO.getNomeVacina()) && Objects.equals(getDataVacinacao(), vacinaDTO.getDataVacinacao());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getEmail(), getNomeVacina(), getDataVacinacao());
    }
}
