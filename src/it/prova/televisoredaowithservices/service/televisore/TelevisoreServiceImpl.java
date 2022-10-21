package it.prova.televisoredaowithservices.service.televisore;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import it.prova.televisoredaowithservices.connection.MyConnection;
import it.prova.televisoredaowithservices.dao.Constants;
import it.prova.televisoredaowithservices.model.Televisore;
import it.prova.televisoredaowithservices.dao.televisore.TelevisoreDAO;

public class TelevisoreServiceImpl implements TelevisoreService {

	private TelevisoreDAO televisoreDAO;

	public void setTelevisoreDAO(TelevisoreDAO televisoreDAO) {
		this.televisoreDAO = televisoreDAO;
	}

	@Override
	public List<Televisore> listAll() throws Exception {
		List<Televisore> result = new ArrayList<>();
		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			televisoreDAO.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = televisoreDAO.list();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public Televisore findById(Long idInput) throws Exception {
		Televisore result = null;
		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			televisoreDAO.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = televisoreDAO.get(idInput);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public int aggiorna(Televisore input) throws Exception {
		int result = 0;
		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			televisoreDAO.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = televisoreDAO.update(input);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public int inserisciNuovo(Televisore input) throws Exception {
		int result = 0;
		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			televisoreDAO.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = televisoreDAO.insert(input);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public int rimuovi(Televisore input) throws Exception {
		int result = 0;
		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			televisoreDAO.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = televisoreDAO.delete(input);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public List<Televisore> findByExample(Televisore input) throws Exception {
		List<Televisore> result = new ArrayList<>();
		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			televisoreDAO.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = televisoreDAO.findByExample(input);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public List<Televisore> voglioTuttiITelevisoriProdottiTra(Date dataMin, Date dataMax) throws Exception {
		List<Televisore> result = new ArrayList<>();
		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			televisoreDAO.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = televisoreDAO.voglioTuttiITelevisoriProdottiTra(dataMin, dataMax);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public Televisore voglioIlTelevisorePiuGrande() throws Exception {
		Televisore result = null;
		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			televisoreDAO.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = televisoreDAO.voglioIlTelevisorePiuGrande();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public List<String> voglioLaListaDelleMarcheDiTVProdottiNegliUltimi6Mesi(Date data) throws Exception {
		List<String> result = new ArrayList<>();
		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			televisoreDAO.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = televisoreDAO.voglioLaListaDelleMarcheDiTVProdottiNegliUltimi6Mesi(data);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public int deleteAll() throws Exception {
		int result = 0;
		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			televisoreDAO.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = televisoreDAO.deleteAll();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

}
