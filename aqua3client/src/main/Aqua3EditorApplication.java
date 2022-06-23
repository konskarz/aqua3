package main;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.naming.NamingException;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import view.Aqua3EditorViewRoot;

import controller.Aqua3EditorController;


public class Aqua3EditorApplication extends JFrame {

	private static final long serialVersionUID = 1L;
	private AquaPreferences prefs = null;
	private Aqua3EditorViewRoot rootPanel;
	
	public Aqua3EditorApplication() {
		prefs = new AquaPreferences(this);
		init();
	}

	public void init() {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				initView();
				initFrame();
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
		Resources.setResourceBundle(prefs.getLocale());
		setLookAndFeel(prefs.getLafClassName());
		rootPanel = new Aqua3EditorViewRoot(this);
	}

	private void initFrame() {
		setTitle(Resources.getString("Frame.title"));
		setBoundsAndState();
		setVisible(true);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				saveAndExit();
			}
		});
	}

	private void setLookAndFeel(String lafClassName) {
		try {
			UIManager.setLookAndFeel(lafClassName);
		} catch (Exception ex) {}
		SwingUtilities.updateComponentTreeUI(this);
	}

	private void setBoundsAndState() {
		this.setSize(prefs.getWindowSize());
		this.setLocation(prefs.getWindowPoint());
		this.setExtendedState(prefs.getWindowState());
	}
	
	public void saveAndExit() {
		saveBoundsAndState();
		saveLookAndFeel();
		System.exit(0);
	}
	
	private void saveBoundsAndState() {
		int windowState=this.getExtendedState();
		prefs.setWindowState(windowState);
		if(windowState==JFrame.NORMAL) {
			prefs.setWindowPoint(this.getLocation());
			prefs.setWindowSize(this.getSize());
		}
	}

	private void saveLookAndFeel() {
		prefs.setLafClassName(UIManager.getLookAndFeel().getClass().getName());
	}

	public static void main(String[] args) {
		new Aqua3EditorApplication();
	}

}
