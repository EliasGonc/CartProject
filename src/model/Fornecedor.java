package model;

import utils.EstadoInvalidoException;
import utils.ValorNegativoException;

import java.util.Objects;

public class Fornecedor {
    private int codigo;
    private String razaoSocial;
    private String endereco;
    private String cidade;
    private String estado;
    private Contato contato;

    public Fornecedor(int codigo, String razaoSocial, String endereco, String cidade, String estado, Contato contato) throws ValorNegativoException, EstadoInvalidoException {
        setCodigo(codigo);
        this.razaoSocial = razaoSocial;
        this.endereco = endereco;
        this.cidade = cidade;
        setEstado(estado);
        this.contato = contato;
        contato = new Contato();
    }

    public Fornecedor(int codigo, String razaoSocial, String endereco, Contato contato) throws ValorNegativoException {
        setCodigo(codigo);
        this.razaoSocial = razaoSocial;
        this.endereco = endereco;
        this.contato = contato;
        cidade = "Mogi Mirim";
        estado = "SP";
        contato = new Contato();
    }

    public Fornecedor() {
        contato = new Contato();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) throws ValorNegativoException {
        if(codigo < 0) {
            throw new ValorNegativoException();
        } else {
            this.codigo = codigo;
        }
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) throws EstadoInvalidoException {
        if(estado.length() != 2 || !estado.equals(estado.toUpperCase())) {
            throw new EstadoInvalidoException();
        } else {
            this.estado = estado;
        }
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    @Override
    public String toString() {
        return "(" + codigo + ") " + razaoSocial + "; " + endereco + "; "
                + cidade + "/" + estado + "; Contato: " + contato;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fornecedor that = (Fornecedor) o;
        return codigo == that.codigo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
}
