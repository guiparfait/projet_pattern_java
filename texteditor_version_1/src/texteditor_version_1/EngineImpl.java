package texteditor_version_1;


public class EngineImpl implements Engine {
	
	private StringBuilder buffer = new StringBuilder("toto");
	private String clipboard;
	private Selection selection = new SelectionImpl();
	
    /**
     * Provides access to the selection control object
     *
     * @return the selection object
     */
	
	public EngineImpl() {
    	selection.setBufferBeginIndex();
    	selection.setBufferEndIndex(buffer.length());
	}
	
	public void entrerselection(int debut, int fin) {
		selection.setBeginIndex(debut);
		selection.setEndIndex(fin);
	}
		
    @Override
    public Selection getSelection() {
        return selection;
    }

    /**
     * Provides the whole contents of the buffer, as a string
     *
     * @return a copy of the buffer's contents
     */
    @Override
    public String getBufferContents() {
        return buffer.toString();
    }

    /**
     * Provides the clipboard contents
     *
     * @return a copy of the clipboard's contents
     */
    @Override
    public String getClipboardContents() {
        return clipboard;
    }

    /**
     * Removes the text within the interval
     * specified by the selection control object,
     * from the buffer.
     */
    @Override
    public void cutSelectedText() {
    	this.copySelectedText();
    	this.delete();   	
    }

    /**
     * Copies the text within the interval
     * specified by the selection control object
     * into the clipboard.
     */
    @Override
    public void copySelectedText() {
    	clipboard = buffer.substring(selection.getBeginIndex(), selection.getEndIndex()+1); 
    }

    /**
     * Replaces the text within the interval specified by the selection object with
     * the contents of the clipboard.
     */
    @Override
    public void pasteClipboard() {
    	if(clipboard.equals(null)) {
    		throw new NullPointerException("le clipboard est vide"); 
    	}else {
    		buffer.replace(selection.getBeginIndex(), selection.getEndIndex(), clipboard);
        	selection.setBufferEndIndex(buffer.length());
    		
    	}
    }

    /**
     * Inserts a string in the buffer, which replaces the contents of the selection
     *
     * @param s the text to insert
     */
    @Override
    public void insert(String s) {
    	if (s.equals(null)) {
    		throw new NullPointerException("le texte entrer est null");    		
    	}else {
    		buffer.replace(selection.getBeginIndex(), selection.getEndIndex(), s);
        	selection.setBufferEndIndex(buffer.length());
    	}
    }

    /**
     * Removes the contents of the selection in the buffer
     */
    @Override
    public void delete() {
    	buffer.delete(selection.getBeginIndex(), selection.getEndIndex()+1); 
    	selection.setBufferEndIndex(buffer.length());
    }

}
