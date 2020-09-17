/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entity;

/**
 *
 * @author Jean
 */
public class Painel {
        private String regiao;
        private String estado;
        private String municipio;
        private String data;
        private int casosacumulado;
        private int obitosacumulado;
        private int recuperadosnovos;

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getCasosAcumulado() {
        return casosacumulado;
    }

    public void setCasosAcumulado(int casosAcumulado) {
        this.casosacumulado = casosAcumulado;
    }

    public int getObitosAcumulado() {
        return obitosacumulado;
    }

    public void setObitosAcumulado(int obitosAcumulado) {
        this.obitosacumulado = obitosAcumulado;
    }

    public int getRecuperadosnovos() {
        return recuperadosnovos;
    }

    public void setRecuperadosnovos(int recuperadosnovos) {
        this.recuperadosnovos = recuperadosnovos;
    }
         
         
}
