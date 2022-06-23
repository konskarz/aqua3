package controller;

import java.awt.Container;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import main.Aqua3EditorApplication;
import main.Resources;


public class ProgramExitAction extends AbstractAction {

	private static final long serialVersionUID = 1L;
	private Container parent;
	
	public ProgramExitAction(Container parent) {
		super(Resources.getString("FileMenu.exit_label"));
		putValue(SHORT_DESCRIPTION, Resources.getString("FileMenu.exit_desc"));
		putValue(MNEMONIC_KEY, Resources.getMnemonicInt("FileMenu.exit_mnemonic"));
		this.parent = parent;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(this.getClass().getSimpleName());
		if(parent instanceof Aqua3EditorApplication)
			((Aqua3EditorApplication)parent).saveAndExit();
	}

}
	
