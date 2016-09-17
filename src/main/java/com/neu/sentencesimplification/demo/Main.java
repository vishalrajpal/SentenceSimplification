package com.neu.sentencesimplification.demo;

import com.neu.sentencesimplification.stanfordcorenlp.DependenciesParser;
import com.neu.sentencesimplification.stanfordcorenlp.QuestionSentence;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Sentence Simplification Demo.
 */
public class Main extends JFrame {

    public Main() {
        final Frame frame = this;
        final GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        final JLabel sentenceLabel = new JLabel("Sentence:");
        final JTextArea sentenceTextArea = new JTextArea(3, 20);
        sentenceTextArea.setLineWrap(true);
        final JLabel simplifiedSentences = new JLabel("Simplified Sentences:");
        final JTextArea simplifiedSentencesTextArea = new JTextArea(5, 30);
        simplifiedSentencesTextArea.setLineWrap(true);
        final JButton simplifySentencesJButton = new JButton("Simplify Sentences");

        final Border blackBorder = BorderFactory.createLineBorder(Color.BLACK, 1);
        sentenceTextArea.setBorder(blackBorder);
        simplifiedSentencesTextArea.setBorder(blackBorder);

        layout.setHorizontalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(sentenceLabel)
                        .addComponent(simplifiedSentences))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(sentenceTextArea)
                        .addComponent(simplifiedSentencesTextArea)
                        .addComponent(simplifySentencesJButton)
            ));

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(sentenceLabel)
                        .addComponent(sentenceTextArea))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(simplifiedSentences)
                        .addComponent(simplifiedSentencesTextArea))
                .addComponent(simplifySentencesJButton));

        simplifySentencesJButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                final String sentenceToSimplify = sentenceTextArea.getText();
                final java.util.List<QuestionSentence> simplifiedSentences = DependenciesParser.extractPartsOfSpeechFromDependencies(sentenceToSimplify);
                final StringBuilder simplifiedSentencesString = new StringBuilder();
                for (final QuestionSentence questionSentence: simplifiedSentences) {
                    simplifiedSentencesString.append(questionSentence.getSentenceText());
                    simplifiedSentencesString.append("\n");
                }
                simplifiedSentencesTextArea.setText(simplifiedSentencesString.toString());
            }
        });

        layout.linkSize(SwingConstants.VERTICAL, simplifySentencesJButton);
        setTitle("Sentence Simplification Demo");
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }



    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(
                            "javax.swing.plaf.metal.MetalLookAndFeel");
                    //  "com.sun.java.swing.plaf.motif.MotifLookAndFeel");
                    //UIManager.getCrossPlatformLookAndFeelClassName());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                new Main().setVisible(true);
            }
        });
    }
}
