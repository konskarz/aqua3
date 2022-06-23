package view;

import java.awt.Container;

import javax.swing.Action;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import main.Resources;



public class MenuProgram extends JMenu {

	private static final long serialVersionUID = 1L;
	private JMenuItem menuItem = null;

	public MenuProgram(Container mainContainer) {
		super(Resources.getString("FileMenu.file_label"));
		this.setMnemonic(Resources.getMnemonic("FileMenu.file_mnemonic"));
	}
		
	public void addItem(Action a) {
		menuItem = new JMenuItem(a);
		menuItem.setIcon(null);
		this.add(menuItem);
	}

}
