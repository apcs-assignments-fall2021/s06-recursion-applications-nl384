import java.util.ArrayList;
public class Folder implements FileItem {
    private String folderName;
    private ArrayList<FileItem> items;

    // Create a folder given the folderName
    public Folder(String folderName) {
        this.folderName = folderName;
        this.items = new ArrayList<FileItem>();
    }

    // Add a FileItem to the folder
    public void addToFolder(FileItem item) {
        this.items.add(item);
    }

    // Returns the total number of files
    // This is a folder, so it counts as 1
    // In addition, we need to count all the files in the folder,
    // and all the files in the folder's folders, etc.!
    public int countFiles() {
        int count = 1;

        // Use recursion to count the files
        // We don't need a base case because the
        // files are the "base case"
        for (int i = 0; i < items.size(); i++) {
            FileItem item = items.get(i);
            count += item.countFiles();
        }

        return count;
    }

    // Calculates the total size of the files and folders in the current FileItem
    // The starting size of a Folder should be 512;
    // furthermore, we should add 128 for each FileItem in the Folder,
    // plus the actual size of all the items in the folder.

    // For example, let's say that we have a Folder called folder1 that contains 3 Files:
    // file1 which is size 200, file2 which is size 300, and file3 which is size 150.
    // Then, the size of folder1 = 512 + 128*3 + 200 + 300 + 150 = 1546.
    public int calculateSize() {
        // YOUR CODE HERE
        return -1;
    }

    // Creates a copy of the current FileItem
    // We will need to copy the folder and then copy all the
    // stuff inside the folder!

    // In the Folder class, the copy() method should return a new Folder
    // with the new folderName consisting of the String "_copy" appended
    // to the end of folderName of the original Folder. In addition, the
    // copy() method should be called on all FileItems in the folder, such
    // that the contents of the folder is copied as well.
    public FileItem copy() {
        // YOUR CODE HERE
        return null;
    }

    // toString method
    @Override
    public String toString() {
        return this.folderName + ": " + this.items;
    }
}