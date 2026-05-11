package io.floci.testcontainers.config.services;

import org.testcontainers.containers.Container;

/**
 * Configuration for Textract-specific container settings.
 *
 * <p>Instances are created via {@link Builder}:
 * <pre>{@code
 * TextractConfig config = TextractConfig.builder()
 *     .build();
 * }</pre>
 */
public class TextractConfig extends AbstractServiceConfig {

    private TextractConfig(Builder builder) {
        super(builder.enabled);
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public void applyEnvVarsToContainer(Container<?> container) {
        container.withEnv("FLOCI_SERVICES_TEXTRACT_ENABLED", String.valueOf(isEnabled()));
    }

    /**
     * Builder for {@link TextractConfig}.
     */
    public static class Builder {

        private boolean enabled = DEFAULT_ENABLED;

        private Builder() {
            // Allow instantiation only via TextractConfig.builder()
        }

        /**
         * Enables or disables the Textract service.
         *
         * @param enabled {@code true} to enable (default {@value DEFAULT_ENABLED})
         * @return this builder
         */
        public Builder enabled(boolean enabled) {
            this.enabled = enabled;
            return this;
        }

        /**
         * Creates an immutable {@link TextractConfig} from this builder.
         *
         * @return the Textract configuration
         */
        public TextractConfig build() {
            return new TextractConfig(this);
        }
    }
}
