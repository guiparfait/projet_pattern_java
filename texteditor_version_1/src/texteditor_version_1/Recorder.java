package texteditor_version_1;

public interface Recorder {
	void save(Command command);
	void replay();

}
