package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import main.Resources;
import model.DimensionenModel;


public class DeleteDimensionenAction extends AbstractAction {

	private static final long serialVersionUID = 1L;
	private DimensionenModel model;
	
	public DeleteDimensionenAction(DimensionenModel model) {
		super(Resources.getString("Szen.aqp_deleteButton"));
		this.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		model.deleteSelectedDimensionen();
	}
}

