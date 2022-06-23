package main;

import java.net.URL;

import javax.naming.NamingException;
import javax.swing.JApplet;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import view.Aqua3EditorViewRoot;

import controller.Aqua3EditorController;


public class Aqua3EditorApplet extends JApplet {
	
	private static final long serialVersionUID = 1003016146497959856L;
	private Aqua3EditorViewRoot rootPanel;

	public void init() {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				initView();
				initController();
			}
		});
	}

	private void initController() {
		try {
			AquaContext context = new AquaContext();
			new Aqua3EditorController(this, rootPanel, context);
		} catch (NamingException e) {
			ErrorMessage.show(ErrorMessage.CONNECTION);
			System.exit(0);
		}
	}

	private void initView() {
		Resources.setResourceBundle(getLocale());
		setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		rootPanel = new Aqua3EditorViewRoot(this);
	}

	public void setLookAndFeel(String lafClassName) {
		try {
			UIManager.setLookAndFeel(lafClassName);
		} catch (Exception ex) {}
		SwingUtilities.updateComponentTreeUI(this);
	}

	public URL getURL(String filename) {
		URL codeBase = this.getCodeBase();
		URL url = null;
		try {
			url = new URL(codeBase, filename);
			System.out.println(url);
		} catch (java.net.MalformedURLException e) {
			System.err.println(e.getMessage());
			return null;
		}
		return url;
	}

}
