package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import main.Resources;
import model.SzenarienModel;


public class DeleteSzeanrioAction extends AbstractAction {

	private static final long serialVersionUID = 1L;
	SzenarienModel model;
	
	public DeleteSzeanrioAction(SzenarienModel model) {
		super(Resources.getString("Szen.deleteButton"));
		this.model = model;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		model.deleteSelectedSzenario();
	}
}

