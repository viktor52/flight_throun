package search;

import org.eclipse.swt.widgets.Display;
import search.SearchFlight;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;

public class SelectFlight {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 * @wbp.parser.entryPoint
	 */
	public static void selectFlight(String s, String c) {
		try {
			SelectFlight window = new SelectFlight();
			window.open(s,c);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open(String s, String c) {
		Display display = Display.getDefault();
		createContents(s,c);
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents(String s, String c) {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		
		Label Dep = new Label(shell, SWT.NONE);
		Dep.setBounds(46, 46, 60, 14);
		Dep.setText(s);
		
		Label Ret = new Label(shell, SWT.NONE);
		Ret.setBounds(46, 100, 60, 14);
		Ret.setText(c);
	}

}
