package com.example.consulta.model;

public class pecas {

    private String MainDMCHous; // Tampa Bruta
    private String MainDMCCover;// Front Cover Bruto
    private String MainFinalDMC;// Front Cover Final
    private String Aprovado; //status Final FC
    private String SerialUsinagem; //serial Usinagem
    private String OperadorUsinagem; //operador Usinagem
    private String HoraUsinagem; // hora Usinagem
    private String MaquinaUsinagem; // maquina usinagem
    private String OperadorInjecao; // operador Injecao
    private String HoraInjecao;// hora injecao
    private String MaquinaInjecao; // maquina injecao


    public String getHoraFinal() {
        return HoraFinal;
    }

    public void setHoraFinal(String horaFinal) {
        HoraFinal = horaFinal;
    }

    public String getOperadorFinal() {
        return OperadorFinal;
    }

    public void setOperadorFinal(String operadorFinal) {
        OperadorFinal = operadorFinal;
    }

    public String getOperadorUsinagem() {
        return OperadorUsinagem;
    }

    public void setOperadorUsinagem(String operadorUsinagem) {
        OperadorUsinagem = operadorUsinagem;
    }

    public String getHoraUsinagem() {
        return HoraUsinagem;
    }

    public void setHoraUsinagem(String horaUsinagem) {
        HoraUsinagem = horaUsinagem;
    }

    public String getOperadorInjecao() {
        return OperadorInjecao;
    }

    public void setOperadorInjecao(String operadorInjecao) {
        OperadorInjecao = operadorInjecao;
    }

    public String getHoraInjecao() {
        return HoraInjecao;
    }

    public void setHoraInjecao(String horaInjecao) {
        HoraInjecao = horaInjecao;
    }

    private String HoraFinal; //hora inspecao Final
    private String OperadorFinal; //operador inspecao

    public String getSerialUsinagem() {
        return SerialUsinagem;
    }

    public void setSerialUsinagem(String serialUsinagem) {
        SerialUsinagem = serialUsinagem;
    }


    public String getMaquinaUsinagem() {
        return MaquinaUsinagem;
    }

    public void setMaquinaUsinagem(String maquinaUsinagem) {
        MaquinaUsinagem = maquinaUsinagem;
    }

    public String getMaquinaInjecao() {
        return MaquinaInjecao;
    }

    public void setMaquinaInjecao(String maquinaInjecao) {
        MaquinaInjecao = maquinaInjecao;
    }


    public String getMainDMCHous() {
        return MainDMCHous;
    }

    public void setMainDMCHous(String mainDMCHous) {
        MainDMCHous = mainDMCHous;
    }

    public String getMainDMCCover() {
        return MainDMCCover;
    }

    public void setMainDMCCover(String mainDMCCover) {
        MainDMCCover = mainDMCCover;
    }

    public String getMainFinalDMC() {
        return MainFinalDMC;
    }

    public void setMainFinalDMC(String mainFinalDMC) {
        MainFinalDMC = mainFinalDMC;
    }

    public String getAprovado() {
        return Aprovado;
    }

    public void setAprovado(String aprovado) {
        Aprovado = aprovado;
    }
}
