/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filefinder;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Nayeong Kim (S1006313)
 */
public class FileFinder implements Runnable {

    private final File rootDir;
    private String fileName;
    private File file;
    private String root;

    public FileFinder(String root) throws IOException {
        this.root = root;
        rootDir = new File(root);
        if (!(rootDir.exists() && rootDir.isDirectory())) {
            throw new IOException(root + " is not a directory.");
        }
    }
    
    public FileFinder(String root, File file, String fileName) throws IOException {
        this.file = file;
        this.fileName = fileName;
        rootDir = new File(root);
        if (!(rootDir.exists() && rootDir.isDirectory())) {
            throw new IOException(root + " is not a directory.");
        }
    }

    public void findFile(String file) throws IOException {
        find(rootDir, file);
    }

    private void find(File rootDir, String fileName) throws IOException {
        File[] files = rootDir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.getName().equals(fileName)) {
                    System.out.println("Found at: " + file.getAbsolutePath());
                } else if (file.isDirectory()) {  
                    FileFinder ff2 = new FileFinder(file.getAbsolutePath(), file, fileName);
                    new Thread(ff2).start();
                }
            }
        }
    }

    @Override
    public void run() {
        try {
            find(file, fileName);
        } catch (IOException ex) {
            Logger.getLogger(FileFinder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
