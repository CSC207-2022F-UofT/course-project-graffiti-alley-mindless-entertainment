package managers;

public class OutputHandler {
    public void generateText(String text) {
        System.out.println(text);
    }

    public void generateTextWithOptions(String text, String[] options) {
        System.out.println(text);
        String opt="a";
        for (String option: options) {
            System.out.println(opt + ". " + option);
            opt += 1;
        }
    }
}
