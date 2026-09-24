public class Main {
    public static void main(String[] args) {

        TextEditor editor = new TextEditor(60, Alignment.Left);

        editor.addText("Er hörte leise Schritte hinter sich.");
        editor.addText("Das bedeutete nichts Gutes. Wer würde");
        editor.addText("ihm schon folgen, spät in der Nacht und");
        editor.addText("dazu noch in dieser engen Gasse mitten");
        editor.addText("im übel beleumundeten Hafenviertel?");
        editor.addText("Gerade jetzt, wo er das Ding seines");
        editor.addText("Lebens gedreht hatte und mit der Beute");
        editor.addText("verschwinden wollte!");

        System.out.println("Left aligned text:");
        editor.printText();

        System.out.println();

        System.out.println("Justified text:");
        editor.setAlignment(Alignment.Justified);
        editor.printText();
    }
}
