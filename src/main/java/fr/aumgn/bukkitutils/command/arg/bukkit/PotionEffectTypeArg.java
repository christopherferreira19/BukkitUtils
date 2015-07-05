package fr.aumgn.bukkitutils.command.arg.bukkit;

import fr.aumgn.bukkitutils.command.CommandsMessages;
import fr.aumgn.bukkitutils.command.arg.impl.AbstractCommandArg;
import fr.aumgn.bukkitutils.command.exception.CommandError;
import org.bukkit.potion.PotionEffectType;

public class PotionEffectTypeArg extends AbstractCommandArg<PotionEffectType> {

    private final CommandsMessages messages;

    public PotionEffectTypeArg(CommandsMessages messages, String string) {
        super(string);
        this.messages = messages;
    }

    @Override
    public PotionEffectType value() {
        PotionEffectType effect = PotionEffectType.getByName(string);
        if (effect == null) {
            throw new NoSuchPotionEffect(messages, string);
        }

        return effect;
    }

    public static class NoSuchPotionEffect extends CommandError {
        private static final long serialVersionUID = 6849291638184124428L;

        public NoSuchPotionEffect(CommandsMessages messages, String name) {
            super(messages.noSuchPotionEffect(name));
        }
    }
}
