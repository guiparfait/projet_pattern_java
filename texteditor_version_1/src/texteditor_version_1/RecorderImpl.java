package texteditor_version_1;

import java.util.ArrayList;
import java.util.List;

public class RecorderImpl implements Recorder {public RecorderImpl() {
	// TODO Auto-generated constructor stub
}
	private List<Command>mescommandes = new ArrayList<>();

	@Override
	public void save(Command command) {
		if(command!=null) {
			mescommandes.add(command);
		}
	}

	
	@Override
	public void replay() {
		for(Command cmd: mescommandes) {
			cmd.execute();
			
		}
		
	}

}
