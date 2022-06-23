package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import main.Resources;
import model.FutterzeitModel;


public class DeleteFutterzeitAction extends AbstractAction {
	
	private static final long serialVersionUID = 1L;
	private FutterzeitModel model;
	
	public DeleteFutterzeitAction(FutterzeitModel model) {
		super(Resources.getString("Szen.fzp_deleteButton"));
		this.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		model.deleteFutterzeit();
	}
}

