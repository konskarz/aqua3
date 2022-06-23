package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import main.Resources;
import model.SzenarienLebewesenModel;


public class RemoveLebewesenAction extends AbstractAction {
	
	private static final long serialVersionUID = 1L;
	private SzenarienLebewesenModel model;
	
	public RemoveLebewesenAction(SzenarienLebewesenModel model) {
		super(Resources.getString("Szen.lwp_deleteButton"));
		this.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		model.removeSelectedLebewesen();
	}
}

