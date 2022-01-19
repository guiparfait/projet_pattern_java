package texteditor_version_1;

public class copySelectedText implements Command {
	
	private EngineImpl engine;
	
	@Override
	public void execute() {
		engine.copySelectedText();
	}

}
