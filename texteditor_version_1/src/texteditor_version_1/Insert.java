package texteditor_version_1;

public class Insert implements Command {

	private EngineImpl engine;
	private Invoker invoker;
	
	@Override
	public void execute() {
		String s = invoker.getText();
		engine.insert(s);
	}
}
