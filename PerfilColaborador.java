public class PerfilColaborador {

    private String nome;
    private String E_mail;
    private String nivel;
    private String dataNascimento;
    private String cpf;

    //--------------Geters--------------

    public String getNome() {
        return nome;
    }
    public String getE_mail() {
        return E_mail;
    }
    public String getNivel() {
        return nivel;
    }
    public String getDataNascimento() {
        return dataNascimento;
    }
    public String getCpf() {
        return cpf;
    }

    //--------------Seters--------------

    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setE_mail(String e_mail) {
        E_mail = e_mail;
    }
    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
