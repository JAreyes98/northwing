package com.jdreyes.northwindjsf.bean;

import com.jdreyes.northwindjsf.model.dto.Cliente;
import com.jdreyes.northwindjsf.model.entity.Region;
import com.jdreyes.northwindjsf.model.entity.Territorio;
import com.jdreyes.northwindjsf.rest.RestClient;
import com.jdreyes.northwindjsf.service.RegionService;
import com.jdreyes.northwindjsf.service.TerritorioService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Scope("session")
@Component
public class BaseBackbean implements Serializable {


    private List<Territorio> territorios;
    private List<Region> regiones;

    private Integer id;
    private String nombre;
    private Region somRegion;

    private final TerritorioService territorioService;
    private final RegionService regionService;

    private final RestClient restClient;

    private List<Cliente> clientes;

    @Autowired
    public BaseBackbean(TerritorioService territorioService, RegionService regionService, RestClient restClient) {
        this.territorioService = territorioService;
        this.regionService = regionService;
        this.restClient = restClient;
    }

    @PostConstruct
    private void init() {
        reloadTerritorios();
        regiones = regionService.obtenerRegiones();
    }

    private void reloadTerritorios() {
        territorios = territorioService.obtenerTerritorio();
    }

    private void loadFromAPI() {
        clientes = restClient.get("")
    }

    public void guardar() {
        Territorio territorio = new Territorio();
        territorio.setIdTerritorio(id);
        territorio.setDescTerritorio(nombre);
        territorio.setRegion(somRegion);
        territorioService.nuevaTerritorio(territorio);

//        FacesContext.getCurrentInstance().addMessage("Guardado", FacesMessage.FACES_MESSAGES.);
    }




}
