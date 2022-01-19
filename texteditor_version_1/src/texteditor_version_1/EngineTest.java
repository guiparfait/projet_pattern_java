package texteditor_version_1;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;

public class EngineTest {
	
	 private Engine engine;

	    @org.junit.jupiter.api.BeforeEach
	    void setUp() {
	        engine = new EngineImpl();
	    }

	    
	    @Test
	    @DisplayName("Buffer must be empty after initialisation")
	    void getSelection() {
	        Selection selection = engine.getSelection();
	        assertEquals(selection.getBufferBeginIndex(),selection.getBeginIndex());
	        assertEquals("toto",engine.getBufferContents());
	        //System.out.println(selection.getBufferBeginIndex());
	        //System.out.println(selection.getBufferEndIndex());

	    }

	    @Test
	    @DisplayName("verifie s'il existe un contenu dans le buffer egale ï¿½ ...")
	    void getBufferContents() {
	        assertEquals("toto",engine.getBufferContents());
	    }

	    @Test
	    @DisplayName("verifie s'il existe un contenu dans le clipboard egal ï¿½ ...")
	    void getClipboardContents() {
	        assertEquals(null,engine.getClipboardContents());
	    }

	    @Test
	    void cutSelectedText() {
	        Selection selection = engine.getSelection();
	        System.out.println(engine.getBufferContents());
	        System.out.println(selection.getBufferEndIndex());
	        System.out.println(engine.getClipboardContents());
	        engine.entrerselection(1,3);
	        engine.cutSelectedText();
	        System.out.println(engine.getClipboardContents());
	        System.out.println(engine.getBufferContents());
	        System.out.println(selection.getBufferEndIndex());
	        assertEquals("t",engine.getBufferContents());
	    }

	    @Test
	    @DisplayName("verifie s'il effectue bien la copie")
	    void copySelectedText() {
	        engine.entrerselection(1,2);
	        engine.copySelectedText();
	        assertEquals("ot",engine.getClipboardContents());     
	       // System.out.println(engine.getClipboardContents());   
	    }

	    @Test
	    @DisplayName("verifie s'il effectue bien le pasteclipboard")
	    void pasteClipboard() {
	        Selection selection = engine.getSelection();
	        engine.entrerselection(2,3);
	        engine.copySelectedText();
	        System.out.println(engine.getBufferContents());
	        System.out.println(selection.getBufferEndIndex());
	        System.out.println(engine.getClipboardContents());
	        engine.entrerselection(0,3);
	        engine.pasteClipboard();
	        System.out.println(engine.getBufferContents());
	        System.out.println(selection.getBufferEndIndex());
	        assertEquals("too",engine.getBufferContents());
	        
	   }
	    
	   @Test
	   @DisplayName("Verifie que l'exception est levée lorsque l'index du debut de la selection est bien inferieur à l'index de debut du buffer")
	   void setBeginIndexException1() {
		   Selection selection = engine.getSelection();
		   Assertions.assertThrows(ArithmeticException.class,() -> {selection.setBeginIndex(-2);});
		   
	   }
	   @Test
	   @DisplayName("Verifie que l'exception est levée lorsque l'index du debut de la selection est superieur a l'index de fin du buffer")
	   void setBeginIndexException2() {
		   Selection selection = engine.getSelection();
		   Assertions.assertThrows(ArithmeticException.class,() -> {selection.setBeginIndex(5);});
		   
	   }
	   @Test
	   @DisplayName("Verifie que l'exception est levée lorsque L'index de fin de la selection est inferieur au debut de l'index de la selection ou/et du buffer")
	   void setEndIndexException1() {
		   Selection selection = engine.getSelection();
		   Assertions.assertThrows(ArithmeticException.class,() -> {selection.setBeginIndex(-2);});
		   
	   }
	   @Test
	   @DisplayName("Verifie que l'exception est levée lorsque L'index de fin de la selection est superieur a  de l'index de fin du buffer")
	   void setEndIndexException2() {
		   Selection selection = engine.getSelection();
		   Assertions.assertThrows(ArithmeticException.class,() -> {selection.setBeginIndex(7);});
		   
	   }
	   @Test
	   @DisplayName("Verifie que l'exception est levée lorque le clipboard est vide")
	   void pasteClipboardException() {
		   engine.entrerselection(2,3);
		   Assertions.assertThrows(NullPointerException.class,() -> {engine.pasteClipboard();});
	   }


}
