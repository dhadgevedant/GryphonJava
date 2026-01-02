public class StudentFileSystem {
    
    private String[] files = new String[10];
    private int fileCount = 0;

    public synchronized void createFile(String fileName) {
        if (fileCount < files.length) {
            files[fileCount++] = fileName;
            System.out.println("File created: " + fileName);
        } else {
            System.out.println("File system is full. Cannot create file: " + fileName);
        }
    }

    public synchronized void deleteFile(String fileName) {
        for (int i = 0; i < fileCount; i++) {
            if (files[i].equals(fileName)) {
                files[i] = files[--fileCount];
                files[fileCount] = null;
                System.out.println("File deleted: " + fileName);
                return;
            }
        }
        System.out.println("File not found: " + fileName);
    }

    public static void main(String[] args) {
        StudentFileSystem sfs = new StudentFileSystem();

        Thread t1 = new Thread(() -> {
            sfs.createFile("file1.txt");
            sfs.createFile("file2.txt");
        });

        Thread t2 = new Thread(() -> {
            sfs.deleteFile("file1.txt");
            sfs.createFile("file3.txt");
        });

        t1.start();
        t2.start();
    }
}
