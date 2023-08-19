package com.JCodexpy;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;

public class CopiadorTexto {
	
	public void copiar(String texto) {
        StringSelection stringSelection = new StringSelection(texto);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, new ClipboardOwner() {
			@Override
			public void lostOwnership(Clipboard clipboard, Transferable contents) {				
			}
        });
	}	
}
