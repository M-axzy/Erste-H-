public class LeftAlignedFormatter implements PageFormatter {

    private int pageWidth;

    public LeftAlignedFormatter(int pageWidth) {
        this.pageWidth = pageWidth;
    }

    @Override
    public void setPageWidth(int number) {
        this.pageWidth = number;
    }

    @Override
    public String format(String string) {
        String[] words = string.split(" ");
        String result = "";
        int length = 0;

        for (int i = 0; i < words.length; i++) {
            if (length + words[i].length() > pageWidth) {
                result += "\n";
                length = 0;
            }

            result += words[i] + " ";
            length += words[i].length() + 1;
        }

        return result;
    }
}
