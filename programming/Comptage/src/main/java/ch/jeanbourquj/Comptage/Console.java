/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.jeanbourquj.Comptage;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 *
 * @author JeanbourquJ
 */
public class Console {

    private static final String MESSAGE_USAGE
            = "usage :  java -cp ./295-comptage.jar [--action (count_chars ¦ count_lines ¦ char_frequency ¦ count_words) ] "
            + "--fichier <nomFichier>\n"
            + "--action tous par défaut";

    private final String fileName;
    private final Action action;
    private final Action DEFAULT_ACTION = Action.ALL;

    public static final String PARAM_ACTION = "--action";
    public static final String PARAM_FILENAME = "--file";
    private static final Logger LOG = Logger.getLogger(Console.class.getName());

    public static void main(String[] args) {

        List<String> argList = Arrays.asList(args);

        Console console = new Console(argList);
        console.run();
    }

    private Console(List<String> argList) {
        action = extractAction(argList);
        fileName = extractParameters(argList, PARAM_FILENAME);

    }

    private Action extractAction(List<String> args) {
        String arg = extractParameters(args, PARAM_ACTION);

        if (arg == null) {
            return DEFAULT_ACTION;
        }

        Action act = DEFAULT_ACTION;
        try {
            act = Action.valueOf(arg.toUpperCase());
        } catch (Exception ex) {
            //ne fait rien conserve la valeur par défaut.
        }
        return act;
    }

    private void executeAction(Action pAction) {
        Counter counter
                = new Counter(new File(this.fileName));
        int charsCount;
        int linesCount;
        int wordCount;
        Map<Character, Integer> wordsFrequency;
        switch (pAction) {
            case COUNT_CHARS:
                charsCount = counter.countChars();
                System.out.printf("Count of characters of file '%s' :\n", this.fileName);
                System.out.printf("\tNumbers of characters : %d\n", charsCount);
                break;
            case COUNT_LINES:
                linesCount = counter.countLines();
                System.out.printf("Count of lines of file '%s' :\n", this.fileName);
                System.out.printf("\tNumbers of lines : %d\n", linesCount);
                break;
            case COUNT_WORDS:
                wordCount = counter.countWords();
                System.out.printf("Count of words of file '%s' :\n", this.fileName);
                System.out.printf("\tNumbers of words : %d\n", wordCount);
                break;
            case CHAR_FREQUENCY:
                System.out.printf("Count of each letters of file '%s' :\n", this.fileName);
                wordsFrequency = counter.countFrequency();
                for (Map.Entry<Character, Integer> entry : wordsFrequency.entrySet()) {
                    Object key = entry.getKey();
                    Object val = entry.getValue();
                    System.out.printf("\tLetters %s : %d\n", key, val);
                }
                break;
        }
        System.out.printf("\n");
    }

    private void run() {

        if (action == Action.ALL) {
            //Chars count
            executeAction(Action.COUNT_CHARS);
            //Lines count
            executeAction(Action.COUNT_LINES);
            //Letters frequency
            executeAction(Action.CHAR_FREQUENCY);
            //Words numbers
            executeAction(Action.COUNT_WORDS);
            
        } else {

            executeAction(action);
        }
    }

    private String extractParameters(List<String> args, String nomParametre) {
        String arg = null;
        int pos = args.indexOf(nomParametre);
        if (pos >= 0 && pos + 1 < args.size()) {
            arg = args.get(pos + 1);
        }
        return arg;
    }

    private enum Action {
        COUNT_CHARS, COUNT_LINES, CHAR_FREQUENCY, COUNT_WORDS, ALL;
    }

}
