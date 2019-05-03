package pl.em.common;

public final class CQRSHandler {
	
	public <T> T executeCommand(DomainCommand<T> command) {
		return command.execute();
	}
	
}
