public class File implements FileItem {
    private String fileName;
    private int size;

    // Create a file given fileName and size
    public File(String fileName, int size) {
        this.fileName = fileName;
        this.size = size;
    }

    // Returns the total number of files
    // Because this is just a single file, returns 1
    public int countFiles() {
        return 1;
    }

    // Calculates the total size of the files and folders in the current FileItem
    // Because this is just a single file, this is just a getter
    public int calculateSize() {
        return this.size;
    }

    // Creates a copy of the current FileItem
    // Because this is just a single file, this creates a new file with the same
    // name + "_copy" and the same size
    public FileItem copy() {
        File fileCopy = new File(this.fileName + "_copy", this.size);
        return fileCopy;
    }

    // toString method
    @Override
    public String toString() {
        return this.fileName + ": " + this.size;
    }
}