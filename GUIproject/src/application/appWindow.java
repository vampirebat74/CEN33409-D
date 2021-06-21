package application;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.layout.RowLayout;

public class appWindow {
	protected Shell shell;
	private Table outputTable;
	private TableItem tableItem;
	private TableItem tableItem_1;
	private TableItem tableItem_2;
	private TableItem tableItem_3;
	private TableItem tableItem_4;
	private TableItem tableItem_5;
	private TableItem tableItem_6;
	private TableItem tableItem_7;
	private TableItem tableItem_8;
	private TableItem tableItem_9;
	private TableColumn tblclmnNewColumn;
	private TableColumn tblclmnNewColumn_1;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			appWindow window = new appWindow();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
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
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 325);
		shell.setText("SWT Application");
		shell.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("Segoe UI", 30, SWT.NORMAL));
		lblNewLabel.setText("Output");
		
		outputTable = new Table(shell, SWT.BORDER);
		outputTable.setToolTipText("Output of reader");
		outputTable.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		outputTable.setHeaderVisible(true);
		outputTable.setLinesVisible(true);
		
		tableItem_1 = new TableItem(outputTable, SWT.NONE);
		tableItem_1.setText(new String[] {"The", "midnight"});
		
		tableItem = new TableItem(outputTable, SWT.NONE);
		tableItem.setText(new String[] {"Raven", "I,"});
		
		tableItem_2 = new TableItem(outputTable, SWT.NONE);
		tableItem_2.setText(new String[] {"By", "Pondered"});
		
		tableItem_3 = new TableItem(outputTable, SWT.NONE);
		tableItem_3.setText(new String[] {"Edgar", "weak"});
		
		tableItem_4 = new TableItem(outputTable, SWT.NONE);
		tableItem_4.setText(new String[] {"Allan", "and"});
		
		tableItem_5 = new TableItem(outputTable, SWT.NONE);
		tableItem_5.setText(new String[] {"Poe", "weary"});
		
		tableItem_9 = new TableItem(outputTable, SWT.NONE);
		tableItem_9.setText(new String[] {"Once", "over"});
		
		tableItem_6 = new TableItem(outputTable, SWT.NONE);
		tableItem_6.setText(new String[] {"Upon", "many"});
		
		tableItem_7 = new TableItem(outputTable, SWT.NONE);
		tableItem_7.setText(new String[] {"a", "a"});
		
		tableItem_8 = new TableItem(outputTable, SWT.NONE);
		tableItem_8.setText(new String[] {"dreary,"});
		
		tblclmnNewColumn = new TableColumn(outputTable, SWT.NONE);
		tblclmnNewColumn.setText("The");
		tblclmnNewColumn.setWidth(200);
		
		tblclmnNewColumn_1 = new TableColumn(outputTable, SWT.NONE);
		tblclmnNewColumn_1.setWidth(200);
		tblclmnNewColumn_1.setText("while");
		
		


	}

}
