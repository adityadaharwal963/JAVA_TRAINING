package Problem1TextEditorSimulator;

public class Simulator {
        private TextFile file;

    public int getCursorPosition() {
        return cursorPosition;
    }

    public void setCursorPosition(int cursorPosition) {
        this.cursorPosition = cursorPosition;
    }

    private int cursorPosition;
        private final StringBuilder buffer;
        Simulator(TextFile file){
            this.file = file;
            this.cursorPosition = 0;
            buffer = new StringBuilder(file.readFile());
        }

        void appendText(String text){
            buffer.append(text);
        }
        void insertAtCursorPosition(String text){
            buffer.insert(this.cursorPosition,text);
        }

        void deleteSelectRange(int start, int end){
            buffer.delete(start,end);
        }
        void displayText(){
            file.saveFile(buffer.toString());
            System.out.println("File Content:");
            System.out.println(file.readFile());
        }

}
