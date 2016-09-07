package org.jbehave.core.io;

import static org.apache.commons.lang3.StringUtils.contains;
import static org.apache.commons.lang3.StringUtils.endsWith;
import static org.apache.commons.lang3.StringUtils.substringAfterLast;
import static org.apache.commons.lang3.StringUtils.substringBeforeLast;
import static org.apache.commons.lang3.text.WordUtils.capitalize;

public class UnderscoredToCapitalized implements StoryNameResolver {

    private final String extension;

    public UnderscoredToCapitalized() {
        this(".story");
    }

    public UnderscoredToCapitalized(final String extension) {
        this.extension = extension;
    }

    @Override
    public String resolveName(final String path) {
        String name = path;
        if (endsWith(name, extension)) {
            name = substringBeforeLast(name, extension);
        }
        if (contains(name, '/')) {
            name = substringAfterLast(name, "/");
        }
        if (contains(name, '.')) {
            name = substringAfterLast(name, ".");
        }
        return capitalize(name.replace("_", " "));
    }

}
