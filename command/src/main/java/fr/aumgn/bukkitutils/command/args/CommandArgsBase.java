package fr.aumgn.bukkitutils.command.args;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import fr.aumgn.bukkitutils.command.messages.Messages;

public class CommandArgsBase implements CommandArgsInterface {

    protected Messages messages;
    protected Set<Character> flags;
    protected String[] args;

    public boolean hasIndex(int index) {
        return index < args.length;
    }

    public boolean hasFlags() {
        return !flags.isEmpty();
    }

    public boolean hasFlag(char character) {
        return flags.contains(character);
    }

    public Iterable<Character> flags() {
        return flags;
    }

    public int length() {
        return args.length;
    }

    public String get(int index) {
        return args[index];
    }

    public String get(int index, String def) {
        if (hasIndex(index)) {
            return get(index);
        }

        return def;
    }

    public String get(int index, int rawEndIndex) {
        int endIndex;
        if (rawEndIndex > -1) {
            endIndex = rawEndIndex;
        } else {
            endIndex = args.length - 1;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = index; i < endIndex; i++) {
            builder.append(args[i]);
            builder.append(" ");
        }
        builder.append(args[endIndex]);
        return builder.toString();
    }

    public String get(int index, int endIndex, String def) {
        if (hasIndex(index) && hasIndex(endIndex)) {
            return get(index, endIndex);
        }

        return def;
    }

    public List<String> asList() {
        return Arrays.asList(args);
    }

    public List<String> asList(int index) {
        return asList(index, args.length - 1);
    }

    public List<String> asList(int index, int endIndex) {
        int startIndex = Math.max(0, index);
        int actualEndIndex = Math.min(args.length, endIndex + 1);
        return asList().subList(startIndex, actualEndIndex);
    }

    @Override
    public Iterator<String> iterator() {
        return asList().iterator();
    }
}