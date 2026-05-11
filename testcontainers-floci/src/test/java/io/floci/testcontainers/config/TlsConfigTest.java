package io.floci.testcontainers.config;

import org.junit.jupiter.api.Test;
import org.testcontainers.containers.GenericContainer;

import static io.floci.testcontainers.testing.ContainerUtils.genericContainer;
import static org.assertj.core.api.Assertions.assertThat;

class TlsConfigTest {

    @Test
    void shouldApplyDefaultTlsConfig() {
        TlsConfig config = TlsConfig.builder().build();
        assertThat(config.isEnabled()).isFalse();
        assertThat(config.isSelfSigned()).isTrue();
        assertThat(config.getCertPath()).isEmpty();
        assertThat(config.getKeyPath()).isEmpty();
    }

    @Test
    void shouldApplyCustomTlsConfig() {
        TlsConfig config = TlsConfig.builder()
                .enabled(true)
                .selfSigned(false)
                .certPath("/certs/server.crt")
                .keyPath("/certs/server.key")
                .build();
        assertThat(config.isEnabled()).isTrue();
        assertThat(config.isSelfSigned()).isFalse();
        assertThat(config.getCertPath()).contains("/certs/server.crt");
        assertThat(config.getKeyPath()).contains("/certs/server.key");
    }

    @Test
    void shouldApplyDefaultEnvVarsToContainer() {
        GenericContainer<?> container = genericContainer();
        TlsConfig.builder().build().applyEnvVarsToContainer(container);

        assertThat(container.getEnvMap())
                .containsEntry("FLOCI_TLS_ENABLED", "false")
                .doesNotContainKey("FLOCI_TLS_SELF_SIGNED")
                .doesNotContainKey("FLOCI_TLS_CERT_PATH")
                .doesNotContainKey("FLOCI_TLS_KEY_PATH");
    }

    @Test
    void shouldApplyEnabledEnvVarsToContainer() {
        GenericContainer<?> container = genericContainer();
        TlsConfig.builder()
                .enabled(true)
                .build()
                .applyEnvVarsToContainer(container);

        assertThat(container.getEnvMap())
                .containsEntry("FLOCI_TLS_ENABLED", "true")
                .containsEntry("FLOCI_TLS_SELF_SIGNED", "true")
                .doesNotContainKey("FLOCI_TLS_CERT_PATH")
                .doesNotContainKey("FLOCI_TLS_KEY_PATH");
    }

    @Test
    void shouldApplyCustomEnvVarsToContainer() {
        GenericContainer<?> container = genericContainer();
        TlsConfig.builder()
                .enabled(true)
                .selfSigned(false)
                .certPath("/certs/server.crt")
                .keyPath("/certs/server.key")
                .build()
                .applyEnvVarsToContainer(container);

        assertThat(container.getEnvMap())
                .containsEntry("FLOCI_TLS_ENABLED", "true")
                .containsEntry("FLOCI_TLS_SELF_SIGNED", "false")
                .containsEntry("FLOCI_TLS_CERT_PATH", "/certs/server.crt")
                .containsEntry("FLOCI_TLS_KEY_PATH", "/certs/server.key");
    }
}
