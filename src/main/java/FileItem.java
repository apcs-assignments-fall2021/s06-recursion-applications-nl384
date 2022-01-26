public interface FileItem {
    // Counts the total number of files and folders in the current FileItem
    public int countFiles();

    // Calculates the total size of the files and folders in the current FileItem
    public int calculateSize();

    // Creates a copy of the current FileItem
    public FileItem copy();
}
