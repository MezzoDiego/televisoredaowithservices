package it.prova.televisoredaowithservices.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import it.prova.televisoredaowithservices.model.Televisore;
import it.prova.televisoredaowithservices.service.MyServiceFactory;
import it.prova.televisoredaowithservices.service.televisore.TelevisoreService;

public class TestTelevisore {

	public static void main(String[] args) {

		TelevisoreService televisoreService = MyServiceFactory.getTelevisoreServiceImpl();

		try {

			System.out.println("------------------------------------------------------------");
			// testInsert(televisoreService);
			System.out.println("------------------------------------------------------------");
			// testUpdate(televisoreService);
			System.out.println("------------------------------------------------------------");
			// testFindByExample(televisoreService);
			System.out.println("------------------------------------------------------------");
			testVoglioTuttiITelevisoriProdottiTra(televisoreService);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void testInsert(TelevisoreService televisoreService) throws Exception {
		System.out.println(".......testInsert inizio.............");
		// faccio la insert e verifico che sia tutto ok
		Date dataProduzione = new SimpleDateFormat("dd-MM-yyyy").parse("03-12-2022");
		Televisore televisoreDaInserire = new Televisore("Sony", "Bravia", 40, dataProduzione);

		if (televisoreService.inserisciNuovo(televisoreDaInserire) != 1)
			throw new RuntimeException("testInserimentoNuovoUser FAILED ");
		// test visivo
		System.out.println(televisoreService.listAll());

		Long idElementoProssimoAllaCancellazione = televisoreService.listAll().get(0).getId();

		// reset tabella
		televisoreService.deleteAll();

		if (televisoreService.findById(idElementoProssimoAllaCancellazione) != null)
			throw new RuntimeException("Si e'verificato un'errore durante la cancellazione della tabella.");

		System.out.println(".......testInsert fine.............");

	}

	private static void testUpdate(TelevisoreService televisoreService) throws Exception {
		System.out.println(".......testUpdate inizio.............");
		// faccio la insert e verifico che sia tutto ok
		Date dataProduzione = new SimpleDateFormat("dd-MM-yyyy").parse("03-12-2022");
		Televisore televisoreDaInserire = new Televisore("Sony", "Bravia", 40, dataProduzione);

		if (televisoreService.inserisciNuovo(televisoreDaInserire) != 1)
			throw new RuntimeException("testInserimentoNuovoUser FAILED ");

		// carico la tabella prima dell'update per test visivo
		System.out.println("before update: " + televisoreService.listAll());

		// eseguo update e verifico che sia tutto ok
		Televisore primoElementoDellaLista = televisoreService.listAll().get(0);
		primoElementoDellaLista.setMarca("Samsung");
		int rowsAffectedUpdate = televisoreService.aggiorna(primoElementoDellaLista);
		if (rowsAffectedUpdate < 1)
			throw new RuntimeException("testUpdate FAILED ");

		// test visivo della tabella dopo l'update
		System.out.println("after update: " + televisoreService.listAll());

		// reset tabella
		int rowsAffected = televisoreService.deleteAll();
		System.out.println("Sono stati rimossi " + rowsAffected + " records.");

		System.out.println(".......testUpdate fine.............");
	}

	private static void testFindByExample(TelevisoreService televisoreService) throws Exception {
		System.out.println(".......testFindByExample inizio.............");
		// inserisco i dati che poi mi aspetto di ritrovare
		Date dataProduzione = new SimpleDateFormat("dd-MM-yyyy").parse("03-12-2022");
		televisoreService.inserisciNuovo(new Televisore("Sony", "Bravia", 40, dataProduzione));
		televisoreService.inserisciNuovo(new Televisore("Samsung", "t5", 50, dataProduzione));

		// preparo un example che ha come marca 's' e ricerco
		List<Televisore> risultatifindByExample = televisoreService.findByExample(new Televisore("s"));
		if (risultatifindByExample.size() != 2)
			throw new RuntimeException("testFindByExample FAILED ");
		// test visivo
		System.out.println(risultatifindByExample);

		// reset tabella
		int rowsAffected = televisoreService.deleteAll();
		System.out.println("Sono stati rimossi " + rowsAffected + " records.");

	}

	private static void testVoglioTuttiITelevisoriProdottiTra(TelevisoreService televisoreService) throws Exception {
		System.out.println(".......testVoglioTuttiITelevisoriProdottiTra inizio.............");

		// faccio la insert e verifico che sia tutto ok
		Date dataProduzione = new SimpleDateFormat("dd-MM-yyyy").parse("03-12-2021");
		Televisore televisoreDaInserire = new Televisore("Sony", "Bravia", 40, dataProduzione);

		if (televisoreService.inserisciNuovo(televisoreDaInserire) != 1)
			throw new RuntimeException("testInserimentoNuovoUser FAILED ");

		// esecuzione query di ricerca
		Date dataProduzioneMin = new SimpleDateFormat("dd-MM-yyyy").parse("01-01-2020");
		Date dataProduzioneMax = new SimpleDateFormat("dd-MM-yyyy").parse("01-01-2023");
		List<Televisore> televisoriAventiDataProduzioneTra = televisoreService
				.voglioTuttiITelevisoriProdottiTra(dataProduzioneMin, dataProduzioneMax);

		// test visivo
		System.out.println(televisoriAventiDataProduzioneTra);

		// reset tabella
		int rowsAffected = televisoreService.deleteAll();
		System.out.println("Sono stati rimossi " + rowsAffected + " records.");

		System.out.println(".......testVoglioTuttiITelevisoriProdottiTra inizio.............");

	}

}
