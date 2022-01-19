package texteditor_version_1;

public class Delete implements  Command {

	private EngineImpl engine;
	
	@Override
	public void execute() {
		engine.delete();
	}

}
