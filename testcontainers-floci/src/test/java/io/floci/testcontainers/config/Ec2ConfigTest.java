package io.floci.testcontainers.config;

import org.junit.jupiter.api.Test;
import org.testcontainers.containers.GenericContainer;

import static io.floci.testcontainers.testing.ContainerUtils.genericContainer;
import static org.assertj.core.api.Assertions.assertThat;

class Ec2ConfigTest {

    @Test
    void shouldApplyDefaultEc2Config() {
        Ec2Config config = Ec2Config.builder().build();
        assertThat(config.isEnabled()).isTrue();
        assertThat(config.isMock()).isFalse();
        assertThat(config.getImdsPort()).isEqualTo(9169);
        assertThat(config.getSshPortRangeStart()).isEqualTo(2200);
        assertThat(config.getSshPortRangeEnd()).isEqualTo(2299);
    }

    @Test
    void shouldApplyCustomEc2Config() {
        Ec2Config config = Ec2Config.builder()
                .enabled(false)
                .mock(true)
                .imdsPort(9170)
                .sshPortRange(2300, 2399)
                .build();
        assertThat(config.isEnabled()).isFalse();
        assertThat(config.isMock()).isTrue();
        assertThat(config.getImdsPort()).isEqualTo(9170);
        assertThat(config.getSshPortRangeStart()).isEqualTo(2300);
        assertThat(config.getSshPortRangeEnd()).isEqualTo(2399);
    }

    @Test
    void shouldApplyDefaultEnvVarsToContainer() {
        GenericContainer<?> container = genericContainer();
        Ec2Config.builder().build().applyEnvVarsToContainer(container);

        assertThat(container.getEnvMap())
                .containsEntry("FLOCI_SERVICES_EC2_ENABLED", "true")
                .containsEntry("FLOCI_SERVICES_EC2_MOCK", "false")
                .containsEntry("FLOCI_SERVICES_EC2_IMDS_PORT", "9169")
                .containsEntry("FLOCI_SERVICES_EC2_SSH_PORT_RANGE_START", "2200")
                .containsEntry("FLOCI_SERVICES_EC2_SSH_PORT_RANGE_END", "2299");
    }

    @Test
    void shouldApplyCustomEnvVarsToContainer() {
        GenericContainer<?> container = genericContainer();
        Ec2Config.builder()
                .enabled(true)
                .mock(true)
                .imdsPort(9170)
                .sshPortRange(2300, 2399)
                .build()
                .applyEnvVarsToContainer(container);

        assertThat(container.getEnvMap())
                .containsEntry("FLOCI_SERVICES_EC2_ENABLED", "true")
                .containsEntry("FLOCI_SERVICES_EC2_MOCK", "true")
                .containsEntry("FLOCI_SERVICES_EC2_IMDS_PORT", "9170")
                .containsEntry("FLOCI_SERVICES_EC2_SSH_PORT_RANGE_START", "2300")
                .containsEntry("FLOCI_SERVICES_EC2_SSH_PORT_RANGE_END", "2399");
    }

    @Test
    void shouldApplyDisabledEnvVarToContainer() {
        GenericContainer<?> container = genericContainer();
        Ec2Config.builder().enabled(false).build().applyEnvVarsToContainer(container);

        assertThat(container.getEnvMap()).containsEntry("FLOCI_SERVICES_EC2_ENABLED", "false");
    }
}
