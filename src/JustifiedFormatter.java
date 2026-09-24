public class JustifiedFormatter implements PageFormatter {
    private int pageWidth;

    public JustifiedFormatter(int pageWidth) {
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
        String line = "";

        for (int i = 0; i < words.length; i++) {
            if (line.length() + words[i].length() + 1 > pageWidth) {

                String[] lineWords = line.split(" ");

                int wordLength = 0;

                for (int j = 0; j < lineWords.length; j++) {
                    wordLength += lineWords[j].length();
                }

                int spaces = pageWidth - wordLength;
                int gaps = lineWords.length - 1;

                for (int j = 0; j < gaps; j++) {
                    int amount = spaces / gaps;

                    lineWords[j] += " ".repeat(amount);
                    spaces -= amount;
                }

                for (int j = 0; j < lineWords.length; j++) {
                    result += lineWords[j];

                    if (j < lineWords.length - 1) {
                        result += " ";
                    }
                }

                result += "\n";
                line = words[i];

            } else {
                if (line.isEmpty()) {
                    line = words[i];
                } else {
                    line += " " + words[i];
                }
            }
        }
        result += line;

        return result;
    }
}
