package it.prova.televisoredaowithservices.dao.televisore;

import java.util.Date;
import java.util.List;

import it.prova.televisoredaowithservices.dao.IBaseDAO;
import it.prova.televisoredaowithservices.model.Televisore;

public interface TelevisoreDAO extends IBaseDAO<Televisore> {
	public List<Televisore> voglioTuttiITelevisoriProdottiTra(Date dataMin, Date dataMax) throws Exception;

	public Televisore voglioIlTelevisorePiuGrande() throws Exception;

	public List<Televisore> voglioLaListaDelleMarcheDiTVProdottiNegliUltimi6Mesi(Date data) throws Exception;
	
	public int deleteAll() throws Exception;

}
