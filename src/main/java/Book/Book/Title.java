package Book.Book;

import org.apache.poi.hpsf.Decimal;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Title {
    private JButton uploadA;
    private JPanel BasePanel;
    private JTextField uploadTextBox;
    private JButton openButton;
    private JLabel labelA;
    private JLabel labelB;
    private JButton uploadB;
    private JButton saveButton;
    private JLabel labelE;
    private JLabel labelGst;
    private JLabel labelName;
    private JLabel labelDate;
    private JLabel labelInvoice;
    private JLabel labelTotal;
    private JLabel labelIgst;
    private JLabel labelCgst;
    private JLabel labelSgst;
    private JLabel Label1;
    private JLabel Label2;
    private JLabel Label3;
    private JLabel Label4;
    private JLabel Label5;
    private JLabel Label6;
    private JLabel Label7;
    private JLabel Label8;
    private JLabel Label9;
    private JLabel labelTax;
    private String fileA=null;
    private String fileB=null;
    private List<Entries> entryA =new ArrayList<>();
    private List<Entries> entryC =new ArrayList<>();
    private String filepath= null;
    void Read() {
        labelGst.setVisible(false);
        labelName.setVisible(false);
        labelIgst.setVisible(false);
        labelInvoice.setVisible(false);
        labelCgst.setVisible(false);
        labelSgst.setVisible(false);
        labelDate.setVisible(false);
        labelTax.setVisible(false);
        labelTotal.setVisible(false);
        Label1.setVisible(false);
        Label2.setVisible(false);
        Label3.setVisible(false);
        Label4.setVisible(false);
        Label5.setVisible(false);
        Label6.setVisible(false);
        Label7.setVisible(false);
        Label8.setVisible(false);
        Label9.setVisible(false);
        final Reader reader = new Reader();
         uploadA.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fileA= FileUpload();
                try {
                    labelE.setText(null);
                    entryA=reader.read(fileA,"Book1",entryA);
                    labelA.setText("FileA loaded Successfully");
                    uploadA.setEnabled(false);
                    uploadB.setEnabled(true);
                } catch (IOException e1) {
                    labelA.setText("FileA unloaded Successfully");
                    labelE.setText(e1.getMessage());
                }
                catch (IllegalStateException e1){
//                    labelE.setText("Wrong Entry made at line  "+reader.line_number());
//                    labelA.setText(reader.error());
                    errorhandler(reader);
                    uploadA.setEnabled(false);
                }

            }
        });
        uploadB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fileB= FileUpload();
                try {

                    labelE.setText(null);
                    entryA=reader.read(fileB,"Book2",entryA);
                    labelB.setText("File B loaded Successfully");
                    openButton.setEnabled(true);
                    uploadB.setEnabled(false);
                } catch (IOException e1) {
                    labelA.setText("FileB unloaded Successfully");
                    labelE.setText(e1.getMessage());
                }
                catch (IllegalStateException e1){
                    errorhandler(reader);
                    uploadB.setEnabled(false);
//                    labelE.setText("Wrong Entry made at line  "+reader.line_number());
                }
            }
        });
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                filepath=filepath+"\\"+uploadTextBox.getText();
                Writer writer = new Writer();
                try {
                    filepath=writer.Write(entryC,filepath);
                    labelE.setText("File Saved Successfully "+filepath );
                    labelE.setForeground(Color.BLUE);
                } catch (IOException e1) {
                    labelE.setText(e1.getMessage());
                } catch (InvalidFormatException e1) {
                    labelE.setText("Wrong Entry made at line");
                }
            }
        });
        uploadTextBox.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) { //watch for key strokes
                if(uploadTextBox.getText().length() == 0)
                    saveButton.setEnabled(false);
                else
                {
                    saveButton.setEnabled(true);

                }
            }
        });
        openButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ValCompare valCompare = new ValCompare();
                entryC=valCompare.compare(entryA,entryC);
                labelE.setText("Match Successfull");
                labelE.setForeground(Color.ORANGE);
                openButton.setEnabled(false);
                uploadTextBox.setEditable(true);
                filepath=fileA.substring(0,fileA.lastIndexOf("\\"));

            }
        });
    }
    public String FileUpload()
    {
        String filename = null;
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter fileNameExtensionFilter = new FileNameExtensionFilter("EXCEL (xlsx)","xlsx");
        fileChooser.setFileFilter(fileNameExtensionFilter);
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION)
        {
            File selectedFile = fileChooser.getSelectedFile();
             filename = selectedFile.getAbsolutePath();
            try
            {
                FileReader reader = new FileReader(filename);
                BufferedReader br = new BufferedReader(reader);
                br.close();
            } catch (Exception e1)
            {
                labelE.setText(e1.getMessage());
            }
        }
        return filename;
    }

    void formShow() {
        JFrame frame = new JFrame();
        frame.setBounds(100, 100, 730, 489);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(BasePanel);
        frame.setVisible(true);
    }

    public void begin() {
        Title base = new Title();
        base.formShow();
        base.Read();
        }
    public void errorhandler(Reader reader){

        labelE.setText("Wrong Entry made at line number "+reader.c);
        labelGst.setVisible(true);
        labelName.setVisible(true);
        labelIgst.setVisible(true);
        labelInvoice.setVisible(true);
        labelCgst.setVisible(true);
        labelSgst.setVisible(true);
        labelDate.setVisible(true);
        labelTax.setVisible(true);
        labelTotal.setVisible(true);
        Label1.setVisible(true);
        Label2.setVisible(true);
        Label3.setVisible(true);
        Label4.setVisible(true);
        Label5.setVisible(true);
        Label6.setVisible(true);
        Label7.setVisible(true);
        Label8.setVisible(true);
        Label9.setVisible(true);
        labelGst.setText(reader.gstno);
        labelName.setText(reader.name);
        labelIgst.setText(Double.toString(reader.igst));
        labelInvoice.setText(reader.billno);
        labelCgst.setText(Double.toString(reader.cgst));
        labelSgst.setText(Double.toString(reader.sgst));
        labelDate.setText(reader.date.toString());
        labelTax.setText(Double.toString(reader.tvalue));
        labelTotal.setText(Double.toString(reader.total));
        switch (reader.j){
            case 0:labelGst.setForeground(Color.RED);
            break;
            case 1:labelName.setForeground(Color.RED);
                break;
            case 2:labelInvoice.setForeground(Color.RED);
                break;
            case 3:labelDate.setForeground(Color.RED);
                break;
            case 4:labelTotal.setForeground(Color.RED);
                break;
            case 5:labelTax.setForeground(Color.RED);
                break;
            case 6:labelIgst.setForeground(Color.RED);
                break;
            case 7:labelCgst.setForeground(Color.RED);
                break;
            case 8:labelSgst.setForeground(Color.RED);
                break;
        }
    }
}

