package com.mgasistemas.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.mgasistemas.model.Empresa;
import com.mgasistemas.repository.Empresas;

@Named
@ViewScoped
public class GestaoEmpresasBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Empresas empresas;
	
	
	public void todasEmpresas() {
		listaEmpresas = empresas.todas();
	}
	
	private List<Empresa> listaEmpresas;

	public List<Empresa> getListaEmpresas() {
		return listaEmpresas;
	}

}
