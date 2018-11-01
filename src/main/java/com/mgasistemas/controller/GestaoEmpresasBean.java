package com.mgasistemas.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.convert.Converter;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.mgasistemas.model.Empresa;
import com.mgasistemas.model.RamoAtividade;
import com.mgasistemas.model.TipoEmpresa;
import com.mgasistemas.repository.Empresas;
import com.mgasistemas.repository.RamoAtividades;
import com.mgasistemas.service.CadastroEmpresaService;
import com.mgasistemas.util.FacesMessages;

@Named
@ViewScoped
public class GestaoEmpresasBean implements Serializable {

	private static final long serialVersionUID = 1L;
	@Inject
	private CadastroEmpresaService cadastroEmpresaService;

	@Inject
	private Empresas empresas;

	@Inject
	private FacesMessages messages;

	@Inject
	private RamoAtividades ramoAtividades;

	private List<Empresa> listaEmpresas;

	private Empresa empresa;

	private String termoPesquisa;

	private Converter ramoAtividadeConverter;

	private boolean jaHouvePesquisa() {
        return termoPesquisa != null && !"".equals(termoPesquisa);
}

	public void prepararNovaEmpresa() {
		empresa = new Empresa();
	}

	public void salvar() {
		cadastroEmpresaService.salvar(empresa);
		if(jaHouvePesquisa()) {
			pesquisar();
		}
		
		messages.info("Empresa cadastrada com Sucesso");
	}

	public void pesquisar() {
		listaEmpresas = empresas.pesquisar(termoPesquisa);

		if (listaEmpresas.isEmpty()) {
			messages.info("Sua consulta não retornou registros.");
		}
	}

	public void todasEmpresas() {
		listaEmpresas = empresas.todas();
	}

	public List<RamoAtividade> completarRamoAtividade(String termo) {
		List<RamoAtividade> listaRamoAtividades = ramoAtividades.pesquisar(termo);

		ramoAtividadeConverter = new RamoAtividadeConverter(listaRamoAtividades);

		return listaRamoAtividades;
	}

	public List<Empresa> getListaEmpresas() {
		return listaEmpresas;
	}

	public String getTermoPesquisa() {
		return termoPesquisa;
	}

	public void setTermoPesquisa(String termoPesquisa) {
		this.termoPesquisa = termoPesquisa;
	}

	public TipoEmpresa[] getTiposEmpresa() {
		return TipoEmpresa.values();
	}

	public Converter getRamoAtividadeConverter() {
		return ramoAtividadeConverter;
	}

	public Empresa getEmpresa() {
		return empresa;
	}
}