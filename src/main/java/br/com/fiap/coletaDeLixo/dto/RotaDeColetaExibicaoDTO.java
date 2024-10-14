package br.com.fiap.coletaDeLixo.dto;

import br.com.fiap.coletaDeLixo.model.RotaDeColeta;

import javax.xml.crypto.Data;

public record RotaDeColetaExibicaoDTO(
        Long rotaID,
        String nomeDaRota,
        Data dataDaColeta,
        Data horaDeInicio,
        Data horaDeTermino,
        String distanciaRota,
        String tipoDeRota,
        String frequenciaDaRota) {
    public RotaDeColetaExibicaoDTO(RotaDeColeta rotaDeColeta){
        this(
                rotaDeColeta.getRotaID(),
                rotaDeColeta.getNomeDaRota(),
                (Data) rotaDeColeta.getDataDaColeta(),
                (Data) rotaDeColeta.getHoraDeInicio(),
                (Data) rotaDeColeta.getHoraDeTermino(),
                rotaDeColeta.getDistanciaRota(),
                rotaDeColeta.getTipoDeRota(),
                rotaDeColeta.getFrequenciaDaRota());
    }
}
