package MementoPattern;

public class MementoRunner {
    public static void main(String[] args) {
        var editor = new Editor();
        var history = new History();
        editor.setContent("a");
        history.push(editor.createState());
        editor.setContent("b");
        history.push(editor.createState());
        editor.restore(history.pop());
        System.out.println(editor.getContent());
    }
}
