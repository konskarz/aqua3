package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import main.Resources;
import model.FutterzeitModel;


public class AddFutterzeitAction extends AbstractAction {
	
	private static final long serialVersionUID = 1L;
	private FutterzeitModel model;
	
	public AddFutterzeitAction(FutterzeitModel model) {
		super(Resources.getString("Szen.fzp_addButton"));
		this.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		model.addFutterzeit();
	}

}
