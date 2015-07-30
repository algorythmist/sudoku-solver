package com.tecacet.games.sudoku.gui;

import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class SudokuPanel extends JPanel {

    class ButtonPanel extends JPanel {
        public ButtonPanel(ActionListener controller) {
            addButton("Move", SudokuController.MOVE_ACTION, controller);
            addButton("Undo", SudokuController.UNDO_ACTION, controller);
            addButton("Clear", SudokuController.CLEAR_ACTION, controller);
            addButton("Solve", SudokuController.SOLVE_ACTION, controller);
        }

        private JButton addButton(String name, String command, ActionListener controller) {
            JButton b = new JButton(name);
            b.setActionCommand(command);
            b.addActionListener(controller);
            add(b);
            return b;
        }
    }

    public SudokuPanel(SudokuView view, SudokuController controller) {
        controller.setView(view);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(view.getComponent());
        add(new ButtonPanel(controller));
    }

}
