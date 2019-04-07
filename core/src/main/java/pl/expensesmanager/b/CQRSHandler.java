package pl.expensesmanager.b;

import java.util.List;

public class CQRSHandler {
	
	public void executeCommand(EMCommand command) {
		command.executeCommand();
	}
	
	public <T> T executeQuery(EMQuery<T> query) {
		return query.executeQuery();
	}
	
	public <T> List<T> executeQuery(EMQueryList<T> query) {
		return query.executeQuery();
	}
	
}
