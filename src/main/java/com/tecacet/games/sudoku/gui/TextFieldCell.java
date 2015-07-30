package com.tecacet.games.sudoku.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JTextField;

import com.tecacet.games.sudoku.Cell;

@SuppressWarnings("serial")
public class TextFieldCell extends JTextField {

	private int row;
	private int col;
	private ListenerSupport listenerSupport = new ListenerSupport();

	public TextFieldCell(int row, int col) {
		super(2);
		this.row = row;
		this.col = col;
		this.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((isValidDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE)))) {
					getToolkit().beep();
					e.consume();
				} else {
					setText("");
				}
			}
		});
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SudokuEvent event = new SudokuEvent(
						SudokuEvent.SELECT_ACTION,
						new Cell(TextFieldCell.this.row, TextFieldCell.this.col),
						Integer.valueOf(TextFieldCell.this.getText()));
				listenerSupport.notifyListeners(event);
			}

		});
	}

	private boolean isValidDigit(char c) {
		if (Character.isDigit(c)) {
			return Integer.valueOf(c + "") > 0;
		}
		return false;
	}
	
	public void setValue(Integer value) {
		if (value == null) {
			this.setText(null);
			return;
		}
		this.setText("" + value);

	}

	public void addSudokuEventListener(SudokuEventListener l) {
		listenerSupport.addListener(l);

	}
}
