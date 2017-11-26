package iesb.br.escolas;



public class ModeloEscola {

    private int codEscola;
    private String nome;
    private double latitude;
    private double longitude;
    private String email;

    public int getCodEscola() {
        return codEscola;
    }

    public void setCodEscola(int codEscola) {
        this.codEscola = codEscola;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
