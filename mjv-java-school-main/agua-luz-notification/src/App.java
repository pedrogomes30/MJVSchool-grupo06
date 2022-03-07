

import java.util.ArrayList;
import java.util.List;

import Model.Contrato;
import util.getContentsFromFile;
import util.Notification;

public class App {
	public static void main(String[] args) {
		List<Contrato> contratos = new ArrayList<Contrato>();
		contratos = getContentsFromFile.docHandle(false);
		for(Contrato ct: contratos) {
			Notification.sendNotification(ct);
		}
	}
}
