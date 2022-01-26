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
        int size = 512;
        size += items.size() * 128;

        for (int i = 0; i < items.size(); i++) {
            FileItem item = items.get(i);
            size += item.calculateSize();
        }

        return size;
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
        Folder folderCopy = new Folder(this.folderName + "_copy");

        for (int i = 0; i < items.size(); i++) {
//            folderCopy.items.add(items.get(i).copy());
            FileItem item = items.get(i);
            folderCopy.addToFolder(item.copy());
        }

        return folderCopy;
    }

    // toString method
    @Override
    public String toString() {
        return this.folderName + ": " + this.items;
    }

    public static void main(String[] args) {
        // folder1 contains 3 files
        Folder folder1 = new Folder("folder1");
        folder1.addToFolder(new File("file1", 200));
        folder1.addToFolder(new File("file2", 300));
        folder1.addToFolder(new File("file3", 150));

        // folder2 contains a file and folder1
        Folder folder2 = new Folder("folder2");
        folder2.addToFolder(new File("file4", 200));
        folder2.addToFolder(folder1);

        // Test getSize() method
        System.out.println(folder1.calculateSize());
        // 1546
        System.out.println(folder2.calculateSize());
        // 2514

        // Test copy() method
        FileItem folder3 = folder2.copy();
        System.out.println(folder3);
        // folder2_copy: [file4_copy: 200, folder1_copy: [file1_copy: 200, file2_copy: 300, file3_copy: 150]]
    }
}