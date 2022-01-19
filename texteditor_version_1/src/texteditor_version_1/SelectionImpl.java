package texteditor_version_1;

public class SelectionImpl implements Selection {

	private int beginIndex;
	private int endIndex;
	private int bufferBeginIndex;
	private int bufferEndIndex;



	@Override
	public int getBeginIndex() {
		return beginIndex;
	}

	@Override
	public int getEndIndex() {
		return endIndex;
	}


	@Override
	public int getBufferBeginIndex() {
		return bufferBeginIndex;

	}

	@Override
	public int getBufferEndIndex() {
		return bufferEndIndex;
	}

	@Override
	public void setBufferBeginIndex() {
		this.bufferBeginIndex = 0;

	}
	@Override
	public void setBufferEndIndex(int bufferEndIndex) {
		if(bufferEndIndex == 0) {
			this.bufferEndIndex = bufferEndIndex;
		}else {
			this.bufferEndIndex = bufferEndIndex;
		}
	}

	@Override
	public void setBeginIndex(int beginIndex) {
		if ((beginIndex >= bufferBeginIndex) && (beginIndex <= bufferEndIndex) ) {
			this.beginIndex = beginIndex;
		}else if(beginIndex < bufferBeginIndex) {
			throw new ArithmeticException("L'index du debut de la selection est inferieur a l'index du debut du buffer");
		}else {
			throw new ArithmeticException("L'index du debut de la selection est superieur a l'index de fin du buffer");
		}		

	}

    /**
     * setEndIndex a string in the buffer, which replaces the contents of the selection
     *
     * @param endIndex the integer to insert
     */

	@Override
	public void setEndIndex(int endIndex) {
		if ((endIndex >= bufferBeginIndex) && (endIndex <= bufferEndIndex) && (endIndex >= beginIndex)) {
			this.endIndex = endIndex;
		}else if(endIndex < beginIndex) {
			throw new ArithmeticException("L'index de fin de la selection est inferieur au debut de l'index de la selection ou/et du buffer");
		}else {
			throw new ArithmeticException("L'index de fin de la selection est superieur a  de l'index de fin du buffer");
		}

	}

}
