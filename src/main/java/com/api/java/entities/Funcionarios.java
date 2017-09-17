package com.api.java.entities;

import com.api.java.enums.PerfilEnum;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "funcionario")
public class Funcionarios implements Serializable {


    private long id;
    private String Nome;
    private String email;
    private String Senha;
    private String cpf;

    private BigDecimal valorHora;
    private float horasTrabalhadas;
    private float horasAlmoco;
    private PerfilEnum perfil;
    private Date dataCriacao;
    private  Date dataAtualizacao;
    private Empresa Empresa;

    private List<Lancamentos> lancamentos;


    public Funcionarios(){

    }


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    @Column(name = "nome", nullable = false)
    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }


    @Column(name = "email", nullable = false)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Column(name = "senha", nullable = false)
    public String getSenha() {
        return Senha;
    }

    public void setSenha(String senha) {
        Senha = senha;
    }


    @Column(name = "cpf", nullable = false)
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }


    @Column(name = "valorHora", nullable = true)
    public BigDecimal getValorHora() {
        return valorHora;
    }

    public void setValorHora(BigDecimal valorHora) {
        this.valorHora = valorHora;
    }

    @Column(name = "horaTrabalha", nullable = false)
    public float getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas(float horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }

    @Column(name = "horasAlmoco", nullable = false)
    public float getHorasAlmoco() {
        return horasAlmoco;
    }

    public void setHorasAlmoco(float horasAlmoco) {
        this.horasAlmoco = horasAlmoco;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "perfil", nullable = false)
    public PerfilEnum getPerfil() {
        return perfil;
    }

    public void setPerfil(PerfilEnum perfil) {
        this.perfil = perfil;
    }

    @Column(name = "dataCriacao", nullable = false)
    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    @Column(name = "dataAtualizacao", nullable = false)
    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Date dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }


    @ManyToOne(fetch = FetchType.EAGER)
    public com.api.java.entities.Empresa getEmpresa() {
        return Empresa;
    }

    public void setEmpresa(com.api.java.entities.Empresa empresa) {
        Empresa = empresa;
    }

    @OneToMany(mappedBy = "funcionario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public List<Lancamentos> getLancamentos() {
        return lancamentos;
    }

    public void setLancamentos(List<Lancamentos> lancamentos) {
        this.lancamentos = lancamentos;
    }

    @PreUpdate
    public void preUpdate(){

        Date dataAtualização = new Date();

    }

    @PrePersist
    public void prePersist(){
        final Date atual = new Date();
        dataCriacao = atual;
        Date dataAtualização = atual;
    }

    @Override
    public String toString() {
        return "Funcionarios{" +
                "id=" + id +
                ", Nome='" + Nome + '\'' +
                ", email='" + email + '\'' +
                ", Senha='" + Senha + '\'' +
                ", cpf='" + cpf + '\'' +
                ", valorHora=" + valorHora +
                ", horasTrabalhadas=" + horasTrabalhadas +
                ", horasAlmoco=" + horasAlmoco +
                ", perfil=" + perfil +
                ", dataCriacao=" + dataCriacao +
                ", dataAtualizacao=" + dataAtualizacao +
                ", Empresa=" + Empresa +
                ", lancamentos=" + lancamentos +
                '}';
    }
}
