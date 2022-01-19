package texteditor_version_1;

public class Select implements Command {
	private Invoker invoker;
	private Selection selection;
	
	
	@Override
	public void execute() {
		selection.setBeginIndex(invoker.getBeginindex());
		selection.setEndIndex(invoker.getEndIndex());		
	}

}
