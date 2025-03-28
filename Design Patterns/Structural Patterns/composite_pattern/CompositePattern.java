package composite_pattern;

import java.util.ArrayList;
import java.util.List;

public class CompositePattern {
    public static void main(String[] args) {
        FileSystemComponent file1 = new File("document1.txt");
        FileSystemComponent file2 = new File("document2.txt");
        Folder folder = new Folder("my-folder");
        folder.addComponent(file1);
        folder.addComponent(file2);

        Folder nestedFolder = new Folder("nested-folder");
        nestedFolder.addComponent(new File("nested-file.txt"));
        folder.addComponent(nestedFolder);
        folder.showDetails();
    }
}

interface FileSystemComponent {
    void showDetails();
}

class File implements FileSystemComponent {
    private String name;

    public File(String name) {
        this.name = name;
    }

    public void showDetails() {
        System.out.println("File: " + name);
    }
}

class Folder implements FileSystemComponent {
    private String name;
    private List<FileSystemComponent> components = new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    public void addComponent(FileSystemComponent component) {
        this.components.add(component);
    }

    public void removeComponent(FileSystemComponent component) {
        this.components.remove(component);
    }

    @Override
    public void showDetails() {
        System.out.println("Folder: " + name);
        for (FileSystemComponent c : components) {
            c.showDetails();
        }
    }
}
