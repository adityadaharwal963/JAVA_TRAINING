package Problem1TextEditorSimulator;

public class TextFile {
    private String fileName;
    private String content;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String readFile() {
        return content;
    }

    public void saveFile(String content) {
        this.content = content;
    }
}
