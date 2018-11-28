package com.kowalski0805;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        TextFormatter.readText().print().transform().print();
    }
}

class TextFormatter {
    private String text;

    private TextFormatter(String text) {
        this.text = (text.trim().isEmpty())
                ? "Lorem ipsum dolor sit amet, adipiscing elit. Maecenas id est id neque.\n" +
                "Efficitur ullamcorper sed in lorem. Aliquam finibus eros mi, ut elementum justo malesuada lacinia.\n" +
                "Fusce blandit a est sed feugiat. Proin maximus ex sed nunc fermentum, non commodo sem viverra.\n" +
                "Vestibulum congue ligula arcu, ut blandit erat vulputate quis.\n" +
                "Curabitur est tellus, varius maximus nisi vitae, vestibulum venenatis est."
                : (text);
    }

    TextFormatter print() {
        System.out.println("\n\nПоточний текст:\n\n" + this.text);
        return this;
    }

    TextFormatter transform() {
        String[] lines = this.text.split("\n");

        for (int i = 0; i < lines.length; i++) {
            String[] sentences = lines[i].split("\\.");

            for (int j = 0; j < sentences.length; j++) {
                String[] words = sentences[j].trim().split(" ");

                String temp = words[0];
                words[0] = words[words.length - 1];
                words[words.length - 1] = temp;

                sentences[j] = String.join(" ", words);
            }

            lines[i] = String.join(". ", sentences) + ".";
        }

        this.text = String.join("\n", lines);

        return this;
    }

    static TextFormatter readText() {
        StringBuilder text = new StringBuilder();
        String line;

        System.out.println("Введіть довільні речення. Щоб закінчити, введіть порожній рядок:");

        do {
            Scanner scanner = new Scanner(System.in);
            line = scanner.nextLine().trim();
            text.append(line).append("\n");
        } while (!line.isEmpty());

        return new TextFormatter(text.toString());
    }
}
