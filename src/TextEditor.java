public class TextEditor {

    private final int DEFAULT_PAGE_WIDTH = 60;
    private int pageWidth;
    private Alignment alignment;
    private StringBuilder text = new StringBuilder();
    private PageFormatter pageFormatter;

    public TextEditor() {
        this.pageWidth = DEFAULT_PAGE_WIDTH;
        this.alignment = Alignment.Left;
        this.pageFormatter = new LeftAlignedFormatter(pageWidth);
    }

    public TextEditor(int pageWidth) {
        this.pageWidth = pageWidth;
        this.pageFormatter = new LeftAlignedFormatter(pageWidth);
    }

    public TextEditor(int pageWidth, Alignment alignment) {
        this.pageWidth = pageWidth;
        this.alignment = alignment;
        if (alignment == Alignment.Left) {
            pageFormatter = new LeftAlignedFormatter(pageWidth);
        } else {
            pageFormatter = new JustifiedFormatter(pageWidth);
        }
    }

    public int getPageWidth() {
        return pageWidth;
    }

    public void setPageWidth(int pageWidth) {
        this.pageWidth = pageWidth;
    }

    public Alignment getAlignment() {
        return alignment;
    }

    public void setAlignment(Alignment alignment) {
        this.alignment = alignment;

        if (alignment == Alignment.Left) {
            pageFormatter = new LeftAlignedFormatter(pageWidth);
        } else {
            pageFormatter = new JustifiedFormatter(pageWidth);
        }
    }

    public void addText(String string) {
        this.text.append(string).append(" ");
    }

    public void printText() {
        correctText();
        System.out.println(pageFormatter.format(text.toString()));
    }

    private void correctText() {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != ' ' || (i > 0 && text.charAt(i - 1) != ' ')) {
                result.append(text.charAt(i));
            }
        }

        text = result;
    }

}