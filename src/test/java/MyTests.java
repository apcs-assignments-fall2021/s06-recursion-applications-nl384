import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyTests {
    @Test
    public void testBinarySearch() {
        assertEquals(true, MyMain.binarySearch(new int[] {1, 2, 4, 5, 7, 8, 10}, 2), "Whether or not the array [1, 2, 4, 5, 7, 8, 10] contains 2 should be: true");
        assertEquals(true, MyMain.binarySearch(new int[] {-5, 2, 7, 13, 25, 38, 42, 58, 70, 72, 100, 104, 128}, 104), "Whether or not the array [-5, 2, 7, 13, 25, 38, 42, 58, 70, 72, 100, 104, 128] contains 104 should be: true");
        assertEquals(false, MyMain.binarySearch(new int[] {-5, 2, 7, 13, 25, 38, 42, 58, 70, 72, 100, 104, 128}, 99), "Whether or not the array [-5, 2, 7, 13, 25, 38, 42, 58, 70, 72, 100, 104, 128] contains 99 should be: false");
    }

    @Test
    public void testCalculateSize() {
        // folder1 contains 3 files
        Folder folder1 = new Folder("folder1");
        folder1.addToFolder(new File("file1", 200));
        folder1.addToFolder(new File("file2", 300));
        folder1.addToFolder(new File("file3", 150));

        // folder2 contains a file and folder1
        Folder folder2 = new Folder("folder2");
        folder2.addToFolder(new File("file4", 200));
        folder2.addToFolder(folder1);

        assertEquals(1546, folder1.calculateSize(), "The size of folder1 should be: 1546");
        assertEquals(2514, folder2.calculateSize(), "The size of folder2 should be: 2514");
    }

    @Test
    public void testCopy() {
        // folder1 contains 3 files
        Folder folder1 = new Folder("folder1");
        folder1.addToFolder(new File("file1", 200));
        folder1.addToFolder(new File("file2", 300));
        folder1.addToFolder(new File("file3", 150));

        // folder2 contains a file and folder1
        Folder folder2 = new Folder("folder2");
        folder2.addToFolder(new File("file4", 200));
        folder2.addToFolder(folder1);

        assertEquals("folder1_copy: [file1_copy: 200, file2_copy: 300, file3_copy: 150]", ""+folder1.copy(), "The copy of folder1 should be: folder1_copy: [file1_copy: 200, file2_copy: 300, file3_copy: 150]");
        assertEquals("folder2_copy: [file4_copy: 200, folder1_copy: [file1_copy: 200, file2_copy: 300, file3_copy: 150]]", ""+folder2.copy(), "The copy of folder2 should be: folder2_copy: [file4_copy: 200, folder1_copy: [file1_copy: 200, file2_copy: 300, file3_copy: 150]]");
    }

    @Test
    public void testMerge() {
        int[] arr1 = {1, 3, 4, 6};
        int[] arr2 = {2, 5, 7, 8};

        int[] arr3 = {-4, 5, 7, 8};
        int[] arr4 = {-5, -1, 2, 3};

        int[] arr5 = {1, 3, 4, 6, 10, 11, 15, 16};
        int[] arr6 = {2, 5, 7, 8, 9, 13, 20, 21};

        assertEquals("[1, 2, 3, 4, 5, 6, 7, 8]", Arrays.toString(MyMain.merge(arr1, arr2)), "The result of merging [1, 3, 4, 6] with [2, 5, 7, 8] should be: [1, 2, 3, 4, 5, 6, 7, 8]");
        assertEquals("[-5, -4, -1, 2, 3, 5, 7, 8]", Arrays.toString(MyMain.merge(arr3, arr4)), "The result of merging [-4, 5, 7, 8] with [-5, -1, 2, 3] should be: [-5, -4, -1, 2, 3, 5, 7, 8]");
        assertEquals("[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 13, 15, 16, 20, 21]", Arrays.toString(MyMain.merge(arr5, arr6)), "The result of merging [1, 3, 4, 6, 10, 11, 15, 16] with [2, 5, 7, 8, 9, 13, 20, 21] should be: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 13, 15, 16, 20, 21]");
    }
}
