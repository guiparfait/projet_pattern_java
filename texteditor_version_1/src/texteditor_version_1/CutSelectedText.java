package texteditor_version_1;

public class CutSelectedText implements Command {
	
	private EngineImpl engine;
	private Recorder re;
	
	@Override
	public void execute() {
		engine.cutSelectedText();
		re.save(this);
	}
}
