package lab.pkg0.file.chooser;

/**
 * @author levenick Jan 8, 2018 12:47:02 PM
 * Edits for Lab 0 functionality made by Sophia Anderson
 */


import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;


class Lab0FileChooser {
    
    public static void main(String[] args) {
        new Lab0FileChooser().printFilesInADirectorySelectedByTheUser();
    }
    
    void printFilesInADirectorySelectedByTheUser() {        
        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnVal = fc.showOpenDialog(new JFrame());
        
        if (returnVal != JFileChooser.APPROVE_OPTION) {  // make sure it worked
            System.out.println("so sad...");
            return;  // give up, go home
        }
        
        File f = fc.getSelectedFile();

        System.out.println("You selected the directory = " + f);
        int x = 0; //Added int x
        printContentsOfDirectory(f,x); //Added x
    }
    
    void printContentsOfDirectory(File f, int x) { //Added int x variable
        for (File nextFile : f.listFiles()) {
            x++; //added
            for(int y=0; y<x; y++) //added for loop 
            {
                System.out.print("    ");
            }
            System.out.println(nextFile);
            if (nextFile.isDirectory()) //added if statement
            {
                printContentsOfDirectory(nextFile, x);
            }
            x--; //added
        }
    }
    
}
    