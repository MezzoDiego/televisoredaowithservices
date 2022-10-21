package it.prova.televisoredaowithservices.service.televisore;

import java.util.Date;
import java.util.List;

import it.prova.televisoredaowithservices.dao.televisore.TelevisoreDAO;
import it.prova.televisoredaowithservices.model.Televisore;

public interface TelevisoreService {
	// questo mi serve per injection
	public void setTelevisoreDAO(TelevisoreDAO televisoreDAO);

	public List<Televisore> listAll() throws Exception;

	public Televisore findById(Long idInput) throws Exception;

	public int aggiorna(Televisore input) throws Exception;

	public int inserisciNuovo(Televisore input) throws Exception;

	public int rimuovi(Televisore input) throws Exception;

	public List<Televisore> findByExample(Televisore input) throws Exception;
	
	public List<Televisore> voglioTuttiITelevisoriProdottiTra (Date dataMin , Date dataMax) throws Exception;
	
	public Televisore voglioIlTelevisorePiuGrande() throws Exception;
	
	public List<String> voglioLaListaDelleMarcheDiTVProdottiNegliUltimi6Mesi(Date data) throws Exception;
	
	public int deleteAll() throws Exception;
}
