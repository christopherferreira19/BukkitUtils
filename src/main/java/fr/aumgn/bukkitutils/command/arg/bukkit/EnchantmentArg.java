package fr.aumgn.bukkitutils.command.arg.bukkit;

import fr.aumgn.bukkitutils.command.CommandsMessages;
import fr.aumgn.bukkitutils.command.arg.impl.AbstractCommandArg;
import fr.aumgn.bukkitutils.command.exception.CommandError;
import org.bukkit.enchantments.Enchantment;

public class EnchantmentArg extends AbstractCommandArg<Enchantment> {

    private final CommandsMessages messages;

    public EnchantmentArg(CommandsMessages messages, String string) {
        super(string);
        this.messages = messages;
    }

    @Override
    public Enchantment value() {
        String name = string;
        Enchantment enchant = Enchantment.getByName(name.toUpperCase());
        if (enchant == null) {
            throw new NoSuchEnchantment(messages, name);
        }

        return enchant;
    }

    public static class NoSuchEnchantment extends CommandError {

        private static final long serialVersionUID = -4832133406864970323L;

        public NoSuchEnchantment(CommandsMessages messages, String name) {
            super(messages.noSuchEnchant(name));
        }
    }
}
